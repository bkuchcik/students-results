package com.students.results.interactors

import arrow.core.Either
import com.students.results.repository.ExamsRepository
import com.students.results.services.requests.NotateExam
import services.Exams
import services.NotateExamException

class ExamsInteractor(private val examsRepository: ExamsRepository) : Exams {
    override fun notate(notation: NotateExam): Either<RuntimeException, Unit> =
            examsRepository.findExamById(notation.examId).bimap({
                NotateExamException(throwable = it)
            }, {
                println("$it")
                Unit
            })
}
