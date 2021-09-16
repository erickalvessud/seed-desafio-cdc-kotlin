package com.deveficiente.errorhandler

import com.deveficiente.dto.ValidationErrorsOutputDto
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerExceptionHandler(val messageSource: MessageSource) {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(exception: MethodArgumentNotValidException): ValidationErrorsOutputDto {

        val validationErrorsOutputDto = ValidationErrorsOutputDto()

        exception.globalErrors.forEach {
            it?.let {
                validationErrorsOutputDto.addError(getErrorMessage(it))
            }
        }

        exception.fieldErrors.forEach {
            it?.let {
                validationErrorsOutputDto.addFieldError(it.field, getErrorMessage(it))
            }
        }

        return validationErrorsOutputDto
    }

    private fun getErrorMessage(it: ObjectError) =
            messageSource.getMessage(it, LocaleContextHolder.getLocale())
}