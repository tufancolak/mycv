package com.johndoe.mycv.screens.work

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.repository.MockRepository
import com.johndoe.mycv.screens.work.glue.WorkViewModelFactory
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class WorkActivityTest : RobolectricTestConfig() {

    lateinit var mockViewModel: WorkViewModel
    private lateinit var activity: WorkActivity

    @get:Rule
    val rule = ActivityTestRule(WorkActivity::class.java,true,false)


    @Before
    fun setup() {

        mockViewModel = Mockito.mock(WorkViewModel::class.java)
        whenever(mockViewModel.getWorkList()).thenReturn(MockRepository().getWork())
        WorkViewModelFactory.setMockViewModel(mockViewModel)

        activity = rule.launchActivity(Intent())
    }

    @After
    fun tearDown() {
        rule.finishActivity()
        WorkViewModelFactory.setMockViewModel(null)
    }

    @Test
    fun whenStartedEverythingShouldBeFine() {
        assertNotNull(activity)
    }

    @Test
    fun whenActivityStartedDataOnRecycleViewShouldBeCorrect() {

        val expected = MockRepository().getResume().work.size

        assertEquals(expected, activity.workRecyclerView.adapter?.itemCount)
    }
}