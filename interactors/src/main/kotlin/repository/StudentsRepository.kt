package repository

import arrow.core.Either
import com.students.results.entities.Student
import com.students.results.repository.NotFoundException
import com.students.results.repository.NotWrittenException
import com.students.results.repository.RepositoryException

interface StudentsRepository {

    fun findStudentById(studentId: Long): Either<RepositoryException, Student>
    fun save(student: Student): Either<RepositoryException, Unit>
}