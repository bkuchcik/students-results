package com.students.results.services.requests

import services.Grade

data class GradeExam(val examId: Long, val studentId: Long, val grade: Grade)
