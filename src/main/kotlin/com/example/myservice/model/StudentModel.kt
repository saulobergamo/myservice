package com.example.myservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class StudentModel(
    @Id
    var id: String? = null,
    var name: String,
    var course: String,
    var age: Number
)