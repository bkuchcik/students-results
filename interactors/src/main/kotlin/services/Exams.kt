package com.students.results.services

import arrow.core.Either
import com.students.results.entities.Exam
import com.students.results.services.requests.NotateExam
import services.NotFoundException

interface Exams {
}

class NotateExamException(message: String? = null, throwable: Throwable? = null) : RuntimeException(message, throwable)
