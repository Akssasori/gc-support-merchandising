-- -----------------------------------------------------
-- Data for table creative_type
-- -----------------------------------------------------
START TRANSACTION;

INSERT INTO program (id, program) VALUES ('Mais voce');
INSERT INTO program (id, program) VALUES ('Caldeirao');
INSERT INTO program (id, program) VALUES ('Encontro');

COMMIT;

--START TRANSACTION;
--
--INSERT INTO creative_type (id, name) VALUES (1, 'Video');
--
--COMMIT;
--
--
---- -----------------------------------------------------
---- Data for table event_type
---- -----------------------------------------------------
--START TRANSACTION;
--
--INSERT INTO event_type (id, name) VALUES (1, 'Entrega do criativo');
--INSERT INTO event_type (id, name) VALUES (2, 'Complemento de abrangência');
--INSERT INTO event_type (id, name) VALUES (3, 'Reprovação do criativo para o player');
--INSERT INTO event_type (id, name) VALUES (4, 'Aprovação do criativo para o player');
--INSERT INTO event_type (id, name) VALUES (5, 'Confirmação de Entrega Cloud');
--
--COMMIT;
--
--
---- -----------------------------------------------------
---- Data for table event_status
---- -----------------------------------------------------
--START TRANSACTION;
--
--INSERT INTO event_status (id, name) VALUES (1, 'Pendente');
--INSERT INTO event_status (id, name) VALUES (2, 'Entregue');
--INSERT INTO event_status (id, name) VALUES (3, 'Error tentiva entrega');
--INSERT INTO event_status (id, name) VALUES (4, 'Não entregue');
--
--COMMIT;
--
---- -----------------------------------------------------
---- Data for table creative_type
---- -----------------------------------------------------
--START TRANSACTION;
--
--INSERT INTO creative_type (id, name) VALUES (1, 'Vídeo');
--
--
--COMMIT;
--
---- -----------------------------------------------------
---- Data for table player
---- -----------------------------------------------------
--START TRANSACTION;
--
--/*PRODUÇÃO*/
----INSERT INTO player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) VALUES (1,'ADSTREAM','adstream','https://a5.adstream.com/globo/api','globo','password',now(),'s6BhdRkqt3','gX1fBat3bV',1,1,1,1);
----INSERT INTO player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) VALUES (2,'ADTOOX','adtoox','https://br-globo-api.adtoox.com/v1','opec@tvglobo.com.br','D#ke4xc!f2',now(),'globo','843uhkGSDFK#',1,1,1,0);
----INSERT INTO player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) VALUES (3,'VATI','casavaticano','https://gw.casavaticano.com.br','Globo','Gl0b0#123',now(),'Globo','$1$w24Qs3SOZ',1,1,1,0);
----INSERT INTO player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) VALUES (4,'ZARPA','avzarpa','https://latam.peachvideo.com/api/Globo','br_globo@amasv.com','ZD9PPzua7Epx6U5u',now(),'API','zN3n8V6z857kzdjm',1,1,1,0);
----INSERT INTO player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) VALUES (5,'GLOBOSIM','globosim','https://api.prd.negocios.tvglobo.com.br/portal/player-gsim','gmid','opec1',now(),'player-gmid',1,1,1,1,1);
--
--/*HOMOLOGAÇÃO*/
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (1,'ADSTREAM','adstream','http://10.19.147.49:8080','globo','password',now(),'s6BhdRkqt3','gX1fBat3bV',1,1,1,1);
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (2,'ADTOOX','adtoox','https://br-globo-api.adtoox.com/v1','opec@tvglobo.com.br','D#ke4xc!f2',now(),'globo','843uhkGSDFK#',1,1,1,1);
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (3,'VATI','casavaticano','https://gw.casavaticano.com.br','Globo','Gl0b0#123',now(),'Globo','$1$w24Qs3SOZ',1,1,1,1);
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (4,'ZARPA','avzarpa','https://www.amasv.com/api/Globo','br_globo@amasv.com','ZD9PPzua7Epx6U5u',now(),'API','zN3n8V6z857kzdjm',1,1,1,1);
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (5,'APP SIM','player5','https://api.dev.negocios.tvglobo.com.br/portal/player-gsim','gmid','Globo@123',now(),'player-gmid',1,1,1,1,1);
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (6,'Live Brasil','livebrasil','https://livebrasil.tv.br/v1','tvglobo-api','Afepw_bs9geuj1R5cAUbryVfrTrg',now(),'tvglobo','AUbryVfrTrgbs9geuj1R5c',1,1,1,1);
--
--Insert into player(id, name, siscom_user, url_ws, user_ws, password_ws,  inserted, api_client_id, api_client_secret, use_new_windows, is_active, use_cloud_material, use_retransmission_cloud ) values (100,'Teste Globo DEV','globo','https://globo/v1','tvglobo-api','Afepw_bs9geuj1R5cAUbryVfrTrg',now(),'tvglobo','AUbryVfrTrgbs9geuj1R5c',1,1,1,1);
--COMMIT;