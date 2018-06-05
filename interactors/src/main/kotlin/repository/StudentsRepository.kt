package repository

import arrow.core.Either
import com.students.results.repository.NotFoundException
import entities.Student

interface StudentsRepository {

    fun findStudentById(id: Long): Either<NotFoundException, Student>
}