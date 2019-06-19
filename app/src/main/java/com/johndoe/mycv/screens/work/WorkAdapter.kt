package com.johndoe.mycv.screens.work

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.model.Work

open class WorkAdapter(private var workData: ArrayList<Work>) :
    RecyclerView.Adapter<WorkAdapter.WorkViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        return WorkViewHolder(getLayoutInflater(parent))
    }


    private fun getLayoutInflater(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.adapter_work_item, parent, false)
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return workData.size
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.company?.text = workData[position].company
        holder.startDate?.text = workData[position].startDate
        holder.endDate?.text = workData[position].endDate
        holder.summary?.text = workData[position].summary
        holder.position?.text = workData[position].position

    }


    inner class WorkViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val company = itemView?.findViewById<TextView>(R.id.adapter_work_item_company)
        val summary = itemView?.findViewById<TextView>(R.id.adapter_work_item_summary)
        val startDate = itemView?.findViewById<TextView>(R.id.adapter_work_item_start)
        val endDate = itemView?.findViewById<TextView>(R.id.adapter_work_item_end)
        val position = itemView?.findViewById<TextView>(R.id.adapter_work_item_position)
    }
}