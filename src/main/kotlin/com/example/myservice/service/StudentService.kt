package com.example.myservice.service

import com.example.myservice.model.StudentModel
import com.example.myservice.repositories.StudentRepository
import org.springframework.stereotype.Service
import java.util.*

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
    fun updateStudent(id: Long, student: StudentModel): StudentModel {
        val oldStudent = this.studentRepo.findById(id).orElse(null)
        oldStudent.name = student.name
        oldStudent.id = student.id
        oldStudent.age = student.age
        oldStudent.course = student.course
        return this.studentRepo.save(oldStudent)
    }

    fun deleteStudent(id: Long): Optional<StudentModel> {
        val tempStudent = this.studentRepo.findById(id)
        studentRepo.deleteById(id)
        return tempStudent
    }

    fun deleteAllStudents(): List<StudentModel>{
        val listStudent = studentRepo.findAll()
        studentRepo.deleteAll()
        return listStudent
    }


}