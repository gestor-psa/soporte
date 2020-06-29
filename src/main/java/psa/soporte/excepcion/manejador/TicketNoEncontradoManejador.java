package psa.soporte.excepcion.manejador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import psa.soporte.excepcion.TicketNoEncontradoExcepcion;

@ControllerAdvice
class TicketNoEncontradoManejador {

    @ResponseBody
    @ExceptionHandler(TicketNoEncontradoExcepcion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ticketNotFoundHandler(TicketNoEncontradoExcepcion ex) {
        return ex.getMessage();
    }
}