INSERT INTO permissions (permission_id,permission_name) VALUES ('7c102ad8-59e4-4e93-a56b-e4033de41745','Write');
INSERT INTO roles (role_id,role_description,role_name) VALUES('340ddc49-1214-4e00-9a77-2334334b23d3','Is a description','ROLE_USER');
INSERT INTO role_permission(role_id,permission_id) VALUES('340ddc49-1214-4e00-9a77-2334334b23d3','7c102ad8-59e4-4e93-a56b-e4033de41745');

INSERT INTO users (user_id,email,password) VALUES ('2efb16c6-f56c-4baa-bdea-cd2c8f372725','prueba@gmail.com','$2a$10$DbwTfHm.UXs6GiIPeP29quu/xSUAz8qOMV.vhWutn9P3vr1iZGFum');
INSERT INTO user_role(user_id,role_id) VALUES ('2efb16c6-f56c-4baa-bdea-cd2c8f372725','340ddc49-1214-4e00-9a77-2334334b23d3');
INSERT INTO profiles (profile_id,user_id,avatar_url,github_url,linkedin_url, profile_name,profile_lastname) VALUES ('5c3b8b6a-0e2e-4b9e-9a7b-7b3e5e4b8a3b','2efb16c6-f56c-4baa-bdea-cd2c8f372725','https://t2.uc.ltmcdn.com/es/posts/0/3/2/como_alejarse_de_una_persona_toxica_45230_orig.jpg','https://github.com/aasdasd','https://www.linkedin.com/in/asdasdasd/','nombreprueba','apellidoprueba');

INSERT INTO languages (language_id, language_name) VALUES ('3f81bee3-099a-446a-b2b6-c135ee116b92', 'JavaScript');
INSERT INTO languages (language_id, language_name) VALUES ('5ad6cd43-8dd0-4d72-8dec-e029e29a1d33', 'TypeScript');
INSERT INTO languages (language_id, language_name) VALUES ('2d23b78b-2577-4721-8d1c-303418ce190d', 'Java');
INSERT INTO languages (language_id, language_name) VALUES ('51a3bdca-00b2-4f34-99d7-08b21ce0e374', 'Python');
INSERT INTO languages (language_id, language_name) VALUES ('7814ecd7-7e1f-47a8-a2e8-db358614e59c', 'C#');
INSERT INTO languages (language_id, language_name) VALUES ('0abf2fc8-7e22-448e-ab61-9f1b9114d2e8', 'PHP');
INSERT INTO languages (language_id, language_name) VALUES ('e07b24b1-0287-4990-9bac-ee7941dfc34a', 'Ruby');
INSERT INTO languages (language_id, language_name) VALUES ('1b8ab760-38f7-4bbf-a5d0-e230807e0e3f', 'Dart');
INSERT INTO languages (language_id, language_name) VALUES ('39431bc6-ba80-4b22-8d7e-073e144e526a', 'Golang');


INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('0945d50a-65d9-4e00-bdd4-ff20268455e9', 'React','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('324f9dc7-560b-4741-bf95-c0bc4d6ab902', 'Angular','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('31bf4ecc-c4ac-4fbe-a6ff-652c8dcebc01', 'Nextjs','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('1352d700-58f6-4b43-8267-65873e52aa7f', 'Vue.js','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('58a4b018-6925-43c1-9db6-963a4f16d2ad', 'Svelte','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('00be320a-d284-48cb-9ae9-ffe27fded064', 'Expressjs','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('38b0c497-9de6-4f3f-90eb-57a641accfad', 'Django','Backend','Python');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('6f5598b1-60a5-4c66-bb6b-09e5c7417529', 'Symfony','Backend','Symfony');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('d160babf-580b-4a42-93ff-ce84df20b724', 'FastApi','Backend','Python');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('30b439ae-9846-47d9-8c49-5fda08f1e313', 'Spring Boot','Backend','Java');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('6fdc3125-073e-4bed-8430-be56a8861301', 'Ruby on Rails','Backend','Ruby');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('5c775c2a-1547-48b9-adf9-6fce95923845', 'React Native','Mobile','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('511e7dc6-b76e-409a-ae30-0680f5df71b9', '.NET','Backend','C#');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('9c8e334c-9e90-42dc-b1f7-864710aaab6f', 'Laravel','Backend','PHP');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('153de720-ea4a-4f74-b498-377b5875faf6', 'Flask','Backend','Python');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('32fb4566-44ee-4986-8128-46a7cd32974b', 'Gin','Backend','Golang');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('e1377717-d27f-4f32-a841-a6025c165df5', 'Quarkus','Backend','Java');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('996ad182-d190-4aa8-87b7-ee310727e56e', 'Flutter','Mobile','Dart');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('df911a98-ea07-4f3a-8920-5ae9c902ae19', 'Qwik','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('003ff117-485d-437f-bb40-5ed1230b2688', 'Android','Mobile','Kotlin');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('bf88d8ce-3851-4c90-903e-60823a4d849d', 'Nest','Backend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('bf0dc911-7573-4ef7-bb33-6f9d71f5e029', 'Node','Backend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('55e79657-7c95-41f1-bd15-f26a5a31e14d', 'Fiber','Backend','Golang');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('ea18ed4e-a71e-4254-83bd-c3aec0861762', 'Nuxt','Frontend','Typescript');
INSERT INTO frameworks (framework_id, framework_name,framework_type,language) VALUES ('99747231-b4c4-4583-b307-32b30eb98f10', 'Micronaut','Backend','Java');

INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('038eff46-b858-4710-9fda-2be48db983fe','Desarrolla soluciones con tecnologias como Java, React, Node, Python.' ,'WebApp');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('447ef4a1-06d4-4a05-b983-e3d4cf467f5b','Construye aplicaciones mobile con tecnologías como Swift (para iOS), Kotlin (para Android), React Native.','NoCode');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('be9716f2-3711-4dd7-9360-4080dd475401', 'Utiliza plataformas como Bubble, Webflow o Zapier para construir MVPs sin codigo. No se requieren conocimientos previos','Mobile');
INSERT INTO project_type (project_type_id,project_type_description ,project_type_name) VALUES ('a9b5cb7a-8eed-458b-9627-a1e92d0623aa', 'Centrado en el análisis y gestión de datos, utilizando herramientas especializadas para interpretar y presentar datos de manera estratégica.','Data Bi');

INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('d5e737ac-316e-46fb-92a6-77aa149ee8e6','Backend','038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('54d5c728-3757-4968-a35d-28edb51b2795','Frontend','038eff46-b858-4710-9fda-2be48db983fe');
 INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('151e9ec2-921d-43a4-9a57-b12319c99439','UX/UI','038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('b6daedcf-b311-473d-b8e1-33354c2220e6','QA Tester','038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('709814fb-cd6a-47b1-8ff6-83db4f38bc72','DevOps','038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('8f562cce-cfac-4452-a25e-e1784a88a15e','Project Manager','038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('b3822e16-e34f-4c88-80db-602cc56a117e','Mobile Dev','038eff46-b858-4710-9fda-2be48db983fe');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('001a753a-8f7d-465f-aeb6-e930c5e4c45c','Automation','be9716f2-3711-4dd7-9360-4080dd475401');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('12c4a4fe-2136-451d-ba1f-00d256c13415','Data Analyst','a9b5cb7a-8eed-458b-9627-a1e92d0623aa');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('0e7f8fe7-1086-4c51-8325-2c2dfa6834e8','Data Engineer','a9b5cb7a-8eed-458b-9627-a1e92d0623aa');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('6b347672-8cd3-4854-872a-7d3e517b272c','Data Scientist','a9b5cb7a-8eed-458b-9627-a1e92d0623aa');
INSERT INTO roles_type (role_type_id,role_type_name,project_type_id) VALUES ('09ba214a-2bb6-4ead-9a7c-d68076b82880','Machine Learning','a9b5cb7a-8eed-458b-9627-a1e92d0623aa');

INSERT INTO events (event_id, event_name, event_type, event_description, event_participant, event_date_start, event_date_end) VALUES ('ddd0643e-ea4c-4aab-89fc-5739d116483a', 'C21', 'Cohorte', 'Cohorte S21-24', null, '2024-11-04', '2024-12-06');
INSERT INTO events (event_id, event_name, event_type, event_description, event_participant, event_date_start, event_date_end) VALUES ('c5d56816-1743-47cc-8b68-ee8772f950ee', 'Evento noviembre', 'Selection', 'Seleccionado S19-24', 0, '2024-11-04', '2024-12-07');

----------- Event Records ----------------------------

------------ UX/UI-----------------
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('f4cf0c51-12ee-43d1-8ec8-3363a11f4604', 'FullTime', True, '151e9ec2-921d-43a4-9a57-b12319c99439', null, 'c9f0a353-ea06-4b7b-8e4c-1aa308f9b72f', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('4bb002b0-20c5-4b29-81bb-ee39d2fe36f0', 'FullTime', True, '151e9ec2-921d-43a4-9a57-b12319c99439', '3f81bee3-099a-446a-b2b6-c135ee116b92', '2f05583a-83e9-4b4c-a746-7d9eaec9e725', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('ebe44278-ce04-4a74-951e-1cfeacb08229', 'FullTime', True, '151e9ec2-921d-43a4-9a57-b12319c99439', '3f81bee3-099a-446a-b2b6-c135ee116b92', '36d02394-ac50-41aa-978e-a40bb44a7af3', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('f3ae6027-a2fd-417c-a9b5-2c4c2fe13b19', 'FullTime', True, '151e9ec2-921d-43a4-9a57-b12319c99439', '2d23b78b-2577-4721-8d1c-303418ce190d', '34d02aeb-0aae-4d89-882d-d006ba2bc33e', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('71470ddf-b6c6-41d0-9cbb-cd6e81ce6500', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', '39431bc6-ba80-4b22-8d7e-073e144e526a', 'b707ff74-d96a-45a2-ac3d-25d2984fbda0', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('d961f108-deb9-40b4-832c-8aaa28ce573b', 'FullTime', True, '151e9ec2-921d-43a4-9a57-b12319c99439', '55e79657-7c95-41f1-bd15-f26a5a31e14d', 'b408f6c6-1150-4ec7-a1f4-e7e719e57f9c', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('a2948aac-1f16-48dc-9b32-ea50a1192dc4', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', '55e79657-7c95-41f1-bd15-f26a5a31e14d', 'e7395b29-b51c-4edc-a90d-69be69fafb68', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('b078137c-dc15-4d99-94d2-abbd1694d2b6', 'FullTime', False, '151e9ec2-921d-43a4-9a57-b12319c99439', '51a3bdca-00b2-4f34-99d7-08b21ce0e374', 'bedf2898-0bc2-41ba-8a59-24cef846a4c0', 'a44913b7-34ca-429f-821f-ae8732423c9d');

------------------ PM-------------------------------------
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('bbdde479-7094-4c54-b5e2-ad6f59cfda6b', 'FullTime', False, '69f3536a-fc8b-4e68-ac0e-34eb70953469',  '39431bc6-ba80-4b22-8d7e-073e144e526a', '21648426-38b0-4cf1-b70d-aaf1214ae06d', 'a44913b7-34ca-429f-821f-ae8732423c9d');
-- INSERT INTO event_records (event_record_id, schedule, tl, role_type_id, language_id, profile_id, event_id) VALUES ('56ad9646-0b9b-4ecb-b8e6-cc17ea40cdab', 'FullTime', True, '9334ad16-2b63-4848-ba96-d4283b4e9690', '2d23b78b-2577-4721-8d1c-303418ce190d', '2cd1a255-5515-42f1-b543-ebc42389601c', 'a44913b7-34ca-429f-821f-ae8732423c9d');


-------------- QA -------------------------------------

--------------- Frontends -----------------------------

-------------- Backends -------------------------------

------------- DevOps -------------------------------