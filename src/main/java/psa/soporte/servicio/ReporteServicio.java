package psa.soporte.servicio;

import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psa.soporte.modelo.Ticket;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReporteServicio {

    @Autowired
    private TicketServicio ticketServicio;

    public TreeMap<LocalDate,ArrayList<Integer>> estadosdiarios() {

        HashMap<LocalDate,ArrayList<Integer>> diccionarioFechas = generarDiccionarioFechas();
        TreeMap<LocalDate,ArrayList<Integer>> diccionarioFechasOrdenado = new TreeMap<LocalDate,ArrayList<Integer>>();
        diccionarioFechasOrdenado.putAll(diccionarioFechas);

        return diccionarioFechasOrdenado;
    }

    public TreeMap<LocalDate,Integer> acumulado() {

        List<LocalDate> daysRange = generarListaUltimosNDias(30);

        LocalDate diaInicial = LocalDate.now().minusDays(30);
        MutableInt ticketsAbiertosInicial = new MutableInt(0);

        List<Ticket> listaTicket = ticketServicio.listarTickets();
        /*listaTicket.forEach(ticket -> {
            if((diaInicial.isAfter(ticket.getFechaDeCreacion()) && diaInicial.isBefore(ticket.getFechaDeCierre()))
                    || (diaInicial.isAfter(ticket.getFechaDeCreacion()) && ticket.getFechaDeCierre() = null)){
                ticketsAbiertosInicial.add(1);
            }
        });// tengo cantidad pendientes para el dia 0.
        // pendientes dia i+1 = (pendientes dia i) + (abierto dia i+1) - (cerrados dia i+1).
*/
        HashMap<LocalDate,ArrayList<Integer>> diccionarioFechas = generarDiccionarioFechas();

        TreeMap<LocalDate,Integer> tree = new TreeMap<LocalDate,Integer>();



        return tree;
    }

    private HashMap<LocalDate,ArrayList<Integer>> generarDiccionarioFechas(){
        List<LocalDate> daysRange = generarListaUltimosNDias(30); //lista de ultimos 30 dias

        HashMap<LocalDate,ArrayList<Integer>> diccionarioFechas = new HashMap<LocalDate, ArrayList<Integer>>();

        daysRange.forEach(localDate -> {
            ArrayList<Integer> cantidadesFecha = new ArrayList<Integer>();
            cantidadesFecha.add(0,0);
            cantidadesFecha.add(1,0);
            diccionarioFechas.put(localDate,cantidadesFecha);
        });//formo dicc de la forma {fecha: [0,0],fecha+1:[0,0]....}


        List<Ticket> listaTicket = ticketServicio.listarTickets();
        listaTicket.forEach(ticket -> {
            LocalDate fechaCreacion = ticket.getFechaDeCreacion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaCierre = ticket.getFechaDeCierre().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (diccionarioFechas.containsKey(fechaCreacion)){
                ArrayList<Integer> cantidadesFecha = diccionarioFechas.get(fechaCreacion);
                cantidadesFecha.set(0,cantidadesFecha.get(0)+1);
                diccionarioFechas.replace(fechaCreacion,cantidadesFecha);
            }
            if (diccionarioFechas.containsKey(fechaCierre)){
                ArrayList<Integer> cantidadesFecha = diccionarioFechas.get(fechaCierre);
                cantidadesFecha.set(1,cantidadesFecha.get(1)+1);
                diccionarioFechas.replace(fechaCreacion,cantidadesFecha);
            }
        });//formo dicc de la forma {fecha: [#creados,#cerrados],fecha+1:[#creados,#cerrados]....}

        return diccionarioFechas;
    }

    private List<LocalDate> generarListaUltimosNDias(Integer n){
        List<LocalDate> daysRange = Stream.iterate(LocalDate.now().minusDays(30),
                date -> date.plusDays(1)).limit(n).collect(Collectors.toList());

        return daysRange;
    }

}
