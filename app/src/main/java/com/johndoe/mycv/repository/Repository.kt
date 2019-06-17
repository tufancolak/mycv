package com.johndoe.mycv.repository

import io.reactivex.Observable

class Repository : IRepository {
    override fun getData(): Observable<CV> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWork(): Observable<ArrayList<Work>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEducation(): Observable<ArrayList<Education>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}