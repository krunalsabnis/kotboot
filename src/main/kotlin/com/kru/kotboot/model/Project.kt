package com.kru.kotboot.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "project")
data class Project(
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
        var id: Long = 0,
        var name: String? = null,
        var description: String? = null,
        var code: String? = null,
        var icon: String? = null,
        var active: Boolean? = false,
        var timestamp: Date? = Date(),
        @Column(name="user_id")
        var userId: Long? = null) {

        fun toDto(): ProjectDTO = ProjectDTO(
                id = this.id,
                name = this.name,
                description = this.description,
                code = this.code,
                icon = this.icon,
                active = this.active,
                timestamp = this.timestamp,
                userId = this.userId)

    companion object {
        fun fromDto(pDto: ProjectDTO) = Project(
                id = pDto.id,
                name = pDto.name,
                description = pDto.description,
                code = pDto.code,
                icon = pDto.icon,
                active = pDto.active,
                timestamp = pDto.timestamp,
                userId = pDto.userId)
    }
}
