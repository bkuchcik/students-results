package com.students.results.repository

import arrow.core.Either
import com.students.results.entities.Student

interface StudentsRepository {

    fun findStudentById(studentId: Long): Either<RepositoryException, Student>
    fun save(student: Student): Either<RepositoryException, Unit>
}