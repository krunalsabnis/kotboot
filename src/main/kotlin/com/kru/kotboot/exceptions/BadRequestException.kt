package com.kru.kotboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "invalid input parameters")
class BadRequestException(override val message: String?): RuntimeException()