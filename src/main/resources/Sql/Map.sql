-- MySQL Script generated by MySQL Workbench
-- Thu Oct 13 20:50:32 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Map
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Map
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Map` DEFAULT CHARACTER SET utf8 ;
USE `Map` ;

-- -----------------------------------------------------
-- Table `Map`.`Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Map`.`Cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Map`.`Stations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Map`.`Stations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `Cities_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Stations_Cities_idx` (`Cities_id` ASC) VISIBLE,
  CONSTRAINT `fk_Stations_Cities`
    FOREIGN KEY (`Cities_id`)
    REFERENCES `Map`.`Cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Map`.`Roads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Map`.`Roads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `distance` double NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Map`.`RoadToStation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Map`.`RoadToStation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Roads_id` INT NOT NULL,
  `Stations_id` INT NOT NULL,
  INDEX `fk_Roads_has_Stations_Stations1_idx` (`Stations_id` ASC) VISIBLE,
  INDEX `fk_Roads_has_Stations_Roads1_idx` (`Roads_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Roads_has_Stations_Roads1`
    FOREIGN KEY (`Roads_id`)
    REFERENCES `Map`.`Roads` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Roads_has_Stations_Stations1`
    FOREIGN KEY (`Stations_id`)
    REFERENCES `Map`.`Stations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*insert*/

-- INSERT INTO cities(name) VALUES ("Batumi");
-- INSERT INTO cities(name) VALUES ("Qutaisi");


-- Batumi
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi A",1);
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi B",1);
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi C",1);
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi D",1);
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi E",1);
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi F",1);
-- INSERT INTO stations(name,Cities_id) VALUES ("Batumi G",1);


-- Queteisi
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi A",2);
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi B",2);
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi C",2);
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi D",2);
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi E",2);
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi F",2);
-- INSERT INTO stations(name,Cities_id) VALUES ("Qutaisi G",2);


-- Roads

-- INSERT INTO roads(distance) VALUES (10.0);
-- INSERT INTO roads(distance) VALUES (10.0);
-- INSERT INTO roads(distance) VALUES (10.0);
-- INSERT INTO roads(distance) VALUES (3.6);
-- INSERT INTO roads(distance) VALUES (5.5);
-- INSERT INTO roads(distance) VALUES (6.4);
-- INSERT INTO roads(distance) VALUES (7.1);
-- INSERT INTO roads(distance) VALUES (3.6);
-- INSERT INTO roads(distance) VALUES (5.5);
-- INSERT INTO roads(distance) VALUES (6.4);
-- INSERT INTO roads(distance) VALUES (7.1);
-- INSERT INTO roads(distance) VALUES (8.8);
-- INSERT INTO roads(distance) VALUES (9.2);
-- INSERT INTO roads(distance) VALUES (10.4);
-- INSERT INTO roads(distance) VALUES (150.80);


-- roadstoStation

-- Batumi
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (1,1);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (1,2);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (2,2);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (2,3);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (3,3);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (3,4);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (4,4);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (4,5);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (5,5);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (5,6);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (6,6);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (6,7);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (7,7);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (7,1);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (15,7);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (15,8);


-- Qeteisi

-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (8,8);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (8,9);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (9,9);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (9,10);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (10,10);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (10,11);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (11,11);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (11,12);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (12,12);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (12,13);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (13,13);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (13,14);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (14,14);
-- INSERT INTO roadtostation (Roads_id,Stations_id) VALUES (14,8);













