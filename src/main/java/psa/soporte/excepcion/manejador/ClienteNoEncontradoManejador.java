package psa.soporte.excepcion.manejador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import psa.soporte.excepcion.ClienteNoEncontradoExcepcion;

@ControllerAdvice
class ClienteNoEncontradoManejador {

    @ResponseBody
    @ExceptionHandler(ClienteNoEncontradoExcepcion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String clienteNotFoundHandler(ClienteNoEncontradoExcepcion ex) {
        return ex.getMessage();
    }
}