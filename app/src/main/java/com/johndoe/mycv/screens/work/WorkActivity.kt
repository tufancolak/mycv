package com.johndoe.mycv.screens.work

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johndoe.mycv.screens.work.glue.WorkViewModelFactory
import kotlinx.android.synthetic.main.activity_work.*


class WorkActivity : AppCompatActivity() {

    // Has to be injected later on
    private val viewModelFactory = WorkViewModelFactory()

    private lateinit var viewModel: WorkViewModel

    lateinit var workRecyclerView: RecyclerView
    private lateinit var workLayoutManager: RecyclerView.LayoutManager
    private lateinit var workAdapter: WorkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.johndoe.mycv.R.layout.activity_work)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WorkViewModel::class.java)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        bindViews()
    }

    private fun bindViews() {
        workLayoutManager = LinearLayoutManager(this)
        workAdapter = WorkAdapter(viewModel.getWorkList())
        workRecyclerView = recycle_view_work.apply {
            this.setHasFixedSize(true)
            this.layoutManager = workLayoutManager
            this.adapter = workAdapter

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
