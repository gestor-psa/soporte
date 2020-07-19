# language: es
Característica: Listar Tareas
  Como ingeniero de soporte
  Deseo listar las tareas asociadas a un ticket
  Para ver como se esta avanzando con la resolucion del ticket

  Antecedentes:
    Dado que existe un ticket:
    Y que tiene tareas creadas con los siguientes atributos:
      | nombre                                    | proyecto                        | descripcion                                                                     | estado      | fechaInicio |
      | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | No iniciada | 20/03/2020  |
      | Arreglar Error de creacion de ticket      | Desarrollo PSA Spring ERP 2.0.3 | Se debe arreglar el error que permite crear tickets con estado invalido         | Iniciada    | 15/05/2020  |


  Escenario: Listar Tareas
    Dado que soy ingeniero de soporte
    Cuando selecciono un ticket y listo sus tareas:
    Entonces obtengo una lista de tareas con los siguientes atributos:
      | nombre                                    | proyecto                        | descripcion                                                                     | estado      | fechaInicio |
      | Corregir Error de Visualizacion de Tareas | Desarrollo PSA Spring ERP 2.0.2 | Un usuario reporto que no se muestran las tareas creadas despues del 12/07/2020 | No iniciada | 20/03/2020  |
      | Arreglar Error de creacion de ticket      | Desarrollo PSA Spring ERP 2.0.3 | Se debe arreglar el error que permite crear tickets con estado invalido         | Iniciada    | 15/05/2020  |

