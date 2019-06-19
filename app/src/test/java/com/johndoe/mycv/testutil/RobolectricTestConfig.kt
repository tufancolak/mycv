package com.johndoe.mycv.testutil

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.johndoe.mycv.TestBaseApplication
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(application = TestBaseApplication::class)
abstract class RobolectricTestConfig {//} : AutoCloseKoinTest() {

    /**
     * Taken from https://github.com/nhaarman/mockito-kotlin
     * Method used to change Mockito`when` to whenever
     */
    fun <T> whenever(methodCall: T): OngoingStubbing<T> = Mockito.`when`(methodCall)!!

    //@Rule
  //  @JvmField
 //  val rxSchedulerRule = RxSchedulersOverrideRule()

}
