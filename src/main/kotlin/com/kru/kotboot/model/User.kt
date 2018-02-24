package com.kru.kotboot.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "user")
internal data class User(
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
        @Column(name="user_id")
        val userId: Long = 0,
        val uid: String? = null,
        val provider: String? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        val email: String? = null,
        val active: Boolean=false,
        val activatedAt: LocalDateTime? = null,
        val loginAt: LocalDateTime? = null,
        val logoutAt: LocalDateTime? = null,
        val timestamp: LocalDateTime? = LocalDateTime.now()) {


    fun toDto(): UserDto = UserDto(
                userId = this.userId,
                uid = this.uid.orEmpty(),
                provider = this.provider.orEmpty(),
                firstName = this.firstName!!,
                lastName = this.lastName!!,
                email = this.email!!,
                active = this.active.or(false)
    )

    companion object {
        fun fromDto(dto: UserDto) = User(
                userId = dto.userId,
                uid = dto.uid,
                provider = dto.provider,
                firstName = dto.firstName,
                lastName = dto.lastName,
                email = dto.email,
                active = dto.active,
                activatedAt = dto.activatedAt,
                loginAt = dto.loginAt,
                logoutAt = dto.logoutAt,
                timestamp = dto.timestamp)

        fun fromDto(userReq: UserRequest) = User(
                firstName = userReq.firstName,
                lastName = userReq.lastName,
                email = userReq.email)
    }
}


