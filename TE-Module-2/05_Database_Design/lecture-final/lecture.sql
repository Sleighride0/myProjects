DROP TABLE IF EXISTS person, purchase, person_purchase, artist, artwork, purchase_artwork;
CREATE TABLE person(
	person_id serial,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	street_name varchar (95),
	city varchar (35),
	district varchar (50),
	postal_code varchar (20),
	cell_phone bigint,
	alternate_phone bigint,
	CONSTRAINT pk_person_id PRIMARY KEY (person_id)
);

CREATE TABLE purchase(
	purchase_id SERIAL PRIMARY KEY,
	sell_date date,
	sale_price money
);

CREATE TABLE person_purchase(
	person_id int NOT NULL,
	purchase_id int NOT NULL,
	CONSTRAINT pk_person_purchase PRIMARY KEY (person_id, purchase_id),
	CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES person (person_id),
	CONSTRAINT fk_purchase_id FOREIGN KEY (purchase_id) REFERENCES purchase (purchase_id)
);

CREATE TABLE artist(
	artist_id serial PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL
);

CREATE TABLE artwork(
	artwork_id SERIAL PRIMARY KEY,
	artist_id int,
	title varchar(100),
	acquire_date date,
	CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
);

CREATE TABLE purchase_artwork(
	purchase_id int,
	artwork_id int,
	CONSTRAINT pk_purchase_artwork PRIMARY KEY (purchase_id, artwork_id),
	CONSTRAINT fk_purchase_id FOREIGN KEY (purchase_id) REFERENCES purchase(purchase_id),
	CONSTRAINT fk_artwork_id FOREIGN KEY (artwork_id) REFERENCES artwork(artwork_id)
);

INSERT INTO person(first_name, last_name, street_name, city, district, postal_code, cell_phone)
VALUES('Elizabeth', 'Jackson', '123 - 4th Avenue', 'Fonthill', 'ON', 'L3J4S4', 206286783 );

INSERT INTO artist(first_name, last_name)VALUES('Carol', 'Channing'), ('Dennis', 'Frings');

INSERT INTO artwork(artist_id, title, acquire_date)VALUES(01, 'Laugh with Teeth', '2000-09-17'),(02, 'At the Movies', '2002-02-14');

