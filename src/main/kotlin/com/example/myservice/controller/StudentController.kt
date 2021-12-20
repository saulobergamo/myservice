package com.example.myservice.controller

import com.example.myservice.model.StudentModel
import com.example.myservice.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController (private val studentService: StudentService){

    @PostMapping
    fun createStudent(@RequestBody student: StudentModel){
        studentService.createStudent(student)
    }

    @GetMapping("/{course}")
    fun readStudents(@PathVariable course: String): ResponseEntity<List<StudentModel>>{
        return ResponseEntity.ok(studentService.readStudents(course))
    }

    @GetMapping
    fun readAllStudents(): ResponseEntity<List<StudentModel>>{
        return ResponseEntity.ok(studentService.readAllStudents())
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: String, @RequestBody student: StudentModel): ResponseEntity<StudentModel>{
        return ResponseEntity.ok(studentService.updateStudent(id, student))
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: String) {
        studentService.deleteStudent(id)
    }

    @DeleteMapping
    fun deleteAllStudents(): ResponseEntity<Unit> {
        return ResponseEntity.ok(studentService.deleteAllStudents())
    }
}