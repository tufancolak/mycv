package com.johndoe.mycv.screens.work

import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.testutil.JunitTestConfig
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class WorkViewModelTest : JunitTestConfig() {

    @Mock
    var repository = mock<IRepository>(IRepository::class.java)

    private var viewModel: WorkViewModel? = null

    @Before
    fun setUp() {
        viewModel = WorkViewModel(repository)
    }

    @Test
    fun testIfViewModelLaunchesProperly() {
        assertNotNull(viewModel)
    }
    @Test
    fun whenWorkListIsRequestedThenItShouldBeRequestedFromRepository() {
        viewModel?.getWorkList()

        verify(repository).getWork()
    }


}