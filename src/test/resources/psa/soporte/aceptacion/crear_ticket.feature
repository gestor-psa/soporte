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
      | nombre   | descripcion   | responsable   | tipo   | criticidad   |
      | <nombre> | <descripcion> | <responsable> | <tipo> | <criticidad> |
    Entonces veo que la creación fue "<resultado>"

    Ejemplos:
      | caso            | resultado | nombre                | descripcion                     | responsable | tipo       | criticidad |
      | sin nombre      | fallida   |                       | ¿Cuál es el costo del envío?    |             | consulta   | baja       |
      | sin descripción | fallida   | Enviar pedido         |                                 |             | consulta   | baja       |
      | sin tipo        | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             |            | baja       |
      | sin criticidad  | fallida   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   |            |
      | correctamente   | exitosa   | Enviar pedido         | ¿Cuál es el costo del envío?    |             | consulta   | baja       |
      | con responsable | exitosa   | Confirmar compra      | Mostrar un popup antes de pagar | Juan Perez  | mejora     | media      |
      | sin responsable | exitosa   | Autenticación fallida | No muestra el botón de login    |             | incidencia | alta       |

  Escenario: Creación exitosa
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Cuando creo un ticket ingresando:
      | nombre        | descripcion                  | responsable | tipo     | criticidad |
      | Enviar pedido | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja       |
    Entonces veo que posee los siguientes atributos:
      | nombre        | descripcion                  | responsable | tipo     | criticidad | estado    | fechaDeCreacion | fechaDeActualizacion | producto | versionDelProducto |
      | Enviar pedido | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja       | pendiente | del momento     |                      | PSA ERP  | 2                  |
    Y veo que no posee comentarios