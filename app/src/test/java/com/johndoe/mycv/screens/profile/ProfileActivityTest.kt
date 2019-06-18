package com.johndoe.mycv.screens.profile

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.Repository
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.work.WorkExperienceActivity
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.mockito.Mockito
import org.robolectric.Shadows.shadowOf


class ProfileActivityTest : RobolectricTestConfig() {

    lateinit var mockViewModel: ProfileViewModel
    lateinit var mockRepository: Repository
    private lateinit var activity: ProfileActivity

    @get:Rule
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @Before
    fun setup() {
        mockViewModel = Mockito.mock(ProfileViewModel::class.java)
        mockRepository = Mockito.mock(Repository::class.java)

        val resume = MutableLiveData<Resume>()
        resume.value = IRepository.resumeData

        whenever(mockViewModel.observeResumeData()).thenReturn(resume)
        whenever(mockViewModel.observeErrorView()).thenReturn(MutableLiveData())
        whenever(mockViewModel.observeProfileView()).thenReturn(MutableLiveData())
        whenever(mockViewModel.observeProgressView()).thenReturn(MutableLiveData())

        loadKoinModules(module {
            single { mockRepository }
            viewModel {
                mockViewModel
            }
        })

        activity = rule.activity
    }


    @Test
    fun whenWorkExperienceViewClickedWorkExperienceActivityWillLaunch() {

        val shadowActivity = shadowOf(activity)

        onView(withId(R.id.button_work)).perform(ViewActions.click())

        assertEquals(
            WorkExperienceActivity::class.java!!.name,
            shadowActivity.nextStartedActivity.component.className
        )
    }

    @Test
    fun whenEducationViewClickedEducationActivityWillLaunch() {

        val shadowActivity = shadowOf(activity)

        onView(withId(R.id.button_education)).perform(ViewActions.click())

        assertEquals(
            EducationActivity::class.java!!.name,
            shadowActivity.nextStartedActivity.component.className
        )
    }

    @Test
    fun whenDataRetrievedNameWillBeAvailable() {

        val expected = IRepository.resumeData.basics.name

        onView(withId(R.id.textView_name)).check(matches(withText(expected)));
    }
}