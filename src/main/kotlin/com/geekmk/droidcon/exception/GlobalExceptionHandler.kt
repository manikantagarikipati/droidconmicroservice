package com.geekmk.droidcon.exception

import com.geekmk.droidcon.model.ErrorItem
import com.geekmk.droidcon.model.ErrorResponseDto
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Produces
@Singleton
class GlobalExceptionHandler : ExceptionHandler<Exception, HttpResponse<ErrorResponseDto>> {
    companion object {
        private val LOG = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
    }
    override fun handle(request: HttpRequest<*>?, exception: Exception?): HttpResponse<ErrorResponseDto> {
        LOG.error(exception?.message, exception)
        return HttpResponse.serverError(
           ErrorResponseDto(
               errors = listOf(
                   ErrorItem(
                   code = "500",
                   message = "Internal server error"
               )
               )
           )
        )
    }
}
