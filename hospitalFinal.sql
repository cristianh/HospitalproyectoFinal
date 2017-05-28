-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamedica`
--

DROP TABLE IF EXISTS `agendamedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendamedica` (
  `id_agenda_medico` varchar(30) NOT NULL COMMENT 'id_agenda_medico',
  `fecha_agenda` date DEFAULT NULL COMMENT 'fecha_agenda',
  `hora_agenda` varchar(15) DEFAULT NULL COMMENT 'hora_agenda',
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  PRIMARY KEY (`id_agenda_medico`),
  KEY `id_medico` (`id_medico`),
  CONSTRAINT `agendamedica_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='agendamedica';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamedica`
--

LOCK TABLES `agendamedica` WRITE;
/*!40000 ALTER TABLE `agendamedica` DISABLE KEYS */;
INSERT INTO `agendamedica` VALUES ('123123','2017-05-10','7:00-9:30','1'),('12333','2017-05-02','7:30-9:30','1'),('2222','2017-05-10','7:00-9:30','1');
/*!40000 ALTER TABLE `agendamedica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cama`
--

DROP TABLE IF EXISTS `cama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cama` (
  `id_cama` varchar(5) NOT NULL COMMENT 'id_cama',
  `id_estado_cama` varchar(2) NOT NULL COMMENT 'id_estado_cama',
  `id_habitacion` varchar(2) NOT NULL,
  PRIMARY KEY (`id_cama`),
  KEY `id_estado_cama` (`id_estado_cama`),
  KEY `id_habitacion_idx` (`id_habitacion`),
  CONSTRAINT `cama_ibfk_1` FOREIGN KEY (`id_estado_cama`) REFERENCES `estado_cama` (`id_estado_cama`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_habitacion` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='cama';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cama`
--

LOCK TABLES `cama` WRITE;
/*!40000 ALTER TABLE `cama` DISABLE KEYS */;
INSERT INTO `cama` VALUES ('1','2','1');
/*!40000 ALTER TABLE `cama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cita` (
  `id_cita` varchar(10) NOT NULL COMMENT 'id_cita',
  `fecha_cita` date DEFAULT NULL COMMENT 'fecha_cita',
  `hora_cita` varchar(45) NOT NULL,
  `id_paciente` varchar(30) NOT NULL COMMENT 'id_paciente',
  `id_tipo_cita` varchar(2) NOT NULL COMMENT 'id_tipo_cita',
  `id_estado_cita` varchar(2) NOT NULL COMMENT 'id_estado_cita',
  `id_consultario` varchar(2) NOT NULL COMMENT 'id_consultario',
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  PRIMARY KEY (`id_cita`),
  KEY `id_consultario` (`id_consultario`),
  KEY `id_estado_cita` (`id_estado_cita`),
  KEY `id_paciente` (`id_paciente`),
  KEY `id_tipo_cita` (`id_tipo_cita`),
  KEY `cita_ibfk_3` (`id_medico`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`id_consultario`) REFERENCES `consultorio` (`id_consultorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`id_estado_cita`) REFERENCES `estado_cita` (`id_estado_cita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `cita_ibfk_4` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cita_ibfk_5` FOREIGN KEY (`id_tipo_cita`) REFERENCES `tipo_cita` (`id_tipo_cita`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='cita';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultorio`
--

DROP TABLE IF EXISTS `consultorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultorio` (
  `id_consultorio` varchar(2) NOT NULL COMMENT 'id_consultario',
  `descripcion_consultorio` varchar(200) DEFAULT NULL COMMENT 'descripcion_consultorio',
  `id_estado_consultorio` varchar(2) NOT NULL COMMENT 'id_estado_consultorio',
  PRIMARY KEY (`id_consultorio`),
  KEY `consultorio_ibfk_1` (`id_estado_consultorio`),
  CONSTRAINT `consultorio_ibfk_1` FOREIGN KEY (`id_estado_consultorio`) REFERENCES `estado_consultorio` (`id_estado_consultorio`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='consultorio';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultorio`
--

LOCK TABLES `consultorio` WRITE;
/*!40000 ALTER TABLE `consultorio` DISABLE KEYS */;
INSERT INTO `consultorio` VALUES ('1','ghg','1'),('2','as','1');
/*!40000 ALTER TABLE `consultorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control_hospitalizacion`
--

DROP TABLE IF EXISTS `control_hospitalizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `control_hospitalizacion` (
  `id_control_hospitalizacion` varbinary(45) DEFAULT NULL COMMENT 'id_control_hospitalizacion',
  `id_hospitalizacion` varbinary(10) NOT NULL COMMENT 'id_hospitalizacion',
  `id_procedimiento` varbinary(5) NOT NULL COMMENT 'id_procedimiento',
  KEY `id_hospitalizacion` (`id_hospitalizacion`),
  KEY `id_procedimiento` (`id_procedimiento`),
  CONSTRAINT `control_hospitalizacion_ibfk_1` FOREIGN KEY (`id_hospitalizacion`) REFERENCES `hospitalizacion` (`id_hospitalizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `control_hospitalizacion_ibfk_2` FOREIGN KEY (`id_procedimiento`) REFERENCES `procedimiento` (`id_procedimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='control_hospitalizacion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_hospitalizacion`
--

LOCK TABLES `control_hospitalizacion` WRITE;
/*!40000 ALTER TABLE `control_hospitalizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `control_hospitalizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control_hospitalizacion_medico`
--

DROP TABLE IF EXISTS `control_hospitalizacion_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `control_hospitalizacion_medico` (
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  `id_hospitalizacion` varbinary(10) NOT NULL COMMENT 'id_hospitalizacion',
  KEY `id_hospitalizacion` (`id_hospitalizacion`),
  KEY `id_medico` (`id_medico`),
  CONSTRAINT `control_hospitalizacion_medico_ibfk_1` FOREIGN KEY (`id_hospitalizacion`) REFERENCES `hospitalizacion` (`id_hospitalizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `control_hospitalizacion_medico_ibfk_2` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='control_hospitalizacion_medico';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_hospitalizacion_medico`
--

LOCK TABLES `control_hospitalizacion_medico` WRITE;
/*!40000 ALTER TABLE `control_hospitalizacion_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `control_hospitalizacion_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id_departamento` varchar(4) NOT NULL COMMENT 'id_departamento',
  `nombre_departamento` varchar(50) DEFAULT NULL COMMENT 'nombre_departamento',
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='departamento';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES ('1','Quindio'),('2','Risaralda'),('3','Valle del Cauca'),('4','Cundinamarca');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico` (
  `id_diagnostico` varchar(5) NOT NULL COMMENT 'id_diagnostico',
  `nombre_diagnostico` varchar(50) DEFAULT NULL COMMENT 'nombre_diagnostico',
  `descripcion_diagnostico` varchar(100) DEFAULT NULL COMMENT 'descripcion_diagnostico',
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  `id_paciente` varchar(45) NOT NULL,
  PRIMARY KEY (`id_diagnostico`),
  KEY `id_medico` (`id_medico`),
  KEY `id_paciente_idx` (`id_paciente`),
  CONSTRAINT `diagnostico_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='diagnostico';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada_medico`
--

DROP TABLE IF EXISTS `entrada_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada_medico` (
  `id_entrada_medico` varchar(5) NOT NULL COMMENT 'id_entrada_medico',
  `fecha_entrada_medico` date DEFAULT NULL COMMENT 'fecha_entrada_medico',
  `hora_entrada_medico` time DEFAULT NULL COMMENT 'hora_entrada_medico',
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  PRIMARY KEY (`id_entrada_medico`),
  KEY `id_medico` (`id_medico`),
  CONSTRAINT `entrada_medico_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='entrada_medico';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada_medico`
--

LOCK TABLES `entrada_medico` WRITE;
/*!40000 ALTER TABLE `entrada_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrada_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidad` (
  `id_especialidad` varchar(3) NOT NULL COMMENT 'id_especialidad',
  `descripcion_especialidad` varchar(50) DEFAULT NULL COMMENT 'descripcion_especialidad',
  `id_incapacidad` varchar(10) NOT NULL COMMENT 'id_incapacidad',
  PRIMARY KEY (`id_especialidad`),
  KEY `id_incapacidad` (`id_incapacidad`),
  CONSTRAINT `especialidad_ibfk_1` FOREIGN KEY (`id_incapacidad`) REFERENCES `incapacidad` (`id_incapacidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='especialidad';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_cama`
--

DROP TABLE IF EXISTS `estado_cama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_cama` (
  `id_estado_cama` varchar(2) NOT NULL COMMENT 'id_estado_cama',
  `descripcion_estado_cama` varchar(45) DEFAULT NULL COMMENT 'descripcion_estado_cama',
  PRIMARY KEY (`id_estado_cama`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='estado_cama';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_cama`
--

LOCK TABLES `estado_cama` WRITE;
/*!40000 ALTER TABLE `estado_cama` DISABLE KEYS */;
INSERT INTO `estado_cama` VALUES ('1','disponible'),('2','ocupada'),('3','pendiente por asignar');
/*!40000 ALTER TABLE `estado_cama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_cita`
--

DROP TABLE IF EXISTS `estado_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_cita` (
  `id_estado_cita` varchar(2) NOT NULL COMMENT 'id_estado_cita',
  `descripcion_estado_cita` varchar(45) DEFAULT NULL COMMENT 'descripcion_estado_cita',
  PRIMARY KEY (`id_estado_cita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='estado_cita';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_cita`
--

LOCK TABLES `estado_cita` WRITE;
/*!40000 ALTER TABLE `estado_cita` DISABLE KEYS */;
INSERT INTO `estado_cita` VALUES ('0','activa'),('1','cancelada'),('2','pendiente');
/*!40000 ALTER TABLE `estado_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_consultorio`
--

DROP TABLE IF EXISTS `estado_consultorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_consultorio` (
  `id_estado_consultorio` varchar(2) NOT NULL COMMENT 'id_estado_consultorio',
  `descripcion_estado_consultorio` varchar(200) DEFAULT NULL COMMENT 'descripcion_estado_consultorio',
  PRIMARY KEY (`id_estado_consultorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='estado_consultorio';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_consultorio`
--

LOCK TABLES `estado_consultorio` WRITE;
/*!40000 ALTER TABLE `estado_consultorio` DISABLE KEYS */;
INSERT INTO `estado_consultorio` VALUES ('1','disponible'),('2','ocupado');
/*!40000 ALTER TABLE `estado_consultorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_hospitalizacion`
--

DROP TABLE IF EXISTS `estado_hospitalizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_hospitalizacion` (
  `id_estado_hospitalizacion` varchar(10) NOT NULL COMMENT 'id_estado_hospitalizacion',
  `descripcion_estado_hospitalizacion` varchar(45) DEFAULT NULL COMMENT 'descripcion_estado_hospitalizacion',
  PRIMARY KEY (`id_estado_hospitalizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='estado_hospitalizacion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_hospitalizacion`
--

LOCK TABLES `estado_hospitalizacion` WRITE;
/*!40000 ALTER TABLE `estado_hospitalizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado_hospitalizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacia`
--

DROP TABLE IF EXISTS `farmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farmacia` (
  `id_farmacia` varchar(12) NOT NULL COMMENT 'id_farmacia',
  `nombre_farmacia` varchar(60) DEFAULT NULL,
  `persona_a_cargo` varchar(60) DEFAULT NULL,
  `telefono_farmacia` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_farmacia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='farmacia';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacia`
--

LOCK TABLES `farmacia` WRITE;
/*!40000 ALTER TABLE `farmacia` DISABLE KEYS */;
INSERT INTO `farmacia` VALUES ('1','el eden tropical','carlos torres','2735754'),('2','el mar azul','oscar orlando','2345678');
/*!40000 ALTER TABLE `farmacia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formula`
--

DROP TABLE IF EXISTS `formula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formula` (
  `id_formula` varchar(10) NOT NULL COMMENT 'id_formula',
  `fecha` date DEFAULT NULL,
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  `id_paciente` varchar(15) NOT NULL,
  PRIMARY KEY (`id_formula`),
  KEY `id_medico` (`id_medico`),
  KEY `id_paciente_idx` (`id_paciente`),
  CONSTRAINT `formula_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='formula';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formula`
--

LOCK TABLES `formula` WRITE;
/*!40000 ALTER TABLE `formula` DISABLE KEYS */;
INSERT INTO `formula` VALUES ('1','2017-05-26','2','1');
/*!40000 ALTER TABLE `formula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formula_medicamento`
--

DROP TABLE IF EXISTS `formula_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formula_medicamento` (
  `id_formula_medicamento` varchar(15) NOT NULL,
  `cantidad_medicamento_formula` int(11) DEFAULT NULL COMMENT 'cantidad_medicamento_formula',
  `descripcion_formula` varchar(45) DEFAULT NULL,
  `id_formula` varchar(10) NOT NULL COMMENT 'id_formula',
  `id_medicamento` varchar(5) NOT NULL COMMENT 'id_medicamento',
  PRIMARY KEY (`id_formula_medicamento`),
  KEY `id_formula` (`id_formula`),
  KEY `id_medicamento` (`id_medicamento`),
  CONSTRAINT `formula_medicamento_ibfk_1` FOREIGN KEY (`id_formula`) REFERENCES `formula` (`id_formula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `formula_medicamento_ibfk_2` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='formula_medicamento';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formula_medicamento`
--

LOCK TABLES `formula_medicamento` WRITE;
/*!40000 ALTER TABLE `formula_medicamento` DISABLE KEYS */;
INSERT INTO `formula_medicamento` VALUES ('1',23,'cada dos horas','1','1');
/*!40000 ALTER TABLE `formula_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `id_genero` varchar(3) NOT NULL COMMENT 'id_genero',
  `tipo` varchar(20) DEFAULT NULL COMMENT 'tipo',
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='genero';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES ('1','Maculino'),('2','Femenino');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitacion` (
  `id_habitacion` varchar(5) NOT NULL COMMENT 'id_habitacion',
  `descripcion_habitacion` varchar(100) DEFAULT NULL COMMENT 'cantidad_camas',
  `id_consultorio` varchar(2) NOT NULL COMMENT 'id_consultario',
  PRIMARY KEY (`id_habitacion`),
  KEY `habitacion_ibfk_1` (`id_consultorio`),
  CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_consultorio`) REFERENCES `consultorio` (`id_consultorio`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='habitacion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES ('1','te amo','1'),('2','qqq','2');
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia`
--

DROP TABLE IF EXISTS `historia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historia` (
  `id_historia` varchar(10) NOT NULL COMMENT 'id_historia',
  `id_cita` varchar(10) NOT NULL COMMENT 'id_cita',
  `id_historia_paciente` varchar(10) NOT NULL COMMENT 'id_historia_paciente',
  PRIMARY KEY (`id_historia`),
  KEY `id_cita` (`id_cita`),
  KEY `id_historia_paciente` (`id_historia_paciente`),
  CONSTRAINT `historia_ibfk_1` FOREIGN KEY (`id_cita`) REFERENCES `cita` (`id_cita`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `historia_ibfk_2` FOREIGN KEY (`id_historia_paciente`) REFERENCES `historia_paciente` (`id_historia_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='historia';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia`
--

LOCK TABLES `historia` WRITE;
/*!40000 ALTER TABLE `historia` DISABLE KEYS */;
/*!40000 ALTER TABLE `historia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia_paciente`
--

DROP TABLE IF EXISTS `historia_paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historia_paciente` (
  `id_historia_paciente` varchar(10) NOT NULL COMMENT 'id_historia_paciente',
  `id_paciente` varchar(30) NOT NULL COMMENT 'id_paciente',
  PRIMARY KEY (`id_historia_paciente`),
  KEY `id_paciente` (`id_paciente`),
  CONSTRAINT `historia_paciente_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='historia_paciente';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia_paciente`
--

LOCK TABLES `historia_paciente` WRITE;
/*!40000 ALTER TABLE `historia_paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `historia_paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospitalizacion`
--

DROP TABLE IF EXISTS `hospitalizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospitalizacion` (
  `id_hospitalizacion` varbinary(10) NOT NULL COMMENT 'id_hospitalizacion',
  `fecha_entrada_hospitalizacion` date DEFAULT NULL COMMENT 'fecha_entrada_hospitalizacion',
  `fecha_salida_hospitalizacion` date DEFAULT NULL COMMENT 'fecha_salida_hospitalizacion',
  `id_estado_hospitalizacion` varchar(10) NOT NULL COMMENT 'id_estado_hospitalizacion',
  PRIMARY KEY (`id_hospitalizacion`),
  KEY `id_estado_hospitalizacion` (`id_estado_hospitalizacion`),
  CONSTRAINT `hospitalizacion_ibfk_1` FOREIGN KEY (`id_estado_hospitalizacion`) REFERENCES `estado_hospitalizacion` (`id_estado_hospitalizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='hospitalizacion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitalizacion`
--

LOCK TABLES `hospitalizacion` WRITE;
/*!40000 ALTER TABLE `hospitalizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospitalizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incapacidad`
--

DROP TABLE IF EXISTS `incapacidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incapacidad` (
  `id_incapacidad` varchar(10) NOT NULL COMMENT 'id_incapacidad',
  `fecha_inicio_incapacidad` date DEFAULT NULL COMMENT 'fecha_inicio_incapacidad',
  `fecha_final_incapacidad` date DEFAULT NULL COMMENT 'fecha_final_incapacidad',
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  PRIMARY KEY (`id_incapacidad`),
  KEY `id_medico` (`id_medico`),
  CONSTRAINT `incapacidad_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='incapacidad';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incapacidad`
--

LOCK TABLES `incapacidad` WRITE;
/*!40000 ALTER TABLE `incapacidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `incapacidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` char(40) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `id_medicamento` varchar(5) NOT NULL COMMENT 'id_medicamento',
  `nombre_medicamento` varchar(50) DEFAULT NULL COMMENT 'nombre_medicamento',
  `marca_medicamento` varchar(50) DEFAULT NULL COMMENT 'marca_medicamento',
  `id_farmacia` varchar(12) NOT NULL COMMENT 'id_farmacia',
  PRIMARY KEY (`id_medicamento`),
  KEY `id_farmacia` (`id_farmacia`),
  CONSTRAINT `medicamento_ibfk_1` FOREIGN KEY (`id_farmacia`) REFERENCES `farmacia` (`id_farmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='medicamento';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES ('1','dolex','arcosos','1');
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento_proveedor`
--

DROP TABLE IF EXISTS `medicamento_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento_proveedor` (
  `id_medicamento_proveedor` varchar(10) NOT NULL COMMENT 'id_medicamento_proveedor',
  `cantidad_medicamento` int(11) DEFAULT NULL COMMENT 'cantidad_medicamento',
  `lote_medicamento` varchar(50) DEFAULT NULL COMMENT 'lote_medicamento',
  `fecha_vencimento` date DEFAULT NULL COMMENT 'fecha_vencimento',
  `id_proveedor` varchar(15) NOT NULL COMMENT 'id_proveedor',
  `id_medicamento` varchar(5) NOT NULL COMMENT 'id_medicamento',
  PRIMARY KEY (`id_medicamento_proveedor`),
  KEY `id_medicamento` (`id_medicamento`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `medicamento_proveedor_ibfk_1` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `medicamento_proveedor_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='medicamento_proveedor';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento_proveedor`
--

LOCK TABLES `medicamento_proveedor` WRITE;
/*!40000 ALTER TABLE `medicamento_proveedor` DISABLE KEYS */;
INSERT INTO `medicamento_proveedor` VALUES ('1',23,'25','2016-05-25','1','1');
/*!40000 ALTER TABLE `medicamento_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  `nombre_medico` varchar(40) DEFAULT NULL COMMENT 'nombre_medico',
  `apellido_medico` varchar(50) DEFAULT NULL COMMENT 'apellido_medico',
  `telefono_medico` varchar(20) DEFAULT NULL COMMENT 'telefono_medico',
  `direccion_medico` varchar(50) DEFAULT NULL COMMENT 'direccion_medico',
  `email_medico` varchar(50) DEFAULT NULL COMMENT 'email_medico',
  `telefono_emergencia_medico` varchar(20) DEFAULT NULL COMMENT 'telefono_emergencia_medico',
  `fecha_nacimiento_medico` date DEFAULT NULL COMMENT 'fecha_nacimiento_medico',
  `numero_documento_medico` varchar(20) DEFAULT NULL COMMENT 'numero_documento_medico',
  `id_tipo_documento` varchar(3) NOT NULL COMMENT 'id_tipo_documento',
  PRIMARY KEY (`id_medico`),
  KEY `medico_ibfk_1` (`id_tipo_documento`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipodocumento` (`id_tipo_documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='medico';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES ('1','dkjd','cnc','3223','jdsdj','sjsjs','221','2017-05-31','qqq','1'),('2','Juan','Perez','2131321','wqeqwqw12312','cddd@fdfd.com','23123123123123','2017-05-31','1092','2'),('3','Pedro','Sanchez','312122121121','asdasd','caherer@pepito.com','21323','2017-05-02','1094909434','1');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipio` (
  `id_municipio` varchar(5) NOT NULL COMMENT 'id_municipio',
  `nombre_municipio` varchar(30) DEFAULT NULL COMMENT 'nombre_municipio',
  `id_departamento` varchar(4) NOT NULL COMMENT 'id_departamento',
  PRIMARY KEY (`id_municipio`),
  KEY `id_departamento` (`id_departamento`),
  CONSTRAINT `municipio_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='municipio';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES ('1','Buenavista','1'),('10','Quimbaya','1'),('11','Salento','1'),('12','Apia','2'),('13','Balboa','2'),('14','Belan de Umbria','2'),('15','Dos Quebradas','2'),('16','Guatica','2'),('17','La Celia','2'),('18','La Virginia','2'),('19','Marsella','2'),('2','Calarca','1'),('20','Mistrato','2'),('21','Pereira','2'),('22','Pueblo Rico','2'),('23','Quinchia','2'),('24','Santa Rosa de Cabal','2'),('25','Santuario','2'),('26','Alcala','3'),('27','Andalucia','3'),('28','Ansermanuevo','3'),('29','Argelia','3'),('3','Circasia','1'),('30','Bolovar','3'),('31','Buenaventura','3'),('32','Buga','3'),('33','Bugalagrande','3'),('34','Caicedonia','3'),('35','Calima','3'),('36','Candelaria','3'),('37','Cartago,','3'),('38','Dagua','3'),('39','Cali','3'),('4','Cordoba','1'),('40','El aguila','3'),('41','El Cairo','3'),('42','El Cerrito','3'),('43','El Dovio','3'),('44','Florida','3'),('45','Ginebra','3'),('46','Guacari','3'),('47','Jamundi','3'),('48','La Cumbre','3'),('49','La Union','3'),('5','Filandia','1'),('50','La Victoria','3'),('51','Obando','3'),('52','Palmira','3'),('53','Pradera','3'),('54','Restrepo','3'),('55','Riofrio','3'),('56','Roldanillo','3'),('57','San Pedro','3'),('58','Sevilla','3'),('59','Toro','3'),('6','Genova','1'),('60','Trujillo','3'),('61','Tulua','3'),('62','Ulloa','3'),('63','Versalles','3'),('64','Vijes','3'),('65','Yotoco','3'),('66','Yumbo','3'),('67','Zarzal','3'),('7','La Tebaida','1'),('8','Montenegro','1'),('9','Pijao','1');
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `id_paciente` varchar(30) NOT NULL COMMENT 'id_paciente',
  `nombre_paciente` varchar(50) DEFAULT NULL COMMENT 'nombre_paciente',
  `apellido_paciente` varchar(50) DEFAULT NULL COMMENT 'apellido_paciente',
  `direccion_paciente` varchar(100) DEFAULT NULL COMMENT 'direccion_paciente',
  `fecha_nacimiento_paciente` date DEFAULT NULL COMMENT 'fecha_nacimiento_paciente',
  `telefono_paciente` varchar(20) DEFAULT NULL COMMENT 'telefono_paciente',
  `peso_paciente` float DEFAULT NULL COMMENT 'peso_paciente',
  `numero_documento_paciente` varchar(30) DEFAULT NULL COMMENT 'numero_documento_paciente',
  `id_tipo_documento` varchar(3) NOT NULL COMMENT 'id_tipo_documento',
  `id_municipio` varchar(5) NOT NULL COMMENT 'id_municipio',
  `id_genero` varchar(3) NOT NULL COMMENT 'id_genero',
  PRIMARY KEY (`id_paciente`),
  KEY `id_genero` (`id_genero`),
  KEY `id_municipio` (`id_municipio`),
  KEY `id_tipo_documento` (`id_tipo_documento`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `paciente_ibfk_2` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `paciente_ibfk_3` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipodocumento` (`id_tipo_documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='paciente';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES ('1','JuanR','Sanchez','B los olivos 13 # 12','3889-02-23','312222332',34,'1234','1','1','1'),('2','gh','gh','h','2017-05-04','123',123,'12333','1','1','1'),('3','sdsad','sdfds','sdfds','2017-05-05','123454354',12312,'10954904905','1','2','1'),('4','hh','HH','asadas',NULL,'12312',1312,'13123','2','2','1'),('5','wsadasd','asdasdas','asdasd',NULL,'1321312',1212,'12312312','1','1','1'),('6','fg','fg','fg','2017-05-03','565',5565,'12312','1','1','1'),('7','GHG','GHGHG','HHGG','2017-05-11','1232',12321,'1001010','1','1','1');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedimiento`
--

DROP TABLE IF EXISTS `procedimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procedimiento` (
  `id_procedimiento` varbinary(5) NOT NULL COMMENT 'id_procedimiento',
  `nombre_procedimiento` varchar(50) DEFAULT NULL COMMENT 'nombre_procedimiento',
  `procedimiento` varchar(100) DEFAULT NULL COMMENT 'procedimiento',
  PRIMARY KEY (`id_procedimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='procedimiento';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedimiento`
--

LOCK TABLES `procedimiento` WRITE;
/*!40000 ALTER TABLE `procedimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `procedimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id_proveedor` varchar(15) NOT NULL COMMENT 'id_proveedor',
  `nombre_proveedor` varchar(50) DEFAULT NULL COMMENT 'nombre_proveedor',
  `persona_contacto` varchar(50) DEFAULT NULL COMMENT 'persona_contacto',
  `direccion_proveedor` varchar(50) DEFAULT NULL COMMENT 'direccion_proveedor',
  `telefono_proveedor` varchar(20) DEFAULT NULL COMMENT 'telefono_proveedor',
  `email_preveedor` varchar(100) DEFAULT NULL COMMENT 'email_preveedor',
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='proveedor';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('1','el sol azul','carlos torres','la calle','2735754','pa');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remision`
--

DROP TABLE IF EXISTS `remision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remision` (
  `id_remision` varchar(5) NOT NULL COMMENT 'id_remision',
  `id_paciente` varchar(30) NOT NULL COMMENT 'id_paciente',
  `descripcion_remision` varchar(100) DEFAULT NULL COMMENT 'descripcion_remision',
  PRIMARY KEY (`id_remision`),
  KEY `id_paciente` (`id_paciente`),
  CONSTRAINT `remision_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='remision';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remision`
--

LOCK TABLES `remision` WRITE;
/*!40000 ALTER TABLE `remision` DISABLE KEYS */;
/*!40000 ALTER TABLE `remision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salida_medico`
--

DROP TABLE IF EXISTS `salida_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salida_medico` (
  `id_salida_medico` varchar(5) NOT NULL COMMENT 'id_salida_medico',
  `hora_salida_medico` time DEFAULT NULL COMMENT 'hora_salida_medico',
  `fecha_salida_medico` date DEFAULT NULL COMMENT 'fecha_salida_medico',
  `id_medico` varchar(15) NOT NULL COMMENT 'id_medico',
  PRIMARY KEY (`id_salida_medico`),
  KEY `id_medico` (`id_medico`),
  CONSTRAINT `salida_medico_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='salida_medico';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salida_medico`
--

LOCK TABLES `salida_medico` WRITE;
/*!40000 ALTER TABLE `salida_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `salida_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cita`
--

DROP TABLE IF EXISTS `tipo_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_cita` (
  `id_tipo_cita` varchar(2) NOT NULL COMMENT 'id_tipo_cita',
  `descripcion_tipo_cita` varchar(100) DEFAULT NULL COMMENT 'descripcion_tipo_cita',
  PRIMARY KEY (`id_tipo_cita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tipo_cita';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cita`
--

LOCK TABLES `tipo_cita` WRITE;
/*!40000 ALTER TABLE `tipo_cita` DISABLE KEYS */;
INSERT INTO `tipo_cita` VALUES ('0','General'),('1','Especializada');
/*!40000 ALTER TABLE `tipo_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodocumento` (
  `id_tipo_documento` varchar(3) NOT NULL COMMENT 'id_tipo_documento',
  `tipo_documento` varchar(30) DEFAULT NULL COMMENT 'tipo_documento',
  PRIMARY KEY (`id_tipo_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tipodocumento';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES ('1','Cedula'),('2','Pasaporte'),('3','Nit');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urgencia`
--

DROP TABLE IF EXISTS `urgencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urgencia` (
  `id_urgencia` varchar(5) NOT NULL COMMENT 'id_urgencia',
  `hora_urgencia` time DEFAULT NULL COMMENT 'hora_urgencia',
  `fecha_urgencia` date DEFAULT NULL COMMENT 'fecha_urgencia',
  PRIMARY KEY (`id_urgencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='urgencia';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urgencia`
--

LOCK TABLES `urgencia` WRITE;
/*!40000 ALTER TABLE `urgencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `urgencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urgencia_paciente`
--

DROP TABLE IF EXISTS `urgencia_paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urgencia_paciente` (
  `id_urgencia` varchar(5) NOT NULL COMMENT 'id_urgencia',
  `id_paciente` varchar(30) NOT NULL COMMENT 'id_paciente',
  KEY `id_paciente` (`id_paciente`),
  KEY `id_urgencia` (`id_urgencia`),
  CONSTRAINT `urgencia_paciente_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `urgencia_paciente_ibfk_2` FOREIGN KEY (`id_urgencia`) REFERENCES `urgencia` (`id_urgencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='urgencia_paciente';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urgencia_paciente`
--

LOCK TABLES `urgencia_paciente` WRITE;
/*!40000 ALTER TABLE `urgencia_paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `urgencia_paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `urgencia_procedimiento`
--

DROP TABLE IF EXISTS `urgencia_procedimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urgencia_procedimiento` (
  `id_urgencia` varchar(5) NOT NULL COMMENT 'id_urgencia',
  `id_procedimiento` varbinary(5) NOT NULL COMMENT 'id_procedimiento',
  KEY `id_procedimiento` (`id_procedimiento`),
  KEY `id_urgencia` (`id_urgencia`),
  CONSTRAINT `urgencia_procedimiento_ibfk_1` FOREIGN KEY (`id_procedimiento`) REFERENCES `procedimiento` (`id_procedimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `urgencia_procedimiento_ibfk_2` FOREIGN KEY (`id_urgencia`) REFERENCES `urgencia` (`id_urgencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='urgencia_procedimiento';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urgencia_procedimiento`
--

LOCK TABLES `urgencia_procedimiento` WRITE;
/*!40000 ALTER TABLE `urgencia_procedimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `urgencia_procedimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-27 15:10:50
