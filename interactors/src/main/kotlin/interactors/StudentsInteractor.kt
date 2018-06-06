package com.students.results.interactors

import arrow.core.Either
import arrow.core.flatMap
import com.students.results.repository.ExamsRepository
import com.students.results.repository.StudentsRepository
import com.students.results.services.NotateExamException
import com.students.results.services.Students
import com.students.results.services.requests.NotateExam

class StudentsInteractor(private val studentsRepository: StudentsRepository, private val examsRepository: ExamsRepository) : Students {

    override fun notate(notateExam: NotateExam): Either<NotateExamException, Unit> =
            studentsRepository.findStudentById(studentId = 1).flatMap { student ->
                examsRepository.findExamById(examId = notateExam.examId).flatMap { exam ->
                    student.notate(exam, notateExam.note).flatMap { updatedStudent ->
                        studentsRepository.save(updatedStudent)
                    }
                }
            }.mapLeft { NotateExamException(throwable = it) }

}
