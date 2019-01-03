package com.students.results.teacher

data class Teacher(val id:String, val modules: List<Module> = listOf()) {
    fun addNewModule(module: Module): Teacher = Teacher("toto")
}

