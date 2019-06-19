package com.johndoe.mycv.screens.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.johndoe.mycv.R
import com.johndoe.mycv.repository.model.Education

open class EducationAdapter(private var educationData: ArrayList<Education>) :
    RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(getLayoutInflater(parent))
    }


    private fun getLayoutInflater(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.adapter_education_item, parent, false)
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return educationData.size
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.institution?.text = educationData[position].institution
        holder.startDate?.text = educationData[position].startDate
        holder.endDate?.text = educationData[position].endDate
        holder.studyType?.text = educationData[position].studyType
        holder.area?.text = educationData[position].area

    }


    inner class EducationViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val institution = itemView?.findViewById<TextView>(R.id.adapter_education_item_institution)
        val studyType = itemView?.findViewById<TextView>(R.id.adapter_education_item_study_type)
        val startDate = itemView?.findViewById<TextView>(R.id.adapter_education_item_start)
        val endDate = itemView?.findViewById<TextView>(R.id.adapter_education_item_end)
        val area = itemView?.findViewById<TextView>(R.id.adapter_education_item_area)
    }
}