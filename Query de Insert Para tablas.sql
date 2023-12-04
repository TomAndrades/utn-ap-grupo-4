Use integradorintermedio;

INSERT INTO TECNICOS (idTecnico,legajo, nombre, dni, mail, cel) VALUES (1,120,'Pedro',43568641,'pedro@gmail.com','11243621');
INSERT INTO tecnicos (idTecnico,legajo,nombre,dni,mail,cel) VALUES (2,121,"Juan",123456789,"juan@gmail.com","1112345678");
INSERT INTO tecnicos (idTecnico,legajo,nombre,dni,mail,cel) VALUES (3,122,"Luis",78945612,"lucho@gmail.com","1112345876");
INSERT INTO tecnicos (idTecnico,legajo,nombre,dni,mail,cel) VALUES (4,123,"Marcos",025165448,"Marcos@gmail.com","646523875");
INSERT INTO tecnicos (idTecnico,legajo,nombre,dni,mail,cel) VALUES (5,124,"Pepe",321546886,"Pepe@gmail.com","8945623565");
INSERT INTO tecnicos (idTecnico,legajo,nombre,dni,mail,cel) VALUES (6,125,"Fernando",321648951,"Fer@gmail.com","112100541");
INSERT INTO tecnicos (idTecnico,legajo,nombre,dni,mail,cel) VALUES (7,126,"Paola",42568641,"paola@gmail.com","1124111141");

Insert into especialidades(idEspecialidad,nombre,descripcion) Values(1,"Windows","Sistema operativo");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(2,"Ubuntu","Sistema operativo");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(3,"Mac","Sistema operativo");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(4,"SAP","Aplicacion");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(5,"Tango","Aplicaion");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(6,"Ms Word","Aplicacion");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(7,"Brave Browser","Aplicacion");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(8,"MySql","BD");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(9,"Ultimaker Cura","Aplicacion");
Insert into especialidades(idEspecialidad,nombre,descripcion) Values(10,"TeamViewer","Aplicacion");


Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(1,1,1);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(2,2,1);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(3,3,1);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(4,5,2);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(5,1,3);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(6,5,3);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(7,10,2);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(8,2,5);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(9,7,6);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(10,8,7);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(11,4,4);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(12,6,5);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(13,9,4);
Insert into especialidades_tecnico(idEspecialidad_tecnico,idEspecialidad,idTecnico) values(14,8,2);


select * from integradorintermedio.especialidad;
Select * from tecnico;
delete  from tecnico where id_tecnico=0;