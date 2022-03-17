CREATE DATABASE  IF NOT EXISTS `ipartekify30` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ipartekify30`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ipartekify30
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
  `anno` int NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `artista_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKejugut6n712x7a89eon2fr1oy` (`artista_id`),
  CONSTRAINT `FKejugut6n712x7a89eon2fr1oy` FOREIGN KEY (`artista_id`) REFERENCES `artistas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albumes`
--

LOCK TABLES `albumes` WRITE;
/*!40000 ALTER TABLE `albumes` DISABLE KEYS */;
INSERT INTO `albumes` VALUES (2,1974,'https://i.ytimg.com/vi/YXnj64o198A/mqdefault.jpg','Relayer',3),(4,2013,'https://img.discogs.com/E20VSDgPrIJN-XCOQNSKILCcawY=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-5752937-1401702925-7304.jpeg.jpg','Looking For La Fiesta',1),(5,2006,'libros.png','Milliontown',4),(6,2016,NULL,'Falling Satellites (Deluxe)',4),(7,2013,NULL,'Sweet Movimiento',1);
/*!40000 ALTER TABLE `albumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artistas`
--

DROP TABLE IF EXISTS `artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artistas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `informacion` longtext,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artistas`
--

LOCK TABLES `artistas` WRITE;
/*!40000 ALTER TABLE `artistas` DISABLE KEYS */;
INSERT INTO `artistas` VALUES (1,'Disco Funk','Fundación Tony Manero'),(3,'Rock Progresivo','Yes'),(4,'Rock Progresivo muy molón y moderno','Frost*');
/*!40000 ALTER TABLE `artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mp3` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `tiempo` char(8) NOT NULL,
  `album_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3qhkonfhjl4fvlhmy2282rokx` (`album_id`),
  CONSTRAINT `FK3qhkonfhjl4fvlhmy2282rokx` FOREIGN KEY (`album_id`) REFERENCES `albumes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
INSERT INTO `canciones` VALUES (2,'EdmUAsU2eXI','The Gates of Delirium','00:21:16',2),(4,'QukX9I6ZLsM','Soon','00:04:06',2),(5,'PS5zshNRvLo','Supersexy Girl','00:03:52',4);
/*!40000 ALTER TABLE `canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas`
--

DROP TABLE IF EXISTS `listas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` longtext,
  `nombre` varchar(45) NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlrt1784cd7cosv8n2v2ka8iyy` (`usuario_id`),
  CONSTRAINT `FKlrt1784cd7cosv8n2v2ka8iyy` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas`
--

LOCK TABLES `listas` WRITE;
/*!40000 ALTER TABLE `listas` DISABLE KEYS */;
INSERT INTO `listas` VALUES (1,NULL,'Prueba',1),(2,NULL,'Otro',1),(3,NULL,'Pepelista',2);
/*!40000 ALTER TABLE `listas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listas_canciones`
--

DROP TABLE IF EXISTS `listas_canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listas_canciones` (
  `lista_id` bigint NOT NULL,
  `canciones_id` bigint NOT NULL,
  PRIMARY KEY (`lista_id`,`canciones_id`),
  KEY `FKsiu812dtunhknons19jw90w63` (`canciones_id`),
  CONSTRAINT `FKsiu812dtunhknons19jw90w63` FOREIGN KEY (`canciones_id`) REFERENCES `canciones` (`id`),
  CONSTRAINT `FKti9vm8co6vxxj651yg8gyrhla` FOREIGN KEY (`lista_id`) REFERENCES `listas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listas_canciones`
--

LOCK TABLES `listas_canciones` WRITE;
/*!40000 ALTER TABLE `listas_canciones` DISABLE KEYS */;
INSERT INTO `listas_canciones` VALUES (1,5),(3,5);
/*!40000 ALTER TABLE `listas_canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` char(60) NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'javier@lete.net','$2a$10$2OKb07.JVoC6IpkUMTCREeqUKWbz0siE0I7meUjQvOnTRobRNJ2R.','ADMIN'),(2,'pepe@perez.net','$2a$10$0a4j/ZtzCgIjJa.isxg8fu8/ZR.Gpg07iicFmXgN.Fmsibr2jzFXW','USER'),(3,'juan@gonzalez.net','$2a$10$Qggj2UJBjIfP89qR1h5nEeQ6KKiRwijUTw7EFU1RV.zxQ/0M8sAHK','USER');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_albumes_favoritos`
--

DROP TABLE IF EXISTS `usuarios_albumes_favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_albumes_favoritos` (
  `usuario_id` bigint NOT NULL,
  `albumes_favoritos_id` bigint NOT NULL,
  PRIMARY KEY (`usuario_id`,`albumes_favoritos_id`),
  KEY `FK9j63suen14j36h5g2eil5b8g4` (`albumes_favoritos_id`),
  CONSTRAINT `FK2nshktct4mbwpigt4toyxc0hs` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FK9j63suen14j36h5g2eil5b8g4` FOREIGN KEY (`albumes_favoritos_id`) REFERENCES `albumes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_albumes_favoritos`
--

LOCK TABLES `usuarios_albumes_favoritos` WRITE;
/*!40000 ALTER TABLE `usuarios_albumes_favoritos` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_albumes_favoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_artistas_favoritos`
--

DROP TABLE IF EXISTS `usuarios_artistas_favoritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_artistas_favoritos` (
  `usuario_id` bigint NOT NULL,
  `artistas_favoritos_id` bigint NOT NULL,
  PRIMARY KEY (`usuario_id`,`artistas_favoritos_id`),
  KEY `FKl6oxp708ecqra6q7ttren74cv` (`artistas_favoritos_id`),
  CONSTRAINT `FK2fnqamsh1ssiv95c26c5xfwpj` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKl6oxp708ecqra6q7ttren74cv` FOREIGN KEY (`artistas_favoritos_id`) REFERENCES `artistas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_artistas_favoritos`
--

LOCK TABLES `usuarios_artistas_favoritos` WRITE;
/*!40000 ALTER TABLE `usuarios_artistas_favoritos` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_artistas_favoritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_canciones_favoritas`
--

DROP TABLE IF EXISTS `usuarios_canciones_favoritas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_canciones_favoritas` (
  `usuario_id` bigint NOT NULL,
  `canciones_favoritas_id` bigint NOT NULL,
  PRIMARY KEY (`usuario_id`,`canciones_favoritas_id`),
  KEY `FK38p66wcfrl4vkbbvqhmjucnuh` (`canciones_favoritas_id`),
  CONSTRAINT `FK1u49mhfnfusfgvr3jgoxmlhds` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FK38p66wcfrl4vkbbvqhmjucnuh` FOREIGN KEY (`canciones_favoritas_id`) REFERENCES `canciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_canciones_favoritas`
--

LOCK TABLES `usuarios_canciones_favoritas` WRITE;
/*!40000 ALTER TABLE `usuarios_canciones_favoritas` DISABLE KEYS */;
INSERT INTO `usuarios_canciones_favoritas` VALUES (2,2),(1,4),(1,5),(2,5);
/*!40000 ALTER TABLE `usuarios_canciones_favoritas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ipartekify30'
--

--
-- Dumping routines for database 'ipartekify30'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-17  8:30:02
