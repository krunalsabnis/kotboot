package com.kru.kotboot.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@JsonInclude(value= JsonInclude.Include.NON_NULL)
data class UserDto(
        var userId: Long,
        var uid: String? = null,
        var firstName: String,
        var provider: String? = null,
        var lastName: String,
        var email: String,
        var active: Boolean,
        var activatedAt: LocalDateTime? = null,
        var loginAt: LocalDateTime? = null,
        var logoutAt: LocalDateTime? = null,
        var timestamp: LocalDateTime? = null)