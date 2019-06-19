package com.johndoe.mycv.repository.model

data class Resume(
    val basics: Basics,
    val education: List<Education>,
    val work: List<Work>
)