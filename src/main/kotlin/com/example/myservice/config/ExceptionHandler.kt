package com.example.myservice.config

import com.example.myservice.exception.NotFoundRunTime
import com.example.myservice.model.ExceptionBody
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundRunTime::class)
    fun notFoundResponseException(notFound: NotFoundRunTime, request: WebRequest): ResponseEntity<ExceptionBody> {
        val exceptionBody = ExceptionBody(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.reasonPhrase,
            message = notFound.localizedMessage,
            path = request.contextPath
        )
        return ResponseEntity(exceptionBody, HttpHeaders(), HttpStatus.NOT_FOUND)
    }
}