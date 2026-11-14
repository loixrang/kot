package com.loixrang.kot.student

import jakarta.persistence.*

@Entity
class Student(
    @Column(nullable = false) var name: String,
    @Column(nullable = false) var email: String,
    @Column(nullable = false) var age: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null
}