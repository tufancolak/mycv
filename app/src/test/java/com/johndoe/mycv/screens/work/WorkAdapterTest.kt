package com.johndoe.mycv.screens.work

import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider
import com.johndoe.mycv.repository.MockRepository
import com.johndoe.mycv.repository.model.Work
import com.johndoe.mycv.testutil.RobolectricTestConfig
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class WorkAdapterTest : RobolectricTestConfig() {

    lateinit var workAdapter: WorkAdapter

    @Before
    fun setUp() {
        workAdapter = WorkAdapter(getMockWork())
    }


    @Test
    fun onCreateViewHolder() {
        val view: WorkAdapter.WorkViewHolder =
            workAdapter.onCreateViewHolder(FrameLayout(ApplicationProvider.getApplicationContext()), 0)
        TestCase.assertNotNull(view)
    }

    @Test
    fun getItemCount() {
        TestCase.assertEquals(getMockWork().size, workAdapter.itemCount)
    }


    @Test
    fun onBindViewHolder() {
        val view: WorkAdapter.WorkViewHolder =
            workAdapter.onCreateViewHolder(FrameLayout(ApplicationProvider.getApplicationContext()), 0)

        workAdapter.onBindViewHolder(view,0)

        TestCase.assertEquals(view.company?.text, getMockWork().get(0).company)
        TestCase.assertEquals(view.startDate?.text, getMockWork().get(0).startDate)
        TestCase.assertEquals(view.endDate?.text, getMockWork().get(0).endDate)
        TestCase.assertEquals(view.summary?.text, getMockWork().get(0).summary)
        TestCase.assertEquals(view.position?.text, getMockWork().get(0).position)
    }

    // Get the mock data
    fun getMockWork(): ArrayList<Work> {
        return MockRepository().getWork()
    }
}