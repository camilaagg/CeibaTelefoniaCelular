create table planes (
 id int(11) not null auto_increment,
 nombre_plan varchar(100) not null,
 valor_plan varchar(45) not null,
 especificaciones_plan varchar(200) not null,
 primary key (id)
);

create table clientes (
 id int(11) not null auto_increment,
 tipo_identificacion varchar(100) not null,
 numero_identificacion varchar(45) not null,
 nombre_cliente varchar(50) not null,
 numero_telefono varchar(10) not null,
 id_plan int(11) not null,
 valor_plan varchar(100) not null,
 fecha_inicio datetime null,
 primary key (id, numero_telefono, numero_identificacion),
 foreign key (id_plan) references planes(id)
);
