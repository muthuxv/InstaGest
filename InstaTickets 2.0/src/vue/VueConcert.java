package vue;

import java.awt.Color;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;


import controleur.Concert;
import controleur.Main;
import controleur.Tableau;


public class VueConcert extends JFrame implements ActionListener{
	
	
	private JTable uneTable ; 
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	private JPanel panelAjout = new JPanel(); 
	private JPanel panelLister = new JPanel(); 
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btRetour = new JButton("<");
	
	private JTextField txtTitre = new JTextField(); 
	private JTextField txtImage = new JTextField(); 
	private JTextField txtDate= new JTextField();
	private JTextField txtDescription= new JTextField();
	private JTextField txtPrix= new JTextField();
	private JComboBox<String> cmbTarif= new JComboBox<String>();
	private JTextField txtIdArtiste= new JTextField();
	private JTextField txtIdLieu= new JTextField();
	
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("Filtrer");
	private JButton btAnnuler = new JButton("Annuler");; 

	public VueConcert() {
	
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des Concerts InstaTickets");
		this.setResizable(false); // Taille de fenetre non modifiable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // procï¿½dure de fermeture de la fenetre
		this.setLayout(null); // pas de cadrillage (prï¿½sent de base)
		
		this.getContentPane().setBackground(new Color (205, 243, 255));

		//Installer le bouton retour
		this.btRetour.setBounds(10, 10, 50, 50);
		this.add(this.btRetour);
		this.btRetour.addActionListener(this);
		
		this.txtMot.setBounds(450, 40, 100, 20);
		this.btFiltrer.setBounds(580, 40, 100, 20);
		this.add(this.txtMot); 
		this.add(this.btFiltrer);
		
		this.btFiltrer.addActionListener(this);
		
		this.btRetour.setBackground(new Color(4, 105, 137 ));
		this.btRetour.setForeground(new Color(255, 255, 255));
		
		this.btEnregistrer.setBackground(new Color(4, 105, 137 ));
		this.btEnregistrer.setForeground(new Color(255, 255, 255));
		
		this.btFiltrer.setBackground(new Color(4, 105, 137 ));
		this.btFiltrer.setForeground(new Color(255, 255, 255));
		
		this.btAnnuler.setBackground(new Color(4, 105, 137 ));
		this.btAnnuler.setForeground(new Color(255, 255, 255));
		//construction du panel Ajout
		this.panelAjout.setBounds(40, 100, 300, 250);
		this.panelAjout.setBackground(new Color (205, 243, 255  ));
		
		
		this.panelAjout.setLayout(new GridLayout(9,2));
		this.panelAjout.add(new JLabel("Titre Concert :")); 
		this.panelAjout.add(this.txtTitre);
		this.panelAjout.add(new JLabel("Image :")); 
		this.panelAjout.add(this.txtImage);
		this.panelAjout.add(new JLabel("Date :")); 
		this.panelAjout.add(this.txtDate);
		this.panelAjout.add(new JLabel("Description :")); 
		this.panelAjout.add(this.txtDescription);
		this.panelAjout.add(new JLabel("Prix :")); 
		this.panelAjout.add(this.txtPrix);
		this.panelAjout.add(new JLabel("Id Artiste :")); 
		this.panelAjout.add(this.txtIdArtiste);
		this.panelAjout.add(new JLabel("Id Lieu :")); 
		this.panelAjout.add(this.txtIdLieu);
		this.panelAjout.add(new JLabel("Tarif :")); 
		this.panelAjout.add(this.cmbTarif);
		this.panelAjout.add(this.btAnnuler); 
		this.panelAjout.add(this.btEnregistrer);
		this.add(this.panelAjout);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		
		//construire le panel Lister 
		this.panelLister.setBackground(new Color (205, 243, 255  ));
		this.panelLister.setLayout(null);
		this.add(this.panelLister); 

		
		this.remplirPanelLister ("");  
		this.setVisible(true);

		//Ajout ds valeurs dans la Combo
		cmbTarif.addItem("gratuit");
		cmbTarif.addItem("payant");


	//suppression d'un artiste de la table 
	
	this.uneTable.addMouseListener(new MouseListener(){
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() >=2) {
				int ligne = uneTable.getSelectedRow();
				System.out.println(ligne);
				int idConcert = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
				int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Concert ?", "Suppression", JOptionPane.YES_NO_OPTION); 
				if (retour == 0) {
					//suppression dans la base 
					Main.deleteConcert(idConcert);
					//suppression dans la table d'affichage 
					unTableau.deleteLigne(ligne);
					JOptionPane.showMessageDialog(null, "Suppression réussie");
				}
			}else if (e.getClickCount() ==1) {
				int ligne = uneTable.getSelectedRow();
				System.out.println(ligne);
				txtTitre.setText(unTableau.getValueAt(ligne, 1).toString());
				txtImage.setText(unTableau.getValueAt(ligne, 2).toString());
				txtDate.setText(unTableau.getValueAt(ligne, 3).toString());
				txtDescription.setText(unTableau.getValueAt(ligne, 4).toString());
				txtPrix.setText(unTableau.getValueAt(ligne, 5).toString());
				txtIdArtiste.setText(unTableau.getValueAt(ligne, 6).toString());
				txtIdLieu.setText(unTableau.getValueAt(ligne, 7).toString());
				cmbTarif.setToolTipText(unTableau.getValueAt(ligne, 8).toString());
				btEnregistrer.setText("Modifier");		
			}
			
		}
	});
	
	 //filtrer les Artistes par un mot de recherche 
}

public void remplirPanelLister(String mot) {
	
	this.panelLister.removeAll();
	String entetes [] = {"IdConcert", "Titre", "Image", "Date", "Description", "Prix", "IdArtiste", "IdLieu", "Tarif"};
	Object donnees [][] = this.getDonnees (mot) ;		
	this.unTableau = new Tableau (donnees, entetes); 
	this.uneTable = new JTable(this.unTableau); 
	this.uneScroll = new JScrollPane(this.uneTable); 
	this.panelLister.setBounds(350, 80, 530, 300);
	
	this.uneScroll.setBounds(20, 20, 510, 280);
	this.panelLister.add(this.uneScroll);
	
}

public Object [] [] getDonnees(String mot) {
	//recuperer les Artistes de la bdd 
	ArrayList<Concert> lesConcerts = Main.selectAllConcerts(mot); 
	//transofrmation des artistes en matrice de donnÃ©es 
	Object donnees [][] = new Object [lesConcerts.size()][9];
	int i = 0 ; 
	for (Concert unConcert : lesConcerts) {
		donnees[i][0] = unConcert.getIdconcert()+""; 
		donnees[i][1] = unConcert.getTitre();
		donnees[i][2] = unConcert.getImage();
		donnees[i][3] = unConcert.getDateconcert();
		donnees[i][4] = unConcert.getDescriptionconcert(); 
		donnees[i][5] = unConcert.getPrix()+"";
		donnees[i][6] = unConcert.getIdartiste()+"";
		donnees[i][7] = unConcert.getIdlieu()+"";
		donnees[i][8] = unConcert.getTarif();
		i++; 
	}

	return donnees;
}

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == this.btRetour) {
		this.dispose ();
		//retour au menu
		Main.rendreVisible(true);
	}
	else if (e.getSource() == this.btAnnuler)
	{
		this.viderLesChamps (); 
	}
	else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) 
	{
		this.insertConcert (); 
	}
	else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier")) 
	{
		this.updateConcert (); 
	}else if (e.getSource() == this.btFiltrer)
	{
		this.remplirPanelLister(this.txtMot.getText());
	}
}

public void updateConcert() {
	String titre = this.txtTitre.getText();
	String image = this.txtImage.getText(); 
	String date = this.txtDate.getText(); 
	String description = this.txtDescription.getText(); 
	int prix = Integer.parseInt(this.txtPrix.getText());
	String tarif = this.cmbTarif.getSelectedItem().toString();
	int idArtiste = Integer.parseInt(this.txtIdArtiste.getText());
	int idLieu = Integer.parseInt(this.txtIdLieu.getText());
	
		int numLigne = uneTable.getSelectedRow(); 
		int idConcert = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
		
		Concert unConcert = new Concert(idConcert, titre, image, date, description, prix, idArtiste, idLieu, tarif);
		//update dans la base de donnÃ©es 
		Main.updateConcert(unConcert);
		
		//modification dans l'affichage tableau 
		Object ligne[] = {unConcert.getIdconcert(), titre, image, date, description, prix + "", idArtiste + "", idLieu + "", tarif};
		this.unTableau.updateLigne(numLigne, ligne);
		
		JOptionPane.showMessageDialog(this,"Modification réussie !");
		this.viderLesChamps();

}

public void insertConcert() {
	String titre = this.txtTitre.getText();
	String image = this.txtImage.getText(); 
	String date = this.txtDate.getText(); 
	String description = this.txtDescription.getText(); 
	int prix = Integer.parseInt(this.txtPrix.getText());
	String tarif = this.cmbTarif.getSelectedItem().toString();
	int idArtiste = Integer.parseInt(this.txtIdArtiste.getText());
	int idLieu = Integer.parseInt(this.txtIdLieu.getText());
	
	int numLigne = 0;
	int idConcert = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());

		Concert unConcert = new Concert(idConcert, titre, image, date, description, prix, idArtiste, idLieu, tarif);
		//insertion dans la base de donnï¿½es 
		Main.insertConcert(unConcert);
		
		//recuperation de l'id a travers un select where 
		unConcert = Main.selectWhereConcert(titre);
		
		//insertion dans l'affichage tableau 
		Object ligne[] = {unConcert.getIdconcert(), titre, image, date, description, prix + "", idArtiste + "", idLieu + "", tarif};
		this.unTableau.insertLigne(ligne);
	
		JOptionPane.showMessageDialog(this,"Insertion réussie !");
		this.viderLesChamps();
	
}

public void viderLesChamps() {
	//vider l'ensemble des champs du formulaire 
	 this.txtTitre.setText("");
	 this.txtImage.setText("");
	 this.txtDate.setText(""); 
	 this.txtDescription.setText("");
	 this.txtPrix.setText(""); 
	 this.txtIdArtiste.setText(""); 
	 this.txtIdLieu.setText(""); 

	 this.btEnregistrer.setText("Enregistrer");
}

}