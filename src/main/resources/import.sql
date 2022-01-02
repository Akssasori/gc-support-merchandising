-- -----------------------------------------------------
-- Data for table program
-- -----------------------------------------------------
--START TRANSACTION;

INSERT INTO program (id, name) VALUES (1,'Programa 1');
INSERT INTO program (id, name) VALUES (2,'Programa 2');
INSERT INTO program (id, name) VALUES (3,'Programa 3');
INSERT INTO program (id, name) VALUES (4,'CALDEIRAO DO HULK');

INSERT INTO client (id, name, id_siscom) VALUES (1,'123 VIAGENS E TURISMO LTDA',419043);
INSERT INTO client (id, name, id_siscom) VALUES (2,'3 M DO BRASIL',115198);
INSERT INTO client (id, name, id_siscom) VALUES (3,'3 MILENIO',441695);
INSERT INTO client (id, name, id_siscom) VALUES (4,'lucas',1);

INSERT INTO agency (id, name, id_siscom) VALUES (1,'2 U PROPAGANDA E COMUNICACAO',390798);
INSERT INTO agency (id, name, id_siscom) VALUES (2,'ADVANCE',122816);
INSERT INTO agency (id, name, id_siscom) VALUES (3,'BETC BRASIL',380483);
INSERT INTO agency (id, name, id_siscom) VALUES (4,'FLASH',44043);

--INSERT INTO action (description, duration, end_time, paytvflag, review_date, start_time, type_action, agency_id, client_id, product_id, program_id) VALUES('ACAO COM LUCIANO E PLATEIA', 60000000000, '2021-12-25T07:57:00', false, '2022-01-01T21:32:21', '2021-12-25T07:56:00', 'ACAO', 4, 3, 1, 3);

--COMMIT;

--INSERT INTO gc_support_merchan.`action`
--(id, description, duration, end_time, paytvflag, review_date, start_time, type_action, agency_id, client_id, product_id, program_id)
--VALUES(1, 'acao com luciano e plateia', 60000000000, '2021-12-25 10:57:00', 0, '2022-01-02 00:32:21', '2021-12-25 10:56:00', 'ACAO', 4, 3, 1, 4);