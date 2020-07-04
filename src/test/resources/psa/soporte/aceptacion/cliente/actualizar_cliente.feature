# language: es
Característica: Actualizar Ticket
  Como ingeniero de soporte
  actualizar un cliente
  para cambiar sus atributos

  Antecedentes:
    Dado que existe un cliente con los siguientes atributos:
      | nombre    | razonsocial     | cuit        | fechacliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   | activo |

  Esquema del escenario: Actualizar cliente
    Dado que soy ingeniero de soporte
    Y selecciono un cliente con nombre "Juan Diaz"
    Cuando modifico el cliente "<caso>":
      | nombre   | razonsocial   | cuit   | fechacliente   | estado   |
      | <nombre> | <razonsocial> | <cuit> | <fechacliente> | <estado> |
    Entonces veo que la operación de cliente fue "<resultado>"

    Ejemplos:
      | caso                        | resultado | nombre       | razonsocial                | cuit        | fechacliente | estado   |
      | sin nombre                  | fallida   |              | Aninfo Software            | 20384532547 | 15/01/2020   | inactivo |
      | sin razonsocial             | fallida   | Juan Diaz    |                            | 20384532547 | 20/03/2020   | activo   |
      | sin cuit                    | fallida   | Juan Diaz    | Metodos y Modelos Software |             | 20/03/2020   | activo   |
      | sin fechacliente            | fallida   | Carlos Perez | Aninfo Software            | 20384532547 |              | inactivo |
      | sin estado                  | fallida   | Juan Diaz    | Aninfo Software            | 20384532547 | 15/01/2020   |          |
      | con cuit incorrecto         | fallida   | Juan Diaz    | Metodos y Modelos Software | 20384532547 | 20/03/2020   | activo   |
      | con fechacliente incorrecta | fallida   | Carlos Perez | Aninfo Software            | 20384532547 | 20/03/2020   | activo   |
      | con estado incorrecto       | fallida   | Juan Diaz    | Aninfo Software            | 20384532547 | 20/03/2020   | abierto  |
      | sin modificacion            | exitosa   | Juan Diaz    | Aninfo Software            | 20384532547 | 20/03/2020   | activo   |

  Esquema del escenario: Actualización exitosa
    Dado que soy ingeniero de soporte
    Y selecciono un cliente con nombre "Juan Diaz"
    Cuando modifico el cliente "<caso>":
      | nombre   | razonsocial   | cuit   | fechacliente   | estado   |
      | <nombre> | <razonsocial> | <cuit> | <fechacliente> | <estado> |
    Entonces veo que el cliente posee los siguientes atributos:
      | nombre   | razonsocial   | cuit   | fechacliente   | estado   |
      | <nombre> | <razonsocial> | <cuit> | <fechacliente> | <estado> |


    Ejemplos:
      | caso                      | nombre                 | razonsocial                | cuit        | fechacliente | estado   |
      | cambiando el nombre       | Carlos Perez           | Aninfo Software            | 20384532547 | 20/03/2020   | activo   |
      | cambiando el razonsocial  | Consulta sobre pedidos | Metodos y Modelos Software | 20384532547 | 20/03/2020   | activo   |
      | cambiando el cuit         | Consulta sobre pedidos | Aninfo Software            | 27415486123 | 20/03/2020   | activo   |
      | cambiando el fechacliente | Consulta sobre pedidos | Aninfo Software            | 20384532547 | 15/01/2020   | activo   |
      | cambiando el estado       | Consulta sobre pedidos | Aninfo Software            | 20384532547 | 20/03/2020   | inactivo |
