select C.id, C.tipo_identificacion, C.numero_identificacion, C.nombre_cliente, C.numero_telefono, P.nombre_plan, C.valor_plan, C.fecha_inicio
from clientes C INNER JOIN planes P ON C.id_plan = P.id WHERE C.numero_identificacion = :identificationNumber AND C.numero_telefono = :phoneNumber