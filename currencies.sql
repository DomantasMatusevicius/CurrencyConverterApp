CREATE SCHEMA `currencies` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE TABLE `currencies`.`currency` (
  `name` VARCHAR(45) NOT NULL,
  `valueineuros` DOUBLE NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

SELECT * FROM currencies.currency;