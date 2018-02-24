package com.kru.kotboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
class ResourceNotFoundException(override val message: String?): RuntimeException()