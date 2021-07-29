package controleur;

public class Concert {
	
	private int idconcert, prix, idartiste, idlieu;
	private String titre, image, dateconcert, descriptionconcert, tarif;
	
	
	public Concert(int idconcert, String titre, String image, String dateconcert,String descriptionconcert, int prix, int idartiste,
			int idlieu, String tarif) {
		this.idconcert = idconcert;
		this.prix = prix;
		this.idartiste = idartiste;
		this.idlieu = idlieu;
		this.titre = titre;
		this.image = image;
		this.dateconcert = dateconcert;
		this.descriptionconcert = descriptionconcert;
		this.tarif = tarif;
	}
	public Concert(String titre, String image, String dateconcert,String descriptionconcert, int prix, int idartiste,
			int idlieu, String tarif) {
		this.idconcert = 0;
		this.prix = prix;
		this.idartiste = idartiste;
		this.idlieu = idlieu;
		this.titre = titre;
		this.image = image;
		this.dateconcert = dateconcert;
		this.descriptionconcert = descriptionconcert;
		this.tarif = tarif;
	}
	public Concert() {
		this.idconcert = 0;
		this.prix = 0;
		this.idartiste = 0;
		this.idlieu = 0;
		this.titre = "";
		this.image = "";
		this.dateconcert = "";
		this.descriptionconcert = "";
		this.tarif = "";
	}

	public String getTarif() {
		return tarif;
	}
	public void setTarif(String tarif) {
		this.tarif = tarif;
	}
	public int getIdconcert() {
		return idconcert;
	}


	public void setIdconcert(int idconcert) {
		this.idconcert = idconcert;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getIdartiste() {
		return idartiste;
	}


	public void setIdartiste(int idartiste) {
		this.idartiste = idartiste;
	}


	public int getIdlieu() {
		return idlieu;
	}


	public void setIdlieu(int idlieu) {
		this.idlieu = idlieu;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDateconcert() {
		return dateconcert;
	}


	public void setDateconcert(String dateconcert) {
		this.dateconcert = dateconcert;
	}


	public String getDescriptionconcert() {
		return descriptionconcert;
	}


	public void setDescriptionconcert(String descriptionconcert) {
		this.descriptionconcert = descriptionconcert;
	}
	
	
	
	

}
