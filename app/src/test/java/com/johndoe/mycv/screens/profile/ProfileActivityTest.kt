package com.johndoe.mycv.screens.profile

import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.profile.glue.ProfileViewModelFactory
import com.johndoe.mycv.screens.work.WorkActivity
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.Shadows.shadowOf


@LargeTest
class ProfileActivityTest : RobolectricTestConfig() {

    @Mock
    lateinit var mockViewModel: ProfileViewModel
    private lateinit var activity: ProfileActivity

    @get:Rule
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @get:Rule
    val instantRule = InstantTaskExecutorRule()



    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mockViewModel = Mockito.mock(ProfileViewModel::class.java)

        val resume = MutableLiveData<Resume>()
        resume.value = IRepository.resumeData

        val show = MutableLiveData<Boolean>()
        show.value = true

        val dontShow = MutableLiveData<Boolean>()
        dontShow.value = false

        whenever(mockViewModel.observeResumeData()).thenReturn(resume)
        whenever(mockViewModel.observeErrorView()).thenReturn(dontShow)
        whenever(mockViewModel.observeProfileView()).thenReturn(show)
        whenever(mockViewModel.observeProgressView()).thenReturn(dontShow)

        ProfileViewModelFactory.setMockViewModel(mockViewModel)
        activity = rule.activity
    }


    @After
    fun tearDown() {
        rule.finishActivity()
    }



    @Test
    fun whenWorkExperienceViewClickedWorkExperienceActivityWillLaunch() {

        val shadowActivity = shadowOf(activity)


        activity.findViewById<TextView>(R.id.button_work).performClick()

        assertEquals(
            WorkActivity::class.java!!.name,
            shadowActivity.nextStartedActivity.component.className
        )
    }

    @Test
    fun whenEducationViewClickedEducationActivityWillLaunch() {

        val shadowActivity = shadowOf(activity)

        activity.findViewById<TextView>(R.id.button_education).performClick()

        assertEquals(
            EducationActivity::class.java!!.name,
            shadowActivity.nextStartedActivity.component.className
        )
    }

    @Test
    fun whenDataRetrievedNameWillBeAvailable() {

        val expected = IRepository.resumeData.basics.name

        onView(withId(R.id.textView_name)).check(matches(withText(expected)))
    }

    @Test
    fun whenDataRetrievedEmailWillBeAvailable() {

        val expected = IRepository.resumeData.basics.email

        onView(withId(R.id.textView_email)).check(matches(withText(expected)))
    }

    @Test
    fun whenDataRetrievedPhoneNumberWillBeAvailable() {

        val expected = IRepository.resumeData.basics.phone

        onView(withId(R.id.textView_phone)).check(matches(withText(expected)))
    }

    @Test
    fun whenDataRetrievedSummaryWillBeAvailable() {

        val expected = IRepository.resumeData.basics.summary

        onView(withId(R.id.textView_summary)).check(matches(withText(expected)))
    }
}