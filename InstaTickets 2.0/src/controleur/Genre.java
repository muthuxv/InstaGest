package controleur;

public class Genre {
	private int idgenre;
	private String nom;
	
	public Genre(int idgenre, String nom) {
		this.idgenre = idgenre;
		this.nom = nom;
	}	
	public Genre(String nom) {
		this.idgenre = 0;
		this.nom = nom;
	}
	public Genre() {
		this.idgenre = 0;
		this.nom = "";
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
	
	
}
