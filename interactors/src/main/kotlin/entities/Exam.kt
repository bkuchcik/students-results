package com.students.results.entities

import arrow.core.Either
import services.Grade

data class Exam(val id: Long) {
    fun validateGrade(notation: Grade): Either<InvalidNotationForThisExamException, Unit> =
            when (notation) {
                in (0.toBigDecimal()..20.toBigDecimal()) -> Either.right(Unit)
                else -> Either.left(InvalidNotationForThisExamException("This notation, $notation, is not in bound"))
            }
}

class InvalidNotationForThisExamException(msg: String?) : Exception(msg)
