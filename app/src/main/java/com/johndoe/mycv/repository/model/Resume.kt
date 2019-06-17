package com.johndoe.mycv.repository.model

data class Resume(
    val awards: List<Award>,
    val basics: Basics,
    val education: List<Education>,
    val interests: List<Interest>,
    val languages: List<Language>,
    val publications: List<Publication>,
    val references: List<Reference>,
    val skills: List<Skill>,
    val volunteer: List<Volunteer>,
    val work: List<Work>
)