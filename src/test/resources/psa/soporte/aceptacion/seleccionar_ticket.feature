# language: es
Característica: Seleccionar ticket
  Como ingeniero de soporte
  Deseo seleccionar un ticket
  Para ver información más detallada de este

  Antecedentes:
    Dado que existe un ticket con los siguientes atributos:
      | tipo     | nombre                 | descripcion                  | criticidad | personaAsignada | fechaDeCreacion     | fechaDeActualización |
      | consulta | Consulta sobre pedidos | ¿Cuál es el costo del envío? | baja       | Juan Perez      | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  |
    Y con los siguientes comentarios:
      | comentario                                                              | usuario    | fecha               |
      | El usuario preguntó por el costo de envío                               | Juan Perez | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | Juan Perez | 2020/06/20 13:56:58 |

  Escenario: Creación de ticket
    Dado que soy ingeniero de soporte
    Y seleccioné una versión de producto
    Cuando selecciono un ticket con nombre "Consulta sobre pedidos"
    Entonces el sistema me informa que dicho ticket tiene:
      | tipo     | nombre                 | descripcion                  | criticidad | personaAsignada | fechaDeCreacion     | fechaDeActualización |
      | consulta | Consulta sobre pedidos | ¿Cuál es el costo del envío? | baja       | Juan Perez      | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  |
    Y los siguientes comentarios:
      | comentario                                                              | usuario    | fecha               |
      | El usuario preguntó por el costo de envío                               | Juan Perez | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | Juan Perez | 2020/06/20 13:56:58 |
