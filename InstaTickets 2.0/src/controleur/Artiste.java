package controleur;

public class Artiste {
	
	private int idartiste, idgenre;
	private String nom, photo_artiste;
	
	public Artiste(int idartiste, int idgenre, String nom, String photo_artiste) {
		this.idartiste = idartiste;
		this.idgenre = idgenre;
		this.nom = nom;
		this.photo_artiste = photo_artiste;
	}
	public Artiste(int idartiste, String nom, String photo_artiste, int idgenre) {
		this.idartiste = idartiste;
		this.nom = nom;
		this.photo_artiste = photo_artiste;
		this.idgenre = idgenre;
	}
	public Artiste(int idgenre, String nom, String photo_artiste) {
		this.idartiste = 0;
		this.idgenre = idgenre;
		this.nom = nom;
		this.photo_artiste = photo_artiste;
	}
	public Artiste() {
		this.idartiste = 0;
		this.idgenre = 0;
		this.nom = "";
		this.photo_artiste = "";
	}
	


		
		
	public int getIdartiste() {
		return idartiste;
	}
	public void setIdartiste(int idartiste) {
		this.idartiste = idartiste;
	}
	public int getIdgenre() {
		return idgenre;
	}
	public void setIdgenre(int idgenre) {
		this.idgenre = idgenre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhoto_artiste() {
		return photo_artiste;
	}
	public void setPhoto_artiste(String photo_artiste) {
		this.photo_artiste = photo_artiste;
	}
	

	
	
	
	

}
