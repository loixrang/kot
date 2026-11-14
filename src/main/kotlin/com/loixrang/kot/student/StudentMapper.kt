package com.loixrang.kot.student

import org.springframework.stereotype.Service

@Service
class StudentMapper {
    fun toStudent(dto: StudentDto): Student {
        val student = Student(name = dto.name, email = dto.email, age = dto.age
        )
        println(student.age)
        return student
    }

    fun toStudentResponseDto(student: Student): StudentResponseDto {
        return StudentResponseDto(name = student.name, email = student.email, age = student.age)
    }
}