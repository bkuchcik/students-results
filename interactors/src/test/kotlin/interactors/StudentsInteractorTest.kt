package com.students.results.interactors

import arrow.core.Either
import com.students.results.services.requests.NotateExam
import entities.Student
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should be instance of`
import org.amshove.kluent.`should be`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import repository.StudentsRepository


class StudentsInteractorTest : Spek({

    given("a student interactor") {

        val studentRepository = mockk<StudentsRepository>() {
            every { findStudentById(any()) } returns Either.right(Student(id = 10L))
        }
        val studentsInteractor = StudentsInteractor(studentRepository)
        it("should notate an existing exam with a note of 20") {
            studentsInteractor.notate20().isRight() `should be` true
        }
        it("should retrieve student by his id") {
            studentsInteractor.notate20()
            verify { studentRepository.findStudentById(1) }
        }
    }
})


private fun StudentsInteractor.notate20() = notate(NotateExam(
        examId = 5,
        studentId = 1,
        note = "20".toBigDecimal()
))