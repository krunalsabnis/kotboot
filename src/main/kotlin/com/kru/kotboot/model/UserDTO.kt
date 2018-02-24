package com.kru.kotboot.model

import java.util.*

open class UserDTO(val firstName: String,
                   val lastName: String,
                   val email: String)


class UserDetailsDTO(
        firstName: String,
        lastName: String,
        email: String,
        val userId: Long,
        val active: Boolean,
        val uid: String,
        val provider: String,
        val activatedAt: Date,
        val loginAt: Date,
        val logoutAt: Date,
        val timestamp: Date
        ) : UserDTO(firstName, lastName, email)