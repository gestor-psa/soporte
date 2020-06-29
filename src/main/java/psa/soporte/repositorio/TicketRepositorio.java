package psa.soporte.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import psa.soporte.modelo.Ticket;

public interface TicketRepositorio extends JpaRepository<Ticket, Long> {

}