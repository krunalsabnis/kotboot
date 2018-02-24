package com.kru.kotboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "duplicate record")
class DuplicateException(override val message: String?): RuntimeException()