CREATE DATABASE menu;
USE menu;

CREATE TABLE meat(
  id SERIAL PRIMARY KEY,
  title CHARACTER VARYING (128) UNIQUE NOT NULL,
  calories INTEGER NOT NULL,
  createdDateDay INTEGER NOT NULL,
  createdDateMonth INTEGER NOT NULL,
  createdDateYear INTEGER NOT NULL,
  validTime INTEGER NOT NULL,
  animal CHARACTER VARYING (128) NOT NULL,
  bodyPart CHARACTER VARYING (128) NOT NULL
);


insert into meat (title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, animal, bodyPart) values
  ('Teriaki chicken', 115, 5, 12, 2018, 5, 'chicken', 'leg'),
  ('Beef in Bear', 140, 5, 11, 2018, 5, 'Beef', 'head');


CREATE TABLE souce(
  id SERIAL PRIMARY KEY,
  title CHARACTER VARYING (128) UNIQUE NOT NULL,
  calories INTEGER NOT NULL,
  createdDateDay INTEGER NOT NULL,
  createdDateMonth INTEGER NOT NULL,
  createdDateYear INTEGER NOT NULL,
  validTime INTEGER NOT NULL,
  sourness CHARACTER VARYING (128) NOT NULL,
  sweetness CHARACTER VARYING (128) NOT NULL,
  salty CHARACTER VARYING (128) NOT NULL
);


insert into souce (title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, sourness, sweetness, salty) values
  ('Garlik', 150, 5, 8, 2018, 50, 'none', 'low', 'low'),
  ('Soy', 140, 5, 11, 2018, 53, 'low', 'none', 'high');


CREATE TABLE vegetables(
  id SERIAL PRIMARY KEY,
  title CHARACTER VARYING (128) UNIQUE NOT NULL,
  calories INTEGER NOT NULL,
  createdDateDay INTEGER NOT NULL,
  createdDateMonth INTEGER NOT NULL,
  createdDateYear INTEGER NOT NULL,
  validTime INTEGER NOT NULL,
  type CHARACTER VARYING (128) NOT NULL,
  productionType CHARACTER VARYING (128) NOT NULL
);


insert into vegetables (title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, type, productionType) values
  ('Peekles', 15, 5, 12, 2018, 5, 'cucomber', 'natural'),
  ('chery', 140, 5, 11, 2018, 15, 'tomato', 'production');


SELECT title,calories,createdDateDay, createdDateMonth, createdDateYear, validTime, animal, bodyPart FROM menu.meat;

UPDATE souce
SET createdDateMonth = 11
WHERE title = 'Soy';