package com.example.myservice.controller

import com.example.myservice.model.StudentModel
import com.example.myservice.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("student")
class StudentController (private val studentService: StudentService){

    @GetMapping("/{course}")
    fun readStudents(@PathVariable course: String): ResponseEntity<List<StudentModel>>{
        return ResponseEntity.ok(studentService.readStudents(course))
    }

    @GetMapping
    fun readAllStudents(): ResponseEntity<List<StudentModel>>{
        return ResponseEntity.ok(studentService.readAllStudents())
    }

    @PatchMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody student: StudentModel): ResponseEntity<StudentModel>{
        return ResponseEntity.ok(studentService.updateStudent(id, student))
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Optional<StudentModel>> {
       return ResponseEntity.ok(studentService.deleteStudent(id))
    }



    @PostMapping
    fun createStudent(@RequestBody student: StudentModel): ResponseEntity<StudentModel>{
        return ResponseEntity.ok(studentService.createStudent(student))
    }

    @DeleteMapping
    fun deleteAllStudents(): ResponseEntity<List<StudentModel>> {
        return ResponseEntity.ok(studentService.deleteAllStudents())
    }
}