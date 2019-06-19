package com.johndoe.mycv.screens.profile

import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.testutil.JunitTestConfig
import io.reactivex.Observable
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock


class ProfileViewModelTest : JunitTestConfig() {

    @Mock
    var repository = mock<IRepository>(IRepository::class.java)

    @Mock
    var resume = mock<Resume>(Resume::class.java)

    private var viewModel: ProfileViewModel? = null

    @Before
    fun setUp() {
        viewModel = ProfileViewModel(repository)
    }

    @Test
    fun testIfViewModelIsThere() {
        assertNotNull(viewModel)
    }

    @Test
    fun whenInitiatedObserveProgressViewWillBeTrue() {
        val expected = true
        assertEquals( expected, viewModel?.observeProgressView()?.value)
    }

    @Test
    fun whenInitiatedObserveProfileViewWillBeFalse() {
        val expected = false
        assertEquals( expected, viewModel?.observeProfileView()?.value)
    }

    @Test
    fun whenInitiatedObserveErrorViewWillBeTrue() {
        val expected = false
        assertEquals( expected, viewModel?.observeErrorView()?.value)
    }


    @Test
    fun whenThereIsNoErrorInGettingDataObserveProfileViewWillBeTrue() {
        val expected = true
        whenever(repository?.getData()).thenReturn(Observable.just((resume)))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeProfileView()?.value)
    }

    @Test
    fun whenThereIsNoErrorInGettingDataObserveErrorViewWillBeFalse() {
        val expected = false
        whenever(repository?.getData()).thenReturn(Observable.just((resume)))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeErrorView()?.value)
    }

    @Test
    fun whenThereIsNoErrorInGettingDataObserveProgressViewWillBeFalse() {
        val expected = false
        whenever(repository?.getData()).thenReturn(Observable.just((resume)))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeProgressView()?.value)
    }

    @Test
    fun whenThereIsAnErrorInGettingDataObserveErrorViewWillBeTrue() {
        val expected = true
        whenever(repository?.getData()).thenReturn(Observable.error(Throwable()))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeErrorView()?.value)
    }

    @Test
    fun whenThereIsAnErrorInGettingDataObserveProfileViewWillBeFalse() {
        val expected = false
        whenever(repository?.getData()).thenReturn(Observable.error(Throwable()))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeProfileView()?.value)
    }

    @Test
    fun whenThereIsAnErrorInGettingDataObserveProgressViewWillBeFalse() {
        val expected = false
        whenever(repository?.getData()).thenReturn(Observable.error(Throwable()))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeProgressView()?.value)
    }


    @Test
    fun whenThereIsNoErrorInGettingDataObserveResumeDataViewWillBeTheOneSent() {
        val expected = resume
        whenever(repository?.getData()).thenReturn(Observable.just((expected)))

        viewModel?.retrieveData()

        assertEquals( expected, viewModel?.observeResumeData()?.value)
    }
}