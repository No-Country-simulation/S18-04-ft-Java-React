CREATE EXTENSION IF NOT EXISTS "pgcrypto";
---------------- Main Dependencies ----------------
INSERT INTO permissions (permission_id,permission_name) VALUES ('7c102ad8-59e4-4e93-a56b-e4033de41745','Write');
INSERT INTO roles (role_id,role_description,role_name) VALUES('340ddc49-1214-4e00-9a77-2334334b23d3','Is a description','ROLE_USER');
INSERT INTO role_permission(role_id,permission_id) VALUES('340ddc49-1214-4e00-9a77-2334334b23d3','7c102ad8-59e4-4e93-a56b-e4033de41745');



------------------- Dependencies -------------------
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('0945d50a-65d9-4e00-bdd4-ff20268455e9', 'React', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('324f9dc7-560b-4741-bf95-c0bc4d6ab902', 'Angular', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('31bf4ecc-c4ac-4fbe-a6ff-652c8dcebc01', 'Nextjs', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('1352d700-58f6-4b43-8267-65873e52aa7f', 'Vue.js', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('58a4b018-6925-43c1-9db6-963a4f16d2ad', 'Svelte', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('00be320a-d284-48cb-9ae9-ffe27fded064', 'Expressjs', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('38b0c497-9de6-4f3f-90eb-57a641accfad', 'Django', 'Backend', 'Python');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('6f5598b1-60a5-4c66-bb6b-09e5c7417529', 'Symfony', 'Backend', 'PHP');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('d160babf-580b-4a42-93ff-ce84df20b724', 'FastApi', 'Backend', 'Python');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('30b439ae-9846-47d9-8c49-5fda08f1e313', 'Spring Boot', 'Backend', 'Java');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('6fdc3125-073e-4bed-8430-be56a8861301', 'Ruby on Rails', 'Backend', 'Ruby');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('5c775c2a-1547-48b9-adf9-6fce95923845', 'React Native', 'Mobile', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('511e7dc6-b76e-409a-ae30-0680f5df71b9', '.NET', 'Backend', 'C#');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('9c8e334c-9e90-42dc-b1f7-864710aaab6f', 'Laravel', 'Backend', 'PHP');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('153de720-ea4a-4f74-b498-377b5875faf6', 'Flask', 'Backend', 'Python');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('32fb4566-44ee-4986-8128-46a7cd32974b', 'Gin', 'Backend', 'Golang');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('e1377717-d27f-4f32-a841-a6025c165df5', 'Quarkus', 'Backend', 'Java');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('996ad182-d190-4aa8-87b7-ee310727e56e', 'Flutter', 'Mobile', 'Dart');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('df911a98-ea07-4f3a-8920-5ae9c902ae19', 'Qwik', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('003ff117-485d-437f-bb40-5ed1230b2688', 'Android', 'Mobile', 'Kotlin');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('bf88d8ce-3851-4c90-903e-60823a4d849d', 'Nest', 'Backend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('bf0dc911-7573-4ef7-bb33-6f9d71f5e029', 'Node', 'Backend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('55e79657-7c95-41f1-bd15-f26a5a31e14d', 'Fiber', 'Backend', 'Golang');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('ea18ed4e-a71e-4254-83bd-c3aec0861762', 'Nuxt', 'Frontend', 'Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('99747231-b4c4-4583-b307-32b30eb98f10', 'Micronaut', 'Backend', 'Java');
INSERT INTO languages (language_id, language_name) VALUES ('3f81bee3-099a-446a-b2b6-c135ee116b92', 'JavaScript');
INSERT INTO languages (language_id, language_name) VALUES ('5ad6cd43-8dd0-4d72-8dec-e029e29a1d33', 'TypeScript');
INSERT INTO languages (language_id, language_name) VALUES ('2d23b78b-2577-4721-8d1c-303418ce190d', 'Java');
INSERT INTO languages (language_id, language_name) VALUES ('51a3bdca-00b2-4f34-99d7-08b21ce0e374', 'Python');
INSERT INTO languages (language_id, language_name) VALUES ('7814ecd7-7e1f-47a8-a2e8-db358614e59c', 'C#');
INSERT INTO languages (language_id, language_name) VALUES ('0abf2fc8-7e22-448e-ab61-9f1b9114d2e8', 'PHP');
INSERT INTO languages (language_id, language_name) VALUES ('e07b24b1-0287-4990-9bac-ee7941dfc34a', 'Ruby');
INSERT INTO languages (language_id, language_name) VALUES ('1b8ab760-38f7-4bbf-a5d0-e230807e0e3f', 'Dart');
INSERT INTO languages (language_id, language_name) VALUES ('39431bc6-ba80-4b22-8d7e-073e144e526a', 'Golang');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('038eff46-b858-4710-9fda-2be48db983fe', 'Desarrolla soluciones con tecnologias como Java, React, Node, Python.','WebApp');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('447ef4a1-06d4-4a05-b983-e3d4cf467f5b', 'Utiliza plataformas como Bubble, Webflow o Zapier para construir MVPs sin codigo. No se requieren conocimientos previos','NoCode');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('be9716f2-3711-4dd7-9360-4080dd475401', 'Construye aplicaciones mobile con tecnologías como Swift (para iOS), Kotlin (para Android), React Native.','Mobile');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('a9b5cb7a-8eed-458b-9627-a1e92d0623aa', 'Centrado en el análisis y gestión de datos, utilizando herramientas especializadas para interpretar y presentar datos de manera estratégica.','Data Bi');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('d5e737ac-316e-46fb-92a6-77aa149ee8e6', 'Backend', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('54d5c728-3757-4968-a35d-28edb51b2795', 'Frontend', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('151e9ec2-921d-43a4-9a57-b12319c99439', 'UX/UI', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('b6daedcf-b311-473d-b8e1-33354c2220e6', 'QA Tester', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('709814fb-cd6a-47b1-8ff6-83db4f38bc72', 'DevOps', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('8f562cce-cfac-4452-a25e-e1784a88a15e', 'Project Manager', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('b3822e16-e34f-4c88-80db-602cc56a117e', 'Mobile Dev', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('001a753a-8f7d-465f-aeb6-e930c5e4c45c', 'Automation', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('12c4a4fe-2136-451d-ba1f-00d256c13415', 'Data Analyst', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('0e7f8fe7-1086-4c51-8325-2c2dfa6834e8', 'Data Engineer', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('6b347672-8cd3-4854-872a-7d3e517b272c', 'Data Scientist', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id, role_type_name, project_type_id) VALUES ('09ba214a-2bb6-4ead-9a7c-d68076b82880', 'Machine Learning', '038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO events (event_id, event_name, event_type, event_description, event_participant, event_date_start, event_date_end) VALUES ('a44913b7-34ca-429f-821f-ae8732423c9d', 'S17', 'Selection', 'Seleccionado S19-20', 0, '2024-08-04', '2024-09-06');
INSERT INTO events (event_id, event_name, event_type, event_description, event_participant, event_date_start, event_date_end) VALUES ('28f1d641-8e7d-4f05-b33c-7fab6b4b6840', 'S18', 'Selection', 'Seleccionado S19-22', 0, '2024-10-04', '2024-11-06');
INSERT INTO events (event_id, event_name, event_type, event_description, event_participant, event_date_start, event_date_end) VALUES ('ddd0643e-ea4c-4aab-89fc-5739d116483a', 'C21', 'Cohorte', 'Cohorte S21-24', 0, '2024-11-04', '2024-12-06');
INSERT INTO events (event_id, event_name, event_type, event_description, event_participant, event_date_start, event_date_end) VALUES ('c5d56816-1743-47cc-8b68-ee8772f950ee', 'S19', 'Selection', 'Seleccionado S19-24', 0, '2024-11-04', '2024-12-07');


---------------------- UX/UI ----------------------
INSERT INTO users (user_id,email,password) VALUES ('bab2772a-3ff7-48ab-aed4-1d160aa5d44c','sherrisanchez@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('bab2772a-3ff7-48ab-aed4-1d160aa5d44c','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('ed2d9c06-ef73-4f5e-b75f-ac589f2f097c','bab2772a-3ff7-48ab-aed4-1d160aa5d44c','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Charles','Booth');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('0ecd5feb-5742-42b5-b80c-93283f085eaf', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', null, 'ed2d9c06-ef73-4f5e-b75f-ac589f2f097c', 'a44913b7-34ca-429f-821f-ae8732423c9d');

INSERT INTO users (user_id,email,password) VALUES ('f3feb0c3-38e2-4c6d-8536-2faa5a68d67e','ashley04@example.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('f3feb0c3-38e2-4c6d-8536-2faa5a68d67e','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('fb1ad524-d240-4a04-a0c7-2e54d2a9d3ef','f3feb0c3-38e2-4c6d-8536-2faa5a68d67e','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Deborah','Simpson');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('a13c76b3-11ef-44f9-80e3-11e840ee70fa', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', null, 'fb1ad524-d240-4a04-a0c7-2e54d2a9d3ef', 'a44913b7-34ca-429f-821f-ae8732423c9d');

INSERT INTO users (user_id,email,password) VALUES ('464282f2-00dd-4bc8-9803-51cfa6a76bac','dicksonmatthew@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('464282f2-00dd-4bc8-9803-51cfa6a76bac','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('b9fd7ab6-cc27-4ce3-9460-fe8c7ed0f73f','464282f2-00dd-4bc8-9803-51cfa6a76bac','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Tyler','English');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('89084a0b-e4df-43d9-9252-7fc5f6bfde61', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', null, 'b9fd7ab6-cc27-4ce3-9460-fe8c7ed0f73f', 'a44913b7-34ca-429f-821f-ae8732423c9d');

INSERT INTO users (user_id,email,password) VALUES ('bc137076-a84e-495f-92dd-281a95d9a17b','lmiller@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('bc137076-a84e-495f-92dd-281a95d9a17b','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('f3a43523-2fcd-4cf9-badb-33403260605e','bc137076-a84e-495f-92dd-281a95d9a17b','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Joseph','Patel');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('bb0c8e86-d127-4ccc-9dc3-9d219e2d3143', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', null, 'f3a43523-2fcd-4cf9-badb-33403260605e', 'a44913b7-34ca-429f-821f-ae8732423c9d');


--------------------- Frontend ---------------------
INSERT INTO users (user_id,email,password) VALUES ('f5b52d97-3576-49cc-9f42-e35d7175fcd5','stokessamuel@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('f5b52d97-3576-49cc-9f42-e35d7175fcd5','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('ddf29012-6c1c-48f1-925c-b68100c3baf5','f5b52d97-3576-49cc-9f42-e35d7175fcd5','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Brandi','Stephens');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('aa50d38d-4552-4eb1-bd01-b6bf100e89b9', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '3f81bee3-099a-446a-b2b6-c135ee116b92', 'ddf29012-6c1c-48f1-925c-b68100c3baf5', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('9f1fbc34-3ade-402c-aa9c-766717931af7','brian25@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('9f1fbc34-3ade-402c-aa9c-766717931af7','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('9e492b36-bb30-42de-9938-f490641359e4','9f1fbc34-3ade-402c-aa9c-766717931af7','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Paula','Taylor');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('e5e90554-a4ab-40b3-8d6c-80606eef227f', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '5ad6cd43-8dd0-4d72-8dec-e029e29a1d33', '9e492b36-bb30-42de-9938-f490641359e4', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('171e4206-e5c7-4db4-ad51-667339b1b693','smithjuan@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('171e4206-e5c7-4db4-ad51-667339b1b693','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('95c710f0-a4c2-433f-874a-96befde84333','171e4206-e5c7-4db4-ad51-667339b1b693','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Wendy','Miller');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('cf4b8b35-516d-4581-a6ca-dc7c1f75e3b2', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '5ad6cd43-8dd0-4d72-8dec-e029e29a1d33', '95c710f0-a4c2-433f-874a-96befde84333', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('68a25905-cb74-4111-83be-917ade387925','mdominguez@example.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('68a25905-cb74-4111-83be-917ade387925','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('9146f7a9-f816-41be-8d48-3398c0bd38b8','68a25905-cb74-4111-83be-917ade387925','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Elizabeth','Fleming');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('8128de9a-85d2-4204-be36-dfbf00f0b035', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '3f81bee3-099a-446a-b2b6-c135ee116b92', '9146f7a9-f816-41be-8d48-3398c0bd38b8', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('2c5eb613-f2ec-420b-9c28-c934051fe806','jerry86@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('2c5eb613-f2ec-420b-9c28-c934051fe806','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('5e42ea13-8a44-4ba3-bfc1-02ce32d31b44','2c5eb613-f2ec-420b-9c28-c934051fe806','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Nicole','Johnson');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('22d67338-213e-45b8-ab79-5f59112ee16a', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '3f81bee3-099a-446a-b2b6-c135ee116b92', '5e42ea13-8a44-4ba3-bfc1-02ce32d31b44', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('c55d826d-4d89-482c-b0ba-6f400eaf6704','jeffreynguyen@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('c55d826d-4d89-482c-b0ba-6f400eaf6704','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('eba4bcc7-88ad-4af4-bf43-6325ae79146b','c55d826d-4d89-482c-b0ba-6f400eaf6704','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Louis','Shepherd');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('badadee2-a64a-4392-bd13-09927e456e45', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '3f81bee3-099a-446a-b2b6-c135ee116b92', 'eba4bcc7-88ad-4af4-bf43-6325ae79146b', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('89d66e85-7bd9-4272-b2c9-8622fe856d34','tateveronica@example.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('89d66e85-7bd9-4272-b2c9-8622fe856d34','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('76dd1c4b-b090-4164-9475-152a0c27a438','89d66e85-7bd9-4272-b2c9-8622fe856d34','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Patricia','Watson');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('7c3a1983-19e0-4614-bc26-4ddabf531bfb', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '3f81bee3-099a-446a-b2b6-c135ee116b92', '76dd1c4b-b090-4164-9475-152a0c27a438', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('b1500770-93c0-4b60-8740-af14dfeee853','wlambert@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('b1500770-93c0-4b60-8740-af14dfeee853','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('27632c0a-d04c-4e6a-821f-bc5533e77481','b1500770-93c0-4b60-8740-af14dfeee853','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Nicole','Gallegos');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('41ae9872-7e28-408d-9e6a-4526c1769e35', 'FullTime', False, '54d5c728-3757-4968-a35d-28edb51b2795', '3f81bee3-099a-446a-b2b6-c135ee116b92', '27632c0a-d04c-4e6a-821f-bc5533e77481', 'a44913b7-34ca-429f-821f-ae8732423c9d');


--------------------- Backend ---------------------
INSERT INTO users (user_id,email,password) VALUES ('b86242a6-7f2d-4351-8ecb-b51ec8ed3b0e','nscott@example.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('b86242a6-7f2d-4351-8ecb-b51ec8ed3b0e','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('327b39dd-10a3-4988-96f5-d8e945387be9','b86242a6-7f2d-4351-8ecb-b51ec8ed3b0e','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Robert','Jenkins');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('fc45f22e-6ef5-4a86-b649-47ae2325d628', 'FullTime', False, 'd5e737ac-316e-46fb-92a6-77aa149ee8e6', '3f81bee3-099a-446a-b2b6-c135ee116b92', '327b39dd-10a3-4988-96f5-d8e945387be9', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('f84775b7-9424-4774-979f-079de71263ed','brent00@example.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('f84775b7-9424-4774-979f-079de71263ed','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('3a9d4cf8-5f3e-4bb5-bdc7-a95d5125ff85','f84775b7-9424-4774-979f-079de71263ed','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Hannah','Miller');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('d20937a5-6a2f-473e-a581-3b6bda6bab6f', 'FullTime', False, 'd5e737ac-316e-46fb-92a6-77aa149ee8e6', '51a3bdca-00b2-4f34-99d7-08b21ce0e374', '3a9d4cf8-5f3e-4bb5-bdc7-a95d5125ff85', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('d485653a-1162-446e-98c7-9a744b05aad8','brittney47@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('d485653a-1162-446e-98c7-9a744b05aad8','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('ed2e747c-f2c4-4570-8fdc-5440cfb9912b','d485653a-1162-446e-98c7-9a744b05aad8','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Shannon','Foster');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('e3d97674-4af1-40a5-a225-cdad56654684', 'FullTime', False, 'd5e737ac-316e-46fb-92a6-77aa149ee8e6', '2d23b78b-2577-4721-8d1c-303418ce190d', 'ed2e747c-f2c4-4570-8fdc-5440cfb9912b', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('9c56f3c5-3dab-4e71-af1e-8d0fed84332f','brandongutierrez@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('9c56f3c5-3dab-4e71-af1e-8d0fed84332f','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('c9c24e26-5bd4-4a14-8b2e-8c538ecbe899','9c56f3c5-3dab-4e71-af1e-8d0fed84332f','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Brian','Wolf');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('d1c507d1-7abe-4a55-b153-4646147028eb', 'FullTime', False, 'd5e737ac-316e-46fb-92a6-77aa149ee8e6', '7814ecd7-7e1f-47a8-a2e8-db358614e59c', 'c9c24e26-5bd4-4a14-8b2e-8c538ecbe899', 'a44913b7-34ca-429f-821f-ae8732423c9d');


-------------------- QA Tester --------------------
INSERT INTO users (user_id,email,password) VALUES ('80b252f6-bd7c-489a-b0ff-3c1d31f8e451','tmonroe@example.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('80b252f6-bd7c-489a-b0ff-3c1d31f8e451','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('9f41dd88-57fa-4ebb-8f31-d8b000f0c00b','80b252f6-bd7c-489a-b0ff-3c1d31f8e451','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Jesse','Taylor');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('2acc3d5a-ba6d-43f2-94c9-8e6fed3b327d', 'FullTime', False, 'b6daedcf-b311-473d-b8e1-33354c2220e6', null, '9f41dd88-57fa-4ebb-8f31-d8b000f0c00b', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('bb42445e-a5f1-4d93-9c14-7ef03c303259','gloverlisa@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('bb42445e-a5f1-4d93-9c14-7ef03c303259','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('27260e2d-0ac9-4cc0-80b1-16a55abb73ce','bb42445e-a5f1-4d93-9c14-7ef03c303259','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Anthony','Holloway');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('71935a31-4c9d-4749-9906-6f94d6ae94aa', 'FullTime', False, 'b6daedcf-b311-473d-b8e1-33354c2220e6', null, '27260e2d-0ac9-4cc0-80b1-16a55abb73ce', 'a44913b7-34ca-429f-821f-ae8732423c9d');


----------------- Project Manager -----------------
INSERT INTO users (user_id,email,password) VALUES ('74469a4d-b517-4957-ae41-b5ab301e25df','robert02@example.org','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('74469a4d-b517-4957-ae41-b5ab301e25df','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('4b9fd554-eda5-4763-ab30-42bdd5d56493','74469a4d-b517-4957-ae41-b5ab301e25df','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Shelly','Davis');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('fd9ea7e7-18ce-4e23-9986-37378b5680a6', 'FullTime', False, '8f562cce-cfac-4452-a25e-e1784a88a15e', null, '4b9fd554-eda5-4763-ab30-42bdd5d56493', 'a44913b7-34ca-429f-821f-ae8732423c9d');
INSERT INTO users (user_id,email,password) VALUES ('2623eb1d-6823-4f48-966e-7b8753631bb8','smithbriana@example.net','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('2623eb1d-6823-4f48-966e-7b8753631bb8','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url,profile_name,profile_lastname) VALUES ('7bd78d94-f322-4b5c-9193-28a91e35addd','2623eb1d-6823-4f48-966e-7b8753631bb8','https://avatars.githubusercontent.com/u/16294803','https://github.com/asdasdasd','https://www.linkedin.com/in/asdasdasd','Kevin','Ramos');
INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('b856b2a3-b0ad-403f-ac8e-0a9e1c7013bb', 'FullTime', False, '8f562cce-cfac-4452-a25e-e1784a88a15e', null, '7bd78d94-f322-4b5c-9193-28a91e35addd', 'a44913b7-34ca-429f-821f-ae8732423c9d');


INSERT INTO users (user_id,email,password) VALUES ('2efb16c6-f56c-4baa-bdea-cd2c8f372725','prueba@gmail.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('2efb16c6-f56c-4baa-bdea-cd2c8f372725','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url, profile_name,profile_lastname) VALUES ('5c3b8b6a-0e2e-4b9e-9a7b-7b3e5e4b8a3b','2efb16c6-f56c-4baa-bdea-cd2c8f372725','https://t2.uc.ltmcdn.com/es/posts/0/3/2/como_alejarse_de_una_persona_toxica_45230_orig.jpg','https://github.com/aasdasd','https://www.linkedin.com/in/asdasdasd/','nombreprueba','apellidoprueba');

INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id,number_team,assigned) VALUES ('f11c3f5d-ca45-46ac-a8f4-0a1b00055ee7', 'FullTime', False, '8f562cce-cfac-4452-a25e-e1784a88a15e', null, '5c3b8b6a-0e2e-4b9e-9a7b-7b3e5e4b8a3b', 'a44913b7-34ca-429f-821f-ae8732423c9d',3,true);
INSERT INTO teams(team_id,event_record_id,team_number,whatsapp_url,team_name,project_name,meet_url) VALUES ('4dc28d2e-d2f7-43c9-92f0-2652b79bced8','b856b2a3-b0ad-403f-ac8e-0a9e1c7013bb',3,null,'S17-03-ft-Java-React',null,null);



-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--
-- ------ Stored Produced ----------------------
-- CREATE OR REPLACE PROCEDURE UpdateAssignedRecords(
--     IN eventNum UUID,
--     IN scheduleNom VARCHAR(30),
--     IN frameworkFront VARCHAR(30),
--     IN frontQuantity INTEGER,
--     IN backQuantity INTEGER,
--     IN qaQuantity INTEGER,
--     IN pmQuantity INTEGER,
--     IN uxQuantity INTEGER
-- )
--     LANGUAGE plpgsql
-- AS $$
-- DECLARE
--     team_counter INTEGER := 1;  -- Contador para el número de equipo
--     team_pk UUID;               -- Variable para almacenar el ID del nuevo equipo
-- BEGIN
--     LOOP
--         WITH eligible_records AS (
--             SELECT e.event_record_id, rt.role_type_name,
--                    ROW_NUMBER() OVER (PARTITION BY rt.role_type_name ORDER BY e.event_record_id) AS rn
--             FROM event_records e
--                      LEFT JOIN register_stack r ON r.event_record_id = e.event_record_id
--                      LEFT JOIN frameworks f ON f.framework_id = r.framework_id
--                      INNER JOIN languages l ON l.language_id = e.language_id
--                      INNER JOIN roles_type rt ON rt.role_type_id = e.role_type_id
--             WHERE e.schedule = scheduleNom
--               AND e.event_id = eventNum
--               AND e.assigned = FALSE
--               AND f.framework_name = frameworkFront
--         )
--         UPDATE event_records e
--         SET assigned = TRUE, number_team = team_counter
--         WHERE e.event_record_id IN (
--             SELECT event_record_id
--             FROM eligible_records
--             WHERE (role_type_name = 'Frontend' AND rn <= frontQuantity) OR
--                 (role_type_name = 'Backend' AND rn <= backQuantity) OR
--                 (role_type_name = 'UX/UI' AND rn <= uxQuantity) OR
--                 (role_type_name = 'Project Manager' AND rn <= pmQuantity) OR
--                 (role_type_name = 'QA Tester' AND rn <= qaQuantity)
--         );
--
--         -- Salir del bucle si no hay más registros con assigned = FALSE
--         EXIT WHEN NOT EXISTS (
--             SELECT 1
--             FROM event_records e
--             WHERE e.schedule = scheduleNom
--               AND e.event_id = eventNum
--               AND e.assigned = FALSE
--         );
--
--         -- Incrementar el contador del número de equipo
--         team_counter := team_counter + 1;
--     END LOOP;
-- END;
-- $$;
--
--
-- CREATE OR REPLACE PROCEDURE create_teams_and_participants(
--     IN event_pk UUID,
--     IN team_init VARCHAR
-- )
--     LANGUAGE plpgsql
-- AS $$
-- DECLARE
--     team_number INTEGER;
--     schedule VARCHAR;
--     new_team_id UUID;
-- BEGIN
--     FOR team_number IN
--         SELECT DISTINCT e.number_team
--         FROM event_records e
--         WHERE assigned = TRUE
--         LOOP
--             -- Generar un nuevo UUID para el equipo
--             new_team_id := gen_random_uuid();
--
--             -- Insertar el equipo en la tabla teams
--             INSERT INTO teams (team_id, meet_url, project_name, team_name, whatsapp_url, participant_id)
--             VALUES (new_team_id, NULL, NULL, team_init + '-' + team_number + '-' + schedule, NULL, new_team_id);
--
--             -- Insertar los participantes en la tabla participants
--             INSERT INTO participants (participant_id, team_id, is_tl, event_record_id)
--             SELECT gen_random_uuid(), new_team_id, e.tl, e.event_record_id
--             FROM event_records e
--             WHERE number_team = team_number AND e.event_id = event_pk AND e.assigned = TRUE;
--         END LOOP;
-- END;
-- $$;
