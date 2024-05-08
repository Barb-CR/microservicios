INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('Barb', '$2a$10$tlEJ8klLHMgS0045vn8Q1O16BsIZoF.1nGLIkrVhS.m1gyC8iB4X6', 1, 'Barbara', 'Ramos', 'barbaracantu@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('yipi', '$2a$10$4S1vuHWmwyO2bnFzT.KDGeJbdajqFT9qJQz3ox5.95Ttvu9WagDni', 1, 'Juan', 'Ramos', 'juan@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO usuarios_to_roles (user_id, roles_id) VALUES (2, 2);
INSERT INTO usuarios_to_roles (user_id, roles_id) VALUES (2, 1);