package psa.soporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import psa.soporte.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}