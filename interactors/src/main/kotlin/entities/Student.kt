package com.students.results.entities

import arrow.core.Either
import java.math.BigDecimal

typealias Notes = Map<Exam, BigDecimal>

data class Student(val id: Long, val notes: Notes = emptyMap()) {
    fun getNotation(exam: Exam): Either<NotEvaluatedException, BigDecimal> =
            when {
                notes.containsKey(exam) -> Either.right(notes.getValue(exam))
                else -> Either.left(NotEvaluatedException())
            }

    fun notate(exam: Exam, note: BigDecimal): Either<InvalidNotationForThisExamException, Student> =
            exam.validateNotation(note).map {
                copy(id = id,
                        notes = notes + mapOf(exam to note))
            }
}

class NotEvaluatedException(msg: String? = null, throwable: Throwable? = null) : RuntimeException(msg, throwable)