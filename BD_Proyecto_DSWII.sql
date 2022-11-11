
DROP DATABASE IF EXISTS proyecto_dswii; 
CREATE DATABASE proyecto_dswii;
USE proyecto_dswii;

/*SHOW CREATE TABLE usuario;*/
/*SHOW CREATE TABLE usuario_has_rol;*/
/*SHOW CREATE TABLE rol;*/
/*SHOW CREATE TABLE rol_has_opcion;*/
/*SHOW CREATE TABLE opcion;*/
drop table if exists `usuario`;
CREATE TABLE `usuario` (
   `idUsuario` int NOT NULL AUTO_INCREMENT,
   `nombres` varchar(100) DEFAULT NULL,
   `apellidos` varchar(100) DEFAULT NULL,
   `dni` varchar(8) DEFAULT NULL,
   `login` varchar(15) DEFAULT NULL,
   `password` varchar(200) DEFAULT NULL,
   `correo` varchar(45) DEFAULT NULL,
   `fechaRegistro` datetime DEFAULT NULL,
   `fechaNacimiento` date DEFAULT NULL,
   `direccion` text,
   PRIMARY KEY (`idUsuario`),
   UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`)
 ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
 
 drop table if exists `rol`;
 CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

drop table if exists `opcion`;
CREATE TABLE `opcion` (
  `idOpcion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `ruta` text,
  `tipo` smallint DEFAULT NULL,
  PRIMARY KEY (`idOpcion`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;

drop table if exists `usuario_has_rol`;
 CREATE TABLE `usuario_has_rol` (
   `idUsuario` int NOT NULL,
   `idRol` int NOT NULL,
   PRIMARY KEY (`idUsuario`,`idRol`),
   KEY `fk_usuario_has_rol_rol1_idx` (`idRol`),
   KEY `fk_usuario_has_rol_usuario1_idx` (`idUsuario`),
   CONSTRAINT `fk_usuario_has_rol_rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`),
   CONSTRAINT `fk_usuario_has_rol_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
 
 drop table if exists `rol_has_opcion`;
 CREATE TABLE `rol_has_opcion` (
  `idrol` int NOT NULL,
  `idopcion` int NOT NULL,
  PRIMARY KEY (`idrol`,`idopcion`),
  KEY `fk_rol_has_opcion_opcion1_idx` (`idopcion`),
  KEY `fk_rol_has_opcion_rol1_idx` (`idrol`),
  CONSTRAINT `fk_rol_has_opcion_opcion1` FOREIGN KEY (`idopcion`) REFERENCES `opcion` (`idOpcion`),
  CONSTRAINT `fk_rol_has_opcion_rol1` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `usuario` VALUES (1,'Luis Alberto','Sanchez Quispe ','74747474','luis','$2a$10$UpRniOJk79kqbommNs/o7u/mQKLmarKRrjjxAvmmcHPrUaqiAreOG','luis@gmail.com','2022-04-04 10:59:07','2000-10-10','Av Lima 123');
INSERT INTO `rol` VALUES (1,'Bibliotecologo','1');
INSERT INTO `opcion` VALUES (1,'Registro Alumno','1','agregarAlumno',1),(2,'Registro Libro','1','agregarLibro',1),(3,'Registro Tesis','1','agregarTesis',1),(4,'Registro Autor','1','agregarAutor',1),(5,'Registro Sala','1','agregarSala',1),(6,'Registro Proveedor','1','agregarProveedor',1),(7,'Crud Alumno','1','crudAlumno',3),(8,'Crud Libro','1','crudLibro',3),(9,'Crud Tesis','1','crudTesis',3),(10,'Crud Autor','1','crudAutor',3),(11,'Crud Sala','1','crudSala',3),(12,'Crud Proveedor','1','crudProveedor',3),(13,'Consulta Alumno','1','consultaAlumno',2),(14,'Consulta Libro','1','consultaLibro',2),(15,'Consulta Tesis','1','consultaTesis',2),(16,'Consulta Autor','1','consultaAutor',2),(17,'Consulta Sala','1','consultaSala',2),(18,'Consulta Proveedor','1','consultaProveedor',2),(19,'Préstamo','1','prestamo',4),(20,'Devolución','1','devolucion',4),(21,'Registro Prueba','1','agregarPrueba',1);
INSERT INTO `rol_has_opcion` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21);
INSERT INTO `usuario_has_rol` VALUES (1,1);

drop table if exists tb_categoria;
create table tb_categoria
(
cod_categoria int,
des_categoria varchar(30),
primary key (cod_categoria)
);

drop table if exists tb_autor;
create table tb_autor(
cod_autor int auto_increment,
nombre_autor varchar(100),
apellido_autor varchar(100),
fechanacimiento_autor date,
primary key (cod_autor)
);

drop table if exists tb_libros;
create table tb_libros(
cod_libro int auto_increment,
nombre_libro varchar(200),
precio_libro decimal(10,2),
stock_libro int,
fechapublicacion_libros date,
cod_categoria int, 
cod_autor int ,
primary key (cod_libro),
constraint fk_libros_categoria foreign key (cod_categoria) references tb_categoria(cod_categoria),
constraint fk_libros_autor foreign key (cod_autor) references tb_autor(cod_autor)
);	

/****************************************************INSERT*********************************************/
/*************************************tb_categoria*****************************************************/
insert into tb_categoria values (1,'Accion');
insert into tb_categoria values (2,'Aventura');
insert into tb_categoria values (3,'Romance');
insert into tb_categoria values (4,'Ficcion');
insert into tb_categoria values (5,'Fantasia');

/*************************************tb_autor*****************************************************/
insert into tb_autor values (1,'Gabriel', 'García Márquez', '1927-03-06');
insert into tb_autor values (2,'Jane ', 'Austen', '1775-12-16');
insert into tb_autor values (3,'León ', 'Tolstói', '1828-08-09');
insert into tb_autor values (4,'Miguel ', 'de Cervantes ', '1547-09-29');
insert into tb_autor values (5,'George ', 'Orwell', '1903-06-25');

/*************************************tb_libros*****************************************************/
insert into tb_libros values (null,'El coronel no tiene quien le escriba', 50.00, 3,'2022-07-04 ',2,1);
insert into tb_libros values (null,'Un señor muy viejo con unas alas enormes', 150.99, 16,'2020-01-13 ',1,1);
insert into tb_libros values (null,'La poesía de jane austen y la familia austen', 16.10, 23,'2017-03-06',3,2);
insert into tb_libros values (null,'Grullas blancas: biología y conservación: biodiversidad del mundo: conservación desde los genes hasta los paisajes', 250.99, 1,'2019-01-26 ',4,2);
insert into tb_libros values (null,'La esclavitud de nuestros tiempos', 300.00, 10,'2017-11-02 ',2,3);
insert into tb_libros values (null,'Los frutos de la cultura: una comedia en cuatro actos', 5.00, 13,'2013-01-17 ',1,3);
insert into tb_libros values (null,'La Historia de Don Quijote de La Mancha', 27.00, 24,'2010-06-16 ',3,4);
insert into tb_libros values (null,'La vida y hazañas del ingenioso hidalgo don quijote de la mancha', 13.00, 8,'2021-03-11 ',4,4);
insert into tb_libros values (null,'Panfletistas británicos', 99.00, 5,'2022-10-10 ',5,5);
insert into tb_libros values (null,'La casa de los espíritus', 50.00, 6,'2020-09-23 ',5,5);


select * from tb_autor; 
select * from tb_libros; 
select * from tb_categoria; 