package com.kru.kotboot.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@JsonInclude(value= JsonInclude.Include.NON_NULL)
data class UserUpdateRequest(
        var uid: String,
        @get:Size(min = 1, max = 20) @get:Pattern(regexp = "^[a-zA-Z]{1,20}") var firstName: String,
        var provider: String,
        @get:Size(min = 1, max = 20) @get:Pattern(regexp = "^[a-zA-Z]{1,20}") var lastName: String,
        var active: Boolean,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var activatedAt: Date,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var loginAt: Date,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var logoutAt: Date)