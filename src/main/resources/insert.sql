/* Populate tables */
INSERT INTO characters (name) VALUES('Jeanne d''Arc');
INSERT INTO franchises (name, description) VALUES('Fate/Grand Order', 'RPG game on iOS and Android platforms. Setting based on Fate series originally started from Fate/stay night');
INSERT INTO character_franchise (character_id, franchise_id, rol) VALUES(1,1,'Secondary');


/* Populate tabla productos */
INSERT INTO companies (name, link) VALUES('Alter',null);
INSERT INTO figures (name, company_id) VALUES('Alter - Jeanne d''Arc 1/7',1);
INSERT INTO releases (price, release_date, figure_id) VALUES(255.0,NOW(),1);
INSERT INTO figure_character (character_id, figure_id) VALUES(1,1);


INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('andres', 'aarchilla21@gmail.com', null, null,  '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('ruanMei', 'ruanmei@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO roles (authority) VALUES('ADMIN');
INSERT INTO roles (authority) VALUES('USER');
INSERT INTO user_role (user_id, role_id) VALUES(1, 1);
INSERT INTO user_role (user_id, role_id) VALUES(2, 2);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('Bennett', 'bennett@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('Fischl', 'fischl@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('Jean', 'jean@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('Lisa', 'lisa@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('Diluc', 'diluc@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO users (username, email, avatar, banner, password, enabled) VALUES('Kaeya', 'kaeya@gmail.com', null, null, '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG', 1);
INSERT INTO user_role (user_id, role_id) VALUES(3, 2);
INSERT INTO user_role (user_id, role_id) VALUES(4, 2);
INSERT INTO user_role (user_id, role_id) VALUES(5, 2);
INSERT INTO user_role (user_id, role_id) VALUES(6, 2);
INSERT INTO user_role (user_id, role_id) VALUES(7, 2);
INSERT INTO user_role (user_id, role_id) VALUES(8, 2);


INSERT INTO figure_user_like (figure_id, user_id ) VALUES(1, 3);
INSERT INTO figure_user_like (figure_id, user_id ) VALUES(1, 4);
INSERT INTO figure_user_like (figure_id, user_id ) VALUES(1, 5);
INSERT INTO figure_user_like (figure_id, user_id ) VALUES(1, 6);
INSERT INTO figure_user_like (figure_id, user_id ) VALUES(1, 7);
INSERT INTO figure_user_like (figure_id, user_id ) VALUES(1, 8);
