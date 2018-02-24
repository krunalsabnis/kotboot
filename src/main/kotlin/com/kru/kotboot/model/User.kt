package com.kru.kotboot.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
        @Column(name="user_id")
        private val userId: Long = 0,
        var uid: String? = null,
        var provider: String? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        val email: String? = null,
        var active: Boolean = false,
        var activatedAt: Date? = null,
        var loginAt: Date? = null,
        var logoutAt: Date? = null,
        private var timestamp: Date? = Date()) {


    @OneToMany(fetch = FetchType.LAZY, cascade = [(CascadeType.DETACH)])
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private val projects: MutableSet<Project> = HashSet()

    fun toDto(): UserDto = UserDto(
                userId = this.userId,
                uid = this.uid,
                provider = this.provider,
                firstName = this.firstName,
                lastName = this.lastName,
                email = this.email,
                active = this.active,
                activatedAt = this.activatedAt,
                loginAt = this.loginAt,
                logoutAt = this.logoutAt,
                timestamp = this.timestamp,
                projects = this.projects.map { x-> x.toDto() }.toCollection(HashSet()))

    companion object {
        fun fromDto(userReq: UserCreateRequest) = User(
                firstName = userReq.firstName,
                lastName = userReq.lastName,
                email = userReq.email)
    }
}


