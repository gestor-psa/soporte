# language: es
Característica: Crear ticket
  Como ingeniero de soporte
  Deseo crea un ticket
  Para llevar un registro del mantenimiento de la versión de un producto

  Antecedentes:
    Dado que existe un producto con nombre "PSA ERP" y versión 2

  Esquema del escenario: Crear de ticket
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Cuando creo un ticket "<caso>" ingresando:
      | nombre   | descripcion   | responsable   | tipo   | severidad   |
      | <nombre> | <descripcion> | <responsable> | <tipo> | <severidad> |
    Entonces veo que la operación fue "<resultado>"

    Ejemplos:
      | caso                     | resultado | nombre                | descripcion                     | responsable | tipo       | severidad |
      | sin nombre               | fallida   |                       | ¿Cuál es el costo del envío?    |             | consulta   | baja      |
      | sin descripción          | fallida   | Enviar pedido         |                                 |             | consulta   | baja      |
      | sin tipo                 | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             |            | baja      |
      | sin severidad            | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   |           |
      | con tipo incorrecto      | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | propuesta  | baja      |
      | con severidad incorrecta | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   | muy alta  |
      | correctamente            | exitosa   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   | baja      |
      | con responsable          | exitosa   | Confirmar compra      | Mostrar un popup antes de pagar | Juan Perez  | mejora     | media     |
      | sin responsable          | exitosa   | Autenticación fallida | No muestra el botón de login    |             | incidencia | alta      |

  Escenario: Creación exitosa
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Cuando creo un ticket "correctamente" ingresando:
      | nombre        | descripcion                  | responsable | tipo     | severidad |
      | Enviar pedido | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja      |
    Entonces veo que posee los siguientes atributos:
      | nombre        | descripcion                  | responsable | tipo     | severidad | estado    | fechaDeCreacion | fechaDeActualizacion |
      | Enviar pedido | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja      | pendiente | ahora           |                      |
    Y veo que no posee comentarios
