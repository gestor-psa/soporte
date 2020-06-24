# language: es
Característica: Crear ticket
  Como ingeniero de soporte
  Deseo crea un ticket
  Para llevar un registro del mantenimiento de la versión de producto

  Esquema del escenario: Creación de ticket
    Dado que soy ingeniero de soporte
    Y seleccioné la versión 2 del producto "PSA ERP"
    Cuando creo un ticket ingresando:
      | nombre   | descripcion   | responsable   | tipo   | criticidad   |
      | <nombre> | <descripcion> | <responsable> | <tipo> | <criticidad> |
    Entonces el sistema me informa que la creación del ticket fue "<resultado>"

    Ejemplos:
      | resultado | nombre                | descripcion                     | responsable | tipo       | criticidad |
      | fallida   |                       | ¿Cuál es el costo del envío?    |             | consulta   | baja       |
      | fallida   | Enviar pedido         |                                 |             | consulta   | baja       |
      | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   | baja       |
      | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             |            | baja       |
      | exitosa   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   | baja       |
      | exitosa   | Confirmar compra      | Mostrar un popup antes de pagar | Juan Perez  | mejora     | media      |
      | exitosa   | Autenticación fallida | No muestra el botón de login    |             | incidencia | alta       |

  Escenario: Valores de un ticket recién creado
    Dado que soy ingeniero de soporte
    Y seleccioné la versión 2 del producto "PSA ERP"
    Cuando creo un ticket ingresando:
      | nombre        | descripcion                  | responsable | tipo     | criticidad |
      | Enviar pedido | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja       |
    Entonces el sistema me informa que la creación del ticket fue "exitosa"
    Y que se creó con los siguientes atributos:
      | nombre        | descripcion                  | responsable | tipo     | criticidad | estado    | fechaDeCreacion | fechaDeActualizacion | producto | versionDelProducto |
      | Enviar pedido | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja       | pendiente | del momento     |                      | PSA ERP  | 2                  |
    Y sin comentarios
