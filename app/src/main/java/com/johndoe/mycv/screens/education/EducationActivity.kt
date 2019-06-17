package com.johndoe.mycv.screens.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.johndoe.mycv.R
import org.koin.android.viewmodel.ext.android.viewModel

class EducationActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    val viewModel: EducationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)
    }
}
