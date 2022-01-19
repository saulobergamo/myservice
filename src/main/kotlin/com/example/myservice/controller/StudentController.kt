package com.example.myservice.controller

import com.example.myservice.model.StudentModel
import com.example.myservice.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController (private val studentService: StudentService){

    @PostMapping
    fun createStudent(@RequestBody student: StudentModel): ResponseEntity<StudentModel?>? {
        return ResponseEntity.ok(studentService.createStudent(student))
    }

    @GetMapping("/id/{id}")
    fun readStudent(@PathVariable id: String): ResponseEntity<StudentModel>?{
        return ResponseEntity.ok(studentService.readStudentById(id))
    }

    @GetMapping("/name/{name}")
    fun readStudentsByName(@PathVariable name: String): ResponseEntity<List<StudentModel>> {
        return ResponseEntity.ok(studentService.readStudentByName(name))
    }

    @GetMapping("/{course}")
    fun readStudents(@PathVariable course: String): ResponseEntity<List<StudentModel>> {
        return ResponseEntity.ok(studentService.readStudents(course))
    }

    @GetMapping
    fun readAllStudents(): ResponseEntity<List<StudentModel>>{
        return ResponseEntity.ok(studentService.readAllStudents())
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: String, @RequestBody student: StudentModel): ResponseEntity<Unit>? {
        return ResponseEntity.ok(studentService.updateStudent(id, student))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteStudent(@PathVariable id: String) {
        studentService.deleteStudent(id)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAllStudents() {
        studentService.deleteAllStudents()
    }
}