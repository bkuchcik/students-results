package com.students.results.interactors

import arrow.core.Either
import com.students.results.entities.Exam
import com.students.results.repository.ExamsRepository
import com.students.results.services.requests.NotateExam
import io.mockk.every
import io.mockk.verify
import org.amshove.kluent.mock
import org.amshove.kluent.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.mockito.ArgumentMatchers.anyLong

class ExamsInteractorTest : Spek({

    val examsRepository = mock<ExamsRepository>()
    given("an exam interactor") {
        val examsInteractor = ExamsInteractor(examsRepository)
        it("should notate an exam, done by a student, with a note of 18") {
            examsInteractor.notate20().isRight() shouldBe true
        }
        it("should locate the exam from the exam repository") {
            every { examsRepository.findExamById(anyLong()) } returns  Either.right(Exam(5L))
            examsInteractor.notate20()
            verify { examsRepository.findExamById(5) }
        }
    }
})

private fun ExamsInteractor.notate20() = notate(NotateExam(
        examId = 5,
        studentId = 1,
        note = "20".toBigDecimal()
))