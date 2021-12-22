package com.example.myservice.model

import java.time.LocalDateTime

class ExceptionBody (
    val timestamp: LocalDateTime? = LocalDateTime.now(),
    val status: Int? = null,
    val error: String? = null,
    val message: String? = null,
    val path: String? = null
)