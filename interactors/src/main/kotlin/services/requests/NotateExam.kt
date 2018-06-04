package com.students.results.services.requests

import java.math.BigDecimal

data class NotateExam(val examId: Long, val studentId: Long, val note: BigDecimal)
