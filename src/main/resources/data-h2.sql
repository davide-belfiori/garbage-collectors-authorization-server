INSERT INTO  ROLE (ROLE_ID, ROLE) VALUES ('1', 'REGISTRATO');
INSERT INTO  ROLE (ROLE_ID, ROLE) VALUES ('2', 'AUTORITA');
INSERT INTO  ROLE (ROLE_ID, ROLE) VALUES ('3', 'AMMINISTRATORE');

INSERT INTO APP_USER (APP_USER_ID, APP_USER_NAME, APP_USER_PASSWORD) VALUES ('1', 'Mark', '$2a$04$e/xHti5h45foCkBTlEvnZegH5fkUORaJadCVQw91gpGydGO7OP3JS'  /* = test_psw */ );
INSERT INTO APP_USER (APP_USER_ID, APP_USER_NAME, APP_USER_PASSWORD) VALUES ('2', 'Tom', '$2a$04$e/xHti5h45foCkBTlEvnZegH5fkUORaJadCVQw91gpGydGO7OP3JS'  /* = test_psw */ );
INSERT INTO APP_USER (APP_USER_ID, APP_USER_NAME, APP_USER_PASSWORD) VALUES ('3', 'Travis', '$2a$04$e/xHti5h45foCkBTlEvnZegH5fkUORaJadCVQw91gpGydGO7OP3JS'  /* = test_psw */ );

INSERT INTO APP_USER_ROLE (APP_USER_ID, ROLE_ID) VALUES ('1','1');
INSERT INTO APP_USER_ROLE (APP_USER_ID, ROLE_ID) VALUES ('2','2');
INSERT INTO APP_USER_ROLE (APP_USER_ID, ROLE_ID) VALUES ('3','3');