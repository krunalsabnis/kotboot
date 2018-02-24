package com.kru.kotboot.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id

@JsonInclude(value= JsonInclude.Include.NON_NULL)
data class ProjectDTO(
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
        var id: Long = 0,
        var name: String ? = null,
        var description: String ? = null,
        var code: String ? = null,
        var icon: String ? = null,
        var active: Boolean ? = false,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        var timestamp: Date ? = Date(),
        var userId: Long ? = null)