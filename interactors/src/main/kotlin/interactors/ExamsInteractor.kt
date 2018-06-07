package com.students.results.interactors

import com.students.results.repository.ExamsRepository
import com.students.results.services.Exams

class ExamsInteractor(private val examsRepository: ExamsRepository) : Exams
