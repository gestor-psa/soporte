# language: es
Característica: Crear ticket
  Como ingeniero de soporte
  Deseo crea un ticket
  Para llevar un registro del mantenimiento de la versión de producto

  Esquema del escenario: Creación de ticket
    Dado que soy ingeniero de soporte
    Y seleccioné una versión de producto
    Cuando creo un ticket ingresando:
      | tipo   | nombre   | descripcion   | criticidad   |
      | <tipo> | <nombre> | <descripcion> | <criticidad> |
    Entonces el sistema me informa que la creación del ticket fue "<resultado>"

    Ejemplos:
      | resultado | tipo       | nombre                | descripcion                     | criticidad |
      | fallida   |            | Enviar pedido         | ¿Cuál es el costo del envío?    | baja       |
      | fallida   | consulta   |                       | ¿Cuál es el costo del envío?    | baja       |
      | fallida   | consulta   | Enviar pedido         |                                 | baja       |
      | fallida   | consulta   | Enviar pedido         | ¿Cuál es el costo del envío?    |            |
      | exitosa   | consulta   | Enviar pedido         | ¿Cuál es el costo del envío?    | baja       |
      | exitosa   | mejora     | Confirmar compra      | Mostrar un popup antes de pagar | media      |
      | exitosa   | incidencia | Autenticación fallida | No muestra el botón de login    | alta       |
