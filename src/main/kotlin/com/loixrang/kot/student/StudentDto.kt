package com.loixrang.kot.student

import jakarta.validation.constraints.*

data class StudentDto(
    @NotEmpty
    val name: String,
    @NotEmpty
    val email: String,
    @NotNull
    val age: Int
)
