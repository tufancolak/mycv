package com.johndoe.mycv.screens.education

import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.testutil.JunitTestConfig
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class EducationViewModelTest : JunitTestConfig() {

    @Mock
    var repository = mock<IRepository>(IRepository::class.java)

    private var viewModel: EducationViewModel? = null

    @Before
    fun setUp() {
        viewModel = EducationViewModel(repository)
    }

    @Test
    fun testIfViewModelLaunchesProperly() {
        assertNotNull(viewModel)
    }
    @Test
    fun whenEducationListIsRequestedThenItShouldBeRequestedFromRepository() {
        viewModel?.getEducationList()

        verify(repository).getEducation()
    }


}