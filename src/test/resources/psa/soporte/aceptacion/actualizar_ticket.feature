# language: es
Característica: Actualizar Ticket
  Como ingeniero de soporte
  Deseo modificar un ticket
  Para actualizar su estado

  Antecedentes:
    Dado que existe un ticket con los siguientes atributos:
      | nombre                 | descripcion                  | responsable | tipo     | severidad | estado    | fechaDeCreacion     | fechaDeActualizacion | producto | versionDelProducto |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja      | pendiente | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  | PSA ERP  | 2                  |
    Y con los siguientes comentarios:
      | comentario                                                              | fecha               |
      | El usuario preguntó por el costo de envío                               | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | 2020/06/20 13:56:58 |
    Y que existe un producto con nombre "PSA ERP" y versión 2

  Esquema del escenario: Actualizar ticket
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Y selecciono un ticket con nombre "Consulta sobre pedidos"
    Cuando modifico el ticket "<caso>":
      | nombre   | descripcion   | responsable   | tipo   | severidad   | estado   |
      | <nombre> | <descripcion> | <responsable> | <tipo> | <severidad> | <estado> |
    Entonces veo que la operación fue "<resultado>"

    Ejemplos:
      | caso             | resultado | nombre                 | descripcion                  | responsable | tipo     | severidad | estado    |
      | sin nombre       | fallida   |                        | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja      | pendiente |
      | sin descripción  | fallida   | Consulta sobre pedidos |                              | Juan Perez  | consulta | baja      | pendiente |
      | sin tipo         | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  |          | baja      | pendiente |
      | sin severidad    | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  | consulta |           | pendiente |
      | sin estado       | fallida   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja      |           |
      | sin modificación | exitosa   | Consulta sobre pedidos | ¿Cuál es el costo del envío? | Juan Perez  | consulta | baja      | pendiente |

  Esquema del escenario: Actualización exitosa
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Y selecciono un ticket con nombre "Consulta sobre pedidos"
    Cuando modifico el ticket "<caso>":
      | nombre   | descripcion   | responsable   | tipo   | severidad   | estado   |
      | <nombre> | <descripcion> | <responsable> | <tipo> | <severidad> | <estado> |
    Entonces veo que posee los siguientes atributos:
      | nombre   | descripcion   | responsable   | tipo   | severidad   | estado   | fechaDeCreacion     | fechaDeActualizacion | producto | versionDelProducto |
      | <nombre> | <descripcion> | <responsable> | <tipo> | <severidad> | <estado> | 2020/06/20 13:53:45 | del momento          | PSA ERP  | 2                  |
    Y veo que posee los siguientes comentarios:
      | comentario                                                              | usuario    | fecha               |
      | El usuario preguntó por el costo de envío                               | Juan Perez | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | Juan Perez | 2020/06/20 13:56:58 |

    Ejemplos:
      | caso                     | nombre                  | descripcion                                               | responsable | tipo       | severidad | estado    |
      | cambiando el nombre      | Error al calcular envío | ¿Cuál es el costo del envío?                              | Juan Perez  | consulta   | baja      | pendiente |
      | cambiando el descripción | Consulta sobre pedidos  | No puedo ingresar el código postal para calcular el envío | Juan Perez  | consulta   | baja      | pendiente |
      | cambiando el responsable | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | Tomás Ayala | consulta   | baja      | pendiente |
      | cambiando el tipo        | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | Juan Perez  | incidencia | baja      | pendiente |
      | cambiando el severidad   | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | Juan Perez  | consulta   | alta      | pendiente |
      | cambiando el estado      | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              | Juan Perez  | consulta   | baja      | iniciado  |
      | quitando reponsable      | Consulta sobre pedidos  | ¿Cuál es el costo del envío?                              |             | consulta   | baja      | pendiente |
