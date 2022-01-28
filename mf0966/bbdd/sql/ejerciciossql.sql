CREATE DATABASE  IF NOT EXISTS `ejerciciossql` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ejerciciossql`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ejerciciossql
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `codDepto` varchar(4) NOT NULL,
  `nombreDpto` varchar(20) NOT NULL,
  `ciudad` varchar(15) DEFAULT NULL,
  `codDirector` varchar(12) DEFAULT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`codDepto`),
  UNIQUE KEY `UX_DPTO` (`nombreDpto`,`ciudad`),
  KEY `FK_EmpDir` (`codDirector`),
  KEY `IX_CIUDAD` (`ciudad`),
  CONSTRAINT `FK_EmpDir` FOREIGN KEY (`codDirector`) REFERENCES `empleado` (`nDIEmp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES ('1000','GERENCIA','CALI','31.840.269',1),('1500','PRODUCCIÓN','CALI','16.211.383',1),('2000','VENTAS','CALI','31.178.144',1),('2100','VENTAS','POPAYAN',NULL,1),('2200','VENTAS','BUGA','768.782',1),('2300','VENTAS','CARTAGO','737.689',1),('3000','INVESTIGACIÓN','CALI','16.759.060',1),('3500','MERCADEO','CALI','22.222.222',1),('4000','MANTENIMIENTO','CALI','333.333.333',1),('4100','MANTENIMIENTO','POPAYAN','888.888',1),('4200','MANTENIMIENTO','BUGA','11.111.111',1),('4300','MANTENIMIENTO','CARTAGO','444.444',1),('6000','TRANSPORTE','CALI',NULL,1),('7000','COMPRAS','CALI',NULL,1);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `departamento_BEFORE_DELETE` BEFORE DELETE ON `departamento` FOR EACH ROW BEGIN
SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'No se permiten deletes reales';
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `nDIEmp` varchar(12) NOT NULL,
  `nomEmp` varchar(30) NOT NULL,
  `sexEmp` char(1) NOT NULL,
  `fecNac` date NOT NULL,
  `fecIncorporacion` date NOT NULL,
  `salEmp` float NOT NULL,
  `comisionE` float NOT NULL,
  `cargoE` varchar(15) NOT NULL,
  `jefeID` varchar(12) DEFAULT NULL,
  `codDepto` varchar(4) NOT NULL,
  PRIMARY KEY (`nDIEmp`),
  KEY `FK_Empl_idx` (`jefeID`),
  KEY `FK_Dpto_idx` (`codDepto`),
  CONSTRAINT `FK_Dpto` FOREIGN KEY (`codDepto`) REFERENCES `departamento` (`codDepto`),
  CONSTRAINT `FK_Empl` FOREIGN KEY (`jefeID`) REFERENCES `empleado` (`nDIEmp`),
  CONSTRAINT `empleado_chk_1` CHECK ((`sexEmp` in (_utf8mb4'F',_utf8mb4'M')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('1.130.222','José Giraldo','M','1985-01-20','2000-11-01',1200000,400000,'Asesor','22.222.222','3500'),('1.130.333','Pedro Blanco','M','1987-10-28','2000-10-01',800000,3000000,'Vendedor','31.178.144','2000'),('1.130.444','Jesús Alfonso','M','1988-03-14','2000-10-01',800000,3500000,'Vendedor','31.178.144','2000'),('1.130.555','Julián Mora','M','1989-07-03','2000-10-01',800000,3100000,'Vendedor','31.178.144','2200'),('1.130.666','Manuel Millán','M','1990-12-08','2004-06-01',800000,3700000,'Vendedor','31.178.144','2300'),('1.130.777','Marcos Cortez','M','1986-06-23','2000-04-16',2550000,500000,'Mecánico','333.333.333','4000'),('1.130.782','Antonio Gil','M','1980-01-23','2010-04-16',850000,1500000,'Técnico','16.211.383','1500'),('1.751.219','Melissa Roa','F','1960-06-19','2001-03-16',2250000,2500000,'Vendedor','31.178.144','2100'),('11.111.111','Irene Díaz','F','1979-09-28','2004-06-01',1050000,200000,'Mecánico','333.333.333','4200'),('16.211.383','Luis Pérez','M','1956-02-25','2000-01-01',5050000,0,'Director','31.840.269','1500'),('16.759.060','Darío Casas','M','1960-04-05','1992-11-01',4500000,500000,'Investigador','31.840.269','3000'),('19.709.802','William Daza','M','1982-10-09','1999-12-16',2250000,1000000,'Investigador','16.759.060','3000'),('22.222.222','Carla López','F','1975-05-11','2005-07-16',4500000,500000,'Jefe Mercadeo','31.840.269','3500'),('22.222.333','Carlos Rozo','M','1975-05-11','2001-09-16',750000,500000,'Vigilante','31.840.269','3500'),('31.174.099','Diana Solarte','F','1957-11-19','1990-05-16',1250000,500000,'Secretaria','31.840.269','1000'),('31.178.144','Rosa Angulo','F','1957-03-15','1998-08-16',3250000,3500000,'Jefe Ventas','31.840.269','2000'),('31.840.269','María Rojas','F','1959-01-15','1990-05-16',6250000,1500000,'Gerente',NULL,'1000'),('333.333.333','Elisa Rojas','F','1979-09-28','2004-06-01',3000000,1000000,'Jefe Mecánicos','31.840.269','4000'),('333.333.334','Marisol Pulido','F','1979-10-01','1990-05-16',3250000,1000000,'Investigador','16.759.060','3000'),('333.333.335','Ana Moreno','F','1992-01-05','2004-06-01',1200000,400000,'Secretaria','16.759.060','3000'),('333.333.336','Carolina Ríos','F','1992-02-15','2000-10-01',1250000,500000,'Secretaria','16.211.383','1500'),('333.333.337','Edith Muñoz','F','1992-03-31','2000-10-01',800000,3600000,'Vendedor','31.178.144','2100'),('444.444','Abel Gómez','M','1939-12-24','2000-10-01',1050000,200000,'Mecánico','333.333.333','4300'),('737.689','Mario Llano','M','1945-08-30','1990-05-16',2250000,2500000,'Vendedor','31.178.144','2300'),('768.782','Joaquín Rosas','M','1947-07-07','1990-05-16',2250000,2500000,'Vendedor','31.178.144','2200'),('888.888','Iván Duarte','M','1955-08-12','1998-05-16',1050000,200000,'Mecánico','333.333.333','4100'),('9999','asdfasdf ','M','2022-01-28','2022-01-28',10000000,0,'Chupasangre',NULL,'1000'),('99999','asdfasdf ','M','2022-01-28','2022-01-28',10000000,0,'Chupasangre',NULL,'1000'),('999999','asdfasdf ','M','2022-01-28','2022-01-28',6000000,0,'Chupasangre',NULL,'1000');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `empleado_BEFORE_INSERT` BEFORE INSERT ON `empleado` FOR EACH ROW BEGIN
IF NEW.salEmp > 10000000 THEN
	SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Ese sueldo es muy sospechoso';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `empleado_AFTER_INSERT` AFTER INSERT ON `empleado` FOR EACH ROW BEGIN
INSERT INTO log_empleados_sospechosos (nDIEmp, nomEmp, salEmp) VALUES (NEW.nDIEmp, NEW.nomEmp, NEW.salEmp);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `log_empleados_sospechosos`
--

DROP TABLE IF EXISTS `log_empleados_sospechosos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_empleados_sospechosos` (
  `nDIEmp` bigint NOT NULL AUTO_INCREMENT,
  `nomEmp` varchar(30) NOT NULL,
  `salEmp` float NOT NULL,
  PRIMARY KEY (`nDIEmp`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_empleados_sospechosos`
--

LOCK TABLES `log_empleados_sospechosos` WRITE;
/*!40000 ALTER TABLE `log_empleados_sospechosos` DISABLE KEYS */;
INSERT INTO `log_empleados_sospechosos` VALUES (999999,'asdfasdf ',6000000);
/*!40000 ALTER TABLE `log_empleados_sospechosos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `media_salarios_por_cargo`
--

DROP TABLE IF EXISTS `media_salarios_por_cargo`;
/*!50001 DROP VIEW IF EXISTS `media_salarios_por_cargo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `media_salarios_por_cargo` AS SELECT 
 1 AS `cargoE`,
 1 AS `Media`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `nombre_maximo_salario`
--

DROP TABLE IF EXISTS `nombre_maximo_salario`;
/*!50001 DROP VIEW IF EXISTS `nombre_maximo_salario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `nombre_maximo_salario` AS SELECT 
 1 AS `nomEmp`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `nombre_minimo_salario`
--

DROP TABLE IF EXISTS `nombre_minimo_salario`;
/*!50001 DROP VIEW IF EXISTS `nombre_minimo_salario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `nombre_minimo_salario` AS SELECT 
 1 AS `nomEmp`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `sumsalar`
--

DROP TABLE IF EXISTS `sumsalar`;
/*!50001 DROP VIEW IF EXISTS `sumsalar`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sumsalar` AS SELECT 
 1 AS `codDepto`,
 1 AS `sumS`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `sumsalar2`
--

DROP TABLE IF EXISTS `sumsalar2`;
/*!50001 DROP VIEW IF EXISTS `sumsalar2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sumsalar2` AS SELECT 
 1 AS `sSalD`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'ejerciciossql'
--

--
-- Dumping routines for database 'ejerciciossql'
--
/*!50003 DROP FUNCTION IF EXISTS `sumar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `sumar`(a INTEGER, b INTEGER) RETURNS int
    NO SQL
BEGIN
RETURN a+b;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `borrados_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `borrados_departamento`()
BEGIN
SELECT codDepto, nombreDpto, ciudad, codDirector FROM departamento WHERE activo = FALSE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_departamento`(_codDepto VARCHAR(4))
BEGIN
-- DELETE FROM departamento WHERE codDepto = _codDepto;
UPDATE departamento SET activo = FALSE WHERE codDepto = _codDepto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_departamento`(_codDepto VARCHAR(4), _nombreDpto VARCHAR(20), _ciudad VARCHAR(15), _codDirector VARCHAR(12))
BEGIN
INSERT INTO departamento (codDepto, nombreDpto, ciudad, codDirector) VALUES (_codDepto, _nombreDpto, _ciudad, _codDirector);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_departamento`()
BEGIN
SELECT codDepto, nombreDpto, ciudad, codDirector FROM departamento WHERE activo = TRUE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `select_id_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_id_departamento`(_codDepto VARCHAR(4))
BEGIN
SELECT codDepto, nombreDpto, ciudad, codDirector FROM departamento WHERE codDepto = _codDepto AND activo = TRUE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `undelete_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `undelete_departamento`(_codDepto VARCHAR(4))
BEGIN
UPDATE departamento SET activo = TRUE WHERE codDepto = _codDepto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_departamento`(_codDepto VARCHAR(4), _nombreDpto VARCHAR(20), _ciudad VARCHAR(15), _codDirector VARCHAR(12))
BEGIN
UPDATE departamento SET nombreDpto = _nombreDpto, ciudad = _ciudad, codDirector = _codDirector WHERE codDepto = _codDepto AND activo = TRUE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `media_salarios_por_cargo`
--

/*!50001 DROP VIEW IF EXISTS `media_salarios_por_cargo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `media_salarios_por_cargo` AS select `empleado`.`cargoE` AS `cargoE`,avg(`empleado`.`salEmp`) AS `Media` from `empleado` group by `empleado`.`cargoE` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nombre_maximo_salario`
--

/*!50001 DROP VIEW IF EXISTS `nombre_maximo_salario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nombre_maximo_salario` AS select `empleado`.`nomEmp` AS `nomEmp` from `empleado` order by `empleado`.`salEmp` desc limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `nombre_minimo_salario`
--

/*!50001 DROP VIEW IF EXISTS `nombre_minimo_salario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `nombre_minimo_salario` AS select `empleado`.`nomEmp` AS `nomEmp` from `empleado` order by `empleado`.`salEmp` limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sumsalar`
--

/*!50001 DROP VIEW IF EXISTS `sumsalar`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sumsalar` AS select `empleado`.`codDepto` AS `codDepto`,sum(`empleado`.`salEmp`) AS `sumS` from `empleado` group by `empleado`.`codDepto` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sumsalar2`
--

/*!50001 DROP VIEW IF EXISTS `sumsalar2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sumsalar2` AS select max(`sumsalar`.`sumS`) AS `sSalD` from `sumsalar` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28 11:24:27
