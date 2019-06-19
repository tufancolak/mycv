package com.johndoe.mycv.screens.profile

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.MockRepository
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
import org.mockito.Mockito
import org.robolectric.Shadows.shadowOf


@LargeTest
class ProfileActivityTest : RobolectricTestConfig() {

    lateinit var mockViewModel: ProfileViewModel
    private lateinit var activity: ProfileActivity

    @get:Rule
    val rule = ActivityTestRule(ProfileActivity::class.java, true, false)


    @Before
    fun setup() {

        mockViewModel = Mockito.mock(ProfileViewModel::class.java)

    }


    fun generalSetup(resumeData : Resume = MockRepository().getResume()) {
        val resume = MutableLiveData<Resume>()
        resume.value = resumeData

        val show = MutableLiveData<Boolean>()
        show.value = true

        val dontShow = MutableLiveData<Boolean>()
        dontShow.value = false

        whenever(mockViewModel.observeResumeData()).thenReturn(resume)
        whenever(mockViewModel.observeErrorView()).thenReturn(dontShow)
        whenever(mockViewModel.observeProfileView()).thenReturn(show)
        whenever(mockViewModel.observeProgressView()).thenReturn(dontShow)

        ProfileViewModelFactory.setMockViewModel(mockViewModel)
    }

    @After
    fun tearDown() {
        rule.finishActivity()
        ProfileViewModelFactory.setMockViewModel(null)
    }

    @Test
    fun whenThereIsWorkDataMoreWorkViewShouldBeVisible() {

        generalSetup()

        activity = rule.launchActivity(Intent())

        assertEquals(
            View.VISIBLE,
            activity.findViewById<View>(R.id.view_work).visibility
        )
    }

    @Test
    fun whenThereIsEducationDataMoreEducationViewShouldBeVisible() {

        generalSetup()

        activity = rule.launchActivity(Intent())

        assertEquals(
            View.VISIBLE,
            activity.findViewById<View>(R.id.view_education).visibility
        )
    }


    @Test
    fun whenThereIsNoWorkDataMoreWorkViewShouldNotBeVisible() {

        generalSetup(MockRepository.resumeEmpty)

        activity = rule.launchActivity(Intent())

        assertEquals(
            View.GONE,
            activity.findViewById<View>(R.id.view_work).visibility
        )
    }

    @Test
    fun whenThereIsNoEducationDataMoreEducationViewShouldNotBeVisible() {

        generalSetup(MockRepository.resumeEmpty)

        activity = rule.launchActivity(Intent())

        assertEquals(
            View.GONE,
            activity.findViewById<View>(R.id.view_education).visibility
        )
    }

    @Test
    fun whenWorkExperienceViewClickedWorkExperienceActivityWillLaunch() {
        generalSetup()
        activity = rule.launchActivity(Intent())
        val shadowActivity = shadowOf(activity)


        activity.findViewById<TextView>(R.id.button_work).performClick()

        assertEquals(
            WorkActivity::class.java!!.name,
            shadowActivity.nextStartedActivity.component.className
        )
    }

    @Test
    fun whenEducationViewClickedEducationActivityWillLaunch() {
        generalSetup()
        activity = rule.launchActivity(Intent())
        val shadowActivity = shadowOf(activity)

        activity.findViewById<TextView>(R.id.button_education).performClick()

        assertEquals(
            EducationActivity::class.java!!.name,
            shadowActivity.nextStartedActivity.component.className
        )
    }

    @Test
    fun whenDataRetrievedNameWillBeAvailable() {
        generalSetup()
        activity = rule.launchActivity(Intent())
        val expected = MockRepository().getResume().basics.name

        onView(withId(R.id.textView_name)).check(matches(withText(expected)))
    }

    @Test
    fun whenDataRetrievedEmailWillBeAvailable() {
        generalSetup()
        activity = rule.launchActivity(Intent())
        val expected = MockRepository().getResume().basics.email

        onView(withId(R.id.textView_email)).check(matches(withText(expected)))
    }

    @Test
    fun whenDataRetrievedPhoneNumberWillBeAvailable() {
        generalSetup()
        activity = rule.launchActivity(Intent())
        val expected = MockRepository().getResume().basics.phone

        onView(withId(R.id.textView_phone)).check(matches(withText(expected)))
    }

    @Test
    fun whenDataRetrievedSummaryWillBeAvailable() {
        generalSetup()
        activity = rule.launchActivity(Intent())
        val expected = MockRepository().getResume().basics.summary

        onView(withId(R.id.textView_summary)).check(matches(withText(expected)))
    }
}