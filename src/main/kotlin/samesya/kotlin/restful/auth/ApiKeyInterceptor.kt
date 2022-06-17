package samesya.kotlin.restful.auth

import java.lang.Exception
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import samesya.kotlin.restful.error.UnauthorizeException
import samesya.kotlin.restful.repository.ApiKeyRepository

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor {

    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key")
        if (apiKey == null) {
            throw UnauthorizeException()
        }

        if (!apiKeyRepository.existsById(apiKey)) {
            throw UnauthorizeException()
        }

        // Valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {}

    override fun afterCompletion(request: WebRequest, ex: Exception?) {}
}
