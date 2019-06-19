package com.johndoe.mycv.testutil

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing

abstract class JunitTestConfig {

    /**
     * Taken from https://github.com/nhaarman/mockito-kotlin
     * Method used to change Mockito`when` to whenever
     */
    fun <T> whenever(methodCall: T): OngoingStubbing<T> = Mockito.`when`(methodCall)!!

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val rxSchedulerRule = RxSchedulersOverrideRule()
}