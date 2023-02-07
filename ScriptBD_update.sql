-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema base_actualizable
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema base_actualizable
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `base_actualizable` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `base_actualizable` ;

-- -----------------------------------------------------
-- Table `base_actualizable`.`datos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `base_actualizable`.`datos` (
  `Cedula_Dt` VARCHAR(10) NOT NULL,
  `Nombre_Dt` VARCHAR(45) NOT NULL,
  `Apellido_Dt` VARCHAR(45) NOT NULL,
  `Telefono_Dt` VARCHAR(10) NULL DEFAULT NULL,
  `Correo_Dt` VARCHAR(45) NULL DEFAULT NULL,
  `Edad_Dt` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cedula_Dt`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
