DROP TABLE IF EXISTS person_purchase, purchase, person, artist, inventory, purchase_inventory;

CREATE TABLE person ( 
	person_id serial, 
	first_name VARCHAR (50) NOT NULL,
	last_name VARCHAR (100) NOT NULL,
	street_name varchar (95),
	city varchar (35),
	district VARCHAR (50),
	postal_code VARCHAR (20),
	cell_phone bigint,
	alternate_phone bigint,
	CONSTRAINT pk_person_id PRIMARY KEY (person_id)
);

CREATE TABLE purchase (
	purchase_id serial,
	sell_date date,
	sale_price money,
	CONSTRAINT pk_purchase_id PRIMARY KEY (purchase_id)
);	

CREATE TABLE person_purchase (
	person_id int NOT NULL,
	purchase_id int NOT NULL,
	CONSTRAINT pk_person_purchase PRIMARY KEY (person_id, purchase_id),
	CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES person (person_id),
	CONSTRAINT fk_purchase_id FOREIGN KEY (purchase_id) REFERENCES purchase (purchase_id)
);
CREATE TABLE artist (
	artist_id serial PRIMARY KEY,
	first_name varchar (50) NOT NULL,
	last_name varchar (50) NOT NULL
);

CREATE TABLE inventory (
	artwork_id serial PRIMARY KEY,
	artist_id int NOT NULL,
	title varchar (100),
	aquire_date date,
	CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artist (artist_id)
);

CREATE TABLE purchase_inventory(
	purchase_id int,
	artwork_id int,
	CONSTRAINT pk_purchase_artwork PRIMARY KEY (purchase_id, artwork_id),
	CONSTRAINT fk_purchase_id FOREIGN KEY (purchase_id) REFERENCES purchase (purchase_id),
	CONSTRAINT fk_artwork_id FOREIGN KEY (artwork_id) REFERENCES inventory (artwork_id)
);
SELECT * FROM person
INSERT INTO person (first_name, last_name, street_name, city, district, postal_code, cell_phone)
VALUES ('Jon', 'Johnson', '1 State St', 'Columbus', 'OH', '43232', 6148675309)