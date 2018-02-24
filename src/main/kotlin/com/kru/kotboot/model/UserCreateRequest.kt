package com.kru.kotboot.model

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.executable.ValidateOnExecution

@Validated
data class UserCreateRequest(
        @NotEmpty var firstName: String,
        @NotEmpty var lastName: String,
        @Size(min = 1, max = 20)
        @Pattern(regexp = "^[a-zA-Z]{1,20}")
        @NotEmpty var email: String)