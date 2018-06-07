package services

import java.math.BigDecimal

typealias Grade = BigDecimal
sealed class ServicesException(msg: String? = null, throwable: Throwable? = null) : Exception(msg, throwable)

class NotFoundException(msg: String? = null, throwable: Throwable? = null) : ServicesException(msg, throwable)