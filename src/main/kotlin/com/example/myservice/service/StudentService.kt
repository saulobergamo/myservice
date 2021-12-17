package com.example.myservice.service

import com.example.myservice.model.StudentModel
import com.example.myservice.repositories.StudentRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepo: StudentRepository){

    fun createStudent(student: StudentModel): StudentModel {
        return studentRepo.save(student)
    }

    fun readStudents(course: String): List<StudentModel> {
        return studentRepo.findByCourse(course)
    }

    fun readAllStudents():List<StudentModel>{
        return studentRepo.findAll()
    }

    fun updateStudent(id: String, student: StudentModel): StudentModel? {
        return if(studentRepo.existsById(id)){
            this.studentRepo.save(student)
        } else null
    }

    fun deleteStudent(id: String) : ResponseEntity<Unit>{
        return ResponseEntity.ok(studentRepo.deleteById(id))
    }

    fun deleteAllStudents(){
        studentRepo.deleteAll()
    }


}