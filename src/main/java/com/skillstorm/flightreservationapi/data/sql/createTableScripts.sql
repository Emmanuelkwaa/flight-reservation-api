

CREATE TABLE `Flight` (
	`id` INT unsigned NOT NULL AUTO_INCREMENT,
	`flight_number` VARCHAR(10) UNIQUE NOT NULL,
	`airplane_id` VARCHAR(15) NOT NULL,
    `depart_city_id` SMALLINT unsigned NOT NULL,
	`arrival_city_id` SMALLINT unsigned NOT NULL,
	`depart_datetime` DATETIME NOT NULL,
	`arrival_datetime` DATETIME NOT NULL,
	`economy_price` DOUBLE unsigned NOT NULL,
	`business_price` DOUBLE unsigned NOT NULL,
	PRIMARY KEY (`id`),

    CONSTRAINT fk_Airplane FOREIGN KEY (airplane_id)
    REFERENCES Airplane (airplane_id)
    ON DELETE SET NULL ON UPDATE CASCADE,

    CONSTRAINT fk_DepartCity FOREIGN KEY (depart_city_id)
    REFERENCES City (city_id)
    ON DELETE SET NULL ON UPDATE CASCADE,

    CONSTRAINT fk_ArriveCity FOREIGN KEY (arrival_city_id)
    REFERENCES City (city_id)
    ON DELETE SET NULL ON UPDATE CASCADE
);