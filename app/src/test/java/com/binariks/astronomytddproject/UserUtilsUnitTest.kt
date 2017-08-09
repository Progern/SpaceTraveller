package com.binariks.astronomytddproject

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat

import com.binariks.astronomytddproject.Utils.UserUtils
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserUtilsUnitTest {

    @Test
    fun testPasswordValidator_checkThatValidationIsCorrect() {
        assertThat(UserUtils.validatePassword("23213124"), `is`(true))
        assertThat(UserUtils.validatePassword("2321"), `is`(false))
        assertThat(UserUtils.validatePassword("23 213124"), `is`(true))
        assertThat(UserUtils.validatePassword("23213124 12"), `is`(true))
        assertThat(UserUtils.validatePassword("23213124"), `is`(true))
    }

}
