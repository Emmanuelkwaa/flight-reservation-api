DROP TABLE IF EXISTS City;
CREATE TABLE `city` (
                        `city_id` SMALLINT unsigned NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(100) NOT NULL,
                        `country` VARCHAR(100) NOT NULL,
                        PRIMARY KEY (`city_id`)
);

-- Airport
DROP TABLE IF EXISTS Airport;
CREATE TABLE `airport` (
                           `airport_id` SMALLINT unsigned NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(100) NOT NULL,
                           `code` VARCHAR(10) NOT NULL,
                           `city_id` SMALLINT unsigned NOT NULL,
                           PRIMARY KEY (`airport_id`),

                           CONSTRAINT fk_city FOREIGN KEY (city_id)
                               REFERENCES city (city_id)
                               ON DELETE CASCADE ON UPDATE CASCADE
);

-- Airline
DROP TABLE IF EXISTS Airline;
CREATE TABLE `airline` (
                           `airline_id` SMALLINT unsigned NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(100) NOT NULL,
                           PRIMARY KEY (`airline_id`)
);

-- Airplane
DROP TABLE IF EXISTS Airplane;
CREATE TABLE `airplane` (
                            `airplane_id` VARCHAR(20) NOT NULL,
                            `curent_capacity` TINYINT unsigned NOT NULL,
                            `max_capacity` TINYINT unsigned NOT NULL,
                            `model` VARCHAR(20) NOT NULL,
                            `airline_id` SMALLINT unsigned NOT NULL,
                            PRIMARY KEY (`airplane_id`),

                            CONSTRAINT fk_Airline FOREIGN KEY (airline_id)
                                REFERENCES airline (airline_id)
                                ON DELETE CASCADE ON UPDATE CASCADE
);

-- Seat
DROP TABLE IF EXISTS Seat;
CREATE TABLE `seat` (
                        `seat_id` TINYINT unsigned AUTO_INCREMENT NOT NULL,
                        `seat_number` VARCHAR(5) NOT NULL,
                        `is_taken` BOOLEAN NOT NULL,
                        `airplane_id` VARCHAR(20) NOT NULL,
                        PRIMARY KEY (`seat_id`),

                        CONSTRAINT fk_Airplane FOREIGN KEY (airplane_id)
                            REFERENCES airplane (airplane_id)
                            ON DELETE CASCADE ON UPDATE CASCADE
);

-- Flight
DROP TABLE IF EXISTS Flight;
CREATE TABLE `flight` (
                          `flight_id` INT unsigned NOT NULL AUTO_INCREMENT,
                          `flight_number` VARCHAR(10) NOT NULL,
                          `airplane_id` VARCHAR(15) NOT NULL,
                          `depart_airport_id` SMALLINT unsigned NOT NULL,
                          `arrival_airport_id` SMALLINT unsigned NOT NULL,
                          `depart_datetime` DATETIME NOT NULL,
                          `arrival_datetime` DATETIME NOT NULL,
                          `economy_price` DOUBLE(7, 2) unsigned NOT NULL,
	`business_price` DOUBLE(7, 2) unsigned NOT NULL,
	PRIMARY KEY (`flight_id`),

    CONSTRAINT fk_F_Airplane FOREIGN KEY (airplane_id)
    REFERENCES airplane (airplane_id)
    ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_DepartCity FOREIGN KEY (depart_airport_id)
    REFERENCES airport (airport_id)
    ON DELETE CASCADE ON UPDATE CASCADE,

    CONSTRAINT fk_ArriveCity FOREIGN KEY (arrival_airport_id)
    REFERENCES airport (airport_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- User
DROP TABLE IF EXISTS User;
CREATE TABLE `user` (
                        `user_id` INT unsigned AUTO_INCREMENT NOT NULL,
                        `first_name` VARCHAR(50) NOT NULL,
                        `last_name` VARCHAR(50) NOT NULL,
                        `phone_number` VARCHAR(20) NOT NULL,
                        `email` VARCHAR(50),
                        PRIMARY KEY (`user_id`)
);

-- Ticket
DROP TABLE IF EXISTS Ticket;
CREATE TABLE `ticket` (
                          `ticket_id` INT unsigned AUTO_INCREMENT NOT NULL,
                          `ticket_type` VARCHAR(15) NOT NULL,
                          `flight_id` INT unsigned NOT NULL,
                          `user_id` INT unsigned NOT NULL,
                          `date_of_purchase` DATETIME NOT NULL,
                          `seat_id` TINYINT unsigned NOT NULL,
                          `from` VARCHAR(100) NOT NULL,
                          `to` VARCHAR(100) NOT NULL,
                          `price` DOUBLE unsigned NOT NULL,
                          PRIMARY KEY (`ticket_id`),

                          CONSTRAINT fk_Flight FOREIGN KEY (flight_id)
                              REFERENCES flight (flight_id)
                              ON DELETE CASCADE ON UPDATE CASCADE,

                          CONSTRAINT fk_User FOREIGN KEY (user_id)
                              REFERENCES user (user_id)
                              ON DELETE CASCADE ON UPDATE CASCADE,

                          CONSTRAINT fk_Seat FOREIGN KEY (seat_id)
                              REFERENCES seat (seat_id)
                              ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE ticket AUTO_INCREMENT = 1110;