package com.students.results.repository

import arrow.core.Either
import com.students.results.entities.Exam

interface ExamsRepository {

    fun findExamById(examId: Long): Either<NotFoundException, Exam>
}