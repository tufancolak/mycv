package com.johndoe.mycv.screens.profile.glue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.johndoe.mycv.repository.Repository
import com.johndoe.mycv.screens.profile.ProfileViewModel

class ProfileViewModelFactory : ViewModelProvider.Factory {


    /**
     * Creates a new instance of the given `Class`.
     *
     * @param modelClass a `Class` whose instance is requested
     * @param <T>        The type parameter for the ViewModel.
     * @return a newly created ViewModel
    </T> */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return getCurrentViewModel() as T
    }

    companion object {

        private var viewModel: ProfileViewModel? = null

        fun setMockViewModel(mockViewModel: ProfileViewModel?) {
            viewModel = mockViewModel
        }

        fun getCurrentViewModel(): ProfileViewModel {
            if (viewModel != null) {
                return viewModel as ProfileViewModel
            }
            return ProfileViewModel(Repository)
        }
    }

}