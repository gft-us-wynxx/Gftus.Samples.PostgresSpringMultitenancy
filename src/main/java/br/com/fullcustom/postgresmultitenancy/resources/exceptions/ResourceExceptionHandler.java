package br.com.fullcustom.postgresmultitenancy.resources.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import br.com.fullcustom.postgresmultitenancy.services.exceptions.ObjectNotFoundException

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    public fun objectNotFound(e: ObjectNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val status = HttpStatus.NOT_FOUND
        val err = StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI())
        return ResponseEntity.status(status).body(err)
    }
}