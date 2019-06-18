package com.johndoe.mycv.screens.education

import androidx.test.rule.ActivityTestRule
import com.johndoe.mycv.repository.Repository
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import org.mockito.Mockito


class EducationActivityTest : RobolectricTestConfig() {

    lateinit var mockViewModel: EducationViewModel
    lateinit var mockRepository: Repository
    lateinit var activity: EducationActivity

    @get:Rule
    val rule = ActivityTestRule(EducationActivity::class.java)

    @Before
    fun setup() {
        mockViewModel = Mockito.mock(EducationViewModel::class.java)

        loadKoinModules(module {
            single { mockRepository }
            viewModel {
                mockViewModel
            }
        })

        activity = rule.activity
    }

    @After
    fun tearDown() {
    }

    @Test
    fun activityallive(){
        assertNotNull(activity)
    }
}