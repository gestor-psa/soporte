# language: es
Característica: Seleccionar ticket
  Como ingeniero de soporte
  Deseo seleccionar un ticket
  Para ver información más detallada de este

  Antecedentes:
    Dado que existe un ticket con los siguientes atributos:
      | nombre                 | descripcion                  | responsable | tipo     | criticidad | estado   | fechaDeCreacion     | fechaDeActualizacion | producto | versionDelProducto |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja       | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  | PSA ERP  | 2                  |
    Y con los siguientes comentarios:
      | comentario                                                              | fecha               |
      | El usuario preguntó por el costo de envío                               | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | 2020/06/20 13:56:58 |

  Escenario: Seleccionar ticket
    Dado que soy ingeniero de soporte
    Y seleccioné la versión 2 del producto "PSA ERP"
    Cuando selecciono un ticket con nombre "Consulta sobre pedidos"
    Entonces el sistema me informa que dicho ticket posee los siguientes atributos:
      | nombre                 | descripcion                  | responsable | tipo     | criticidad | estado   | fechaDeCreacion     | fechaDeActualizacion | producto | versionDelProducto |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja       | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  | PSA ERP  | 2                  |
    Y los siguientes comentarios:
      | comentario                                                              | usuario    | fecha               |
      | El usuario preguntó por el costo de envío                               | Juan Perez | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | Juan Perez | 2020/06/20 13:56:58 |
