package psa.soporte.excepcion;

public class TicketNoEncontradoExcepcion extends RuntimeException {

    public TicketNoEncontradoExcepcion(Long id) {
        super("No se encontró el ticket con id " + id);
    }
}