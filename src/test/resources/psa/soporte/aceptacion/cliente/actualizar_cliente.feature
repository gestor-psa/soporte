# language: es
Característica: Actualizar Ticket
  Como ingeniero de soporte
  actualizar un cliente
  para cambiar sus atributos

  Antecedentes:
    Dado que existe un cliente con los siguientes atributos:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20  | activo |

  Esquema del escenario: Actualizar cliente
    Dado que soy ingeniero de soporte
    Y selecciono un cliente con nombre "Juan Diaz"
    Cuando modifico el cliente "<caso>":
      | nombre   | razonSocial   | cuit   | fechaCliente   | estado   |
      | <nombre> | <razonSocial> | <cuit> | <fechaCliente> | <estado> |
    Entonces veo que la operación de cliente fue "<resultado>"

    Ejemplos:
      | caso                        | resultado | nombre       | razonSocial                | cuit        | fechaCliente | estado   |
      | sin nombre                  | fallida   |              | Aninfo Software            | 20384532547 | 2020/01/15   | inactivo |
      | sin razonSocial             | fallida   | Juan Diaz    |                            | 20384532547 | 2020/03/20  | activo   |
      | sin cuit                    | fallida   | Juan Diaz    | Metodos y Modelos Software |             | 2020/03/20  | activo   |
      | sin fechaCliente            | fallida   | Carlos Perez | Aninfo Software            | 20384532547 |              | inactivo |
      | sin estado                  | fallida   | Juan Diaz    | Aninfo Software            | 20384532547 | 2020/01/15   |          |
      | con cuit incorrecto         | fallida   | Juan Diaz    | Metodos y Modelos Software | qwertyuiop  | 2020/03/20  | activo   |
      | con fechaCliente incorrecta | fallida   | Carlos Perez | Aninfo Software            | 20384532547 | qwertyuiop   | activo   |
      | con estado incorrecto       | fallida   | Juan Diaz    | Aninfo Software            | 20384532547 | 2020/03/20  | abierto  |
      | sin modificacion            | exitosa   | Juan Diaz    | Aninfo Software            | 20384532547 | 2020/03/20  | activo   |

  Esquema del escenario: Actualización exitosa
    Dado que soy ingeniero de soporte
    Y selecciono un cliente con nombre "Juan Diaz"
    Cuando modifico el cliente "<caso>":
      | nombre   | razonSocial   | cuit   | fechaCliente   | estado   |
      | <nombre> | <razonSocial> | <cuit> | <fechaCliente> | <estado> |
    Entonces veo que el cliente posee los siguientes atributos:
      | nombre   | razonSocial   | cuit   | fechaCliente   | estado   |
      | <nombre> | <razonSocial> | <cuit> | <fechaCliente> | <estado> |


    Ejemplos:
      | caso                      | nombre                 | razonSocial                | cuit        | fechaCliente | estado   |
      | cambiando el nombre       | Carlos Perez           | Aninfo Software            | 20384532547 | 2020/03/20  | activo   |
      | cambiando el razonSocial  | Consulta sobre pedidos | Metodos y Modelos Software | 20384532547 | 2020/03/20  | activo   |
      | cambiando el cuit         | Consulta sobre pedidos | Aninfo Software            | 27415486123 | 2020/03/20  | activo   |
      | cambiando el fechaCliente | Consulta sobre pedidos | Aninfo Software            | 20384532547 | 2020/01/15   | activo   |
      | cambiando el estado       | Consulta sobre pedidos | Aninfo Software            | 20384532547 | 2020/03/20  | inactivo |
