-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.47-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jstl
--

CREATE DATABASE IF NOT EXISTS jstl;
USE jstl;

--
-- Definition of table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE `groupe` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `id_n` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_groupe_1` (`id_n`),
  CONSTRAINT `FK_groupe_1` FOREIGN KEY (`id_n`) REFERENCES `niveau` (`id_n`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groupe`
--

/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
INSERT INTO `groupe` (`id`,`nom`,`code`,`id_n`) VALUES 
 (1,'glid','A03',2),
 (2,'Telecomme','005',1),
 (3,'Procéder','007',1);
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;


--
-- Definition of table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE `matiere` (
  `id_m` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom_m` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_m`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matiere`
--

/*!40000 ALTER TABLE `matiere` DISABLE KEYS */;
INSERT INTO `matiere` (`id_m`,`nom_m`) VALUES 
 (1,'jsf'),
 (2,'c#'),
 (3,'symfony'),
 (4,'base de donnée'),
 (6,'android'),
 (7,'patron de conception'),
 (8,'anglais'),
 (9,'francais'),
 (10,'business intelligence'),
 (11,'conception'),
 (12,'programmation web ');
/*!40000 ALTER TABLE `matiere` ENABLE KEYS */;


--
-- Definition of table `matiere_ens`
--

DROP TABLE IF EXISTS `matiere_ens`;
CREATE TABLE `matiere_ens` (
  `id_me` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_ens` int(10) unsigned DEFAULT NULL,
  `id_m` int(10) unsigned DEFAULT NULL,
  `id_g` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_me`),
  KEY `FK_New Table_1` (`id_m`),
  KEY `FK_New Table_2` (`id_g`),
  KEY `FK_New Table_3` (`id_ens`),
  CONSTRAINT `FK_New Table_1` FOREIGN KEY (`id_m`) REFERENCES `matiere` (`id_m`),
  CONSTRAINT `FK_New Table_2` FOREIGN KEY (`id_g`) REFERENCES `groupe` (`id`),
  CONSTRAINT `FK_New Table_3` FOREIGN KEY (`id_ens`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matiere_ens`
--

/*!40000 ALTER TABLE `matiere_ens` DISABLE KEYS */;
INSERT INTO `matiere_ens` (`id_me`,`id_ens`,`id_m`,`id_g`) VALUES 
 (1,5,1,1),
 (2,5,3,1),
 (3,5,4,1),
 (4,5,1,2),
 (5,9,6,1),
 (6,9,8,1),
 (7,9,9,1),
 (8,8,12,1),
 (9,9,8,3),
 (10,7,9,3);
/*!40000 ALTER TABLE `matiere_ens` ENABLE KEYS */;


--
-- Definition of table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE `niveau` (
  `id_n` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nom_n` varchar(45) DEFAULT NULL,
  `code_n` varchar(45) DEFAULT NULL,
  `nbr_g` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_n`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `niveau`
--

/*!40000 ALTER TABLE `niveau` DISABLE KEYS */;
INSERT INTO `niveau` (`id_n`,`nom_n`,`code_n`,`nbr_g`) VALUES 
 (1,'1er annee','001',2),
 (2,'2eme annee','002',1),
 (3,'3eme annee','003',0),
 (4,'4eme annee','006',0);
/*!40000 ALTER TABLE `niveau` ENABLE KEYS */;


--
-- Definition of table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id_m` int(10) unsigned NOT NULL,
  `id_e` int(10) unsigned NOT NULL,
  `id_s` int(10) unsigned NOT NULL,
  `n_comp` varchar(45) DEFAULT NULL,
  `tp` float DEFAULT NULL,
  `ds` float DEFAULT NULL,
  `examain` float DEFAULT NULL,
  `precence` float DEFAULT NULL,
  PRIMARY KEY (`id_m`,`id_e`,`id_s`),
  KEY `FK_note_2` (`id_e`),
  KEY `FK_note_3` (`id_s`),
  CONSTRAINT `FK_note_2` FOREIGN KEY (`id_e`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FK_note_3` FOREIGN KEY (`id_s`) REFERENCES `session` (`id`),
  CONSTRAINT `FK_note_4` FOREIGN KEY (`id_m`) REFERENCES `matiere_ens` (`id_me`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `note`
--

/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` (`id_m`,`id_e`,`id_s`,`n_comp`,`tp`,`ds`,`examain`,`precence`) VALUES 
 (1,4,1,'1',10,10,12,NULL),
 (1,4,2,'00258',NULL,NULL,16,NULL),
 (1,16,1,'3',12,20,NULL,15),
 (1,18,1,'2',17,13,17,NULL),
 (1,19,1,'4',13,10,10,17);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;


--
-- Definition of table `session`
--

DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `date_d` varchar(45) DEFAULT NULL,
  `date_f` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `session`
--

/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` (`id`,`type`,`date_d`,`date_f`) VALUES 
 (1,'Principale','08/06/2016','18/06/2016'),
 (2,'Controle','25/06/2016','30/06/2016');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;


--
-- Definition of table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cin` int(8) unsigned DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `type` int(1) unsigned DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `id_g` int(10) unsigned DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` (`id`,`cin`,`nom`,`prenom`,`type`,`login`,`mp`,`id_g`,`tel`,`adresse`) VALUES 
 (4,11018821,'med','kharrat',3,'med_kh','123',1,'5293355885','sfax'),
 (5,11111111,'ahmed','jmal',2,'ahmed_j','123',NULL,'12345678','sfax'),
 (6,258,'ali','dmk',2,'ll','123',NULL,'125','sfax '),
 (7,1234,'ali','maalej',2,'ali_m','123',NULL,'74651960','53   '),
 (8,123456,'abid','chafik',2,'chaf_a','758',NULL,'25874123','sfax   '),
 (9,55555555,'mohsen','feki',2,'mohsen','785',NULL,'52933567','sfax '),
 (16,12345685,'ahmed','dammak',3,'ahmed','789',1,'12345685','sfax  '),
 (17,12345678,'fatma','boulila',3,'fatma','852',2,'12345696','sfax '),
 (18,12345678,'firas','makni',3,'firas','123',1,'12457896','sfax '),
 (19,74185296,'mahdi','kallel',3,'mahdi','123',1,'12345678','sfax '),
 (20,75315985,'zaynab','kisemtini',3,'zaynab','123',2,'74185212','sfax '),
 (21,74185265,'kholoud','hsayri',3,'kh','123',2,'75395145','sfax '),
 (22,15985214,'sleh','sleh',1,'sleh','123',NULL,'74185236',NULL);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
