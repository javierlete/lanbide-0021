CREATE DATABASE  IF NOT EXISTS `ipartekify` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ipartekify`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ipartekify
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
-- Table structure for table `albumes`
--

DROP TABLE IF EXISTS `albumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albumes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `anno` year NOT NULL,
  `foto` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `artistas_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_albumes_artistas1_idx` (`artistas_id`),
  CONSTRAINT `fk_albumes_artistas1` FOREIGN KEY (`artistas_id`) REFERENCES `artistas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albumes`
--

LOCK TABLES `albumes` WRITE;
/*!40000 ALTER TABLE `albumes` DISABLE KEYS */;
INSERT INTO `albumes` VALUES (1,'Sweet Movimiento',2013,'https://i.ytimg.com/vi/1NRQD9ds7ZQ/maxresdefault.jpg',1),(2,'Relayer',1974,'https://revistaladosis.com/wp-content/uploads/2019/11/Yes-Relayer-1.jpg',3),(3,'Milliontown',2006,'https://m.media-amazon.com/images/I/61YEkcgK8nL._SY355_.jpg',2);
/*!40000 ALTER TABLE `albumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `albumes_favoritos`
--

DROP TABLE IF EXISTS `albumes_favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `albumes_favoritos` (
  `usuarios_id` bigint NOT NULL,
  `albumes_id` bigint NOT NULL,
  PRIMARY KEY (`usuarios_id`,`albumes_id`),
  KEY `fk_usuarios_has_albumes_albumes1_idx` (`albumes_id`),
  KEY `fk_usuarios_has_albumes_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_usuarios_has_albumes_albumes1` FOREIGN KEY (`albumes_id`) REFERENCES `albumes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_usuarios_has_albumes_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albumes_favoritos`
--

LOCK TABLES `albumes_favoritos` WRITE;
/*!40000 ALTER TABLE `albumes_favoritos` DISABLE KEYS */;
INSERT INTO `albumes_favoritos` VALUES (2,1),(2,2),(1,3);
/*!40000 ALTER TABLE `albumes_favoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas`
--

DROP TABLE IF EXISTS `artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `informacion` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas`
--

LOCK TABLES `artistas` WRITE;
/*!40000 ALTER TABLE `artistas` DISABLE KEYS */;
INSERT INTO `artistas` VALUES (1,'Fundación Tony Manero','Disco Funk'),(2,'Frost*','Rock Progresivo'),(3,'Yes','Rock Progresivo');
/*!40000 ALTER TABLE `artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas_favoritos`
--

DROP TABLE IF EXISTS `artistas_favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas_favoritos` (
  `usuarios_id` bigint NOT NULL,
  `artistas_id` bigint NOT NULL,
  PRIMARY KEY (`usuarios_id`,`artistas_id`),
  KEY `fk_usuarios_has_artistas_artistas1_idx` (`artistas_id`),
  KEY `fk_usuarios_has_artistas_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_usuarios_has_artistas_artistas1` FOREIGN KEY (`artistas_id`) REFERENCES `artistas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_usuarios_has_artistas_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas_favoritos`
--

LOCK TABLES `artistas_favoritos` WRITE;
/*!40000 ALTER TABLE `artistas_favoritos` DISABLE KEYS */;
INSERT INTO `artistas_favoritos` VALUES (1,1),(1,2),(2,3);
/*!40000 ALTER TABLE `artistas_favoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `tiempo` time NOT NULL,
  `mp3` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `albumes_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_canciones_albumes1_idx` (`albumes_id`),
  CONSTRAINT `fk_canciones_albumes1` FOREIGN KEY (`albumes_id`) REFERENCES `albumes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
INSERT INTO `canciones` VALUES (1,'Fonky Macarrón','00:03:03','K53xne6iK4s',1),(2,'The Gates of Delirium','00:21:16','EdmUAsU2eXI',2),(3,'Hyperventilate','00:07:31','Ol592sakmZU',3);
/*!40000 ALTER TABLE `canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones_favoritas`
--

DROP TABLE IF EXISTS `canciones_favoritas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones_favoritas` (
  `usuarios_id` bigint NOT NULL,
  `canciones_id` bigint NOT NULL,
  PRIMARY KEY (`usuarios_id`,`canciones_id`),
  KEY `fk_usuarios_has_canciones_canciones1_idx` (`canciones_id`),
  KEY `fk_usuarios_has_canciones_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_usuarios_has_canciones_canciones1` FOREIGN KEY (`canciones_id`) REFERENCES `canciones` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_usuarios_has_canciones_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones_favoritas`
--

LOCK TABLES `canciones_favoritas` WRITE;
/*!40000 ALTER TABLE `canciones_favoritas` DISABLE KEYS */;
INSERT INTO `canciones_favoritas` VALUES (1,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `canciones_favoritas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas`
--

DROP TABLE IF EXISTS `listas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` text COLLATE utf8mb4_general_ci,
  `usuarios_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_listas_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_listas_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas`
--

LOCK TABLES `listas` WRITE;
/*!40000 ALTER TABLE `listas` DISABLE KEYS */;
INSERT INTO `listas` VALUES (1,'Rock',NULL,1),(2,'Funk',NULL,1),(3,'Aleatorio',NULL,2);
/*!40000 ALTER TABLE `listas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas_has_canciones`
--

DROP TABLE IF EXISTS `listas_has_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas_has_canciones` (
  `listas_id` bigint NOT NULL,
  `canciones_id` bigint NOT NULL,
  PRIMARY KEY (`listas_id`,`canciones_id`),
  KEY `fk_listas_has_canciones_canciones1_idx` (`canciones_id`),
  KEY `fk_listas_has_canciones_listas1_idx` (`listas_id`),
  CONSTRAINT `fk_listas_has_canciones_canciones1` FOREIGN KEY (`canciones_id`) REFERENCES `canciones` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_listas_has_canciones_listas1` FOREIGN KEY (`listas_id`) REFERENCES `listas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas_has_canciones`
--

LOCK TABLES `listas_has_canciones` WRITE;
/*!40000 ALTER TABLE `listas_has_canciones` DISABLE KEYS */;
INSERT INTO `listas_has_canciones` VALUES (2,1),(3,1),(1,2),(3,2),(1,3),(3,3);
/*!40000 ALTER TABLE `listas_has_canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `rol` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'javier@lete.net','contra','ADMIN'),(2,'pepe@perez.net','pepe','USER'),(3,'juan@gonzalez.net','juan','USER');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ipartekify'
--

--
-- Dumping routines for database 'ipartekify'
--
/*!50003 DROP PROCEDURE IF EXISTS `albumes_select_artista` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `albumes_select_artista`(_id_artista BIGINT)
BEGIN
SELECT id, nombre, anno, foto FROM albumes WHERE artistas_id = _id_artista;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `albumes_select_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `albumes_select_id`(_id BIGINT)
BEGIN
SELECT id, nombre, anno, foto FROM albumes WHERE id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `artistas_select` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `artistas_select`()
BEGIN
SELECT id, nombre, informacion FROM artistas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `artistas_select_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `artistas_select_id`(_id BIGINT)
BEGIN
SELECT id, nombre, informacion FROM artistas WHERE id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `canciones_select_album` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `canciones_select_album`(_id_usuario BIGINT, _id_album BIGINT)
BEGIN
SELECT id, nombre, tiempo, mp3, IFNULL((SELECT TRUE FROM canciones_favoritas WHERE usuarios_id = _id_usuario AND canciones_id = c.id), FALSE) AS favorito
FROM canciones c
WHERE albumes_id = _id_album;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `canciones_select_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `canciones_select_id`(_id BIGINT)
BEGIN
SELECT `canciones`.`id`,
    `canciones`.`nombre`,
    `canciones`.`tiempo`,
    `canciones`.`mp3`,
    `canciones`.`albumes_id`
FROM `ipartekify`.`canciones`
WHERE id = _id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usuarios_favorito_cancion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usuarios_favorito_cancion`(_id_usuario BIGINT, _id_cancion BIGINT)
BEGIN
IF (SELECT 1 FROM canciones_favoritas WHERE usuarios_id = _id_usuario AND canciones_id = _id_cancion) THEN
	DELETE FROM canciones_favoritas WHERE usuarios_id = _id_usuario AND canciones_id = _id_cancion;
    -- SELECT 'BORRAR';
ELSE
	INSERT canciones_favoritas (usuarios_id, canciones_id) VALUES (_id_usuario, _id_cancion);
    -- SELECT 'AÑADIR';
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-03 10:29:36
