package psa.soporte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import psa.soporte.controlador.ReporteControlador;
import psa.soporte.controlador.TicketControlador;
import psa.soporte.modelo.Cliente;
import psa.soporte.modelo.Ticket;
import psa.soporte.repositorio.TicketRepositorio;
import psa.soporte.servicio.ClienteServicio;
import psa.soporte.servicio.TicketServicio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReporteServicioTest {

	@Autowired
	private ReporteControlador reporteControlador;

	@Autowired
	private ClienteServicio clienteServicio;

	@Autowired
	private TicketServicio ticketServicio;

	@Autowired
	private TicketRepositorio ticketRepositorio;

	private Cliente cliente;


	@BeforeEach
	void crearCliente(){
		Cliente cliente = new Cliente();
		cliente.setNombre("Agustin Rodriguez");
		cliente.setRazonSocial("MeMo I Software");
		cliente.setCuit("20354687981");
		cliente.setFechaDesdeQueEsCliente(LocalDate.parse("2020-07-05"));
		this.cliente = cliente;
		clienteServicio.crear(cliente);
	}

	Long crearTicket(String time){
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha;
		try{
			fecha = format.parse(time);
		}
		catch(ParseException e){
			return new Long(0);
		}
		Ticket ticket = new Ticket();
		ticket.setNombre("Refaccion de codigo");
		ticket.setDescripcion("Corregir el error de blabla");
		ticket.setTipo("consulta");
		ticket.setSeveridad("alta");
		ticket.setResponsableDni(Long.parseLong("20456123"));
		ticket.setCliente(cliente);
		ticket.setFechaDeCreacion(fecha);
		ticketRepositorio.save(ticket);

		return ticket.getId();
	}

	void cerrarTicket(String time, Long id){
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha;
		try{
			fecha = format.parse(time);
		}
		catch(ParseException e){
			return;
		}
		Ticket ticket = ticketServicio.obtener(id);
		ticket.setEstado("cerrado");
		ticket.setFechaDeCierre(fecha);
		ticketRepositorio.save(ticket);
	}


	@Test
	void ticketsPendientesSinCrearTicketsDaSiempre0(){
		TreeMap<LocalDate,Integer> acumulado = reporteControlador.ticketsPendientes();
		acumulado.keySet().forEach(dia -> {
			assertEquals(acumulado.get(dia),0);
		});
	}

	@Test
	void ticketsAbiertosYCerradosPorDiaSinCrearTicketsDaSiempre0(){
		TreeMap<LocalDate, ArrayList<Integer>> estadosdiarios = reporteControlador.ticketsAbiertosYCerradosPorDia();
		estadosdiarios.keySet().forEach(dia -> {
			assertEquals(estadosdiarios.get(dia).get(0),0);
			assertEquals(estadosdiarios.get(dia).get(1),0);
		});
	}

	@Test
	@DirtiesContext
	void ticketsPendientesCreandoTicketsEnUltimos30Dias(){
		Long ticketId0 = crearTicket("02/08/2020");
		Long ticketId1 = crearTicket("03/08/2020");

		TreeMap<LocalDate,Integer> acumulado = reporteControlador.ticketsPendientes();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		assertEquals(acumulado.get(LocalDate.parse("02/08/2020",formatter)),1);
		assertEquals(acumulado.get(LocalDate.parse("03/08/2020",formatter)),2);
		assertEquals(acumulado.get(LocalDate.parse("04/08/2020",formatter)),2);
		assertEquals(acumulado.get(LocalDate.parse("05/08/2020",formatter)),2);
	}

	@Test
	@DirtiesContext
	void ticketsAbiertosYCerradosPorDiaCreandoTicketsEnUltimos30Dias(){
		Long ticketId0 = crearTicket("02/08/2020");
		Long ticketId1 = crearTicket("03/08/2020");
		Long ticketId2 = crearTicket("03/08/2020");

		TreeMap<LocalDate, ArrayList<Integer>> estadosdiarios = reporteControlador.ticketsAbiertosYCerradosPorDia();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		assertEquals(estadosdiarios.get(LocalDate.parse("02/08/2020",formatter)).get(0),1);
		assertEquals(estadosdiarios.get(LocalDate.parse("03/08/2020",formatter)).get(0),2);
	}

	@Test
	@DirtiesContext
	void ticketsPendientesCreandoYCerrandoTicketsEnUltimos30Dias(){
		Long ticketId0 = crearTicket("02/08/2020");
		Long ticketId1 = crearTicket("03/08/2020");
		cerrarTicket("04/08/2020",ticketId0);

		TreeMap<LocalDate,Integer> acumulado = reporteControlador.ticketsPendientes();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		assertEquals(acumulado.get(LocalDate.parse("02/08/2020",formatter)),1);
		assertEquals(acumulado.get(LocalDate.parse("03/08/2020",formatter)),2);
		assertEquals(acumulado.get(LocalDate.parse("04/08/2020",formatter)),1);
		assertEquals(acumulado.get(LocalDate.parse("05/08/2020",formatter)),1);
	}

	@Test
	@DirtiesContext
	void ticketsAbiertosYCerradosPorDiaCreandoYCerrandoTicketsEnUltimos30Dias(){
		Long ticketId0 = crearTicket("02/08/2020");
		Long ticketId1 = crearTicket("03/08/2020");
		Long ticketId2 = crearTicket("03/08/2020");
		cerrarTicket("04/08/2020",ticketId0);

		TreeMap<LocalDate, ArrayList<Integer>> estadosdiarios = reporteControlador.ticketsAbiertosYCerradosPorDia();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		assertEquals(estadosdiarios.get(LocalDate.parse("02/08/2020",formatter)).get(0),1);
		assertEquals(estadosdiarios.get(LocalDate.parse("03/08/2020",formatter)).get(0),2);
		assertEquals(estadosdiarios.get(LocalDate.parse("04/08/2020",formatter)).get(1),1);
	}

	@Test
	@DirtiesContext
	void ticketsPendientesCreandoYCerrandoAntesDeUltimos30Dias(){
		Long ticketId0 = crearTicket("02/06/2020");
		Long ticketId1 = crearTicket("03/06/2020");
		Long ticketId2 = crearTicket("03/06/2020");
		cerrarTicket("14/06/2020",ticketId0);

		TreeMap<LocalDate,Integer> acumulado = reporteControlador.ticketsPendientes();
		acumulado.keySet().forEach(dia -> {
			assertEquals(acumulado.get(dia),2);
		});

	}

	@Test
	@DirtiesContext
	void ticketsAbiertosYCerradosPorDiaCreandoYCerrandoAntesDe30Dias(){
		Long ticketId0 = crearTicket("02/06/2020");
		Long ticketId1 = crearTicket("03/06/2020");
		Long ticketId2 = crearTicket("03/06/2020");
		cerrarTicket("14/06/2020",ticketId0);

		TreeMap<LocalDate, ArrayList<Integer>> estadosdiarios = reporteControlador.ticketsAbiertosYCerradosPorDia();
		estadosdiarios.keySet().forEach(dia -> {
			assertEquals(estadosdiarios.get(dia).get(0),0);
			assertEquals(estadosdiarios.get(dia).get(1),0);
		});
	}

}
