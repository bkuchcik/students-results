package com.students.results.interactors

import arrow.core.Either
import com.students.results.services.NotateExamException
import com.students.results.services.Students
import com.students.results.services.requests.NotateExam
import repository.StudentsRepository

class StudentsInteractor(private val studentsRepository: StudentsRepository) : Students {
    override fun notate(notateExam: NotateExam): Either<NotateExamException, Unit> =
            studentsRepository.findStudentById(1).bimap({
                NotateExamException(throwable = it)
            }, {
                Unit
            })

}
