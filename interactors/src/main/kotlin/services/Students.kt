package com.students.results.services

import arrow.core.Either
import com.students.results.services.requests.NotateExam

interface Students {

    fun notate(notateExam: NotateExam): Either<NotateExamException, Unit>

}
