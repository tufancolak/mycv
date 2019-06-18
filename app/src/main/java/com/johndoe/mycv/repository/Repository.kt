package com.johndoe.mycv.repository

import com.johndoe.mycv.repository.model.Education
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.repository.model.Work
import io.reactivex.Observable

class Repository : IRepository {
    override fun getData(): Observable<Resume> {
        return Observable.just(IRepository.resumeData)
    }

    override fun getWork(): Observable<List<Work>> {
        return Observable.just(IRepository.resumeData.work)
    }

    override fun getEducation(): Observable<List<Education>> {
        return Observable.just(IRepository.resumeData.education)
    }

}