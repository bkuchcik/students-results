package repository.impl

import arrow.core.Either
import com.students.results.entities.Exam
import com.students.results.repository.ExamsRepository
import com.students.results.repository.NotFoundException

class ExamsRepositoryImpl : ExamsRepository {
    override fun findExamById(examId: Long): Either<NotFoundException, Exam> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}