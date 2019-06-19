package com.johndoe.mycv.repository

import com.johndoe.mycv.repository.model.Education
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.repository.model.Work
import com.johndoe.mycv.repository.network.IApi
import io.reactivex.Observable

object Repository : IRepository {


    // Used for saving it in the memory
    private lateinit var resume: Resume


    private val api by lazy {
        IApi.create()
    }

    override fun getData(): Observable<Resume> {
        return api.getResume()
    }

    override fun getEducation(): ArrayList<Education> {
        return ArrayList(this.resume.education)
    }

    override fun getWork(): ArrayList<Work> {
        return ArrayList(this.resume.work)
    }

    override fun storeResume(resume: Resume) {
        this.resume = resume
    }


}