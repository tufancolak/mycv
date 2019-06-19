package com.johndoe.mycv.screens.work

import com.johndoe.mycv.repository.model.Work

interface WorkContract {
    fun getWorkList() : ArrayList<Work>
}