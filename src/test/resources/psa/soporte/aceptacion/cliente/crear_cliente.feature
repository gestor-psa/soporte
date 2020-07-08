# language: es
Característica: Crear ticket
  Como ingeniero de soporte
  Deseo crear un cliente
  Para poder saber quien reporto la incidencia que derivara en un ticket

  Antecedentes:
    Dado que existe un producto con nombre "PSA ERP" y versión 2

  Esquema del escenario: Crear cliente
    Dado que soy ingeniero de soporte
    Cuando creo un cliente "<caso>" ingresando:
      | nombre   | razonsocial   | cuit   | fechacliente   |
      | <nombre> | <razonsocial> | <cuit> | <fechacliente> |
    Entonces veo que la operación de cliente fue "<resultado>"

    Ejemplos:
      | caso                        | resultado | nombre    | razonsocial     | cuit        | fechacliente |
      | sin nombre                  | fallida   |           | Aninfo Software | 20384532547 | 20/03/2020   |
      | sin razon social            | fallida   | Juan Diaz |                 | 20384532547 | 20/03/2020   |
      | sin cuit                    | fallida   | Juan Diaz | Aninfo Software |             | 20/03/2020   |
      | sin fechacliente            | fallida   | Juan Diaz | Aninfo Software | 20384532547 |              |
      | con cuit incorrecto         | fallida   | Juan Diaz | Aninfo Software | qwertyuiop  | 20/03/2020   |
      | con fechacliente incorrecto | fallida   | Juan Diaz | Aninfo Software | 20384532547 | qwertyuiop   |
      | correctamente               | exitosa   | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   |

  Escenario: Creación exitosa
    Dado que soy ingeniero de soporte
    Cuando creo un cliente "correctamente" ingresando:
      | nombre    | razonsocial     | cuit        | fechacliente |
      | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   |
    Entonces veo que el cliente posee los siguientes atributos:
      | nombre    | razonsocial     | cuit        | fechacliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 20/03/2020   | activo |
