package com.johndoe.mycv.screens.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.profile.glue.ProfileViewModelFactory
import com.johndoe.mycv.screens.work.WorkActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.adapter_education_item.*
import kotlinx.android.synthetic.main.adapter_work_item.*
import kotlinx.android.synthetic.main.component_basic_info.*
import kotlinx.android.synthetic.main.component_error.*
import kotlinx.android.synthetic.main.component_profile.*

class ProfileActivity : AppCompatActivity() {

    // Has to be injected later on
    private val viewModelFactory = ProfileViewModelFactory()

    private lateinit var viewModel: ProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProfileViewModel::class.java)
        bindViews()
        observe()
        viewModel.retrieveData()
    }

    // Bind views
    private fun bindViews() {

        // Temporary actions
        button_work.setOnClickListener {
            val intent = Intent(this@ProfileActivity, WorkActivity::class.java)
            startActivity(intent)
        }

        button_education.setOnClickListener {
            val intent = Intent(this@ProfileActivity, EducationActivity::class.java)
            startActivity(intent)
        }

        textView_retry.setOnClickListener {
            viewModel.retrieveData()
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
            // Show just the first one in the main profile
            if(value.education.isNotEmpty()){
                adapter_education_item_area.text= value.education[0].area
                adapter_education_item_end.text = value.education[0].endDate
                adapter_education_item_start.text = value.education[0].startDate
                adapter_education_item_study_type.text = value.education[0].studyType
                adapter_education_item_institution.text = value.education[0].institution
                view_education.visibility=View.VISIBLE
            } else {
                view_education.visibility=View.GONE
            }

            // Show just the first one in the main profile
            if(value.work.isNotEmpty()){
                adapter_work_item_company.text = value.work[0].company
                adapter_work_item_end.text = value.work[0].endDate
                adapter_work_item_start.text = value.work[0].startDate
                adapter_work_item_position.text = value.work[0].position
                adapter_work_item_summary.text = value.work[0].summary
                view_work.visibility=View.VISIBLE
            } else {
                view_work.visibility=View.GONE
            }
        })
    }
}
