package com.johndoe.mycv.screens.education

import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider
import com.johndoe.mycv.repository.MockRepository
import com.johndoe.mycv.repository.model.Education
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class EducationAdapterTest : RobolectricTestConfig() {

    lateinit var educationAdapter: EducationAdapter

    @Before
    fun setUp() {
        educationAdapter = EducationAdapter(getMockEducation())
    }


    @Test
    fun onCreateViewHolder() {
        val view: EducationAdapter.EducationViewHolder =
            educationAdapter.onCreateViewHolder(FrameLayout(ApplicationProvider.getApplicationContext()), 0)
        assertNotNull(view)
    }

    @Test
    fun getItemCount() {
        assertEquals(getMockEducation().size, educationAdapter.itemCount)
    }


    @Test
    fun onBindViewHolder() {
        val view: EducationAdapter.EducationViewHolder =
            educationAdapter.onCreateViewHolder(FrameLayout(ApplicationProvider.getApplicationContext()), 0)

        educationAdapter.onBindViewHolder(view,0)

        assertEquals(view.institution?.text, getMockEducation().get(0).institution)
        assertEquals(view.startDate?.text, getMockEducation().get(0).startDate)
        assertEquals(view.endDate?.text, getMockEducation().get(0).endDate)
        assertEquals(view.studyType?.text, getMockEducation().get(0).studyType)
        assertEquals(view.area?.text, getMockEducation().get(0).area)
    }

    // Get the mock data
    fun getMockEducation(): ArrayList<Education> {
        return MockRepository().getEducation()
    }
}