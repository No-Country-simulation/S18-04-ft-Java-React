INSERT INTO permissions (permission_id,permission_name) VALUES ('7c102ad8-59e4-4e93-a56b-e4033de41745','Write');
INSERT INTO roles (role_id,role_description,role_name) VALUES('340ddc49-1214-4e00-9a77-2334334b23d3','Is a description','ROLE_USER');
INSERT INTO role_permission(role_id,permission_id) VALUES('340ddc49-1214-4e00-9a77-2334334b23d3','7c102ad8-59e4-4e93-a56b-e4033de41745');

INSERT INTO users (user_id,email,password) VALUES ('2efb16c6-f56c-4baa-bdea-cd2c8f372725','prueba@gmail.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('2efb16c6-f56c-4baa-bdea-cd2c8f372725','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url, profile_name,profile_lastname) VALUES ('5c3b8b6a-0e2e-4b9e-9a7b-7b3e5e4b8a3b','2efb16c6-f56c-4baa-bdea-cd2c8f372725','https://t2.uc.ltmcdn.com/es/posts/0/3/2/como_alejarse_de_una_persona_toxica_45230_orig.jpg','https://github.com/aasdasd','https://www.linkedin.com/in/asdasdasd/','nombreprueba','apellidoprueba');