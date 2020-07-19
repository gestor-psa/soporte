# language: es
Característica: Crear Tarea
  Como ingeniero de soporte
  Deseo crear una Tarea asociada a un ticket
  Para poder derivarle al equipo de desarrollo la responsabilidad de resolver la incidencia reportada en el ticket

  Antecedentes:
    Dado que existe un ticket:

  Esquema del escenario: Crear tarea
    Dado que soy ingeniero de soporte
    Cuando creo una tarea "<caso>" ingresando:
      | nombre   | proyecto   | descripcion   | estado   | fechaInicio   |
      | <nombre> | <proyecto> | <descripcion> | <estado> | <fechaInicio> |
    Entonces veo que la operacion de creacion de tarea fue "<resultado>"

    Ejemplos:
      | caso                  | nombre                                    | proyecto                        | descripcion                                                                     | estado      | fechaInicio |
      | sin nombre            |                                           |                                 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | No iniciada | 20/03/2020  |
      | sin proyecto          | Corregir Error de Visualizacion de Tareas |                                 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | No iniciada | 20/03/2020  |
      | sin descripcion       | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 |                                                                                 | No iniciada | 20/03/2020  |
      | sin estado            | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 |             | 20/03/2020  |
      | con estado incorrecto | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | Empezada    | 20/03/2020  |
      | sin fechaInicio       | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | No iniciada |             |
      | correctamente         | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | No iniciada | 20/03/2020  |
