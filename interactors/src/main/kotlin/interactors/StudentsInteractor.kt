package com.students.results.interactors

import arrow.core.Either
import arrow.core.flatMap
import com.students.results.repository.ExamsRepository
import com.students.results.repository.StudentsRepository
import com.students.results.services.GradeExamException
import com.students.results.services.Students
import com.students.results.services.requests.GradeExam

class StudentsInteractor(private val studentsRepository: StudentsRepository, private val examsRepository: ExamsRepository) : Students {

    override fun grade(gradeExam: GradeExam): Either<GradeExamException, Unit> =
            gradeExam.run {
                studentsRepository.findStudentById(studentId).flatMap { student ->
                    examsRepository.findExamById(examId).flatMap { exam ->
                        student.notate(exam, grade).flatMap { studentsRepository.save(it) }
                    }
                }.mapLeft { GradeExamException(throwable = it) }
            }
}
