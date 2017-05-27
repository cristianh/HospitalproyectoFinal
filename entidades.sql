SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Agenda;
DROP TABLE IF EXISTS Citas;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS ff;
DROP TABLE IF EXISTS Profesional;




/* Create Tables */

-- Agenda
CREATE TABLE Agenda
(
	Idagenda int COMMENT 'Idagenda',
	Hora1 time COMMENT 'Hora1',
	Hora2 time COMMENT 'Hora2',
	IdProfesional int COMMENT 'IdProfesional',
	fecha date COMMENT 'fecha'
) COMMENT = 'Agenda';


-- Citas
CREATE TABLE Citas
(
	Fecha_cita date COMMENT 'Fecha_cita',
	Dia_cita date COMMENT 'Dia_cita',
	Hora_cita time COMMENT 'Hora_cita',
	idProfesional int COMMENT 'idProfesional',
	Id_cliente int COMMENT 'Id_cliente',
	UNIQUE (idProfesional),
	UNIQUE (Id_cliente)
) COMMENT = 'Citas';


-- Cliente
CREATE TABLE Cliente
(
	IdCliente int NOT NULL COMMENT 'IdCliente',
	identificacion_cliente int COMMENT 'identificacion_cliente',
	nombre_cliente varchar(100) COMMENT 'nombre_cliente',
	apellido_cliente varchar(100) COMMENT 'apellido_cliente',
	telefono_cliente varchar(100) COMMENT 'telefono_cliente',
	edad_cliente int COMMENT 'edad_cliente',
	PRIMARY KEY (IdCliente),
	UNIQUE (IdCliente)
) COMMENT = 'Cliente';


-- ff
CREATE TABLE ff
(
	nombre varchar(12) NOT NULL COMMENT 'nombre',
	PRIMARY KEY (nombre)
) COMMENT = 'ff';


-- Profesional
CREATE TABLE Profesional
(
	IdProfesional int NOT NULL COMMENT 'IdProfesional',
	nombre_profesional varchar(100) COMMENT 'nombre_profesional',
	apellido_profesional varchar(100) COMMENT 'apellido_profesional',
	identificacion_profesional int COMMENT 'identificacion_profesional',
	area_profesional varchar(100) COMMENT 'area_profesional',
	telefono_profesional varchar(100) COMMENT 'telefono_profesional',
	direccion_profesional varchar(1000) COMMENT 'direccion_profesional',
	PRIMARY KEY (IdProfesional),
	UNIQUE (IdProfesional)
) COMMENT = 'Profesional';



