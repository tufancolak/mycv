package com.johndoe.mycv.repository

import com.johndoe.mycv.repository.model.Education
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.repository.model.Work
import io.reactivex.Observable

class Repository : IRepository {
    override fun getData(): Observable<Resume> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWork(): Observable<ArrayList<Work>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEducation(): Observable<ArrayList<Education>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}