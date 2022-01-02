-- -----------------------------------------------------
-- Data for table program
-- -----------------------------------------------------
--START TRANSACTION;

INSERT INTO program (id, name) VALUES (1,'Programa 1');
INSERT INTO program (id, name) VALUES (2,'Programa 2');
INSERT INTO program (id, name) VALUES (3,'Programa 3');





INSERT INTO client (id, name, id_siscom) VALUES (1,'123 VIAGENS E TURISMO LTDA',419043);
INSERT INTO client (id, name, id_siscom) VALUES (2,'3 M DO BRASIL',115198);
INSERT INTO client (id, name, id_siscom) VALUES (3,'3 MILENIO',441695);
INSERT INTO client (id, name, id_siscom) VALUES (4,'lucas',1);

INSERT INTO agency (id, name, id_siscom) VALUES (1,'2 U PROPAGANDA E COMUNICACAO',390798);
INSERT INTO agency (id, name, id_siscom) VALUES (2,'ADVANCE',122816);
INSERT INTO agency (id, name, id_siscom) VALUES (3,'BETC BRASIL',380483);
INSERT INTO agency (id, name, id_siscom) VALUES (4,'FLASH',44043);


--COMMIT;