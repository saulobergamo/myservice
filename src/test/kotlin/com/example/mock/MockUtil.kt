package com.example.mock

import com.example.myservice.model.StudentModel

class MockUtil {
    companion object {
        fun ValidStudent() = StudentModel(
            id = "12ab",
            name = "Joao",
            course = "Math",
            age = 111
        )

        val ValidStudentList = listOf(
            StudentModel(
                id = "12ab",
                name = "Joao",
                course = "Math",
                age = 111
            )
        )
    }

}