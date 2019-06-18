package com.johndoe.mycv.repository

import com.johndoe.mycv.repository.model.*
import io.reactivex.Observable

interface IRepository {

    fun getData(): Observable<Resume>

    fun getWork(): Observable<List<Work>>

    fun getEducation(): Observable<List<Education>>

    /**
     * Object created for development
     */
    companion object {
        val resumeData: Resume
            get() {

                val basics = Basics(
                    "person@email.com",
                    "Label",
                    "John Doe",
                    "0978648997",
                    "http://www.profile.com",
                    arrayListOf(),
                    "I am a hard working individual, working on everything great",
                    "www.mywebsite.com"
                )

                val education = Education(
                    "Software Engineering",
                    arrayOf("Course 1").asList(),
                    "2008",
                    "5",
                    "University of Arizona",
                    "2004",
                    "University"
                )
                val work1 = Work(
                    "New Bank",
                    "Present",
                    arrayOf("Highlight 1").asList(),
                    "Senior Software Engineer",
                    "2012",
                    "Great software engineer worked day and night",
                    "www.newbank.com"
                )
                val work2 = Work(
                    "Old Bank",
                    "2012",
                    arrayOf("Highlight 1").asList(),
                    "Software Engineer",
                    "2009",
                    "Great software engineer worked day and night",
                    "www.oldbank.com"
                )

                val language = Language(
                    "Great", "English"

                )
                return Resume(
                    basics, arrayOf(education).asList(), arrayOf(language).asList(), arrayOf(work1, work2).asList()
                )
            }
    }

}