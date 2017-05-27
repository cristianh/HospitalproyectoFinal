SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS agendamedica;
DROP TABLE IF EXISTS cama;
DROP TABLE IF EXISTS historia;
DROP TABLE IF EXISTS cita;
DROP TABLE IF EXISTS habitacion;
DROP TABLE IF EXISTS consultorio;
DROP TABLE IF EXISTS control_hospitalizacion;
DROP TABLE IF EXISTS control_hospitalizacion_medico;
DROP TABLE IF EXISTS historia_paciente;
DROP TABLE IF EXISTS remision;
DROP TABLE IF EXISTS urgencia_paciente;
DROP TABLE IF EXISTS paciente;
DROP TABLE IF EXISTS municipio;
DROP TABLE IF EXISTS departamento;
DROP TABLE IF EXISTS diagnostico;
DROP TABLE IF EXISTS entrada_medico;
DROP TABLE IF EXISTS especialidad;
DROP TABLE IF EXISTS estado_cama;
DROP TABLE IF EXISTS estado_cita;
DROP TABLE IF EXISTS estado_consultorio;
DROP TABLE IF EXISTS hospitalizacion;
DROP TABLE IF EXISTS estado_hospitalizacion;
DROP TABLE IF EXISTS formula_medicamento;
DROP TABLE IF EXISTS medicamento_proveedor;
DROP TABLE IF EXISTS medicamento;
DROP TABLE IF EXISTS farmacia;
DROP TABLE IF EXISTS formula;
DROP TABLE IF EXISTS genero;
DROP TABLE IF EXISTS incapacidad;
DROP TABLE IF EXISTS salida_medico;
DROP TABLE IF EXISTS medico;
DROP TABLE IF EXISTS urgencia_procedimiento;
DROP TABLE IF EXISTS procedimiento;
DROP TABLE IF EXISTS proveedor;
DROP TABLE IF EXISTS tipodocumento;
DROP TABLE IF EXISTS tipo_cita;
DROP TABLE IF EXISTS urgencia;




/* Create Tables */

-- agendamedica
CREATE TABLE agendamedica
(
	id_agenda_medico varchar(30) NOT NULL COMMENT 'id_agenda_medico',
	fecha_agenda date COMMENT 'fecha_agenda',
	hora_agenda time COMMENT 'hora_agenda',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_agenda_medico)
) COMMENT = 'agendamedica';


-- cama
CREATE TABLE cama
(
	id_cama varchar(5) NOT NULL COMMENT 'id_cama',
	id_estado_cama varchar(2) NOT NULL COMMENT 'id_estado_cama',
	id_habitacion varchar(5) NOT NULL COMMENT 'id_habitacion',
	PRIMARY KEY (id_cama)
) COMMENT = 'cama';


-- cita
CREATE TABLE cita
(
	id_cita varchar(10) NOT NULL COMMENT 'id_cita',
	fecha_cita date COMMENT 'fecha_cita',
	id_paciente varchar(30) NOT NULL COMMENT 'id_paciente',
	id_tipo_cita varchar(2) NOT NULL COMMENT 'id_tipo_cita',
	id_estado_cita varchar(2) NOT NULL COMMENT 'id_estado_cita',
	id_consultario varchar(2) NOT NULL COMMENT 'id_consultario',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_cita)
) COMMENT = 'cita';


-- consultorio
CREATE TABLE consultorio
(
	id_consultario varchar(2) NOT NULL COMMENT 'id_consultario',
	descripcion_consultorio varchar(2) COMMENT 'descripcion_consultorio',
	id_estado_consultorio varchar(2) NOT NULL COMMENT 'id_estado_consultorio',
	PRIMARY KEY (id_consultario)
) COMMENT = 'consultorio';


-- control_hospitalizacion
CREATE TABLE control_hospitalizacion
(
	id_control_hospitalizacion varbinary(45) COMMENT 'id_control_hospitalizacion',
	id_hospitalizacion varbinary(10) NOT NULL COMMENT 'id_hospitalizacion',
	id_procedimiento varbinary(5) NOT NULL COMMENT 'id_procedimiento'
) COMMENT = 'control_hospitalizacion';


-- control_hospitalizacion_medico
CREATE TABLE control_hospitalizacion_medico
(
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	id_hospitalizacion varbinary(10) NOT NULL COMMENT 'id_hospitalizacion'
) COMMENT = 'control_hospitalizacion_medico';


-- departamento
CREATE TABLE departamento
(
	id_departamento varchar(4) NOT NULL COMMENT 'id_departamento',
	nombre_departamento varchar(50) COMMENT 'nombre_departamento',
	PRIMARY KEY (id_departamento)
) COMMENT = 'departamento';


-- diagnostico
CREATE TABLE diagnostico
(
	id_diagnostico varchar(5) NOT NULL COMMENT 'id_diagnostico',
	nombre_diagnostico varchar(50) COMMENT 'nombre_diagnostico',
	descripcion_diagnostico varchar(100) COMMENT 'descripcion_diagnostico',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_diagnostico)
) COMMENT = 'diagnostico';


-- entrada_medico
CREATE TABLE entrada_medico
(
	id_entrada_medico varchar(5) NOT NULL COMMENT 'id_entrada_medico',
	fecha_entrada_medico date COMMENT 'fecha_entrada_medico',
	hora_entrada_medico time COMMENT 'hora_entrada_medico',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_entrada_medico)
) COMMENT = 'entrada_medico';


-- especialidad
CREATE TABLE especialidad
(
	id_especialidad varchar(3) NOT NULL COMMENT 'id_especialidad',
	descripcion_especialidad varchar(50) COMMENT 'descripcion_especialidad',
	id_incapacidad varchar(10) NOT NULL COMMENT 'id_incapacidad',
	PRIMARY KEY (id_especialidad)
) COMMENT = 'especialidad';


-- estado_cama
CREATE TABLE estado_cama
(
	id_estado_cama varchar(2) NOT NULL COMMENT 'id_estado_cama',
	descripcion_estado_cama varchar(45) COMMENT 'descripcion_estado_cama',
	PRIMARY KEY (id_estado_cama)
) COMMENT = 'estado_cama';


-- estado_cita
CREATE TABLE estado_cita
(
	id_estado_cita varchar(2) NOT NULL COMMENT 'id_estado_cita',
	descripcion_estado_cita varchar(45) COMMENT 'descripcion_estado_cita',
	PRIMARY KEY (id_estado_cita)
) COMMENT = 'estado_cita';


-- estado_consultorio
CREATE TABLE estado_consultorio
(
	id_estado_consultorio varchar(2) NOT NULL COMMENT 'id_estado_consultorio',
	descripcion_estado_consultorio varchar(45) COMMENT 'descripcion_estado_consultorio',
	PRIMARY KEY (id_estado_consultorio)
) COMMENT = 'estado_consultorio';


-- estado_hospitalizacion
CREATE TABLE estado_hospitalizacion
(
	id_estado_hospitalizacion varchar(10) NOT NULL COMMENT 'id_estado_hospitalizacion',
	descripcion_estado_hospitalizacion varchar(45) COMMENT 'descripcion_estado_hospitalizacion',
	PRIMARY KEY (id_estado_hospitalizacion)
) COMMENT = 'estado_hospitalizacion';


-- farmacia
CREATE TABLE farmacia
(
	id_farmacia varchar(12) NOT NULL COMMENT 'id_farmacia',
	PRIMARY KEY (id_farmacia)
) COMMENT = 'farmacia';


-- formula
CREATE TABLE formula
(
	id_formula varchar(10) NOT NULL COMMENT 'id_formula',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_formula)
) COMMENT = 'formula';


-- formula_medicamento
CREATE TABLE formula_medicamento
(
	id_formula varchar(10) NOT NULL COMMENT 'id_formula',
	id_medicamento varchar(5) NOT NULL COMMENT 'id_medicamento',
	cantidad_medicamento_formula int COMMENT 'cantidad_medicamento_formula'
) COMMENT = 'formula_medicamento';


-- genero
CREATE TABLE genero
(
	id_genero varchar(3) NOT NULL COMMENT 'id_genero',
	tipo varchar(20) COMMENT 'tipo',
	PRIMARY KEY (id_genero)
) COMMENT = 'genero';


-- habitacion
CREATE TABLE habitacion
(
	id_habitacion varchar(5) NOT NULL COMMENT 'id_habitacion',
	descripcion_cama varchar(52) COMMENT 'descripcion_cama',
	id_consultario varchar(2) NOT NULL COMMENT 'id_consultario',
	PRIMARY KEY (id_habitacion)
) COMMENT = 'habitacion';


-- historia
CREATE TABLE historia
(
	id_historia varchar(10) NOT NULL COMMENT 'id_historia',
	id_cita varchar(10) NOT NULL COMMENT 'id_cita',
	id_historia_paciente varchar(10) NOT NULL COMMENT 'id_historia_paciente',
	PRIMARY KEY (id_historia)
) COMMENT = 'historia';


-- historia_paciente
CREATE TABLE historia_paciente
(
	id_historia_paciente varchar(10) NOT NULL COMMENT 'id_historia_paciente',
	id_paciente varchar(30) NOT NULL COMMENT 'id_paciente',
	PRIMARY KEY (id_historia_paciente)
) COMMENT = 'historia_paciente';


-- hospitalizacion
CREATE TABLE hospitalizacion
(
	id_hospitalizacion varbinary(10) NOT NULL COMMENT 'id_hospitalizacion',
	fecha_entrada_hospitalizacion date COMMENT 'fecha_entrada_hospitalizacion',
	fecha_salida_hospitalizacion date COMMENT 'fecha_salida_hospitalizacion',
	id_estado_hospitalizacion varchar(10) NOT NULL COMMENT 'id_estado_hospitalizacion',
	PRIMARY KEY (id_hospitalizacion)
) COMMENT = 'hospitalizacion';


-- incapacidad
CREATE TABLE incapacidad
(
	id_incapacidad varchar(10) NOT NULL COMMENT 'id_incapacidad',
	fecha_inicio_incapacidad date COMMENT 'fecha_inicio_incapacidad',
	fecha_final_incapacidad date COMMENT 'fecha_final_incapacidad',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_incapacidad)
) COMMENT = 'incapacidad';


-- medicamento
CREATE TABLE medicamento
(
	id_medicamento varchar(5) NOT NULL COMMENT 'id_medicamento',
	nombre_medicamento varchar(50) COMMENT 'nombre_medicamento',
	marca_medicamento varchar(50) COMMENT 'marca_medicamento',
	id_farmacia varchar(12) NOT NULL COMMENT 'id_farmacia',
	PRIMARY KEY (id_medicamento)
) COMMENT = 'medicamento';


-- medicamento_proveedor
CREATE TABLE medicamento_proveedor
(
	id_medicamento_proveedor varchar(10) NOT NULL COMMENT 'id_medicamento_proveedor',
	cantidad_medicamento int COMMENT 'cantidad_medicamento',
	lote_medicamento varchar(50) COMMENT 'lote_medicamento',
	fecha_vencimento date COMMENT 'fecha_vencimento',
	id_proveedor varchar(15) NOT NULL COMMENT 'id_proveedor',
	id_medicamento varchar(5) NOT NULL COMMENT 'id_medicamento',
	PRIMARY KEY (id_medicamento_proveedor)
) COMMENT = 'medicamento_proveedor';


-- medico
CREATE TABLE medico
(
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	nombre_medico varchar(40) COMMENT 'nombre_medico',
	apellido_medico varchar(50) COMMENT 'apellido_medico',
	telefono_medico varchar(20) COMMENT 'telefono_medico',
	direccion_medico varchar(50) COMMENT 'direccion_medico',
	email_medico varchar(50) COMMENT 'email_medico',
	telefono_emergencia_medico varchar(20) COMMENT 'telefono_emergencia_medico',
	fecha_nacimiento_medico date COMMENT 'fecha_nacimiento_medico',
	numero_documento_medico varchar(20) COMMENT 'numero_documento_medico',
	id_tipo_documento varchar(3) NOT NULL COMMENT 'id_tipo_documento',
	PRIMARY KEY (id_medico)
) COMMENT = 'medico';


-- municipio
CREATE TABLE municipio
(
	id_municipio varchar(5) NOT NULL COMMENT 'id_municipio',
	nombre_municipio varchar(30) COMMENT 'nombre_municipio',
	id_departamento varchar(4) NOT NULL COMMENT 'id_departamento',
	PRIMARY KEY (id_municipio)
) COMMENT = 'municipio';


-- paciente
CREATE TABLE paciente
(
	id_paciente varchar(30) NOT NULL COMMENT 'id_paciente',
	nombre_paciente varchar(50) COMMENT 'nombre_paciente',
	apellido_paciente varchar(50) COMMENT 'apellido_paciente',
	direccion_paciente varchar(100) COMMENT 'direccion_paciente',
	fecha_nacimiento_paciente date COMMENT 'fecha_nacimiento_paciente',
	telefono_paciente varchar(20) COMMENT 'telefono_paciente',
	peso_paciente float(20) COMMENT 'peso_paciente',
	numero_documento_paciente varchar(30) COMMENT 'numero_documento_paciente',
	id_tipo_documento varchar(3) NOT NULL COMMENT 'id_tipo_documento',
	id_municipio varchar(5) NOT NULL COMMENT 'id_municipio',
	id_genero varchar(3) NOT NULL COMMENT 'id_genero',
	PRIMARY KEY (id_paciente)
) COMMENT = 'paciente';


-- procedimiento
CREATE TABLE procedimiento
(
	id_procedimiento varbinary(5) NOT NULL COMMENT 'id_procedimiento',
	nombre_procedimiento varchar(50) COMMENT 'nombre_procedimiento',
	procedimiento varchar(100) COMMENT 'procedimiento',
	PRIMARY KEY (id_procedimiento)
) COMMENT = 'procedimiento';


-- proveedor
CREATE TABLE proveedor
(
	id_proveedor varchar(15) NOT NULL COMMENT 'id_proveedor',
	nombre_proveedor varchar(50) COMMENT 'nombre_proveedor',
	persona_contacto varchar(50) COMMENT 'persona_contacto',
	direccion_proveedor varchar(50) COMMENT 'direccion_proveedor',
	telefono_proveedor varchar(20) COMMENT 'telefono_proveedor',
	email_preveedor varchar(100) COMMENT 'email_preveedor',
	PRIMARY KEY (id_proveedor)
) COMMENT = 'proveedor';


-- remision
CREATE TABLE remision
(
	id_remision varchar(5) NOT NULL COMMENT 'id_remision',
	id_paciente varchar(30) NOT NULL COMMENT 'id_paciente',
	descripcion_remision varchar(100) COMMENT 'descripcion_remision',
	PRIMARY KEY (id_remision)
) COMMENT = 'remision';


-- salida_medico
CREATE TABLE salida_medico
(
	id_salida_medico varchar(5) NOT NULL COMMENT 'id_salida_medico',
	hora_salida_medico time COMMENT 'hora_salida_medico',
	fecha_salida_medico date COMMENT 'fecha_salida_medico',
	id_medico varchar(15) NOT NULL COMMENT 'id_medico',
	PRIMARY KEY (id_salida_medico)
) COMMENT = 'salida_medico';


-- tipodocumento
CREATE TABLE tipodocumento
(
	id_tipo_documento varchar(3) NOT NULL COMMENT 'id_tipo_documento',
	tipo_documento varchar(30) COMMENT 'tipo_documento',
	PRIMARY KEY (id_tipo_documento)
) COMMENT = 'tipodocumento';


-- tipo_cita
CREATE TABLE tipo_cita
(
	id_tipo_cita varchar(2) NOT NULL COMMENT 'id_tipo_cita',
	descripcion_tipo_cita varchar(100) COMMENT 'descripcion_tipo_cita',
	PRIMARY KEY (id_tipo_cita)
) COMMENT = 'tipo_cita';


-- urgencia
CREATE TABLE urgencia
(
	id_urgencia varchar(5) NOT NULL COMMENT 'id_urgencia',
	hora_urgencia time COMMENT 'hora_urgencia',
	fecha_urgencia date COMMENT 'fecha_urgencia',
	PRIMARY KEY (id_urgencia)
) COMMENT = 'urgencia';


-- urgencia_paciente
CREATE TABLE urgencia_paciente
(
	id_urgencia varchar(5) NOT NULL COMMENT 'id_urgencia',
	id_paciente varchar(30) NOT NULL COMMENT 'id_paciente'
) COMMENT = 'urgencia_paciente';


-- urgencia_procedimiento
CREATE TABLE urgencia_procedimiento
(
	id_urgencia varchar(5) NOT NULL COMMENT 'id_urgencia',
	id_procedimiento varbinary(5) NOT NULL COMMENT 'id_procedimiento'
) COMMENT = 'urgencia_procedimiento';



/* Create Foreign Keys */

ALTER TABLE historia
	ADD FOREIGN KEY (id_cita)
	REFERENCES cita (id_cita)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cita
	ADD FOREIGN KEY (id_consultario)
	REFERENCES consultorio (id_consultario)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE habitacion
	ADD FOREIGN KEY (id_consultario)
	REFERENCES consultorio (id_consultario)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE municipio
	ADD FOREIGN KEY (id_departamento)
	REFERENCES departamento (id_departamento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cama
	ADD FOREIGN KEY (id_estado_cama)
	REFERENCES estado_cama (id_estado_cama)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cita
	ADD FOREIGN KEY (id_estado_cita)
	REFERENCES estado_cita (id_estado_cita)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



ALTER TABLE consultorio
	ADD FOREIGN KEY (id_estado_consultorio)
	REFERENCES estado_consultorio (id_estado_consultorio)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE hospitalizacion
	ADD FOREIGN KEY (id_estado_hospitalizacion)
	REFERENCES estado_hospitalizacion (id_estado_hospitalizacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE medicamento
	ADD FOREIGN KEY (id_farmacia)
	REFERENCES farmacia (id_farmacia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE formula_medicamento
	ADD FOREIGN KEY (id_formula)
	REFERENCES formula (id_formula)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE paciente
	ADD FOREIGN KEY (id_genero)
	REFERENCES genero (id_genero)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cama
	ADD FOREIGN KEY (id_habitacion)
	REFERENCES habitacion (id_habitacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE historia
	ADD FOREIGN KEY (id_historia_paciente)
	REFERENCES historia_paciente (id_historia_paciente)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE control_hospitalizacion
	ADD FOREIGN KEY (id_hospitalizacion)
	REFERENCES hospitalizacion (id_hospitalizacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE control_hospitalizacion_medico
	ADD FOREIGN KEY (id_hospitalizacion)
	REFERENCES hospitalizacion (id_hospitalizacion)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE especialidad
	ADD FOREIGN KEY (id_incapacidad)
	REFERENCES incapacidad (id_incapacidad)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE formula_medicamento
	ADD FOREIGN KEY (id_medicamento)
	REFERENCES medicamento (id_medicamento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE medicamento_proveedor
	ADD FOREIGN KEY (id_medicamento)
	REFERENCES medicamento (id_medicamento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE agendamedica
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cita
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE control_hospitalizacion_medico
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE diagnostico
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE entrada_medico
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE formula
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE incapacidad
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE salida_medico
	ADD FOREIGN KEY (id_medico)
	REFERENCES medico (id_medico)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE paciente
	ADD FOREIGN KEY (id_municipio)
	REFERENCES municipio (id_municipio)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cita
	ADD FOREIGN KEY (id_paciente)
	REFERENCES paciente (id_paciente)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE historia_paciente
	ADD FOREIGN KEY (id_paciente)
	REFERENCES paciente (id_paciente)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE remision
	ADD FOREIGN KEY (id_paciente)
	REFERENCES paciente (id_paciente)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE urgencia_paciente
	ADD FOREIGN KEY (id_paciente)
	REFERENCES paciente (id_paciente)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE control_hospitalizacion
	ADD FOREIGN KEY (id_procedimiento)
	REFERENCES procedimiento (id_procedimiento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE urgencia_procedimiento
	ADD FOREIGN KEY (id_procedimiento)
	REFERENCES procedimiento (id_procedimiento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE medicamento_proveedor
	ADD FOREIGN KEY (id_proveedor)
	REFERENCES proveedor (id_proveedor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE medico
	ADD FOREIGN KEY (id_tipo_documento)
	REFERENCES tipodocumento (id_tipo_documento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE paciente
	ADD FOREIGN KEY (id_tipo_documento)
	REFERENCES tipodocumento (id_tipo_documento)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cita
	ADD FOREIGN KEY (id_tipo_cita)
	REFERENCES tipo_cita (id_tipo_cita)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE urgencia_paciente
	ADD FOREIGN KEY (id_urgencia)
	REFERENCES urgencia (id_urgencia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE urgencia_procedimiento
	ADD FOREIGN KEY (id_urgencia)
	REFERENCES urgencia (id_urgencia)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



