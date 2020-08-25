CREATE SCHEMA `currencies` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE TABLE `currencies`.`currency` (
  `name` VARCHAR(45) NOT NULL,
  `valueineuros` DOUBLE NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE `currencies`.`useractivity` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `fromCurrency` VARCHAR(45) NOT NULL,
  `toCurrency` VARCHAR(45) NOT NULL,
  `value` DOUBLE NOT NULL,
  `result` DOUBLE NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

SELECT * FROM currencies.currency;