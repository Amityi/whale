package com.zhongyu.test

import com.zhongyu.common.Env
import org.testng.annotations.Test

/**
 * @author ZhongYu
 */
class Example {

    @Test
    fun site() {
        println(Env.SITE)
    }

}
