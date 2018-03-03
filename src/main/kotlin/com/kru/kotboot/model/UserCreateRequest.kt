package com.kru.kotboot.model

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.executable.ValidateOnExecution

@Validated
data class UserCreateRequest(
        @get:Size(min = 1, max = 20) @get:Pattern(regexp = "^[a-zA-Z]{1,20}") var firstName: String,
        @get:Size(min = 1, max = 20) @get:Pattern(regexp = "^[a-zA-Z]{1,20}") var lastName: String,
        @get:Size(min = 4, max = 50) @get:Pattern(regexp = "[^@]+@[^@]+\\.[^@]+") var email: String)