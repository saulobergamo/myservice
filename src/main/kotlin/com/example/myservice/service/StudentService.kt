package com.example.myservice.service

import com.example.myservice.exception.NotFoundRunTime
import com.example.myservice.model.StudentModel
import com.example.myservice.repositories.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepo: StudentRepository){

    fun createStudent(student: StudentModel){
        studentRepo.save(student)
    }

    fun readStudents(course: String): List<StudentModel> {
        if(studentRepo.existsByCourse(course)){
            return studentRepo.findByCourse(course)
        }
        throw NotFoundRunTime("Course doesn't have any student")
    }

    fun readAllStudents():List<StudentModel>{
        return studentRepo.findAll()
    }

    fun updateStudent(id: String, student: StudentModel) {
        if(studentRepo.existsById(id)){
            this.studentRepo.save(student)
        }
        throw NotFoundRunTime("Student doesn't exist")
    }


    fun deleteStudent(id: String) {
        if(studentRepo.existsById(id)){
            return studentRepo.deleteById(id)
        }
        throw NotFoundRunTime("Student doesn't exist")
    }

    fun deleteAllStudents() {
        studentRepo.deleteAll()
    }


}