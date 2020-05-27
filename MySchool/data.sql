LOCK TABLES `compte` WRITE;
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` VALUES (86,'karim','karim',1,'yes'),(94,'yanis','yanis',2,'yes'),(95,'sebasiane','sebasiane',2,'yes');
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Maths','0',NULL,'Cours de maths avec plusieurs chapitres: algèbre, arithmetique, etc','https://image.shutterstock.com/image-vector/creative-hand-drawn-vector-maths-260nw-461142283.jpg'),(2,'Français','0',NULL,'Cours de Français avec plusieurs chapitres: Grammaire, Orthographe etc ','https://t3.ftcdn.net/jpg/01/28/45/16/240_F_128451685_HwRiouQcs31bEtAvaixODxVpGvJRMUCU.jpg'),(3,'Physique','0',NULL,'Cours de Physique avec plusieurs chapitres: Electricité, Mécanique etc ','https://www.studyrama.com/IMG/arton89280.jpg'),(4,'Chimie','0',NULL,'Cours de Chimie avec plusieurs chapitres: les composants chimiques, réactions etc ','https://cdn.futura-sciences.com/buildsv6/images/wide1920/b/b/5/bb5ab61f3e_50151085_quiz-chimie-bac-mg-fotolia.jpg'),(5,'Anglais','0',NULL,'Cours d\' ANglais avec plusieurs chapitres: Grammaire, Speaking, reading etc ','https://vraiesecolesdelangues.com/wp-content/uploads/2013/02/learning-english.jpg'),(6,'Histoire','0',NULL,'Cours d\'Histoire avec plusieurs chapitres: Guerres mondialles, crise des années 30 etc ','https://i.f1g.fr/media/eidos/805x453_crop/2017/06/16/XVM2b5c766c-4080-11e7-a469-62c36d07d43b.jpg'),(7,'Géographie','0',NULL,'Cours de Géographie avec plusieurs chapitres: la démographie mondiale etc ','https://www.geodus.com/globe-map/tresgrand/geo_wb34083.jpg'),(8,'Biologie','0',NULL,'Cours de Biologie avec plusieurs chapitres: les plantes, la réproduction etc ','https://www.prf.upol.cz/typo3temp/assets/_processed_/d/e/csm_dna-1811955_1920_7b6c094ae2.jpg');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_content`
--

LOCK TABLES `course_content` WRITE;
/*!40000 ALTER TABLE `course_content` DISABLE KEYS */;
INSERT INTO `course_content` VALUES (1,'http://www.ancestralauthor.com/tutorial/tutorial.pdf','premier cours',1,1),(2,'http://www.ancestralauthor.com/download/large.pdf','deuxième cours',1,1),(3,'http://www.ancestralauthor.com/download/sample.pdf','troisième cours',1,1),(4,'http://www.ancestralauthor.com/tutorial/tutorial.pdf','Français elementaire',2,1),(5,'https://webusers.imj-prg.fr/~alessandro.chiodo/LU1MA002/exomov/F05E06.mp4','calcul fréquenciel',1,2);
/*!40000 ALTER TABLE `course_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_progress`
--

LOCK TABLES `course_progress` WRITE;
/*!40000 ALTER TABLE `course_progress` DISABLE KEYS */;
INSERT INTO `course_progress` VALUES (1,1,1,'done'),(2,2,1,'notdone'),(3,3,1,'done'),(4,4,1,'done'),(5,5,1,'notdone');
/*!40000 ALTER TABLE `course_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exercice`
--

LOCK TABLES `exercice` WRITE;
/*!40000 ALTER TABLE `exercice` DISABLE KEYS */;
INSERT INTO `exercice` VALUES (1,'exo1',13.5,1),(2,'exo2',14,1),(3,'exo3',14,2),(4,'exo4',12,2);
/*!40000 ALTER TABLE `exercice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exercice_progress`
--

LOCK TABLES `exercice_progress` WRITE;
/*!40000 ALTER TABLE `exercice_progress` DISABLE KEYS */;
INSERT INTO `exercice_progress` VALUES (1,1,1,1,'done'),(2,1,2,1,'notdone');
/*!40000 ALTER TABLE `exercice_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `listchoices`
--

LOCK TABLES `listchoices` WRITE;
/*!40000 ALTER TABLE `listchoices` DISABLE KEYS */;
INSERT INTO `listchoices` VALUES (1,'A','48',1),(2,'B','28',1),(3,'C','27',1),(4,'D','30',1),(5,'A','25',2),(6,'B','27',2),(7,'C','26',2),(8,'D','30',2);
/*!40000 ALTER TABLE `listchoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `log_activity`
--

LOCK TABLES `log_activity` WRITE;
/*!40000 ALTER TABLE `log_activity` DISABLE KEYS */;
INSERT INTO `log_activity` VALUES (1,'2020-05-21 22:00:00.000000','premier cours',112),(2,'2020-05-24 22:00:00.000000','premier cours',120),(3,'2020-05-24 22:00:00.000000','premier cours',120),(4,'2020-05-24 22:00:00.000000','premier cours',120),(5,'2020-05-24 22:00:00.000000','premier cours',120);
/*!40000 ALTER TABLE `log_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `log_session`
--

LOCK TABLES `log_session` WRITE;
/*!40000 ALTER TABLE `log_session` DISABLE KEYS */;
INSERT INTO `log_session` VALUES (1,'2020-05-22 15:08:30.225000',NULL,NULL),(2,'2020-05-22 15:08:48.358000','2020-05-22 15:46:55.268000',112),(3,'2020-05-22 23:43:03.730000','2020-05-22 23:43:08.806000',112),(4,'2020-05-23 11:17:24.605000','2020-05-23 11:20:58.278000',112),(5,'2020-05-23 11:41:19.656000','2020-05-23 11:41:38.133000',112),(6,'2020-05-23 11:43:26.898000','2020-05-23 11:43:42.704000',112),(7,'2020-05-23 12:36:25.080000','2020-05-23 12:36:33.816000',112),(8,'2020-05-23 12:47:39.763000','2020-05-23 13:07:44.772000',112),(9,'2020-05-23 13:12:24.418000','2020-05-23 13:14:43.551000',112),(10,'2020-05-23 13:41:59.339000','2020-05-23 13:44:44.666000',112),(11,'2020-05-23 14:21:34.019000','2020-05-25 01:16:20.790000',112),(12,'2020-05-23 14:22:44.225000','2020-05-23 14:23:54.423000',112),(13,'2020-05-23 14:27:15.222000','2020-05-23 14:27:23.254000',112),(14,'2020-05-24 23:59:57.826000','2020-05-25 00:00:16.555000',112),(15,'2020-05-25 01:16:30.768000','2020-05-25 01:20:11.254000',112),(16,'2020-05-25 01:20:20.340000','2020-05-25 01:20:29.667000',112),(17,'2020-05-25 01:20:46.965000','2020-05-25 01:20:59.789000',120),(18,'2020-05-25 01:21:09.285000',NULL,120),(19,'2020-05-25 17:30:43.811000','2020-05-25 18:32:17.851000',112),(20,'2020-05-25 17:35:08.052000','2020-05-25 17:36:22.170000',112),(21,'2020-05-25 17:36:41.486000','2020-05-25 17:36:49.936000',120),(22,'2020-05-25 17:37:03.432000','2020-05-25 18:31:06.392000',112);
/*!40000 ALTER TABLE `log_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payement`
--

LOCK TABLES `payement` WRITE;
/*!40000 ALTER TABLE `payement` DISABLE KEYS */;
INSERT INTO `payement` VALUES (1,2020,4356,1,'theirno barry','05999378574885',112);
/*!40000 ALTER TABLE `payement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'parent','ROLE_PARENT'),(2,'eleve','ROLE_ELEVE');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `qcm`
--

LOCK TABLES `qcm` WRITE;
/*!40000 ALTER TABLE `qcm` DISABLE KEYS */;
INSERT INTO `qcm` VALUES (1,NULL,'Combien vaut 3+5²','B',1,'calcul puissance');
/*!40000 ALTER TABLE `qcm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `qr`
--

LOCK TABLES `qr` WRITE;
/*!40000 ALTER TABLE `qr` DISABLE KEYS */;
/*!40000 ALTER TABLE `qr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recommendation`
--

LOCK TABLES `recommendation` WRITE;
/*!40000 ALTER TABLE `recommendation` DISABLE KEYS */;
INSERT INTO `recommendation` VALUES (1,'Bossez bien, les examens approches','2020-05-15 23:35:08.000000'),(2,'Revenez sur votre cours, soyez motivé','2020-05-15 23:35:53.000000'),(3,'Ne baissez pas les bras.','2020-05-15 23:36:10.000000'),(4,'Courage, il vous reste pas beaucoup.','2020-05-15 23:36:25.000000'),(5,'La réussité vient au bout de l\'effort.','2020-05-15 23:37:49.000000'),(6,'Soyez perséverant','2020-05-15 23:37:49.000000'),(7,'Bravo, Vous êtes bien avancé.','2020-05-15 23:39:20.000000');
/*!40000 ALTER TABLE `recommendation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tchat`
--

LOCK TABLES `tchat` WRITE;
/*!40000 ALTER TABLE `tchat` DISABLE KEYS */;
/*!40000 ALTER TABLE `tchat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (112,'karim.dahdouh.fr@gmail.com',NULL,'karim','dahdouh',NULL,86,'null','null','null','0789876543','Montpellier',NULL),(120,'null',NULL,'Yanis','Dubois',NULL,94,'Cours élémentaire première année (CE1)','Mother','boy','null','null',112),(121,'null',NULL,'Sebasiane','Martin',NULL,95,'Cours élémentaire deuxième année (CE2)','Father','boy','null','null',112);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

