package com.students.results.repository


sealed class RepositoryException(msg: String? = null, throwable: Throwable? = null) : Exception(msg, throwable)

class NotFoundException(msg: String? = null, throwable: Throwable? = null) : RepositoryException(msg, throwable)
class NotWrittenException(msg: String? = null, throwable: Throwable? = null) : RepositoryException(msg, throwable)
class RepositoryNotAvailableException(msg: String? = null, throwable: Throwable? = null) : RepositoryException(msg, throwable)