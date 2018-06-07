package repository.impl

import arrow.core.Either
import com.students.results.entities.Student
import com.students.results.repository.RepositoryException
import com.students.results.repository.StudentsRepository

class StudentsRepositoryImpl : StudentsRepository {

    override fun findStudentById(studentId: Long): Either<RepositoryException, Student> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(student: Student): Either<RepositoryException, Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}