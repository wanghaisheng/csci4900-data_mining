CREATE DATABASE  IF NOT EXISTS `dm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dm`;
-- MySQL dump 10.13  Distrib 5.1.73, for redhat-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: dm
-- ------------------------------------------------------
-- Server version	5.1.73

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
-- Table structure for table `jailx_address`
--

DROP TABLE IF EXISTS `jailx_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jailx_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `jailx_id` int(10) unsigned DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jailx_address_1_idx` (`jailx_id`),
  CONSTRAINT `fk_jailx_address_1` FOREIGN KEY (`jailx_id`) REFERENCES `jailx` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jailx_address`
--

LOCK TABLES `jailx_address` WRITE;
/*!40000 ALTER TABLE `jailx_address` DISABLE KEYS */;
INSERT INTO `jailx_address` VALUES (1,1,'3642 SALEM GLEN RD','LITHONIA','GA','30038'),(2,2,'143 BERLIN ST APT 205','ATHENS','GA','30605'),(3,3,'440 HOLLOW RIDGE','ATHENS','GA','30607'),(4,4,'606 CREEKSIDE','ATHENS','GA','30605'),(5,5,'465 NORWOOD CIRCLE','ATHENS','GA','30601'),(6,6,'7591 JEFFERSON RIVER RD','ATHENS','GA','30607'),(7,8,'326 TAL PHILLIPS RD','COMMERCE','GA','30530'),(8,9,'7591 JEFFERSON RIVER ROAD','ATHENS','GA','30607'),(9,10,'106 WOODHAVEN POINTE','ATHENS','GA','30601'),(10,12,'120 NOWHERE RD','ATHENS','GA','30601'),(11,13,'240 BRIDGES DRIVE','WINTERVILLE','GA','30683'),(12,14,'193 INDIANA AVE','ATHENS','GA','30605'),(13,15,'132 HIGHLAND PARK DRIVE','ATHENS','GA','30606'),(14,16,'2022 S MILLEDGE AVE RM# 328','ATHENS','GA','30606'),(15,17,'155 CHEROKEE RIDGE','ATHENS','GA','30605'),(16,18,'654 DEARING STREET','ATHENS','GA','30606'),(17,19,'185 HOLMES AVE','ATHENS','GA','30601'),(18,20,'250 FAIRVIEW ST','ATHENS','GA','30606'),(19,22,'1113 LAKE POINT LN','STONE MOUNTAIN','GA','30088'),(20,23,'31 CHRISAREN LN','ATHENS','GA','30601'),(21,24,'135 RIVERBOTTOM RD','ATHENS','GA','30606'),(22,25,'150 EAST CARVER DRIVE','ATHENS','GA','30605'),(23,26,'705 SPRING VALLEY RD APT 184','ATHENS','GA','30601'),(24,27,'240 SYCAMORE DRIVE D4','ATHENS','GA','30606'),(25,28,'1775 E BROAD ST APT D4','ATHENS','GA','30601'),(26,29,'132 CREEKSIDE PLACE','ARNOLDVILLE','GA','30615'),(27,30,'705 SPRINGVALLEY ROAD','ATHENS','GA','30605'),(28,31,'125 HEELSTONE PLACE','BOGART','GA','30622'),(29,33,'110 CHALFONT DR APT B','ATHENS','GA','30606'),(30,34,'270 SUNSET DRIVE','ATHENS','GA','30606'),(31,36,'35 SOUTH HICKORY POINTE','HULL','GA','30646'),(32,37,'831 WADDELL ST','ATHENS','GA','30606'),(33,38,'273 WILTSHIRE DRIVE','ATHENS','GA','30605'),(34,39,'43 ALMOND DRIVE','COMER','GA','30629'),(35,40,'614 PINE LOG RD','ATHENS','GA','30605'),(36,41,'1150 TOWNE SQUARE LN','ATHENS','GA','30607'),(37,42,'1515 SALEM ROAD, P.O.BOX 219','FARMINGTON','GA','30638'),(38,43,'216 E PACE DR.','ATHENS','GA','30605'),(39,44,'105 TALL TREE RD','BOGART','GA','30622'),(40,45,'118 PARKVIEW DRIVE','ATHENS','GA','30606'),(41,46,'345 LAVENDER ROAD','ATHENS','GA','30606'),(42,47,'293 EVANS STREET','ATHENS','GA','30606'),(43,48,'245 FIRST ST','ATHENS','GA','30601'),(44,50,'182 COLERIDGE CT','ATHENS','GA','30605'),(45,51,'95 NORTH AVE','ATHENS','GA','30606'),(46,53,'2411 WINTERVILLE ROAD','ATHENS','GA','30605'),(47,54,'95 NORTH AVE.','ATHENS','GA','30602'),(48,55,'3009 BURTON CIRCLE','GAINESVILLE','GA','30507'),(49,56,'22 RED OAK RUN','WINTERVILLE','GA','30683'),(50,57,'105 SARDEN CIRCLE','BOGARTS','GA','30622'),(51,58,'197 QUAIL RUN','ATHENS','GA','30606'),(52,60,'421 WEST HANCOCK AVE APT 115','ATHENS','GA','30605'),(53,61,'115 HICKMAN DR APT.5','ATHENS','GA','30605'),(54,62,'340 NORWOOD CIR LOT C 12','ATHENS','GA','30601'),(55,63,'HEALING PLACE HOMELESS SHELTER','ATHENS','GA','30601'),(56,65,'276 OAK MEADOWS DR.','ATHENS','GA','30605'),(57,66,'415 BURKLAND DR','ATHENS','GA','30601'),(58,67,'499 CLOVER STREET','ATHENS','GA','30606'),(59,68,'172 COLEMANOR DRIVE','ATHENS','GA','30606'),(60,71,'187 ACADIA DR.','ATHENS','GA','30607'),(61,72,'75 WESTCHESTER DR','ATHENS','GA','30606'),(62,73,'190 MASON DR','COBB','GA','31735'),(63,74,'248 ASHBROOK DR','ATHENS','GA','30605'),(64,75,'75 THRASHER DR','WATKINSVILLE','GA','30677'),(65,76,'347 FAIRVIEW ST.','ATHENS','GA','30601'),(66,78,'950 MADISON DR','ATHENS','GA','30605'),(67,79,'1018 OGLSBY ST','ELBERTON','GA','30643'),(68,80,'585 VAUGHN RD','ATHENS','GA','30606'),(69,81,'130 COOPER SPRING CT','ATHENS','GA','30605'),(70,82,'1771 WHITE PLAINS RD','GREENSBORO','GA','30642'),(71,83,'501 CREEK HOLLOW WAY','ATHENS','GA','30607'),(72,84,'125.5 HAWTHORNE EXT','ATHENS','GA','30606'),(73,85,'280 TIMBERLAND DRIVE','DANIELSVILLE','GA','30633'),(74,86,'2430 DANIELSVILLE RD','ATHENS','GA','30601'),(75,87,'1693 EAST BROAD','ATHENS','GA','30601'),(76,89,'205 CRYSTAL CREEK DR','COLBERT','GA','30628'),(77,90,'133 GRESHAM LANE','ATHENS','GA','30605'),(78,91,'1116 DUNLAP RD','WINTERVILLE','GA','30683'),(79,92,'50 JACKSON MEADOWS DRIVE','HOSCHTON','GA','30548'),(80,93,'100 OAK HILL DR APT 214','ATHENS','GA','30605'),(81,94,'1292 MALCOLM BRIDGE RD','BOGART','GA','30622'),(82,95,'155 ROYALE ROAD APT 229','ATHENS','GA','30605'),(83,96,'310 NORWOOD CIR','ATHENS','GA','30601'),(84,97,'263 ROCKSPRINGS CT','ATHENS','GA','30606'),(85,98,'5067 SMOKEY ROAD','ATHENS','GA','30601'),(86,99,'167 BRISTLE CONE CT','WINTERVILLE','GA','30683'),(87,100,'272.5 FOURTH STREET','ATHENS','GA','30606'),(88,101,'1157 ROBERT HARDEMAN','WINTERVILLE','GA','30683'),(89,102,'279 WOODRIDGE CIR','ATHENS','GA','30601'),(90,103,'265 LEANN DR','ATHENS','GA','30605'),(91,104,'FAIR FAX APT APT 2017','ATHENS','GA','30606'),(92,105,'915 TURK RD LOT 6','BETHLEHEM','GA','30620'),(93,106,'128 STRICKLAND WAY','LAVONIA','GA','30553'),(94,107,'261 HOWARD ROAD','HULL','GA','30680'),(95,109,'140 WRIGHT CIRCLE','ATHENS','GA','30601'),(96,110,'250 ALBERTA DR','COLBERT','GA','30628'),(97,111,'119 TOWNE VIEW PLACE','ATHENS','GA','30606'),(98,112,'1995 WINTERVILLE RD APT 4','ATHENS','GA','30605'),(99,114,'1020 COLLEGE AVE APT 5','ATHENS','GA','30601'),(100,115,'315 EVANS STREET','ATHENS','GA','30606'),(101,116,'1214 WASHINGTON ST','JEFFERSON','GA','30549'),(102,117,'230 BROOKSTONE DR','ATHENS','GA','30605'),(103,118,'156 GROVE ST. APT.','ATHENS','GA','30606'),(104,119,'1200 ROBERT HARDEMAN RD','WINTERVILLE','GA','30683'),(105,120,'279 WOODRIDGE CIRCLE','ATHENS','GA','30606'),(106,121,'2430 DANIELSVILLE RD','ATHENS','GA','30601'),(107,122,'97 MEYER FARM ROAD','ARNOLDSVILLE','GA','30619'),(108,123,'159 UPSON COURT','LEXINGTON','GA','30648'),(109,125,'169 CARRIAGE CT','ATHENS','GA','30605'),(110,126,'196 BONNIE LANE','ATHENS','GA','30601'),(111,127,'690 FOURTH STREET APT 6101','ATHENS','GA','30605'),(112,128,'115 SOUTH RIDGE DR','ATHENS','GA','30607'),(113,129,'115 HOWELL WAY APT 4','ATHENS','GA','30606'),(114,130,'150 1/2 HARPER ST','ATHENS','GA','30601'),(115,131,'245 JULIOUS DRIVE','ATHENS','GA','30606'),(116,132,'240 ROBIN HOOD COURT','ATHENS','GA','30601'),(117,133,'265 LAVENDER ROAD','ATHENS','GA','30601'),(118,134,'162 MICHELLE DR','ATHENS','GA','30605'),(119,135,'94 NORTHWOOD CIRCLE','COLBERT','GA','30628'),(120,136,'359 ARCH STREET','ATHENS','GA','30605'),(121,137,'582 FREEMAN DR','ATHENS','GA','30601'),(122,138,'121 ACADIA DRIVE','ATHENS','GA','30606'),(123,139,'1995 WINTERVILLE RD APT 15','ATHENS','GA','30605'),(124,140,'235 SYCAMORE DRIVE APT P31','ATHENS','GA','30606'),(125,141,'140 MARTIN COURT','ATHENS','GA','30605'),(126,142,'125 BAXTER DRIVE APT C 10','ATHENS','GA','30606'),(127,143,'145 PAISLEY DR','ATHENS','GA','30605'),(128,144,'316 NORTH BURSON STREET','BOGART','GA','30622'),(129,145,'95 NORTH AVE','ATHENS','GA','30601'),(130,146,'280 GARNETT WARD RD','HULL','GA','30646'),(131,147,'4109 NW 78TH AVENUE','SUNRISE','FL','33351'),(132,148,'175 HICKMAN DRIVE APT 8','ATHENS','GA','30601'),(133,149,'180 MARTIN COURT','ATHENS','GA','30605'),(134,150,'522 MICHAEL CIRCLE','MONROE','GA','30052'),(135,151,'12 CONE DRIVE','ATHENS','GA','30605'),(136,153,'3802 SOAPSTONE RD','DECATUR','GA','30034'),(137,154,'HOMELESS','ATHENS','GA','30601'),(138,156,'270 ROCKSPRINGS HOME','ATHENS','GA','30606'),(139,157,'360 DEERPARK DRIVE','ATHENS','GA','30601'),(140,158,'HOMELESS','ATHENS','GA','30601'),(141,159,'112 LIVE OAK DR','ATHENS','GA','30606'),(142,160,'835 OCONEE ST.','ATHENS','GA','30605'),(143,161,'235 SYCAMORE DRIVE APT Q7D','ATHENS','GA','30606'),(144,162,'135 BURKLAND DRIVE','ATHENS','GA','30606'),(145,164,'227 JOHNSON AVE','CARROLTON','GA','30117'),(146,166,'116 OAK PARK AVE','ATHENS','GA','30605'),(147,167,'5405 CAMERON FORSET PARKWAY','ALPHARETTA','GA','30022'),(148,168,'37 BACKWOODS TRAIL','COMER','GA','30629'),(149,169,'195 CHATHAM DRIVE','ATHENS','GA','30607'),(150,170,'312 STONEYBROOK CIRCLE','ATHENS','GA','30605'),(151,171,'131 QUEEN ST','TACCOA','GA','30577'),(152,172,'177 ASHMORE DRIVE','ATHENS','GA','30601'),(153,173,'635 HUNTINGTON ROAD','ATHENS','GA','30606'),(154,174,'1101 FERNWOOD DR','WATKINSVILLE','GA','30677'),(155,175,'7015 HICKORY DRIVE','WINTERVILLE','GA','30683'),(156,176,'23 GATES PL','AUGUSTA','GA','30907'),(157,177,'115 BRIDWELL CT','SIX MILE','SC','29682'),(158,178,'HOMELESS','ATHENS','GA','30601'),(159,179,'155 SPRINGTREE RD APT A','ATHENS','GA','30605'),(160,180,'HOMELESS','ATHENS','GA','30601'),(161,181,'390 MARTIN CIR','ATHENS','GA','30683'),(162,182,'117 ASHMORE DR.','ATHENS','GA','30601'),(163,183,'141 N DUBLIN ST','ATHENS','GA','30601'),(164,184,'152 MINERAL SPRINGS','ATHENS','GA','30601'),(165,185,'1775 E BROAD ST APT 1','ATHENS','GA','30605'),(166,186,'450 CRESTWOOD DR','ATHENS','GA','30605'),(167,187,'246 ACADIA DR','ATHENS','GA','30607'),(168,188,'95 FAIRGROUND ROAD','LEXINGTON','GA','30648'),(169,190,'204 WHITE OAK TRAIL','JEFFERSON','GA','30549'),(170,191,'2025 WINTERVILLE RD APT 19','ATHENS','GA','30605'),(171,192,'345 WOODRIDGE CIR','ATHENS','GA','30606'),(172,193,'150 NORWOOD COURT','ATHENS','GA','30605'),(173,194,'116 NORTH BLUFF PL','ATHENS','GA','30607'),(174,195,'251 WINDY HILL WAY','ATHENS','GA','30606'),(175,196,'213 RHODES DR','ATHENS','GA','30606'),(176,197,'103 OAK PARK COURT','ATHENS','GA','30606'),(177,198,'215 COLERIDGE CT','ATHENS','GA','30605'),(178,199,'345 JEFFERSON RIVER RD','ATHENS','GA','30607'),(179,200,'100 RANICK RD','WINTERVILLE','GA','30683'),(180,201,'126 CROSS CREEK DR','ATHENS','GA','30605'),(181,202,'196 PEPPERIDGE LANE','ATHENS','GA','30606'),(182,203,'237 MADISON HEIGHTS','ATHENS','GA','30601'),(183,204,'305 MARTIN CIRCLE','ATHENS','GA','30601'),(184,205,'1709 WOODALL RD','DEWY ROSE','GA','30624'),(185,206,'396 ARCH STREET','ATHENS','GA','30601'),(186,207,'266 HIGHLAND PARK LN','ATHENS','GA','30607'),(187,210,'295 SAXON WOODS DR','ATHENS','GA','30607'),(188,211,'291 SPRINGDALE DR','WINDER','GA','30680'),(189,212,'537 FOURTH ST','ATHENS','GA','30601'),(190,213,'6136 GORDY STREET','COVINGTON','GA','30014'),(191,214,'534 E. CARVER DRIVE','ATHENS','GA','30606'),(192,216,'160 NORTHSIDE DRIVE','ATHENS','GA','30601'),(193,217,'127 FRANKLIN ST','ATHENS','GA','30606'),(194,218,'52 FOREST AVE','COMMERCE','GA','30529'),(195,219,'120 MERLIN DR','ATHENS','GA','30606'),(196,220,'722 GROVE LEVEL RD','BANKS','GA','30529'),(197,221,'829 STOREHOUSE CT APT H','MONROE','GA','30656'),(198,222,'317 WESTCHESTER DRIVE','ATHENS','GA','30606'),(199,223,'335 EPPS BRIDGE PARKWAY','ATHENS','GA','30606'),(200,224,'130 BLACKS CREEK CHURCH RD','DANIELSVILLE','GA','30633'),(201,225,'117 LAKE PL','ATHENS','GA','30606'),(202,227,'335 EPPS BRIDGE PARKWAY','ATHENS','GA','30606'),(203,228,'255 MILLSTONE DRIVE','ATHENS','GA','30601'),(204,229,'288 BAILEY ST. APT T-4','ATHENS','GA','30605'),(205,230,'105 OAK HILL DR APT 3111','ATHENS','GA','30601'),(206,231,'1645 E BROAD ST APT.4','ATHENS','GA','30606'),(207,232,'P O BOX 82008','ATHENS','GA','30608'),(208,233,'215 OLD MONROE RD','ATHENS','GA','30622'),(209,234,'150 HICKMAN DR APT 3','ATHENS','GA','30601'),(210,235,'245 BIG OAK CIRCLE','ATHENS','GA','30605'),(211,236,'235 SYCAMORE DRIVE','ATHENS','GA','30607'),(212,237,'240 SYCAMORE DR APT E-5','ATHENS','GA','30606'),(213,238,'420 FOURTH ST','ATHENS','GA','30601'),(214,240,'305 WESTCHESTER DR APT 325','ATHENS','GA','30606'),(215,241,'155 SUNNY HILLS DR','ATHENS','GA','30601'),(216,242,'240 BUCKINGHAM CT','ATHENS','GA','30607'),(217,243,'105 LAKE CT','ATHENS','GA','30606'),(218,244,'354 HUTCHINS RD','CRAWFORD','GA','30630'),(219,245,'261 REED STREET APT. CA','ATHENS','GA','30605'),(220,246,'2025 WINTERVILLE RD APT 22','ATHENS','GA','30605'),(221,247,'850 SUNSET DRIVE APT 1','ATHENS','GA','30606'),(222,248,'140 ZATELLA LANE','ATHENS','GA','30606'),(223,249,'608 LITTLE JOHN STREET','GAFFNEY','SC','29340'),(224,250,'150 NORTH BROAD ST','WINDER','GA','30680'),(225,251,'123 EAST PACES DR','ATHENS','GA','30605'),(226,252,'1783 OCONEE ST','ATHENS','GA','30601'),(227,253,'580 AUBREY DR','BOGART','GA','30622'),(228,254,'140 HICKMAN DR APT 7','ATHENS','GA','30605'),(229,255,'115 JUDY CIRCLE','ATHENS','GA','30601'),(230,257,'80 HENDRIX ROAD','COMMERCE','GA','30529'),(231,258,'287 GRAN ELLEN DR.','ATHENS','GA','30605'),(232,259,'1416 LENA DR','ELBERTON','GA','30635'),(233,260,'337 UTLEY RD','WAYNESBORO','GA','30830'),(234,261,'440 QUAILWOOD DRIVE','ATHENS','GA','30606'),(235,262,'120 NORTH LAKE DR','ATHENS','GA','30601'),(236,263,'220 SUSSEX DRIVE APT#12','ATHENS','GA','30606'),(237,264,'165 ED COILE RD.','HULL GA','GA','30666'),(238,265,'110 MERCER CT','ATHENS','GA','30606'),(239,266,'100 OAK HILL DR APT. 6211','ATHENS','GA','30601'),(240,267,'310 PITTARD RD','ATHENS','GA','30605'),(241,268,'2711 SOUTH 15TH ST','FT PERSON','FL','34982'),(242,269,'1410 ROSE LN','TOCCOA','GA','30577'),(243,271,'454 SAWDUST RD','HULL','GA','30601'),(244,272,'209 PALOMA TRL','ATHENS','GA','30601'),(245,273,'252 WEIR CIR','ATHENS','GA','30605'),(246,274,'5657 HWY 29 SOUTH','HULL','GA','30646'),(247,275,'170 HANOVER PL APT 2','ATHENS','GA','30601'),(248,276,'190 PARK VIEW HOMES','ATHENS','GA','30601'),(249,278,'325 OLD MONROE ROAD','BOGART','GA','30622'),(250,279,'347 FAIRVIEW ST','ATHENS','GA','30601'),(251,280,'129 PINEHURST CR APT 4','ATHENS','GA','30606'),(252,281,'240 B MACON HWY','ATHENS','GA','30601'),(253,282,'1625 MARCH DR','GAINESVILLE','GA','30507'),(254,283,'125 HICKMAN DRIVE','ATHENS','GA','30605'),(255,284,'505 A ATHENS AVE','ATHENS','GA','30601'),(256,286,'200 HARVEST WAY','ATHENS','GA','30607'),(257,287,'11 EASTWOOD CT APT A','WINTERVILLE','GA','30683'),(258,288,'500 N BILLUPS STREET','ATHENS','GA','30606'),(259,289,'505 NORWOOD CIR','ATHENS','GA','30606'),(260,290,'P.O. BOX 21','HULL','GA','30646'),(261,291,'105 LAVENDER RD','ATHENS','GA','30606'),(262,293,'1010 S PINE ST','LAURINBURG','NC','28352'),(263,294,'250 LAVENDER RD','ATHENS','GA','30606'),(264,295,'235 LOMBARDY DRIVE','ATHENS','GA','30605'),(265,297,'1195 WEST HANCOCK AVE','ATHENS','GA','30606'),(266,298,'2140 ATHEN RD','WINTERVILLE','GA','30603'),(267,299,'155 SUSSEX DR','ATHENS','GA','30606'),(268,300,'175 GREAT OAK DR','ATHENS','GA','30605'),(269,301,'764 TUXEDO DRIVE','COMMERCE','GA','30530'),(270,302,'235 SYCAMORE DR APT N4','ATHENS','GA','30606'),(271,303,'221 SNYDER AVE','ELBERTON','GA','30635'),(272,304,'HOMELESS','ATHENS','GA','30606'),(273,305,'400 N BLUFF RD','ATHENS','GA','30607'),(274,306,'1790 E BROAD STREET','ATHENS','GA','30601'),(275,307,'699 BERKELEY RD','CARLTON','GA','30627'),(276,308,'355 MARTIN CIRCLE','ATHENS','GA','30601'),(277,310,'2201 GREENSBRO HWY','GREENSBRO','GA','30642'),(278,311,'295 FAIRLANE DR','ATHENS','GA','30607'),(279,312,'145 MARTIN CIR','ATHENS','GA','30607'),(280,313,'249 FREDERICK DRIVE','ATHENS','GA','30607'),(281,314,'496 MCCARTY RD','STATHAM','GA','30666'),(282,315,'860 MITCHELL BRIDGE RD','ATHENS','GA','30606'),(283,316,'708 VINCENT DR','ATHENS','GA','30707'),(284,317,'15 SAM GROVES ST','DANIELSVILLE','GA','30633'),(285,318,'104 WOODRIDGE RD','BANDER HART','NC','20684'),(286,319,'320 GRIFFIN ST','GRANTVILLE','GA','30220'),(287,320,'163 MARTIN CIRLCE','ATHENS','GA','30601'),(288,321,'893 VETERANS PKWY','BARNESVILLE','GA','30204'),(289,322,'2050 O\'KELLEY RD','ATHENS','GA','30601'),(290,323,'5989 LANIER BLVD','NORCROSS','GA','30071'),(291,324,'132 MEARS STREET','WINDER','GA','30680'),(292,325,'190 MINERAL SPRINGS DR','ATHENS','GA','30606'),(293,326,'193 WARREN STREET','ATHENS','GA','30601'),(294,327,'1190 ROBERT HARDMAN RD','WINTERVILLE','GA','30605'),(295,328,'827 WADDELL STREET','ATHENS','GA','30606'),(296,329,'165 RIVERMONT ROAD','ATHENS','GA','30605'),(297,330,'HOMELESS','ATHENS','GA','30605'),(298,331,'935 BAXTER STREET APT 21','ATHENS','GA','30606'),(299,332,'350 COOPER ROAD','ATHENS','GA','30605'),(300,333,'529 A STREET','STATHAM','GA','30666'),(301,334,'257 N FINLEY ST','ATHENS','GA','30601'),(302,335,'563 WEST MINISH LAKE RD','COMMERCE','GA','30530'),(303,336,'140 MASSEY LN.','ATHENS','GA','30601'),(304,337,'2360 W BROAD STREET APT A-9','ATHENS','GA','30606'),(305,338,'205 BENTWOOD TRL','WINTERVILLE','GA','30683'),(306,339,'240 SYCAMORE DRIVE APT F8','ATHENS','GA','30606'),(307,341,'2505 DANIELSVILLE ROAD APT. 19','ATHENS','GA','30601'),(308,342,'1081 LAUREL POINTE','ATHENS','GA','30605'),(309,343,'195 LINDA AVE','ATHENS','GA','30601'),(310,344,'1465 EAST BROAD ST','ATHENS','GA','30605'),(311,345,'355 FIRST STREET','ATHENS','GA','30601'),(312,346,'173 LANGFORD CT','ATHENS','GA','30607'),(313,347,'990 ENOTA','GAINSVILLE','GA','30501'),(314,349,'151 W PACES DR','ATHENS','GA','30605'),(315,351,'6894 BEACON MOUNTAIN DR','LITHONIA','GA','30038'),(316,352,'143 BRYAN ST','ATHENS','GA','30601'),(317,353,'100 OAK HILL DRIVE APT 8121','ATHENS','GA','30606'),(318,354,'283 LINDA AVENUE','ATHENS','GA','30601'),(319,355,'215 KENNEDY CIRCLE','ATHENS','GA','30601'),(320,356,'POSSIBY HOMELESS','ATHENS','GA','30606'),(321,357,'PO BOX 133','LEXINGTON','GA','30648'),(322,358,'185 SUNNY HILLS DR','ATHENS','GA','30605'),(323,359,'1230 TRAVIS DRIVE','WATKINSVILLE','GA','30677'),(324,360,'163 CYPRESS DRIVE','JEFFERSON','GA','30549'),(325,361,'1000 CAMPBELL DRIVE','ATHENS','GA','30605'),(326,362,'275 CAMELOT DRIVE','ATHENS','GA','30606'),(327,363,'705 SPRING VALLEY RD','ATHENS','GA','30605'),(328,364,'270 KENNEDY CIRCLE','ATHENS','GA','30605'),(329,365,'275 HILL ST APT A','ATHENS','GA','30606'),(330,366,'244 CARWOOD DR','MONROE','GA','30655'),(331,367,'131 NORTH BLUFF','ATHENS','GA','30601'),(332,369,'1417 GLEN CAREY RD','HULL','GA','30646'),(333,370,'1131 KENNEDY RD','ARNOLDSVILLE','GA','30619'),(334,371,'180 CARRIAGE CT','ATHENS','GA','30606'),(335,372,'108 BUTTERBEAN CT','BRUNSWICK','GA','31525'),(336,373,'1660 UNION POINT HWY','STEPHENS','GA','30667'),(337,374,'350 WEST FAIR PLAY BLVD','FAIR PLAY','SC','29643'),(338,375,'65 JAMES LANE','DANIELSVILLE','GA','30633'),(339,377,'145 FAIRVIEW ST','ATHENS','GA','30601'),(340,378,'269 KISSAM ST','JEFFERSON','GA','30549'),(341,379,'142 COLE MANOR DRIVE','ATHENS','GA','30606'),(342,380,'24-42 98 TH STREET','EAST ELMHURST','NY','11369'),(343,381,'175 MISSION DR','ELBERTON','GA','30635'),(344,382,'2420 ADAMS AVE','MACON','GA','31206'),(345,383,'87 BUS BIN LANE','COLBERT','GA','30628'),(346,384,'226 MADISON HEIGHTS','ATHENS','GA','30601'),(347,385,'1758 GLORY HOLE RD','BAXLEY','GA','31513'),(348,386,'6 COLLEN WAY','NEPTUNE','NJ','07753'),(349,387,'661 BRANCH ST','ATHENS','GA','30605'),(350,389,'275 BIG OAK CIRCLE','ATHENS','GA','30605'),(351,390,'1345 DANIELSVILLE RD','ATHENS','GA','30601'),(352,391,'1140 RODGEERS RD','BOGART','GA','30622'),(353,392,'190 N BLUFF ROAD','ATHENS','GA','30607'),(354,393,'160 DUDLEY DR APT 536','ATHENS','GA','30605'),(355,394,'105 CHANDLER RD','ATHENS','GA','30605'),(356,395,'251 PLAZA STREET','ATHENS','GA','30606'),(357,396,'345 LAKEVIEW DR','WINTERVILLE','GA','30683'),(358,397,'140 CARRIAGE COURT APT 7','ATHENS','GA','30605'),(359,398,'135 POINTERS RIDGE','ATHENS','GA','30606'),(360,399,'HOMLESS',' ATHENS','GA','30605'),(361,400,'2025 WINTERVILLE RD','ATHENS',NULL,'30605'),(362,401,'250 HIGHLAND PARK DR','ATHENS','GA','30605'),(363,402,'45 STONERIDGE DR','COLBERT','GA','30628'),(364,403,'48 BROCKTON OAKS DRIVE','JEFFERSON','GA','30549'),(365,404,'372 OLD ORCHARD RD','BALDWIN','GA','30511'),(366,405,'107 COLE MANOR DRIVE','ATHENS','GA','30606'),(367,406,'140 ZEBULON DRIVE','ATHENS','GA','30601'),(368,407,'129 TRINITY AVE','ATLANTA','GA','30303'),(369,408,'185 TIBBETTS AVE','ATHENS','GA','30601'),(370,409,'549 N PETER ST.','ATHENS','GA','30601'),(371,410,'155 SPRING CIR','ATHENS','GA','30605'),(372,411,'353 ARCH ST','ATHENS','GA','30605'),(373,412,'2360 WEST BROAD APT 525','ATHENS','GA','30605'),(374,413,'3425 ATLANTA HWY APT 103','ATHENS','GA','30606'),(375,414,'705 SPRING VALLEY RD','ATHENS','GA','30605'),(376,415,'1081 LUMPKIN COUNTY PKWY','DAHLONNGA','GA','30533'),(377,416,'HOMELESS','ATHENS','GA','30601'),(378,417,'5162 EAST PONCE DELEON AVE','STONE MOUNTAIN','GA','30083'),(379,418,'2916 CARVER SPRINGS TERR','STATHAM','GA','30666'),(380,419,'350 OAK ST APT B','ATHENS','GA','30605'),(381,420,'125 MALLARD DRIVE','ATHENS','GA','30606'),(382,422,'310 NELLIE B ROAD','ATHENS','GA','30605'),(383,423,'319 WESTCHESTER DR','ATHENS','GA','30606'),(384,424,'916 DAISY LANE','ATHENS','GA','30605'),(385,425,'100 MADISON DR APT 268','ATHENS','GA','30605'),(386,426,'270 VINE ST','ATHENS','GA','30601'),(387,427,'157 GILMER ST','ATHENS','GA','30606'),(388,428,'818 CABIN CREEK DR','NICHOLSON','GA','30565'),(389,429,'185 HOLMES AVE','ATHENS','GA','30606'),(390,430,'186 GRIFFETH ST APT E','ATHENS','GA','30601'),(391,432,'1709 GRANITE DR','STATHAM','GA','30666'),(392,433,'HOMELESS','ATHENS','GA','30601'),(393,434,'6930 BONNES BLVD','AUSTELL','GA','30168'),(394,435,'822 SUNSET DR APT 3','ATHENS','GA','30606'),(395,436,'454 N. PETERS STREET','ATHENS','GA','30606'),(396,437,'HOMELESS 8 WALDEN LN','LEXINGTON','GA','30648'),(397,439,'2660 DANIELVILLE RD','ATHENS','GA','30601'),(398,440,'148 CATALPA LN','ATHENS','GA','30601'),(399,441,'347 FAIRVIEW ST','ATHENS','GA','30601'),(400,442,'150 KENNEDY CIR','ATHENS','GA','30601'),(401,443,'108 FAUST FARM ROAD','ARNOLDSVILLE','GA','30619'),(402,444,'156 CARRIAGE CT','ATHENS','GA','30605'),(403,445,'120 ALTARSTONE DR','BOGART','GA','30622'),(404,446,'1838 WASHINGTON HIGHWAY','ELBERTON','GA','30605'),(405,447,'523 16TH ST E APT B','TIFTON','GA','31794'),(406,448,'2360 W BROAD ST APT 404','ATHENS','GA','30601');
/*!40000 ALTER TABLE `jailx_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-18 15:37:18