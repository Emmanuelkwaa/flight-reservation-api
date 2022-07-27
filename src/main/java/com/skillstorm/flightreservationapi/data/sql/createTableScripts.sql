CREATE TABLE `Flight` (
	`id` INT unsigned NOT NULL AUTO_INCREMENT,
	`flightNumber` VARCHAR(10) UNIQUE NOT NULL,
	`airplaneId` VARCHAR(10) NOT NULL,
    `departCityId` SMALLINT unsigned NOT NULL,
	`arrivalCityId` SMALLINT unsigned NOT NULL,
	`departDateTime` DATETIME NOT NULL,
	`arrivalDateTime` DATETIME NOT NULL,
	`capacity` INT unsigned NOT NULL,
	`economyPrice` DOUBLE unsigned NOT NULL,
	`businessPrice` DOUBLE unsigned NOT NULL,
	PRIMARY KEY (`id`),

    CONSTRAINT fk_Airplane FOREIGN KEY (airplaneId)
    REFERENCES Airplane (id)
    ON DELETE SET NULL ON UPDATE CASCADE,

    CONSTRAINT fk_DepartCity FOREIGN KEY (departCityId)
    REFERENCES City (id)
    ON DELETE SET NULL ON UPDATE CASCADE,

    CONSTRAINT fk_ArriveCity FOREIGN KEY (arrivalCityId)
    REFERENCES City (id)
    ON DELETE SET NULL ON UPDATE CASCADE
);