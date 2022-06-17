package samesya.kotlin.restful.controller

import javax.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import samesya.kotlin.restful.error.NotFoundException
import samesya.kotlin.restful.error.UnauthorizeException
import samesya.kotlin.restful.model.WebResponse

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(
            constraintViolationException: ConstraintViolationException
    ): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(code = 404, status = "NOT FOUND", data = "Not Found")
    }

    @ExceptionHandler(value = [UnauthorizeException::class])
    fun notFound(unauthorizeException: UnauthorizeException): WebResponse<String> {
        return WebResponse(code = 401, status = "UNAUTHORIZED", data = "Please put your X-Api-Key")
    }
}
