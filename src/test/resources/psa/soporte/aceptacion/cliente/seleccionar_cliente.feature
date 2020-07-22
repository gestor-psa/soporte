# language: es
Característica: Seleccionar ticket
  Como ingeniero de soporte
  Deseo seleccionar un ticket
  Para ver información más detallada de este

  Antecedentes:
    Dado que existe un cliente con los siguientes atributos:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20  | activo |

  Escenario: Seleccionar cliente
    Dado que soy ingeniero de soporte
    Cuando selecciono un cliente con nombre "Juan Diaz"
    Entonces veo que el cliente posee los siguientes atributos:
      | nombre    | razonSocial     | cuit        | fechaCliente | estado |
      | Juan Diaz | Aninfo Software | 20384532547 | 2020/03/20  | activo |

