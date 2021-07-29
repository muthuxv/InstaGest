package controleur;

public class Membre {
	
	private int idMembre ;
	private String  email, mdp, nom, prenom, adresse, tel, droits;
	
	
	public Membre(int idMembre, String nom, String prenom, String adresse, String tel, String email, String droits, String mdp) {
		this.idMembre = idMembre;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.droits = droits;
		this.mdp = mdp;
	}
	public Membre(String nom, String prenom, String adresse, String tel, String email, String droits, String mdp) {
		this.idMembre = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.droits = droits;
		this.mdp = mdp;
	}
	public Membre() {
		this.idMembre = 0;
		this.nom = "";
		this.prenom = "";
		this.adresse = "";
		this.tel = "";
		this.email = "";
		this.droits = "";
		this.mdp = "";
	}
	
	public int getIdMembre() {
		return idMembre;
	}
	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDroits() {
		return droits;
	}
	public void setDroits(String droits) {
		this.droits = droits;
	}


}
