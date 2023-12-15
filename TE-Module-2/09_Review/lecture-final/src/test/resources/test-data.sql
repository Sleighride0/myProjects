BEGIN TRANSACTION;

DROP TABLE IF EXISTS category_venue, category, reservation, space, venue, city, state CASCADE;

CREATE TABLE venue (
  id SERIAL PRIMARY KEY,
  name VARCHAR(120) NOT NULL,
  city_id INTEGER NOT NULL,
  description VARCHAR(500) NOT NULL
);

CREATE TABLE space (
  id SERIAL PRIMARY KEY,
  venue_id INTEGER NOT NULL,
  name VARCHAR(80) NOT NULL,
  is_accessible BOOLEAN NOT NULL DEFAULT false,
  open_from INTEGER NULL,
  open_to INTEGER NULL,
  daily_rate MONEY NOT NULL,
  max_occupancy INTEGER NOT NULL
);

CREATE TABLE city (
  id SERIAL PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  state_abbreviation CHAR(2) NOT NULL
);

CREATE TABLE state (
  abbreviation CHAR(2) PRIMARY KEY,
  name VARCHAR(15) NOT NULL
);

CREATE TABLE category (
  id SERIAL PRIMARY KEY,
  name VARCHAR(80)
);

CREATE TABLE category_venue (
  venue_id INTEGER NOT NULL,
  category_id INTEGER NOT NULL,

  PRIMARY KEY (venue_id, category_id)
);

CREATE TABLE reservation (
  reservation_id SERIAL PRIMARY KEY,
  space_id INTEGER NOT NULL,
  number_of_attendees INTEGER NOT NULL DEFAULT 100,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  reserved_for VARCHAR(100) NOT NULL
);

-- Hidden Owl Eatery
INSERT INTO venue (id, name, city_id, description) VALUES (1, 'Hidden Owl Eatery', 1, 'This venue has plenty of "property" to enjoy. Roll the dice and check out all of our spaces.');

-- Painted Squirrel Club
INSERT INTO venue (id, name, city_id, description) VALUES (2, 'Painted Squirrel Club', 1, 'Lock in your reservation now! This venue has dungeons and an underground theme. Not for the faint of heart!');

-- Rusty Farmer Spot
INSERT INTO venue (id, name, city_id, description) VALUES (3, 'Rusty Farmer Spot', 1, 'This rustic and seasonal spot is fun year-round. Great for equinox celebrations!');

INSERT INTO space (id, venue_id, name, is_accessible, open_from, open_to, daily_rate, max_occupancy) VALUES (1, 1, 'Boardwalk', TRUE, NULL, NULL, '5250', 210);
INSERT INTO space (id, venue_id, name, is_accessible, open_from, open_to, daily_rate, max_occupancy) VALUES (2, 1, 'Park Place', TRUE, 2, 8, '900', 60);
INSERT INTO space (id, venue_id, name, is_accessible, open_from, open_to, daily_rate, max_occupancy) VALUES (3, 1, 'Marvin Gardens', TRUE, NULL, NULL, '1650', 110);

INSERT INTO city (id, name, state_abbreviation) VALUES (1, 'Bona', 'MI');
INSERT INTO city (id, name, state_abbreviation) VALUES (2, 'Srulbury', 'OH');
INSERT INTO city (id, name, state_abbreviation) VALUES (3, 'Yepford', 'IA');
INSERT INTO city (id, name, state_abbreviation) VALUES (4, 'Andoshire', 'PA');

-- State
INSERT INTO state (abbreviation, name) VALUES ('MI', 'Michigan');
INSERT INTO state (abbreviation, name) VALUES ('OH', 'Ohio');
INSERT INTO state (abbreviation, name) VALUES ('IA', 'Iowa');
INSERT INTO state (abbreviation, name) VALUES ('PA', 'Pennsylvania');

-- Category
INSERT INTO category (id, name) VALUES (1, 'Family Friendly');
INSERT INTO category (id, name) VALUES (2, 'Outdoors');
INSERT INTO category (id, name) VALUES (3, 'Historic');

-- Category_Venue
INSERT INTO category_venue (venue_id, category_id) VALUES (1, 1);
INSERT INTO category_venue (venue_id, category_id) VALUES (1, 6);
INSERT INTO category_venue (venue_id, category_id) VALUES (3, 1);
INSERT INTO category_venue (venue_id, category_id) VALUES (3, 2);
INSERT INTO category_venue (venue_id, category_id) VALUES (3, 4);

ALTER TABLE venue ADD FOREIGN KEY (city_id) REFERENCES city(id);
ALTER TABLE space ADD FOREIGN KEY (venue_id) REFERENCES venue(id);
ALTER TABLE city ADD FOREIGN KEY (state_abbreviation) REFERENCES state(abbreviation);
ALTER TABLE category_venue ADD FOREIGN KEY (venue_id) REFERENCES venue(id);
ALTER TABLE category_venue ADD FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE reservation ADD FOREIGN KEY (space_id) REFERENCES space(id);

COMMIT;