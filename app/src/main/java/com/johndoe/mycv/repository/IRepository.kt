package com.johndoe.mycv.repository
import com.johndoe.mycv.repository.model.Education
import com.johndoe.mycv.repository.model.Resume
import com.johndoe.mycv.repository.model.Work
import io.reactivex.Observable
interface IRepository {

    fun getData() : Observable<Resume>

    fun getWork() : Observable<ArrayList<Work>>

    fun getEducation() : Observable<ArrayList<Education>>
}