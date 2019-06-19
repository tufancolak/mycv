package com.johndoe.mycv.screens.work.glue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.johndoe.mycv.repository.Repository
import com.johndoe.mycv.screens.work.WorkViewModel

class WorkViewModelFactory : ViewModelProvider.Factory {


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

        private var viewModel: WorkViewModel? = null

        fun setMockViewModel(mockViewModel: WorkViewModel?) {
            viewModel = mockViewModel
        }

        fun getCurrentViewModel(): WorkViewModel {
            if (viewModel != null) {
                return viewModel as WorkViewModel
            }
            return WorkViewModel(Repository)
        }
    }

}