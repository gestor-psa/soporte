# language: es
Característica: Actualizar Ticket
  Como ingeniero de soporte
  Deseo modificar un ticket
  Para actualizar su estado

  Antecedentes:
    Dado que existe un cliente con los siguientes atributoss:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |
    Y que existe un ticket con los siguientes atributos:
      | nombre                 | descripcion                  | responsableDni | tipo     | severidad | estado   | fechaDeCreacion     | fechaDeActualizacion |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  |

  Esquema del escenario: Actualizar ticket
    Dado que soy ingeniero de soporte
    Y selecciono un ticket con nombre "Consulta sobre pedidos"
    Cuando modifico el ticket "<caso>":
      | nombre   | descripcion   | responsableDni   | tipo   | severidad   | estado   |
      | <nombre> | <descripcion> | <responsableDni> | <tipo> | <severidad> | <estado> |
    Entonces veo que la operación fue "<resultado>"

    Ejemplos:
      | caso                     | resultado | nombre                 | descripcion                  | responsableDni | tipo      | severidad | estado     |
      | sin nombre               | fallida   |                        | ¿Cuál es el costo del envío? | 41226943    | consulta  | baja      | pendiente  |
      | sin descripción          | fallida   | Consulta sobre pedidos |                              | 41226943    | consulta  | baja      | pendiente  |
      | sin tipo                 | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    |           | baja      | pendiente  |
      | sin severidad            | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    | consulta  |           | pendiente  |
      | sin estado               | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    | consulta  | baja      |            |
      | con tipo incorrecto      | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    | propuesta | baja      | pendiente  |
      | con severidad incorrecta | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    | consulta  | muy alta  | pendiente  |
      | con estado incorrecto    | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    | consulta  | baja      | paralizado |
      | sin modificación         | exitosa   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943    | consulta  | baja      | pendiente  |

  Esquema del escenario: Actualización exitosa
    Dado que soy ingeniero de soporte
    Y selecciono un ticket con nombre "Consulta sobre pedidos"
    Cuando modifico el ticket "<caso>":
      | nombre   | descripcion   | responsableDni   | tipo   | severidad   | estado   |
      | <nombre> | <descripcion> | <responsableDni> | <tipo> | <severidad> | <estado> |
    Entonces veo que posee los siguientes atributos:
      | nombre   | descripcion   | responsableDni   | tipo   | severidad   | estado   | fechaDeCreacion     | fechaDeActualizacion |
      | <nombre> | <descripcion> | <responsableDni> | <tipo> | <severidad> | <estado> | 2020/06/20 13:53:45 | ahora                |
    Y veo que posee el siguiente cliente:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |

    Ejemplos:
      | caso                        | nombre                  | descripcion                                               | responsableDni | tipo       | severidad | estado    |
      | cambiando el nombre         | Error al calcular envío | ¿Cuál es el costo del envío?                              | 41226943       | consulta   | baja      | pendiente |
      | cambiando el descripción    | Consulta sobre pedidos  | No puedo ingresar el código postal para calcular el envío | 41226943       | consulta   | baja      | pendiente |
      | cambiando el responsableDni | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | 36489425       | consulta   | baja      | pendiente |
      | cambiando el tipo           | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | 41226943       | incidencia | baja      | pendiente |
      | cambiando el severidad      | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | 41226943       | consulta   | alta      | pendiente |
      | cambiando el estado         | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | 41226943       | consulta   | baja      | iniciado  |
      | quitando reponsable         | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              |                | consulta   | baja      | pendiente |
