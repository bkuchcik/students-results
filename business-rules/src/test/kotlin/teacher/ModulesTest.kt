package com.students.results.teacher

import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldContain
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class ModulesTest : Spek({
    describe("all the teached modules") {
        val modules: Modules = MockModules()
        val module = Module(name = "web in java or kotlin", description = """
                The class shows how to code a new web application with java framework
                Examples are coded in Kotlin too
            """.trimIndent())
        modules.addModule(module)

        it("adding a modules to the existing should add it to the module list") {
            modules.findAllModules().also {
                it.size shouldEqual 1
                it shouldContain module
            }
        }

        it("a teacher can teach a module") {
            val teacher = Teacher(id = "aTeacher")
            modules.teachModule(teacher, module)
            modules.findAllModules().also {
                it.size shouldEqual 1
                it[0].teachers shouldEqual teacher
            }
        }
    }
})

class MockModules(private var modules: MutableList<Module> = mutableListOf()) : Modules {
    override fun teachModule(teacher: Teacher, module: Module) {
        modules = modules.map {
            if (it == module) {
                it.copy(teachers = it.teachers + teacher)
            } else {
                it
            }
        }.toMutableList()
    }

    override fun addModule(module: Module) {
        modules.add(module)
    }

    override fun findAllModules() = modules
}