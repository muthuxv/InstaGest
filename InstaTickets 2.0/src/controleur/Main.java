package controleur;

import vue.VueArtiste;
import vue.VueCommentaire;
import vue.VueConcert;
import vue.VueConnexion;
import vue.VueGenre;
import vue.VueLieu;
import vue.VueMembre;

import java.util.ArrayList;
import modele.Modele;

public class Main {
	
	private static VueConnexion uneVueConnexion;
	private static VueArtiste uneVueArtiste;
	private static VueLieu uneVueLieu;
	private static VueMembre uneVueMembre;
	private static VueGenre uneVueGenre;
	private static VueConcert uneVueConcert;
	private static VueCommentaire uneVueCommentaire;

	public static void main (String [] args) {
		uneVueConnexion = new VueConnexion();
	}
	/**********************************GESTION DES VUES*****************************************/

	public static void instancierVueArtiste() {
		uneVueArtiste = new VueArtiste();
	}
	public static void instancierVueLieu() {
		uneVueLieu = new VueLieu();
	}
	public static void instancierVueMembre () {
		uneVueMembre = new VueMembre(); 
	}
	
	public static void instancierVueGenre () {
		uneVueGenre = new VueGenre(); 
	}
	
	public static void instancierVueConcert () {
		uneVueConcert = new VueConcert(); 
	}
	public static void instancierVueCommentaire () {
		uneVueCommentaire = new VueCommentaire(); 
	}
	public static void rendreVisible(boolean action) {
		uneVueConnexion.setVisible(action);
	}
	
	public static Membre verifConnexion (String email, String mdp) {
		//controle des donneées de connexion
		return Modele.verifConnexion(email, mdp);
	}
	/**********************************					*****************************************/

	
	/**********************************CONTROLEUR Artistes*****************************************/
	public static void insertArtiste(Artiste unArtiste) {
		// on réalise les traitements ou controles avt insertion
		Modele.insertArtiste(unArtiste);
	}
	public static void deleteArtiste(int idArtiste) {
		// on réalise les traitements ou controles avt insertion
		Modele.deleteArtiste(idArtiste);
	}
	public static void updateArtiste(Artiste unArtiste) {
		// on réalise les traitements ou controles avt insertion
		Modele.updateArtiste(unArtiste);
	}
	public static Artiste selectWhereArtiste(int idArtiste) {
		// on réalise les traitements ou controles avt insertion
		return Modele.selectWhereArtiste(idArtiste);
	}
	public static Artiste selectWhereArtiste(String nom) {
		// on réalise les traitements ou controles avt insertion
		return Modele.selectWhereArtiste(nom);
	}
	public static ArrayList<Artiste> selectAllArtistes (String mot){
		return Modele.selectAllArtistes(mot);
	}
	/**********************************				*****************************************/

	
	/**********************************CONTROLEUR Lieux*****************************************/
	public static void insertLieu(Lieu unLieu) {
		// on réalise les traitements ou controles avt insertion
		Modele.insertLieu(unLieu);
	}
	public static void deleteLieu(int idLieu) {
		// on réalise les traitements ou controles avt insertion
		Modele.deleteLieu(idLieu);
	}
	public static void updateLieu(Lieu unLieu) {
		// on réalise les traitements ou controles avt insertion
		Modele.updateLieu(unLieu);
	}
	public static Lieu selectWhereLieu(int idLieu) {
		// on réalise les traitements ou controles avt insertion
		return Modele.selectWhereLieu(idLieu);
	}
	public static Lieu selectWhereLieu(String nom) {
		// on réalise les traitements ou controles avt insertion
		return Modele.selectWhereLieu(nom);
	}
	public static ArrayList<Lieu> selectAllLieux (String mot){
		return Modele.selectAllLieux(mot);
	}
	/**********************************				*****************************************/

	/*************************************************** Controleur Membre ********************************************/
	public static void insertMembre (Membre unMembre)
	{
		//ici on réalise des controles avant insertion 
		
		Modele.insertMembre(unMembre);
	}
	public static void deleteMembre (int idMembre)
	{
		
		Modele.deleteMembre(idMembre);
	}
	public static void updateMembre (Membre unMembre)
	{
		//ici on réalise des controles avant mise à jour  
		
		Modele.updateMembre(unMembre);
	}
	public static Membre selectWhereMembre (int idMembre)
	{
		
		return Modele.selectWhereMembre(idMembre);
	}
	
	public static Membre selectWhereMembre (String email, String tel)
	{
		
		return Modele.selectWhereMembre(email, tel);
	}
	
	
	public static ArrayList<Membre> selectAllMembres  (String mot)
	{
		return Modele.selectAllMembre(mot);
	} 
	/***************************************************                   ********************************************/
	
	/**********************************CONTROLEUR Genres*****************************************/
	public static void insertGenre(Genre unGenre) {
		// on r�alise les traitements ou controles avt insertion
		Modele.insertGenre(unGenre);
	}
	public static void deleteGenre(int idGenre) {
		// on r�alise les traitements ou controles avt insertion
		Modele.deleteGenre(idGenre);
	}
	public static void updateGenre(Genre unGenre) {
		// on r�alise les traitements ou controles avt insertion
		Modele.updateGenre(unGenre);
	}
	public static Genre selectWhereGenre(int idGenre) {
		// on r�alise les traitements ou controles avt insertion
		return Modele.selectWhereGenre(idGenre);
	}
	public static Genre selectWhereGenre(String nom) {
		// on r�alise les traitements ou controles avt insertion
		return Modele.selectWhereGenre(nom);
	}
	public static ArrayList<Genre> selectAllGenres(String mot){
		return Modele.selectAllGenres(mot);
	}
	/**********************************				*****************************************/
	
	/**********************************CONTROLEUR Concerts*****************************************/
	public static void insertConcert(Concert unConcert) {
		// on r�alise les traitements ou controles avt insertion
		Modele.insertConcert(unConcert);
	}
	public static void deleteConcert(int idConcert) {
		// on r�alise les traitements ou controles avt insertion
		Modele.deleteConcert(idConcert);
	}
	public static void updateConcert(Concert unConcert) {
		// on r�alise les traitements ou controles avt insertion
		Modele.updateConcert(unConcert);
	}
	public static Concert selectWhereConcert(int idConcert) {
		// on r�alise les traitements ou controles avt insertion
		return Modele.selectWhereConcert(idConcert);
	}
	public static Concert selectWhereConcert(String titre) {
		// on r�alise les traitements ou controles avt insertion
		return Modele.selectWhereConcert(titre);
	}
	public static ArrayList<Concert> selectAllConcerts (String mot){
		return Modele.selectAllConcerts(mot);
	}
	/**********************************				*****************************************/
	/**********************************CONTROLEUR Commentaires *****************************************/
	public static void insertCommentaire(Commentaire unCommentaire) {
		// on r�alise les traitements ou controles avt insertion
		Modele.insertCommentaire(unCommentaire);
	}
	public static void deleteCommentaire(int idComment) {
		// on r�alise les traitements ou controles avt insertion
		Modele.deleteCommentaire(idComment);
	}
	public static void updateCommentaire(Commentaire unCommentaire) {
		// on r�alise les traitements ou controles avt insertion
		Modele.updateCommentaire(unCommentaire);
	}
	public static Commentaire selectWhereCommentaire(int idComment) {
		// on r�alise les traitements ou controles avt insertion
		return Modele.selectWhereCommentaire(idComment);
	}
	public static Commentaire selectWhereCommentaire(String nom) {
		// on r�alise les traitements ou controles avt insertion
		return Modele.selectWhereCommentaire(nom);
	}
	public static ArrayList<Commentaire> selectAllCommentaires (String mot){
		return Modele.selectAllCommentaires(mot);
	}
	/**********************************				*****************************************/

}
