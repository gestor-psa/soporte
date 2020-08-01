package psa.soporte.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import psa.soporte.servicio.ReporteServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

@RestController
public class ReporteControlador {

    @Autowired
    private ReporteServicio reporteServicio;

    @GetMapping("/reportes/ticketsPendientes")
    public TreeMap<LocalDate,Integer> acumulado() {
        return reporteServicio.acumulado();
    }

    @GetMapping("/reportes/ticketsAbiertosYCerradosPorDia")
    public TreeMap<LocalDate,ArrayList<Integer>> estadosdiarios() {
        return reporteServicio.estadosdiarios();
    }

}
