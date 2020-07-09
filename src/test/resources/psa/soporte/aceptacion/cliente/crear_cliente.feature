# language: es
Característica: Crear ticket
  Como ingeniero de soporte
  Deseo crear un cliente
  Para poder saber quien reporto la incidencia que derivara en un ticket


  Esquema del escenario: Crear cliente
    Dado que soy ingeniero de soporte
    Cuando creo un cliente "<caso>" ingresando:
      | nombre   | razonSocial   | cuit   | fechaCliente   |
      | <nombre> | <razonSocial> | <cuit> | <fechaCliente> |
    Entonces veo que la operación de cliente fue "<resultado>"

    Ejemplos:
      | caso                        | resultado | nombre    | razonSocial     | cuit        | fechaCliente |
      | sin nombre                  | fallida   |           | Aninfo Software | 20384532547 | 20/03/2020   |
      | sin razon social            | fallida   | Juan Diaz |                 | 20384532547 | 20/03/2020   |
      | sin cuit                    | fallida   | Juan Diaz | Aninfo Software |             | 20/03/2020   |
      | sin fechaCliente            | fallida   | Juan Diaz | Aninfo Software | 20384532547 |              |
      | con cuit incorrecto         | fallida   | Juan Diaz | Aninfo Software | qwertyuiop  | 20/03/2020   |
      | con fechaCliente incorrecto | fallida   | Juan Diaz | Aninfo Software | 20384532547 | qwertyuiop   |
      | correctamente               | exitosa   | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   |

  Escenario: Creación exitosa
    Dado que soy ingeniero de soporte
    Cuando creo un cliente "correctamente" ingresando:
      | nombre    | razonSocial     | cuit        | fechaCliente |
      | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   |
    Entonces veo que el cliente posee los siguientes atributos:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   | activo |
