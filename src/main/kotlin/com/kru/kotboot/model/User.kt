package com.kru.kotboot.model

import java.util.*
import javax.persistence.*

@Entity(name = "user")
data class User (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val userId: Long = 0,
        val uid: String,
        val provider: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        val active: Boolean,
        val activatedAt: Date,
        val loginAt: Date,
        val logOutAt: Date,
        val timeStamp: Date) {


        fun toUserDto(): UserDTO {
            return UserDTO(this.firstName, this.lastName, this.email)
        }

        fun toUserDetailDto(): UserDetailsDTO {
            return UserDetailsDTO(this.firstName, this.lastName, this.email,
                    this.userId, this.active, this.uid, this.provider,
                    this.activatedAt, this.loginAt, this.logOutAt,
                    this.timeStamp)
        }
}


