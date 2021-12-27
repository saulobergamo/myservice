package com.example.service

import com.example.TestRunner
import com.example.mock.MockUtil.Companion.ValidStudent
import com.example.mock.MockUtil.Companion.ValidStudentList
import com.example.myservice.model.StudentModel
import com.example.myservice.repositories.StudentRepository
import com.example.myservice.service.StudentService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StudentServiceTest : TestRunner() {

    @InjectMockKs
    private lateinit var studentService: StudentService

    @MockK
    private lateinit var studentRepository: StudentRepository


    @Test
    fun `GIVE a valid student WHEN calling createStudent THEN save it in the database`() {
        every { studentRepository.save(any()) } returns ValidStudent()

        val student = StudentModel("12ab", "Joao", "Math", 111)
        val response = studentService.createStudent(student)

        assertEquals(student.id, response?.id)
        assertEquals(student.name, response?.name)
        assertEquals(student.course, response?.course)
        assertEquals(student.age, response?.age)
    }

    @Test
    fun `GIVE a valid course WHEN calling readStudents THEN returns a list of students`() {
        every { studentRepository.existsByCourse(any()) } returns true
        every { studentRepository.findByCourse(any()) } returns ValidStudentList

        val response = studentService.readStudents("Math")
        val student = StudentModel("12ab", "Joao", "Math", 111)

        assertEquals(student.id, response[0]?.id)
        assertEquals(student.name, response[0]?.name)
        assertEquals(student.course, response[0]?.course)
        assertEquals(student.age, response[0]?.age)
    }
}
