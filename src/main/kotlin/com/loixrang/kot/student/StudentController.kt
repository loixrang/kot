package com.loixrang.kot.student

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.function.Consumer


@RestController
class StudentController(val studentService: StudentService) {
    @GetMapping("/")
    fun sayHello(): List<Student> {
        return studentService.getAllStudent()
    }
    @PostMapping("/student")
    fun addStudent(@Valid @RequestBody studentDto: StudentDto): StudentResponseDto {
        return studentService.addStudent(studentDto)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exp: MethodArgumentNotValidException): ResponseEntity<*> {
        val errors = HashMap<String?, String?>()
        exp.bindingResult.allErrors.forEach(Consumer { error: ObjectError? ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage
            errors.put(fieldName, errorMessage)
        })
        return ResponseEntity<HashMap<String?, String?>>(errors, HttpStatus.BAD_REQUEST)
    }
}