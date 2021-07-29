package controleur;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Commentaire {
	
	private int idcommmentaire, note, idconcert, idmembre;
	private String datecomment, contenu;
	

	public Commentaire(int idcommmentaire, String datecomment, String contenu, int note, int idconcert, int idmembre) {
		this.idcommmentaire = idcommmentaire;
		this.datecomment = datecomment;
		this.contenu = contenu;
		this.note = note;
		this.idconcert = idconcert;
		this.idmembre = idmembre;

	}

	
	public Commentaire(int idcommentaire , String datecomment, String contenu, int note, int idconcert) {
		this.idcommmentaire = idcommentaire;
		this.datecomment = datecomment;
		this.contenu = contenu;
		this.note = note;
		this.idconcert = idconcert;
		this.idmembre = 0;
	}
	public Commentaire(int idcommentaire , String contenu, int note, int idconcert) {
		this.idcommmentaire = idcommentaire;
		this.datecomment = "";
		this.contenu = contenu;
		this.note = note;
		this.idconcert = idconcert;
		this.idmembre = 0;
	}
	
	public Commentaire(int note, int idconcert, int idmembre, String datecomment, String contenu) {
		this.idcommmentaire = 0;
		this.note = note;
		this.idconcert = idconcert;
		this.idmembre = idmembre;
		this.datecomment = datecomment;
		this.contenu = contenu;
	}
	public Commentaire() {
		this.idcommmentaire = 0;
		this.note = 0;
		this.idconcert = 0;
		this.idmembre = 0;
		this.datecomment = "";
		this.contenu = "";
	}

	public int getIdcommmentaire() {
		return idcommmentaire;
	}

	public void setIdcommmentaire(int idcommmentaire) {
		this.idcommmentaire = idcommmentaire;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getIdconcert() {
		return idconcert;
	}

	public void setIdconcert(int idconcert) {
		this.idconcert = idconcert;
	}

	public int getIdmembre() {
		return idmembre;
	}

	public void setIdmembre(int idmembre) {
		this.idmembre = idmembre;
	}

	public String getDatecomment() {
		return datecomment;
	}

	public void setDatecomment(String datecomment) {
		this.datecomment = datecomment;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	

	
}

