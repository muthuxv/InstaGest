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


import controleur.Artiste;
import controleur.Main;
import controleur.Tableau;


public class VueArtiste extends JFrame implements ActionListener{
	
	
	private JTable uneTable ; 
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	private JPanel panelAjout = new JPanel(); 
	private JPanel panelLister = new JPanel(); 
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btRetour = new JButton("<");
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPhotoArtiste = new JTextField(); 
	private JTextField txtIdGenre= new JTextField(); 
	
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("Filtrer");
	private JButton btAnnuler = new JButton("Annuler");; 

	public VueArtiste() {
	
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des Artistes InstaTickets");
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

		//construction du panel Ajout
		this.panelAjout.setBounds(40, 100, 300, 250);
		this.panelAjout.setBackground(new Color (205, 243, 255  ));
		
		this.btRetour.setBackground(new Color(4, 105, 137 ));
		this.btRetour.setForeground(new Color(255, 255, 255));
		
		this.btEnregistrer.setBackground(new Color(4, 105, 137 ));
		this.btEnregistrer.setForeground(new Color(255, 255, 255));
		
		this.btFiltrer.setBackground(new Color(4, 105, 137 ));
		this.btFiltrer.setForeground(new Color(255, 255, 255));
		
		this.btAnnuler.setBackground(new Color(4, 105, 137 ));
		this.btAnnuler.setForeground(new Color(255, 255, 255));
		
		this.panelAjout.setLayout(new GridLayout(7,2));
		this.panelAjout.add(new JLabel("Nom Artiste :")); 
		this.panelAjout.add(this.txtNom);
		this.panelAjout.add(new JLabel("PhotoArtiste :")); 
		this.panelAjout.add(this.txtPhotoArtiste);
		this.panelAjout.add(new JLabel("IdGenre :")); 
		this.panelAjout.add(this.txtIdGenre);
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
				int idArtiste = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
				int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet Artiste ?", "Suppression", JOptionPane.YES_NO_OPTION); 
				if (retour == 0) {
					//suppression dans la base 
					Main.deleteArtiste(idArtiste);
					//suppression dans la table d'affichage 
					unTableau.deleteLigne(ligne);
					JOptionPane.showMessageDialog(null, "Suppression réussie");
				}
			}else if (e.getClickCount() ==1) {
				int ligne = uneTable.getSelectedRow();
				System.out.println(ligne);
				txtNom.setText(unTableau.getValueAt(ligne, 1).toString());
				txtPhotoArtiste.setText(unTableau.getValueAt(ligne, 2).toString());
				txtIdGenre.setText(unTableau.getValueAt(ligne, 3).toString());
				btEnregistrer.setText("Modifier");		
			}
			
		}
	});
	
	 //filtrer les Artistes par un mot de recherche 
}

public void remplirPanelLister(String mot) {
	
	this.panelLister.removeAll();
	String entetes [] = {"IdArtiste", "Nom", "PhotoArtiste", "Genre"};
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
	ArrayList<Artiste> lesArtistes = Main.selectAllArtistes(mot); 
	//transofrmation des artistes en matrice de donnÃ©es 
	Object donnees [][] = new Object [lesArtistes.size()][4];
	int i = 0 ; 
	for (Artiste unArtiste : lesArtistes) {
		donnees[i][0] = unArtiste.getIdartiste()+""; 
		donnees[i][1] = unArtiste.getNom(); 
		donnees[i][2] = unArtiste.getPhoto_artiste();  
		donnees[i][3] = unArtiste.getIdgenre()+""; 
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
		this.insertArtiste (); 
	}
	else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier")) 
	{
		this.updateArtiste (); 
	}else if (e.getSource() == this.btFiltrer)
	{
		this.remplirPanelLister(this.txtMot.getText());
	}
}

public void updateArtiste() {
	String nom = this.txtNom.getText(); 
	String photoArtiste = this.txtPhotoArtiste.getText(); 
	int idGenre = Integer.parseInt(this.txtIdGenre.getText());  
	
		int numLigne = uneTable.getSelectedRow(); 
		int idArtiste = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
		
		Artiste unArtiste = new Artiste(idArtiste, nom, photoArtiste, idGenre);
		//update dans la base de donnÃ©es 
		Main.updateArtiste(unArtiste);
		
		//modification dans l'affichage tableau 
		Object ligne[] = {unArtiste.getIdartiste(), nom, photoArtiste, idGenre+""};
		this.unTableau.updateLigne(numLigne, ligne);
		
		JOptionPane.showMessageDialog(this,"Modification réussie !");
		this.viderLesChamps();

	
}

public void insertArtiste() {
	String nom = this.txtNom.getText(); 
	String photoArtiste = this.txtPhotoArtiste.getText(); 
	int idGenre = Integer.parseInt(this.txtIdGenre.getText());  
	
	int numLigne = 0;
	int idArtiste = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());

		Artiste unArtiste = new Artiste(idArtiste, nom, photoArtiste, idGenre);
		//insertion dans la base de donnï¿½es 
		Main.insertArtiste(unArtiste);
		
		//recuperation de l'id a travers un select where 
		unArtiste = Main.selectWhereArtiste(nom);
		
		//insertion dans l'affichage tableau 
		Object ligne[] = {unArtiste.getIdartiste(), nom, photoArtiste, idGenre+""};
		this.unTableau.insertLigne(ligne);
	
		JOptionPane.showMessageDialog(this,"Insertion réussie !");
		this.viderLesChamps();
	
}

public void viderLesChamps() {
	//vider l'ensemble des champs du formulaire 
	 this.txtNom.setText("");
	 this.txtPhotoArtiste.setText("");
	 this.txtIdGenre.setText(""); 

	 this.btEnregistrer.setText("Enregistrer");
}

}
