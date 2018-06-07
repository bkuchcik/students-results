package com.students.results.interactors

import arrow.core.Either
import com.students.results.entities.Exam
import com.students.results.entities.Student
import com.students.results.repository.ExamsRepository
import com.students.results.repository.StudentsRepository
import com.students.results.services.requests.GradeExam
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


class StudentsInteractorTest : Spek({

    val student = Student(id = 10L)
    given("a student interactor") {

        val studentSlot = slot<Student>()
        val studentRepository = mockk<StudentsRepository>() {
            every { findStudentById(3) } returns Either.right(student)
            every { save(student = capture(studentSlot)) } returns Either.right(Unit)
        }
        val exam = Exam(id = 5)
        val examsRepository = mockk<ExamsRepository>().apply {
            every { findExamById(5) } returns Either.right(exam)
        }
        val studentsInteractor = StudentsInteractor(studentRepository, examsRepository)
        studentsInteractor.notate20().apply {
            it("should retrieve student by his id") {
                verify { studentRepository.findStudentById(3) }
            }
            it("should retrieve exam by id") {
                verify { examsRepository.findExamById(5) }
            }
            it("should save student to the repository with the expected notation of 20 for this exam") {
                studentSlot.captured.getNotation(exam).apply {
                    isRight() shouldBe true
                    map { it shouldEqual "20".toBigDecimal() }
                }
            }
        }
    }
})

private fun StudentsInteractor.notate20() = grade(GradeExam(
        examId = 5,
        studentId = 3,
        grade = "20".toBigDecimal()
))