# language: es
Característica: Crear ticket
  Como ingeniero de soporte
  Deseo crea un ticket
  Para llevar un registro del mantenimiento de la versión de un producto

  Antecedentes:
    Dado que existe un producto con nombre "PSA ERP" y versión 2

  Esquema del escenario: Crear de ticket
    Dado que soy ingeniero de soporte
    Cuando creo un ticket "<caso>" ingresando:
      | nombre   | descripcion   | responsableDni   | tipo   | severidad   |
      | <nombre> | <descripcion> | <responsableDni> | <tipo> | <severidad> |
    Y con el siguiente cliente:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |
    Entonces veo que la operación fue "<resultado>"

    Ejemplos:
      | caso                     | resultado | nombre                | descripcion                     | responsableDni | tipo       | severidad |
      | sin nombre               | fallida   |                       | ¿Cuál es el costo del envío?    |                | consulta   | baja      |
      | sin descripción          | fallida   | Enviar pedido         |                                 |                | consulta   | baja      |
      | sin tipo                 | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |                |            | baja      |
      | sin severidad            | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |                | consulta   |           |
      | con tipo incorrecto      | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |                | propuesta  | baja      |
      | con severidad incorrecta | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |                | consulta   | muy alta  |
      | correctamente            | exitosa   | Enviar pedido         | ¿Cuál es el costo del envío?    |                | consulta   | baja      |
      | con responsableDni       | exitosa   | Confirmar compra      | Mostrar un popup antes de pagar | 41226943       | mejora     | media     |
      | sin responsableDni       | exitosa   | Autenticación fallida | No muestra el botón de login    |                | incidencia | alta      |

  Escenario: Creación exitosa
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Cuando creo un ticket "correctamente" ingresando:
      | nombre        | descripcion                  | responsableDni | tipo     | severidad |
      | Enviar pedido | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      |
    Y con el siguiente cliente:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |
    Entonces veo que posee los siguientes atributos:
      | nombre        | descripcion                  | responsableDni | tipo     | severidad | estado    | fechaDeCreacion | fechaDeActualizacion |
      | Enviar pedido | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      | pendiente | ahora           |                      |
    Y veo que posee el siguiente cliente:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |