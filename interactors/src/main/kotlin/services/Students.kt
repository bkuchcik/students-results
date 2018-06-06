package com.students.results.services

import arrow.core.Either
import com.students.results.services.requests.GradeExam

interface Students {

    fun grade(gradeExam: GradeExam): Either<GradeExamException, Unit>

}
