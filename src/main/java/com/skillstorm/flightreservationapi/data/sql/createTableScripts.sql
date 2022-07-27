-- City
CREATE TABLE `City` (
	`city_id` SMALLINT unsigned NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`country` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`city_id`)
);

CREATE TABLE `Airport` (
	`airport_id` SMALLINT unsigned NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`city_id` SMALLINT unsigned NOT NULL,
	PRIMARY KEY (`airport_id`),

    CONSTRAINT fk_City FOREIGN KEY (city_id)
    REFERENCES City (city_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- Airline
CREATE TABLE `Airline` (
	`airline_id` SMALLINT unsigned NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`airline_id`)
);

-- Airplane
CREATE TABLE `Airplane` (
	`airplane_id` VARCHAR(20) NOT NULL,
	`curent_capacity` TINYINT unsigned NOT NULL,
	`max_capacity` TINYINT unsigned NOT NULL,
	`model` VARCHAR(20) NOT NULL,
	`airline_id` SMALLINT unsigned NOT NULL,
	PRIMARY KEY (`airplane_id`),

    CONSTRAINT fk_Airline FOREIGN KEY (airline_id)
    REFERENCES Airline (airline_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Seat` (
	`seat_id` TINYINT unsigned NOT NULL,
	`seat_number` VARCHAR(5) NOT NULL,
	`is_taken` BOOLEAN NOT NULL,
	`airplane_id` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`seat_id`),

    CONSTRAINT fk_Airplane FOREIGN KEY (airplane_id)
    REFERENCES Airplane (airplane_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Flight` (
	`id` INT unsigned NOT NULL AUTO_INCREMENT,
	`flight_number` VARCHAR(10) UNIQUE NOT NULL,
	`airplane_id` VARCHAR(15) NOT NULL,
    `depart_city_id` SMALLINT unsigned NOT NULL,
	`arrival_city_id` SMALLINT unsigned NOT NULL,
	`depart_datetime` DATETIME NOT NULL,
	`arrival_datetime` DATETIME NOT NULL,
	`economy_price` DOUBLE(7, 2) unsigned NOT NULL,
	`business_price` DOUBLE(7, 2) unsigned NOT NULL,
	PRIMARY KEY (`id`),

    CONSTRAINT fk_Airplane FOREIGN KEY (airplane_id)
    REFERENCES Airplane (airplane_id)
    ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_DepartCity FOREIGN KEY (depart_city_id)
    REFERENCES City (city_id)
    ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_ArriveCity FOREIGN KEY (arrival_city_id)
    REFERENCES City (city_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `User` (
	`user_id` INT unsigned NOT NULL,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`phone_number` VARCHAR(20) NOT NULL,
	`email` VARCHAR(50),
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `Ticket` (
	`ticket_id` VARCHAR(15) NOT NULL,
	`flight_id` INT unsigned NOT NULL,
	`user_id` INT unsigned NOT NULL,
	`date_of_purchase` DATETIME NOT NULL,
	`seat_id` TINYINT unsigned NOT NULL,
	`price` DOUBLE unsigned NOT NULL,
	PRIMARY KEY (`ticket_id`),

    CONSTRAINT fk_Flight FOREIGN KEY (flight_id)
    REFERENCES Flight (flight_id)
    ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_User FOREIGN KEY (user_id)
    REFERENCES User (user_id)
    ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_Seat FOREIGN KEY (seat_id)
    REFERENCES Seat (seat_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
