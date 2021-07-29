Drop database if exists cfaparis;
create database cfaparis; 

use cfaparis; 

create table classe (
	idclasse int(3) not null auto_increment,
	nom varchar (50),
	salle varchar(50), 
	nbEtudiants int(3), 
	budget float, 
	primary key(idclasse)
);

create table etudiant (
	idetudiant int(3) not null auto_increment,
	nom varchar (50),
	prenom varchar(50), 
	dtinscription date, 
	montant float, 
	email varchar(50),
	idclasse int (3) not null,
	primary key(idetudiant), 
	foreign key (idclasse) references classe (idclasse)
);

insert into classe values (null, "Promotion 222", "Salle 5", 0, 0);
insert into etudiant values (null, "hugo", "assuncao", "2019-09-09", 4500, 
	"a@gmail.com", 1);

insert into etudiant values (null, "Bilel", "Justin", "2019-10-10", 4200, 
	"b@gmail.com", 1);
select * from classe ;
-------------------------------------------------------

DROP trigger IF EXISTS etudiant_nbetudiants;
DELIMITER $
CREATE TRIGGER etudiant_nbetudiants
AFTER INSERT ON etudiant
FOR EACH ROW
BEGIN
	UPDATE classe SET nbEtudiants = nbEtudiants + 1, budget = budget + new.montant
	WHERE idclasse = new.idclasse;
END $
DELIMITER ;

--------------------------------
DROP trigger IF EXISTS etudiant_inverse_nbetudiants;
DELIMITER $
CREATE TRIGGER etudiant_inverse_nbetudiants
AFTER DELETE ON etudiant
FOR EACH ROW
BEGIN
	UPDATE classe SET nbEtudiants = nbEtudiants - 1, budget = budget - old.montant
	WHERE idclasse = old.idclasse;
END $
DELIMITER ;
-------------------------------
insert  new
delete old 
update : old et new 

------------------------------------------
Ecrire un trigger qui a chaque insertion dune classe, si le nbEtudiants
est inferier à 0 il serait remis à zero et idem pour budget

DROP TRIGGER IF exist Test_Valeurs;
DELIMITER $
CREATE TRIGGER Test_Valeurs
before INSERT ON classe
FOR EACH ROW
BEGIN
	if new.nbEtudiants<0
	then SET new.nbEtudiants = 0;
	end if ;
	if new.budget <0
	then SET new.budget = 0;
	end if;
END $
DELIMITER ;

---------------------------------------
Application du trigger 
insert into classe values (null, "Promotion 222", "Salle 5", -5, -6700);
select * from classe;
------------------------------------------
(Mysql) Syntaxe du IF :

	IF condition 
		then instruction;
		else instruction;
	end IF;
---------------------------------------------------

Ecrire une procédure stockée 
qui permet de recevoir le nom dune classe et dafficher la liste de ses etudiants (nom, prenom, dtinscription)

z
--------------------------------------------------
call listeEtudiants ("promotion 222");

call listeEtudiants ("promotion 241");

--------------------------------------------------
trigger : execution auto 
procedure : call 


------------------------------------
@ -> variable globale
--------------------------------------

DROP PROCEDURE IF EXISTS tot_budget;

DELIMITER $ 
CREATE PROCEDURE tot_budget(OUT total float) 
BEGIN 
	SELECT nom, salle, budget 
	FROM classe;
	SELECT sum(budget) into total from classe ;
END $ 
DELIMITER  ; 

#On déclare une variable : budget_total 

Set @budget_total = 0; 
select @budget_total ;

call tot_budget (@budget_total); 