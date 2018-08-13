package com.zhongyu.extend

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.ResourceCDN
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.reporter.ExtentHtmlReporter
import com.aventstack.extentreports.reporter.configuration.ChartLocation
import com.aventstack.extentreports.reporter.configuration.Theme
import org.testng.*
import org.testng.xml.XmlSuite
import java.io.File
import java.util.*

/**
 * @author ZhongYu
 */
class ExtentTestNGIReporterListener : IReporter {

    private var extent: ExtentReports? = null

    override fun generateReport(xmlSuites: List<XmlSuite>, suites: List<ISuite>, outputDirectory: String) {
        init()
        var createSuiteNode = false
        if (suites.size > 1) {
            createSuiteNode = true
        }
        for (suite in suites) {
            val result = suite.results
            if (result.isEmpty()) {
                continue
            }
            var suiteFailSize = 0
            var suitePassSize = 0
            var suiteSkipSize = 0
            var suiteTest: ExtentTest? = null
            if (createSuiteNode) {
                suiteTest = extent!!.createTest(suite.name).assignCategory(suite.name)
            }
            var createSuiteResultNode = false
            if (result.size > 1) {
                createSuiteResultNode = true
            }
            for (r in result.values) {
                val resultNode: ExtentTest? = if (createSuiteResultNode) {
                    if (null == suiteTest) {
                        extent!!.createTest(r.testContext.name)
                    } else {
                        suiteTest.createNode(r.testContext.name)
                    }
                } else {
                    suiteTest
                }
                val context = r.testContext
                if (resultNode != null) {
                    resultNode.model.name = suite.name + " : " + r.testContext.name
                    if (resultNode.model.hasCategory()) {
                        resultNode.assignCategory(r.testContext.name)
                    } else {
                        resultNode.assignCategory(suite.name, r.testContext.name)
                    }
                    resultNode.model.startTime = r.testContext.startDate
                    resultNode.model.endTime = r.testContext.endDate
                    val passSize = r.testContext.passedTests.size()
                    val failSize = r.testContext.failedTests.size()
                    val skipSize = r.testContext.skippedTests.size()
                    suitePassSize += passSize
                    suiteFailSize += failSize
                    suiteSkipSize += skipSize
                    if (failSize > 0) {
                        resultNode.model.status = Status.FAIL
                    }
                    resultNode.model.description = String.format("Pass: %s ; Fail: %s ; Skip: %s ;", passSize, failSize, skipSize)
                }
                buildTestNodes(resultNode, context.failedTests, Status.FAIL)
                buildTestNodes(resultNode, context.skippedTests, Status.SKIP)
                buildTestNodes(resultNode, context.passedTests, Status.PASS)
            }
            if (suiteTest != null) {
                suiteTest.model.description = String.format("Pass: %s ; Fail: %s ; Skip: %s ;", suitePassSize, suiteFailSize, suiteSkipSize)
                if (suiteFailSize > 0) {
                    suiteTest.model.status = Status.FAIL
                }
            }

        }

        extent!!.flush()
    }

    private fun init() {
        val reportDir = File(OUTPUT_FOLDER)
        if (!reportDir.exists() && !reportDir.isDirectory) {
            reportDir.mkdir()
        }
        val htmlReporter = ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME)
        htmlReporter.config().resourceCDN = ResourceCDN.EXTENTREPORTS
        htmlReporter.config().documentTitle = "移动端自动化测试报告"
        htmlReporter.config().reportName = "移动端自动化测试报告"
        htmlReporter.config().chartVisibilityOnOpen = true
        htmlReporter.config().testViewChartLocation = ChartLocation.TOP
        htmlReporter.config().theme = Theme.STANDARD
        htmlReporter.config().css = ".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}"
        extent = ExtentReports()
        extent!!.attachReporter(htmlReporter)
        extent!!.setReportUsesManualConfiguration(true)
    }

    private fun buildTestNodes(extenttest: ExtentTest?, tests: IResultMap, status: Status) {
        var categories = arrayOfNulls<String>(0)
        if (extenttest != null) {
            val categoryList = extenttest.model.categoryContext.all
            categories = arrayOfNulls(categoryList.size)
            for (index in categoryList.indices) {
                categories[index] = categoryList[index].name
            }
        }

        var test: ExtentTest

        if (tests.size() > 0) {
            val treeSet = TreeSet<ITestResult> { o1, o2 -> if (o1.startMillis < o2.startMillis) -1 else 1 }
            treeSet.addAll(tests.allResults)
            for (result in treeSet) {
                val parameters = result.parameters
                var name = ""
                for (param in parameters) {
                    name += param.toString()
                }
                if (name.isNotEmpty()) {
                    if (name.length > 50) {
                        name = name.substring(0, 49) + "..."
                    }
                } else {
                    name = result.method.methodName
                }
                test = if (extenttest == null) {
                    extent!!.createTest(name)
                } else {
                    extenttest.createNode(name).assignCategory(*categories)
                }
                for (group in result.method.groups)
                    test.assignCategory(group)

                val outputList = Reporter.getOutput(result)
                for (output in outputList) {
                    test.debug(output)
                }
                if (result.throwable != null) {
                    test.log(status, result.throwable)
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed")
                }

                test.model.startTime = getTime(result.startMillis)
                test.model.endTime = getTime(result.endMillis)
            }
        }
    }

    private fun getTime(millis: Long): Date {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millis
        return calendar.time
    }

    companion object {
        private const val OUTPUT_FOLDER = "test-output/"
        private const val FILE_NAME = "index.html"
    }

}
