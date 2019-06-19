package com.johndoe.mycv.screens.education

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.repository.MockRepository
import com.johndoe.mycv.screens.education.glue.EducationViewModelFactory
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


class EducationActivityTest : RobolectricTestConfig() {


    lateinit var mockViewModel: EducationViewModel
    private lateinit var activity: EducationActivity

    @get:Rule
    val rule = ActivityTestRule(EducationActivity::class.java,true,false)


    @Before
    fun setup() {
        mockViewModel = Mockito.mock(EducationViewModel::class.java)

        whenever(mockViewModel.getEducationList()).thenReturn(MockRepository().getEducation())
        EducationViewModelFactory.setMockViewModel(mockViewModel)
        activity = rule.launchActivity(Intent())

    }

    @After
    fun tearDown() {
        rule.finishActivity()
        EducationViewModelFactory.setMockViewModel(null)
    }

    @Test
    fun whenActivityStartedEverythingShouldBeFine() {
        assertNotNull(activity)
    }

    @Test
    fun whenActivityStartedDataOnRecycleViewShouldBeCorrect() {

        val expected = MockRepository().getResume().education.size

        assertEquals(expected,activity.educationRecyclerView.adapter?.itemCount)
    }
}