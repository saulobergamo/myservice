package com.example.myservice.repositories

import com.example.myservice.model.StudentModel
import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository : MongoRepository<StudentModel, Long> {
    fun findByName(name: String) : List<StudentModel>?
    fun findByCourse(course: String) : List<StudentModel>
    fun deleteById(id: String)
    fun findById(id: String): StudentModel?
    abstract fun existsById(id: String): Boolean
    abstract fun existsByCourse(course: String): Boolean
}