/* Populate tables */
INSERT INTO characters (name) VALUES('Jeanne d''Arc');
INSERT INTO franchises (name, description) VALUES('Fate/Grand Order', 'RPG game on iOS and Android platforms. Setting based on Fate series originally started from Fate/stay night');
INSERT INTO character_franchise (character_id, franchise_id, rol) VALUES(1,1,'Secondary');


/* Populate tabla productos */
INSERT INTO companies (name, link) VALUES('Alter',null);
INSERT INTO figures (name, company_id) VALUES('Alter - Jeanne d''Arc 1/7',1);
INSERT INTO releases (price, release_date, figure_id) VALUES(255.0,NOW(),1);
INSERT INTO figure_character (character_id, figure_id) VALUES(1,1);
