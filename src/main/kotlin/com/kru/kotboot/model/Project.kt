package com.kru.kotboot.model

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Project(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var name: String = "",
    var description: String = "",
    var code: String = "",
    var icon: String = "",
    var active: Boolean,
    var timestamp: Date,
    var userId: Long = 0)
