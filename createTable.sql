CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb`;DROP TABLE IF EXISTS `mydb`.`geoip` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`geoip` (
  `id_geoip` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ip_range_start` INT UNSIGNED NOT NULL ,
`ip_range_end` INT UNSIGNED NOT NULL ,
  `country_code` VARCHAR(2) NULL ,
  `country_name` VARCHAR(100) NULL ,
  `region_name` VARCHAR(100) NULL ,

  `city_name` VARCHAR(100) NULL ,
  `latitude` DECIMAL(9,6) NULL ,
  `longitude` DECIMAL(9,6) NULL ,
  PRIMARY KEY (`id_geoip`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `start_range_idx1` ON `mydb`.`geoip` (`ip_range_start` ASC) ;

CREATE UNIQUE INDEX `end_range_idx1` ON `mydb`.`geoip` (`ip_range_end` ASC) ;
CREATE USER 'geoip_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON `mydb`.`geoip` TO 'geoip_user'@'localhost';
FLUSH PRIVILEGES;