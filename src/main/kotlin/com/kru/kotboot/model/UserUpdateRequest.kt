package com.kru.kotboot.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(value= JsonInclude.Include.NON_NULL)
data class UserUpdateRequest(
        var uid: String,
        var firstName: String,
        var provider: String,
        var lastName: String,
        var active: Boolean,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var activatedAt: Date,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var loginAt: Date,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var logoutAt: Date)