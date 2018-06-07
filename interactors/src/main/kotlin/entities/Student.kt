package com.students.results.entities

import arrow.core.Either
import services.Grade
import java.math.BigDecimal

typealias Grades = Map<Exam, Grade>

data class Student(val id: Long, val grades: Grades = emptyMap()) {
    fun getNotation(exam: Exam): Either<NotEvaluatedException, BigDecimal> =
            when {
                grades.containsKey(exam) -> Either.right(grades.getValue(exam))
                else -> Either.left(NotEvaluatedException())
            }

    fun notate(exam: Exam, note: BigDecimal): Either<InvalidNotationForThisExamException, Student> =
            exam.validateGrade(note).map {
                copy(grades = grades + mapOf(exam to note))
            }
}

class NotEvaluatedException(msg: String? = null, throwable: Throwable? = null) : Exception(msg, throwable)