package services

import arrow.core.Either
import com.students.results.services.requests.NotateExam

interface Exams {
    fun notate(notation: NotateExam): Either<NotateExamException, Unit>
}

class NotateExamException(message: String? = null, throwable: Throwable? = null) : RuntimeException(message, throwable)
