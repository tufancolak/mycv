package com.johndoe.mycv.screens.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.work.WorkExperienceActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.component_profile.*
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        bindViews()
        observe()
        viewModel.retrieveData()
    }

    // Bind views
    private fun bindViews() {

        // Temporary actions
        button_work.setOnClickListener {
            val intent = Intent(this@ProfileActivity, WorkExperienceActivity::class.java)
            startActivity(intent)
        }

        button_education.setOnClickListener {
            val intent = Intent(this@ProfileActivity, EducationActivity::class.java)
            startActivity(intent)
        }
    }

    // Observe ViewModel
    private fun observe() {

        // Observe View states

        viewModel.observeErrorView().observe(this, Observer<Boolean> { value ->
            view_error.visibility = if (value == true) View.VISIBLE else View.INVISIBLE
        })

        viewModel.observeProfileView().observe(this, Observer<Boolean> { value ->
            view_profile.visibility = if (value == true) View.VISIBLE else View.INVISIBLE
        })

        viewModel.observeProgressView().observe(this, Observer<Boolean> { value ->
            view_loading.visibility = if (value == true) View.VISIBLE else View.INVISIBLE
        })

        viewModel.observeResumeData().observe(this, Observer<Resume> { value ->
            textView_name.text = value.basics.name
            textView_email.text = value.basics.email
            textView_phone.text = value.basics.phone
            textView_summary.text = value.basics.summary
        })
    }
}
