-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fogcarport
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fogcarport` ;

-- -----------------------------------------------------
-- Schema fogcarport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fogcarport` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fogcarport` ;

-- -----------------------------------------------------
-- Table `fogcarport`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`user` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`user` (
                                                   `user_id` INT NOT NULL AUTO_INCREMENT,
                                                   `email` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    `balance` INT NOT NULL DEFAULT 50000,
    `name` VARCHAR(45) NOT NULL,
    `address` VARCHAR(45) NOT NULL,
    `city` VARCHAR(45) NOT NULL,
    `zipcode` INT NOT NULL,
    `phone_number` INT NOT NULL,
    PRIMARY KEY (`user_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`order` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`order` (
                                                    `order_id` INT NOT NULL AUTO_INCREMENT,
                                                    `user_id` INT NOT NULL,
                                                    `order_date` DATETIME NOT NULL,
                                                    `order_price` INT NOT NULL,
                                                    `order_status` TINYINT NOT NULL,
                                                    PRIMARY KEY (`order_id`),
    INDEX `fk_order_user_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `fogcarport`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`rooftype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`rooftype` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`rooftype` (
                                                       `rooftype_id` INT NOT NULL AUTO_INCREMENT,
                                                       `roof_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`rooftype_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`toolshed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`toolshed` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`toolshed` (
                                                       `toolshed_id` INT NOT NULL AUTO_INCREMENT,
                                                       `toolshed_width` INT NOT NULL,
                                                       `toolshed_length` INT NOT NULL,
                                                       PRIMARY KEY (`toolshed_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`materials` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`materials` (
                                                        `material_id` INT NOT NULL,
                                                        `material_description` VARCHAR(45) NOT NULL,
    `material_guidance` VARCHAR(45) NOT NULL,
    `material_category` VARCHAR(45) NOT NULL,
    `material_unit` VARCHAR(45) NOT NULL,
    `material_length` INT NOT NULL,
    `material_price` INT NOT NULL,
    `bom_id` INT NOT NULL,
    PRIMARY KEY (`material_id`),
    INDEX `fk_materials_bom1_idx` (`bom_id` ASC) VISIBLE,
    CONSTRAINT `fk_materials_bom1`
    FOREIGN KEY (`bom_id`)
    REFERENCES `fogcarport`.`bom` (`bom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`bom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`bom` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`bom` (
                                                  `bom_id` INT NOT NULL AUTO_INCREMENT,
                                                  `material_amount` INT NOT NULL,
                                                  `material_id` INT NOT NULL,
                                                  PRIMARY KEY (`bom_id`),
    INDEX `fk_bom_materials1_idx` (`material_id` ASC) VISIBLE,
    CONSTRAINT `fk_bom_materials1`
    FOREIGN KEY (`material_id`)
    REFERENCES `fogcarport`.`materials` (`material_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`carport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`carport` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`carport` (
                                                      `carport_id` INT NOT NULL AUTO_INCREMENT,
                                                      `carport_width` INT NOT NULL,
                                                      `carport_length` INT NOT NULL,
                                                      `carport_heigth` INT NOT NULL DEFAULT 2,5,
                                                      `roof_tilt` INT NOT NULL,
                                                      `rooftype_id` INT NOT NULL,
                                                      `toolshed_id` INT NOT NULL,
                                                      `order_id` INT NOT NULL,
                                                      `carport_price` INT NOT NULL,
                                                      `bom_id` INT NOT NULL,
                                                      PRIMARY KEY (`carport_id`),
    INDEX `fk_carport_rooftype1_idx` (`rooftype_id` ASC) VISIBLE,
    INDEX `fk_carport_toolshed1_idx` (`toolshed_id` ASC) VISIBLE,
    INDEX `fk_carport_order1_idx` (`order_id` ASC) VISIBLE,
    INDEX `fk_carport_order2_idx` (`carport_price` ASC) VISIBLE,
    INDEX `fk_carport_bom1_idx` (`bom_id` ASC) VISIBLE,
    CONSTRAINT `fk_carport_rooftype1`
    FOREIGN KEY (`rooftype_id`)
    REFERENCES `fogcarport`.`rooftype` (`rooftype_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_toolshed1`
    FOREIGN KEY (`toolshed_id`)
    REFERENCES `fogcarport`.`toolshed` (`toolshed_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `fogcarport`.`order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_order2`
    FOREIGN KEY (`carport_price`)
    REFERENCES `fogcarport`.`order` (`order_price`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_carport_bom1`
    FOREIGN KEY (`bom_id`)
    REFERENCES `fogcarport`.`bom` (`bom_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
