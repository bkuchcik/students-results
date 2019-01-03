package com.students.results.teacher


interface Modules {
    fun addModule(module: Module): Unit
    fun findAllModules(): List<Module>
    fun teachModule(teacher: Teacher, module: Module)
}

data class Module(val name: String, val description: String, val teachers: List<Teacher> = listOf())
