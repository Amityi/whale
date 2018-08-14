package com.zhongyu.utils

import com.esotericsoftware.yamlbeans.YamlConfig
import com.esotericsoftware.yamlbeans.YamlException
import com.esotericsoftware.yamlbeans.YamlReader
import java.io.FileNotFoundException
import java.io.FileReader

/**
 * @author ZhongYu
 */
class AddressUtil {

    fun exists(root: String): Boolean {
        val yml = yaml
        if (null != yml!![root]) {
            return true
        }
        return false
    }

    fun getInfo(root: String, key: String): String {
        val yml = yaml
        try {
            val maps = yml!![root] as Map<*, *>
            return maps[key].toString()
        } catch (e: NullPointerException) {
            throw RuntimeException("元素未找到!")
        }

    }

    fun getAddress(root: String, key: String): String {
        val yml = yaml
        try {
            val maps = yml!![root] as Map<*, *>
            // 此处写死,address.yml中必须与此一致
            val address = maps["address"] as Map<String, Any>
            return address[key].toString()
        } catch (e: NullPointerException) {
            throw RuntimeException("元素未找到!")
        }

    }

    companion object {

        @Volatile
        private var addressUtil: AddressUtil? = null

        val instance: AddressUtil?
            get() {
                if (addressUtil == null) {
                    synchronized(AddressUtil::class.java) {
                        if (addressUtil == null) {
                            addressUtil = AddressUtil()
                        }
                    }
                }
                return addressUtil
            }

        private val yaml: Map<String, Any>?
            get() {
                val config = YamlConfig()
                config.setAllowDuplicates(false)
                val reader: YamlReader
                var `object`: Any? = null
                try {
                    reader = YamlReader(FileReader("src/main/resources/address.yml"), config)
                    `object` = reader.read()
                } catch (e: FileNotFoundException) {
                    throw RuntimeException("address.yml文件未找到")
                } catch (e: YamlException) {
                    e.printStackTrace()
                }

                return `object` as Map<String, Any>?
            }

        @JvmStatic
        fun main(args: Array<String>) {
            val info = AddressUtil.instance!!.getInfo("hk", "name")
            val address = AddressUtil.instance!!.getAddress("hk", "address_1")
            print(AddressUtil.instance!!.exists("hk"))
            println(info)
            println(address)
        }
    }

}
