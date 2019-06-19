package com.johndoe.mycv.screens.education

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johndoe.mycv.R
import com.johndoe.mycv.screens.education.glue.EducationViewModelFactory
import kotlinx.android.synthetic.main.activity_education.*
import kotlin.collections.ArrayList as ArrayList1

class EducationActivity : AppCompatActivity() {

    // Has to be injected later on
    private val viewModelFactory = EducationViewModelFactory()

    private lateinit var viewModel: EducationViewModel

    lateinit var educationRecyclerView: RecyclerView
    private lateinit var educationLayoutManager: RecyclerView.LayoutManager
    private lateinit var educationAdapter: EducationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(EducationViewModel::class.java)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bindViews()
    }

    private fun bindViews() {
        educationLayoutManager = LinearLayoutManager(this)
        educationAdapter = EducationAdapter(viewModel.getEducationList())
        educationRecyclerView = recycle_view_education.apply {
            this.setHasFixedSize(true)
            this.layoutManager = educationLayoutManager
            this.adapter = educationAdapter

        }
    }
}
