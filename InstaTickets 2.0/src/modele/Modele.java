package modele;

import controleur.Artiste;
import controleur.Commentaire;
import controleur.Lieu;
import controleur.Membre;
import controleur.Concert;
import controleur.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modele {
	
	//private static Bdd uneBdd = new Bdd ("localhost:8889", "bddInstaTicket", "root", "root");
	private static Bdd uneBdd = new Bdd ("localhost:8889", "bddInstaTicket", "root", "root");

	
	public static Membre verifConnexion (String email, String mdp) {
		
		Membre unMembre = null;
		String requete = "select * from membre where email = '" + email + "' and mdp = '" + mdp + "' ;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if (unRes.next()) {
				unMembre = new Membre (
						unRes.getInt("idmembre"), unRes.getString("nom"), unRes.getString("prenom"), 
						unRes.getString("adresse"), unRes.getString("tel"), unRes.getString("email"), 
						unRes.getString("droits"), unRes.getString("mdp")
						);
			}
			unRes.close();
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur d'exécution de la requête :" +requete);
		}
		
		
		return unMembre;
	}
	
	
	// Méthodes de gestion de la table artistes
	
	public static void insertArtiste (Artiste unArtiste) {
		String requete = "insert into artiste values (null, '" + unArtiste.getNom() + "', '" + unArtiste.getPhoto_artiste() + "', '" + unArtiste.getIdgenre() + "');" ;
		executerRequete(requete);
	}
	
	public static void deleteArtiste (int idartiste) {
		String requete = "delete from artiste where idartiste = " + idartiste + ";" ;
		executerRequete(requete);
	}
	
	public static void updateArtiste (Artiste unArtiste) {
		String requete = "update artiste set nom ='" + unArtiste.getNom() + "', photo_artiste = '" + unArtiste.getPhoto_artiste() + "', idgenre = " + unArtiste.getIdgenre() + " where idartiste = " + unArtiste.getIdartiste() + " ;";
		executerRequete(requete);
	}
	
	public static Artiste selectWhereArtiste( int idArtiste) {
		String requete = "select where idartiste = " + idArtiste + ";";
		Artiste unArtiste = null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unArtiste = new Artiste (
						unRes.getInt("idartiste"), unRes.getString("nom"), unRes.getString("photo_artiste"), unRes.getInt("idgenre")
						);
			}			
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete :" + requete);
		}
		return unArtiste;
	}
	//surcharge de la mÃ©thode avec de nouveaux arguments 
	public static Artiste selectWhereArtiste (String nom)
	{
		String requete ="select * from artiste where nom = '"+ nom +"' ;" ;
		Artiste unArtiste = null; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unArtiste = new Artiste  (
						unRes.getInt("idartiste"), unRes.getString("nom"), unRes.getString("photo_artiste"), unRes.getInt("idgenre")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'exécution de la requete : " + requete );
		}
		return unArtiste ; 
	}
	
	public static ArrayList<Artiste> selectAllArtistes(){
		String requete = "select * from artiste;";
		ArrayList<Artiste> lesArtistes = new ArrayList<Artiste>();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Artiste unArtiste = new Artiste (
						desRes.getInt("idartiste"), desRes.getInt("idgenre"), desRes.getString("nom"), desRes.getString("photo_artiste")
						);
				lesArtistes.add(unArtiste);
			}			
			unStat.close();
			desRes.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de la requete : " + requete);
		}
		return lesArtistes;
		
	}
	
	public static ArrayList<Artiste> selectAllArtistes (String mot){
		
		String requete ; 
		if (mot.equals("")) {
			requete ="select * from artiste ;" ;
		}else {
			requete ="select * from artiste where nom like '%"+mot+"%' or idartiste like '%"+mot+"%' or idgenre like '%" + mot + "%' or photo_artiste like '%" + mot + "%' ; " ;
		}
		ArrayList<Artiste> lesArtistes = new ArrayList<Artiste>();  
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Artiste unArtiste = new Artiste (
						desRes.getInt("idartiste"), desRes.getInt("idgenre"), desRes.getString("nom"), desRes.getString("photo_artiste")
						);
				lesArtistes.add(unArtiste);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'exécution de la requete : " + requete );
		}
		return lesArtistes ; 
	}

	//#########################################  Methodes de Gestion de la table Lieu  #####
	
	
		public static void insertLieu (Lieu unLieu) {
			String requete = "insert into lieu values (null, '" + unLieu.getNom() + "', '" + unLieu.getAdresse() + "', '" + unLieu.getCapacite() + "');" ;
			executerRequete(requete);
		}
		
		public static void deleteLieu (int idlieu) {
			String requete = "delete from lieu where idlieu = " + idlieu + ";";
			executerRequete(requete);
		}
		
		public static void updateLieu (Lieu unLieu) {
			String requete = "update lieu set nom ='" + unLieu.getNom() + "', adresse = '" + unLieu.getAdresse() + "', capacite = '" + unLieu.getCapacite() + "' where idlieu = " + unLieu.getIdlieu() + " ;" ;
			executerRequete(requete);
		}
		
		public static Lieu selectWhereLieu( int idLieu) {
			String requete = "select where idlieu = " + idLieu + ";";
			Lieu unLieu = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unLieu = new Lieu (
							unRes.getInt("idlieu"), unRes.getString("nom"), unRes.getString("adresse"), unRes.getInt("capacite")
							);
				}			
				unStat.close();
				unRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete :" + requete);
			}
			return unLieu;
		}
		//surcharge de la mÃ©thode avec de nouveaux arguments 
		public static Lieu selectWhereLieu (String nom)
		{
			String requete ="select * from lieu where nom = '"+ nom +"' ;" ;
			Lieu unLieu = null; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unLieu = new Lieu  (
							unRes.getInt("idlieu"), unRes.getString("nom"), unRes.getString("adresse"), unRes.getInt("capacite")
							);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return unLieu ; 
		}
		
		public static ArrayList<Lieu> selectAllLieux(){
			String requete = "select * from lieu;";
			ArrayList<Lieu> lesLieux = new ArrayList<Lieu>();
			Lieu unLieu = null; 

			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					unLieu = new Lieu  (
							desRes.getInt("idlieu"), desRes.getString("nom"), desRes.getString("adresse"), desRes.getInt("capacite")
							);
					lesLieux.add(unLieu);
				}			
				unStat.close();
				desRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete);
			}
			return lesLieux;
			
		}
		
		public static ArrayList<Lieu> selectAllLieux (String mot){
			
			String requete ; 
			if (mot.equals("")) {
				requete ="select * from lieu ;" ;
			}else {
				requete ="select * from lieu where idlieu like '%"+mot+"%' or nom like '%"+mot+"%' or adresse like '%" + mot + "%' or capacite like '%" + mot + "%' ; " ;
			}
			ArrayList<Lieu> lesLieux = new ArrayList<Lieu>();  
			
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Lieu unLieu = new Lieu (
							desRes.getInt("idlieu"), desRes.getString("nom"), desRes.getString("adresse"), desRes.getInt("capacite")
							);
					lesLieux.add(unLieu);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return lesLieux ; 
		}
		/**********************************  M�thodes de gestion de la table membre	*****************************************/
		public static void insertMembre (Membre unMembre)
		{
			String requete ="insert into membre values (null, '" + unMembre.getNom() + "','" + unMembre.getPrenom()
			+"','" + unMembre.getAdresse() + "','" + unMembre.getTel() + "','" + unMembre.getEmail() + "','" + unMembre.getDroits() + "','" + unMembre.getMdp() + "');" ;
			executerRequete(requete);
		}
			
		public static void deleteMembre (int idmembre)
		{
			String requete =" delete from membre where idmembre = " + idmembre + ";" ;
			executerRequete(requete);
		}
			
		public static void updateMembre (Membre unMembre)
		{
			String requete ="update membre set nom = '" + unMembre.getNom() + "', prenom = '" + unMembre.getPrenom()
			+"', adresse = '" + unMembre.getAdresse() + "', Tel = '" + unMembre.getTel() + "', email = '" + unMembre.getEmail()
			+ "', droits = '" + unMembre.getDroits() + "', Mdp = '" + unMembre.getMdp() + "'where idmembre = " + unMembre.getIdMembre() + ";" ;
			executerRequete(requete);
		}
			
		public static Membre selectWhereMembre (int idMembre)
		{
			String requete ="select * from membre where idmembre = "+ idMembre + ";" ;
			Membre unMembre = null ; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unMembre = new Membre (unRes.getInt("idmembre"), unRes.getString("nom"), unRes.getString("prenom"),
							unRes.getString("adresse"), unRes.getString("tel"), unRes.getString("email"),unRes.getString("droits"), unRes.getString("mdp"));
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return unMembre ; 
			}
		//surcharge de la méthode avec de nouveaux arguments 
		public static Membre selectWhereMembre (String email, String nom)
		{
			String requete ="select * from membre where email = '"+ email +"' and nom = '"+ nom +"' ;" ;
			Membre unMembre = null ; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unMembre = new Membre (unRes.getInt("idmembre"), unRes.getString("nom"), unRes.getString("prenom"),
							unRes.getString("adresse"), unRes.getString("tel"), unRes.getString("email"),unRes.getString("droits"),
							unRes.getString("mdp"));
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return unMembre ; 
		}

		public static ArrayList<Membre> selectAllMembre (String mot){
			
			String requete ; 
			if (mot.equals("")) {
				requete ="select * from membre ;" ;
			}else {
				requete ="select * from membre where nom like '%"+mot+"%' or tel like '%"+mot+"%' ; " ;
			}
			ArrayList<Membre> lesMembres = new ArrayList<Membre>();  
			
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Membre unMembre = new Membre (desRes.getInt("idmembre"), desRes.getString("nom"), desRes.getString("prenom"),
							desRes.getString("adresse"), desRes.getString("tel"), desRes.getString("email"),desRes.getString("droits"), desRes.getString("mdp"));
					lesMembres.add(unMembre);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return lesMembres ; 
		}
		/**********************************					*****************************************/
		
		/**********************************  Méthodes de gestion de la table Genre	*****************************************/
		
		public static void insertGenre (Genre unGenre) {
			String requete = "insert into genre values (null, '" + unGenre.getNom() + "');" ;
			executerRequete(requete);
		}
		
		public static void deleteGenre (int idGenre) {
			String requete = "delete from genre where idgenre = " + idGenre + ";";
			executerRequete(requete);
		}
		
		public static void updateGenre (Genre unGenre) {
			String requete = "update genre set nom ='" + unGenre.getNom() + "'where idgenre = " + unGenre.getIdgenre() + ";" ;
			executerRequete(requete);
		}
		
		public static Genre selectWhereGenre( int idGenre) {
			String requete = "select where idgenre = " + idGenre + ";";
			Genre unGenre = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unGenre = new Genre (
							unRes.getInt("idgenre"), unRes.getString("nom"));
				}			
				unStat.close();
				unRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete :" + requete);
			}
			return unGenre;
		}
		//surcharge de la méthode avec de nouveaux arguments 
		public static Genre selectWhereGenre (String nom)
		{
			String requete ="select * from genre where nom = '"+ nom +"' ;" ;
			Genre unGenre = null; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unGenre = new Genre  (
							unRes.getInt("idgenre"), unRes.getString("nom"));
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'ex�cution de la requete : " + requete );
			}
			return unGenre ; 
		}
		
		public static ArrayList<Genre> selectAllGenres(){
			String requete = "select * from genre;";
			ArrayList<Genre> lesGenres = new ArrayList<Genre>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Genre unGenre = new Genre (
							desRes.getInt("idgenre"), desRes.getString("nom"));
					lesGenres.add(unGenre);
				}			
				unStat.close();
				desRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete);
			}
			return lesGenres;
			
		}
		
		public static ArrayList<Genre> selectAllGenres (String mot){
			
			String requete ; 
			if (mot.equals("")) {
				requete ="select * from genre ;" ;
			}else {
				requete ="select * from genre where nom like '%"+mot+"%' or idgenre like '%"+mot+"%' ; " ;
			}
			ArrayList<Genre> lesGenres = new ArrayList<Genre>();  
			
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Genre unGenre = new Genre (
							desRes.getInt("idgenre"), desRes.getString("nom"));
					lesGenres.add(unGenre);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'éxécution de la requete : " + requete );
			}
			return lesGenres ; 
		}
		
		/**********************************					*****************************************/
		
	/**********************************  Méthodes de gestion de la table concert *****************************************/
		
		public static void insertConcert(Concert unConcert) {
			String requete = "insert into concert values (null, '" + unConcert.getTitre() + "', '" + unConcert.getImage() + "', '" + unConcert.getDateconcert() +
					 "','" + unConcert.getDescriptionconcert() + "','" + unConcert.getPrix() + "', '" + unConcert.getIdartiste() + "','" + unConcert.getIdlieu() + "', '" + unConcert.getTarif() + "');" ;
			executerRequete(requete);
		}
		
		public static void deleteConcert (int idConcert) {
			String requete = "delete from concert where idconcert = " + idConcert + ";";
			executerRequete(requete);
		}
		
		public static void updateConcert (Concert unConcert){
			String requete = "update concert set titre ='" + unConcert.getTitre() + "', image = '" + unConcert.getImage() + "', dateconcert = '" + unConcert.getDateconcert() + 
					"', descriptionconcert = '" + unConcert.getDescriptionconcert() + "', prix = '" + unConcert.getPrix() + "', idartiste = '" + unConcert.getIdartiste() + "', idlieu = '" + unConcert.getIdlieu() +"' , tarif = '" + unConcert.getTarif() + "'where idconcert = " + unConcert.getIdconcert() + ";" ;
			executerRequete(requete);
		}
		
		public static Concert selectWhereConcert( int idConcert) {
			String requete = "select * from concert where idconcert = " + idConcert + ";";
			Concert unConcert = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unConcert = new Concert (
							unRes.getInt("idconcert"), unRes.getString("titre"), unRes.getString("image"), unRes.getString("dateconcert"),
							unRes.getString("descriptionconcert"), unRes.getInt("prix"), unRes.getInt("idartiste"), unRes.getInt("idlieu"), unRes.getString("tarif"));
				}			
				unStat.close();
				unRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete :" + requete);
			}
			return unConcert;
		}
		//surcharge de la méthode avec de nouveaux arguments 
		public static Concert selectWhereConcert(String titre)
		{
			String requete ="select * from concert where titre = '"+ titre +"' ;" ;
			Concert unConcert = null; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unConcert = new Concert (
							unRes.getInt("idconcert"), unRes.getString("titre"), unRes.getString("image"), unRes.getString("dateconcert"),
							unRes.getString("descriptionconcert"), unRes.getInt("prix"), unRes.getInt("idartiste"), unRes.getInt("idlieu"), unRes.getString("tarif"));
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete );
			}
			return unConcert ; 
		}
		
		public static ArrayList<Concert> selectAllConcerts(){
			String requete = "select * from concert;";
			ArrayList<Concert> lesConcerts = new ArrayList<Concert>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Concert unConcert = new Concert (
							desRes.getInt("idconcert"), desRes.getString("titre"), desRes.getString("image"), desRes.getString("dateconcert"),
							desRes.getString("descriptionconcert"), desRes.getInt("prix"), desRes.getInt("idartiste"), desRes.getInt("idlieu"), desRes.getString("tarif"));
					lesConcerts.add(unConcert);
				}			
				unStat.close();
				desRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete);
			}
			return lesConcerts;
			
		}
		
		public static ArrayList<Concert> selectAllConcerts (String mot){
			
			String requete ; 
			if (mot.equals("")) {
				requete ="select * from concert ;" ;
			}else {
				requete ="select * from concert where titre like '%"+mot+"%' or idconcert like '%"+mot+"%' or idartiste like '%" + mot + "%' ; " ;
			}
			ArrayList<Concert> lesConcerts = new ArrayList<Concert>();  
			
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Concert unConcert = new Concert (
							desRes.getInt("idconcert"), desRes.getString("titre"), desRes.getString("image"), desRes.getString("dateconcert"),
							desRes.getString("descriptionconcert"), desRes.getInt("prix"), desRes.getInt("idartiste"), desRes.getInt("idlieu"), desRes.getString("tarif"));
					lesConcerts.add(unConcert);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return lesConcerts ; 
		}
		
		/**********************************					*****************************************/

	/**********************************  Méthodes de gestion de la table Commentaire *****************************************/
		
		public static void insertCommentaire(Commentaire unCommentaire) {
			String requete = "insert into commentaire values (null, '" + unCommentaire.getDatecomment() + "', '" + unCommentaire.getContenu() + "', '" + unCommentaire.getNote() +
					 "', '" + unCommentaire.getIdconcert() + "', '" + unCommentaire.getIdmembre() + "');" ;
			executerRequete(requete);
		}
		
		public static void deleteCommentaire (int idCommentaire) {
			String requete = "delete from commentaire where idcomment = " + idCommentaire + ";";
			executerRequete(requete);
		}
		
		public static void updateCommentaire (Commentaire unCommentaire){
			String requete = "update commentaire set contenu ='" + unCommentaire.getContenu() + "', note = '" + unCommentaire.getNote() + "', idconcert = '" + unCommentaire.getIdconcert() + 
					"', idmembre = '" + unCommentaire.getIdmembre() + "'where idcomment = " + unCommentaire.getIdcommmentaire() + ";" ;
			executerRequete(requete);
		}


		
		public static Commentaire selectWhereCommentaire( int idCommentaire) {
			String requete = "select where idcomment = " + idCommentaire + ";";
			Commentaire unCommentaire = null;
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unCommentaire = new Commentaire (
							unRes.getInt("idcomment"), unRes.getString("datecomment"), unRes.getString("contenu"), unRes.getInt("note"),
							unRes.getInt("idconcert"), unRes.getInt("idmembre"));
				}			
				unStat.close();
				unRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete :" + requete);
			}
			return unCommentaire;
		}
		
		//surcharge de la méthode avec de nouveaux arguments 
		public static Commentaire selectWhereCommentaire(String commentaire)
		{
			String requete ="select * from commentaire where contenu = '"+ commentaire +"' ;" ;
			Commentaire unCommentaire = null; 
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet unRes = unStat.executeQuery(requete);
				if (unRes.next()) {
					unCommentaire = new Commentaire (
							unRes.getInt("idcomment"), unRes.getString("datecomment"), unRes.getString("contenu"), unRes.getInt("note"),
							unRes.getInt("idconcert"), unRes.getInt("idmembre"));
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete );
			}
			return unCommentaire ; 
		}
		
		public static ArrayList<Commentaire> selectAllCommentaires(){
			String requete = "select * from commentaire;";
			ArrayList<Commentaire> lesCommentaires = new ArrayList<Commentaire>();
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Commentaire unCommentaire = new Commentaire (
							desRes.getInt("idcomment"), desRes.getString("datecomment"), desRes.getString("contenu"), desRes.getInt("note"),
							desRes.getInt("idconcert"), desRes.getInt("idmembre"));
					lesCommentaires.add(unCommentaire);
				}			
				unStat.close();
				desRes.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete);
			}
			return lesCommentaires;
			
		}
		
		public static ArrayList<Commentaire> selectAllCommentaires (String mot){
			
			String requete ; 
			if (mot.equals("")) {
				requete ="select * from commentaire ;" ;
			}else {
				requete ="select * from commentaire where idcomment like '%"+mot+"%' or datecomment like '%"+mot+"%' or contenu like '%" + mot + "%' or note like '%" + mot + "%'  or idconcert like '%" + mot + "%'  or idmembre like '%" + mot + "%' ; " ;
			}
			ArrayList<Commentaire> lesCommentaires = new ArrayList<Commentaire>();  
			
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement(); 
				ResultSet desRes = unStat.executeQuery(requete);
				while (desRes.next()) {
					Commentaire unCommentaire = new Commentaire (
							desRes.getInt("idcomment"), desRes.getString("datecomment"), desRes.getString("contenu"), desRes.getInt("note"),
							desRes.getInt("idconcert"), desRes.getInt("idmembre"));
					lesCommentaires.add(unCommentaire);
				}
				unStat.close();
				uneBdd.seDeconnecter();
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'exécution de la requete : " + requete );
			}
			return lesCommentaires ; 
		}
		
		/**********************************					*****************************************/
		
		
		
		//méthode générique d'execution de n'importe qu'elle requete ( sans retour de resultat )
		public static void executerRequete (String requete) {
			try {
				uneBdd.seConnecter();
				Statement unStat = uneBdd.getMaConnexion().createStatement();
				unStat.execute(requete);
				unStat.close();
				uneBdd.seDeconnecter();
				
			}
			catch(SQLException exp) {
				System.out.println("Erreur d'execution de la requete : " + requete);
				 
			}
		}

}
