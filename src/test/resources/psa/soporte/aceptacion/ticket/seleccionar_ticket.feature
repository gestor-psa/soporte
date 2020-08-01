# language: es
Característica: Seleccionar ticket
  Como ingeniero de soporte
  Deseo seleccionar un ticket
  Para ver información más detallada de este

  Antecedentes:
    Dado que existe un ticket con los siguientes atributos:
      | nombre                 | descripcion                  | responsableDni | tipo     | severidad | estado   | fechaDeCreacion     | fechaDeActualizacion | producto | versionDelProducto |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  | PSA ERP  | 2                  |
    Y con los siguientes comentarios:
      | comentario                                                              | usuario        | fecha               |
      | El usuario preguntó por el costo de envío                               | Matias Marquez | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | Matias Marquez | 2020/06/20 13:56:58 |
    Y que existe un producto con nombre "PSA ERP" y versión 2

  Escenario: Seleccionar ticket
    Dado que soy ingeniero de soporte
    Y selecciono la versión 2 del producto "PSA ERP"
    Cuando selecciono un ticket con nombre "Consulta sobre pedidos"
    Entonces veo que posee los siguientes atributos:
      | nombre                 | descripcion                  | responsableDni | tipo     | severidad | estado   | fechaDeCreacion     | fechaDeActualizacion |
      | Consulta sobre pedidos | ¿Cuál es el costo del envío? | 41226943       | consulta | baja      | iniciado | 2020/06/20 13:53:45 | 2020/06/20 13:58:24  |
    Y veo que posee los siguientes comentarios:
      | comentario                                                              | usuario        | fecha               |
      | El usuario preguntó por el costo de envío                               | Matias Marquez | 2020/06/20 13:54:17 |
      | Se respondío al usuario que eso se calcula al ingresar el código postal | Matias Marquez | 2020/06/20 13:56:58 |
