CREATE TABLE Programmeur (
	id INT NOT NULL AUTO_INCREMENT, 
	nom varchar(50) default NULL, 
	prenom varchar(50) default NULL,
	Naissance INT default NULL,
	Salaire FLOAT, 
	Prime FLOAT, 
	Pseudo varchar (50) default NULL, 
	Responsable varchar(50) default NULL, 
	Hobby varchar(50) default NULL, 
	Adresse varchar(60) default NULL, 
	PRIMARY KEY (id)

); 
