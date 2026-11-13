package com.loixrang.kot.student

import jakarta.persistence.*
import jakarta.validation.constraints.Email

@Entity
class Student(firstname: String, lastname: String, email: String, age: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private var id: String? = ""
    @Column(nullable = false)
    private var firstname: String? = ""
    @Column(nullable = false)
    @Email
    private var email: String? = ""
    @Column(nullable = false)
    private var age: Int? = null
}