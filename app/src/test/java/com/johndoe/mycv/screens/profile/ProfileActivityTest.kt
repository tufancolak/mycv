package com.johndoe.mycv.screens.profile

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.repository.Repository
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.work.WorkExperienceActivity
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.Assert.assertEquals
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
    lateinit var activity: ProfileActivity

    @get:Rule
    val rule = ActivityTestRule(ProfileActivity::class.java)

    @Before
    fun setup() {
        mockViewModel = Mockito.mock(ProfileViewModel::class.java)

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

        onView(ViewMatchers.withId(com.johndoe.mycv.R.id.button_work)).perform(ViewActions.click())

        assertEquals(WorkExperienceActivity::class.java!!.getName(), shadowActivity.nextStartedActivity.component.className)
    }

    @Test
    fun whenEducationViewClickedEducationActivityWillLaunch() {
        val shadowActivity = shadowOf(activity)

        onView(ViewMatchers.withId(com.johndoe.mycv.R.id.button_education)).perform(ViewActions.click())

        assertEquals(EducationActivity::class.java!!.getName(), shadowActivity.nextStartedActivity.component.className)
    }
}