# language: es
Característica: Seleccionar ticket
  Como ingeniero de soporte
  Deseo seleccionar un ticket
  Para ver información más detallada de este

  Antecedentes:
    Dado que existe un cliente con los siguientes atributoss:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |
    Y que existe un ticket con los siguientes atributos:
      | nombre                 | descripcion                  | responsableDni | tipo     | severidad | estado   | fechaDeCreacion     | fechaDeActualizacion |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  |

  Escenario: Seleccionar ticket
    Dado que soy ingeniero de soporte
    Cuando selecciono un ticket con nombre "Consulta sobre pedidos"
    Entonces veo que posee los siguientes atributos:
      | nombre                 | descripcion                  | responsableDni | tipo     | severidad | estado   | fechaDeCreacion     | fechaDeActualizacion |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  |
    Y veo que posee el siguiente cliente:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20   | activo |
