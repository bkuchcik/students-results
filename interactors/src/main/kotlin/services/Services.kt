package services

sealed class ServicesException(msg: String? = null, throwable: Throwable? = null) : RuntimeException(msg, throwable)

class NotFoundException(msg: String? = null, throwable: Throwable? = null) : ServicesException(msg, throwable)