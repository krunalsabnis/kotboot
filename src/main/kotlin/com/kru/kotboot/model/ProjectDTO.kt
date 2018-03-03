package com.kru.kotboot.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size

@JsonInclude(value= JsonInclude.Include.NON_NULL)
data class ProjectDTO(
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
        var id: Long = 0,
        @get:Size(min = 1, max = 20) var name: String ? = null,
        @get:Size(min = 1, max = 100) var description: String ? = null,
        @get:Size(min = 1, max = 20) var code: String ? = null,
        var icon: String ? = null,
        var active: Boolean ? = false,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") var timestamp: Date ? = Date(),
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) var userId: Long ? = null)