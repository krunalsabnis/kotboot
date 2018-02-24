package com.kru.kotboot.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@JsonInclude(value= JsonInclude.Include.NON_NULL)
data class UserDto(
        var userId: Long,
        var uid: String? = null,
        var firstName: String? = null,
        var provider: String? = null,
        var lastName: String? = null,
        @Size(min = 1, max = 20)
        @Pattern(regexp = "^[a-zA-Z]{1,20}")
        var email: String? = null,
        var active: Boolean? = false,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var activatedAt: Date? = null,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var loginAt: Date? = null,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var logoutAt: Date? = null,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var timestamp: Date? = null,
        val projects: MutableSet<ProjectDTO>? = null)