package com.example.myservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class StudentModel(
    id: Long?,
    name: String,
    course: String,
    age: Number
) {
    @Id
    var id: Long? = id
    var name: String = name
    var course: String = course
    var age: Number = age
}