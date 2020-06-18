package psa.soporte.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import psa.soporte.model.Employee;

@SpringBootTest
public class EmployeeControllerTests {

    @Autowired
    private EmployeeController controller;

    @Test
    public void contexLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void DevuelveUnaListaVaciaEnPrincipio() {
        assertThat(controller.all()).isEmpty();
    }

    @Test
    @Transactional
    public void DevuelveElMismoEmpleadoDespuesDeCrearlo() {
        Employee empleado = new Employee();
        empleado.setName("Tulio");
        empleado.setRole("Presentador");
        Employee otroEmpleado = controller.newEmployee(empleado);
        assertThat(otroEmpleado).isEqualTo(empleado);
    }

    @Test
    @Transactional
    public void allDevuelveUnEmpleadoDespuesDeCrearlo() {
        Employee empleado = new Employee();
        empleado.setName("Tulio");
        empleado.setRole("Presentador");
        controller.newEmployee(empleado);
        assertThat(controller.all()).hasSize(1).first().isEqualTo(empleado);
    }
}