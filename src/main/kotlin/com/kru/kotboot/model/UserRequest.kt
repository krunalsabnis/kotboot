package com.kru.kotboot.model

import javax.validation.constraints.NotEmpty


data class UserRequest(
        @NotEmpty var firstName: String,
        @NotEmpty var lastName: String,
        @NotEmpty var email: String)