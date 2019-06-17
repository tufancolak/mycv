package com.johndoe.mycv.screens.work

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.johndoe.mycv.R
import org.koin.android.viewmodel.ext.android.viewModel

class WorkExperienceActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    val viewModel: WorkExperienceViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_experience)
    }
}
