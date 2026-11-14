package com.loixrang.kot.student

import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class StudentService(val studentRepository: StudentRepository, val studentMapper: StudentMapper) {
    fun getAllStudent(): List<Student> {
        return studentRepository.findAll()
    }
    fun addStudent(dto: StudentDto): StudentResponseDto {
        val student = this.studentMapper.toStudent(dto)
        val savedStudent = this.studentRepository.save(student)
        return studentMapper.toStudentResponseDto(savedStudent)
    }
}