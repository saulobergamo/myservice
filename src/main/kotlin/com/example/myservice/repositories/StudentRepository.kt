package com.example.myservice.repositories

import com.example.myservice.model.StudentModel
import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository : MongoRepository<StudentModel, Long> {
    fun findByName(name: String) : StudentModel
    fun findByCourse(course: String) : List<StudentModel>
}