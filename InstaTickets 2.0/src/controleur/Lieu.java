package controleur;

public class Lieu {
	private int idlieu, capacite;
	private String nom, adresse;
	
	public Lieu(int idlieu, String nom, String adresse, int capacite) {
		this.idlieu = idlieu;
		this.nom = nom;
		this.adresse = adresse;
		this.capacite = capacite;

	}
	public Lieu(int capacite, String nom, String adresse) {
		this.idlieu = 0;
		this.capacite = 0;
		this.nom = "";
		this.adresse = "";
	}

	public int getIdlieu() {
		return idlieu;
	}

	public void setIdlieu(int idlieu) {
		this.idlieu = idlieu;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	

}
