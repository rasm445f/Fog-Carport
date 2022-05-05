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
                                                        PRIMARY KEY (`material_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogcarport`.`bill_of_materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`bill_of_materials` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`bill_of_materials` (
                                                                `bom_id` INT NOT NULL AUTO_INCREMENT,
                                                                `material_amount` INT NOT NULL,
                                                                `material_id` INT NOT NULL,
                                                                PRIMARY KEY (`bom_id`),
                                                                INDEX `fk_bill_of_materials_materials1_idx` (`material_id` ASC) VISIBLE,
                                                                CONSTRAINT `fk_bill_of_materials_materials1`
                                                                    FOREIGN KEY (`material_id`)
                                                                        REFERENCES `fogcarport`.`materials` (`material_id`)
                                                                        ON DELETE NO ACTION
                                                                        ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogcarport`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`user` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`user` (
                                                   `user_id` INT NOT NULL AUTO_INCREMENT,
                                                   `email` VARCHAR(45) NOT NULL,
                                                   `password` VARCHAR(45) NOT NULL,
                                                   `name` VARCHAR(45) NOT NULL,
                                                   `address` VARCHAR(45) NOT NULL,
                                                   `city` VARCHAR(45) NOT NULL,
                                                   `zipcode` INT NOT NULL,
                                                   `phone_number` INT NOT NULL,
                                                   `balance` INT NOT NULL DEFAULT '50000',
                                                   `role` VARCHAR(45) NOT NULL DEFAULT 'customer',
                                                   PRIMARY KEY (`user_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 7
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


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
                                                    `bom_id` INT NOT NULL,
                                                    PRIMARY KEY (`order_id`),
                                                    INDEX `fk_order_user_idx` (`user_id` ASC) VISIBLE,
                                                    INDEX `fk_order_bill_of_materials1_idx` (`bom_id` ASC) VISIBLE,
                                                    CONSTRAINT `fk_order_user`
                                                        FOREIGN KEY (`user_id`)
                                                            REFERENCES `fogcarport`.`user` (`user_id`),
                                                    CONSTRAINT `fk_order_bill_of_materials1`
                                                        FOREIGN KEY (`bom_id`)
                                                            REFERENCES `fogcarport`.`bill_of_materials` (`bom_id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogcarport`.`rooftype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`rooftype` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`rooftype` (
                                                       `rooftype_id` INT NOT NULL AUTO_INCREMENT,
                                                       `roof_name` VARCHAR(45) NOT NULL,
                                                       PRIMARY KEY (`rooftype_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogcarport`.`toolshed_length`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`toolshed_length` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`toolshed_length` (
                                                              `toolshed_length_id` INT NOT NULL AUTO_INCREMENT,
                                                              `toolshed_length_cm` INT NOT NULL,
                                                              PRIMARY KEY (`toolshed_length_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`toolshed_width`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`toolshed_width` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`toolshed_width` (
                                                             `toolshed_width_id` INT NOT NULL,
                                                             `toolshed_width_cm` INT NOT NULL,
                                                             PRIMARY KEY (`toolshed_width_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`toolshed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`toolshed` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`toolshed` (
                                                       `toolshed_id` INT NOT NULL AUTO_INCREMENT,
                                                       `toolshed_width_id` INT NOT NULL,
                                                       `toolshed_length_id` INT NOT NULL,
                                                       PRIMARY KEY (`toolshed_id`),
                                                       INDEX `fk_toolshed_toolshed_length1_idx` (`toolshed_length_id` ASC) VISIBLE,
                                                       INDEX `fk_toolshed_toolshed_width1_idx` (`toolshed_width_id` ASC) VISIBLE,
                                                       CONSTRAINT `fk_toolshed_toolshed_length1`
                                                           FOREIGN KEY (`toolshed_length_id`)
                                                               REFERENCES `fogcarport`.`toolshed_length` (`toolshed_length_id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION,
                                                       CONSTRAINT `fk_toolshed_toolshed_width1`
                                                           FOREIGN KEY (`toolshed_width_id`)
                                                               REFERENCES `fogcarport`.`toolshed_width` (`toolshed_width_id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogcarport`.`carport_width`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`carport_width` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`carport_width` (
                                                            `carport_width_id` INT NOT NULL AUTO_INCREMENT,
                                                            `carport_width_cm` INT NOT NULL,
                                                            PRIMARY KEY (`carport_width_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`carport_length`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`carport_length` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`carport_length` (
                                                             `carport_length_id` INT NOT NULL,
                                                             `carport_length_cm` INT NOT NULL,
                                                             PRIMARY KEY (`carport_length_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fogcarport`.`carport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fogcarport`.`carport` ;

CREATE TABLE IF NOT EXISTS `fogcarport`.`carport` (
                                                      `carport_id` INT NOT NULL AUTO_INCREMENT,
                                                      `width_id` INT NOT NULL,
                                                      `length_id` INT NOT NULL,
                                                      `rooftype_id` INT NOT NULL,
                                                      `toolshed_id` INT NULL,
                                                      `order_id` INT NOT NULL,
                                                      PRIMARY KEY (`carport_id`),
                                                      INDEX `fk_carport_carport_width1_idx` (`width_id` ASC) VISIBLE,
                                                      INDEX `fk_carport_carport_length1_idx` (`length_id` ASC) VISIBLE,
                                                      INDEX `fk_carport_rooftype1_idx` (`rooftype_id` ASC) VISIBLE,
                                                      INDEX `fk_carport_toolshed1_idx` (`toolshed_id` ASC) VISIBLE,
                                                      INDEX `fk_carport_order1_idx` (`order_id` ASC) VISIBLE,
                                                      CONSTRAINT `fk_carport_carport_width1`
                                                          FOREIGN KEY (`width_id`)
                                                              REFERENCES `fogcarport`.`carport_width` (`carport_width_id`)
                                                              ON DELETE NO ACTION
                                                              ON UPDATE NO ACTION,
                                                      CONSTRAINT `fk_carport_carport_length1`
                                                          FOREIGN KEY (`length_id`)
                                                              REFERENCES `fogcarport`.`carport_length` (`carport_length_id`)
                                                              ON DELETE NO ACTION
                                                              ON UPDATE NO ACTION,
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
                                                              ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
