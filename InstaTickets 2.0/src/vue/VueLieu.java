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


import controleur.Lieu;
import controleur.Main;
import controleur.Tableau;


public class VueLieu extends JFrame implements ActionListener{
	
	
	private JTable uneTable ; 
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	private JPanel panelAjout = new JPanel(); 
	private JPanel panelLister = new JPanel(); 
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btRetour = new JButton("<");
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtAdresse = new JTextField(); 
	private JTextField txtCapacite= new JTextField(); 
		
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("Filtrer");
	private JButton btAnnuler = new JButton("Annuler");; 

	public VueLieu() {
	
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des Lieux InstaTickets");
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
		
		
		this.panelAjout.setLayout(new GridLayout(7,2));
		this.panelAjout.add(new JLabel("Nom du Lieu :")); 
		this.panelAjout.add(this.txtNom);
		this.panelAjout.add(new JLabel("Adresse :")); 
		this.panelAjout.add(this.txtAdresse);
		this.panelAjout.add(new JLabel("Capacité :")); 
		this.panelAjout.add(this.txtCapacite);
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
				int idlieu = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
				int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Lieu ?", "Suppression", JOptionPane.YES_NO_OPTION); 
				if (retour == 0) {
					//suppression dans la base 
					Main.deleteLieu(idlieu);
					//suppression dans la table d'affichage 
					unTableau.deleteLigne(ligne);
					JOptionPane.showMessageDialog(null, "Suppression réussie");
				}
			}else if (e.getClickCount() ==1) {
				int ligne = uneTable.getSelectedRow();
				System.out.println(ligne);
				txtNom.setText(unTableau.getValueAt(ligne, 1).toString());
				txtAdresse.setText(unTableau.getValueAt(ligne, 2).toString());
				txtCapacite.setText(unTableau.getValueAt(ligne, 3).toString());
				btEnregistrer.setText("Modifier");		
			}
			
		}
	});
	
	 //filtrer les Lieux par un mot de recherche 
}

public void remplirPanelLister(String mot) {
	
	this.panelLister.removeAll();
	String entetes [] = {"Idlieu", "Nom", "Adresse", "Capacite"};
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
	ArrayList<Lieu> lesLieux = Main.selectAllLieux(mot); 
	//transofrmation des artistes en matrice de donnï¿½es 
	Object donnees [][] = new Object [lesLieux.size()][4];
	int i = 0 ; 
	for (Lieu unLieu : lesLieux) {
		donnees[i][0] = unLieu.getIdlieu()+""; 
		donnees[i][1] = unLieu.getNom(); 
		donnees[i][2] = unLieu.getAdresse();  
		donnees[i][3] = unLieu.getCapacite()+""; 
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
		this.insertLieu (); 
	}
	else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier")) 
	{
		this.updateLieu (); 
	}else if (e.getSource() == this.btFiltrer)
	{
		this.remplirPanelLister(this.txtMot.getText());
	}
}

public void updateLieu() {
	String nom = this.txtNom.getText(); 
	String adresse = this.txtAdresse.getText(); 
	int capacite = Integer.parseInt(this.txtCapacite.getText());  
	
		int numLigne = uneTable.getSelectedRow(); 
		int idlieu = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
		
		Lieu unLieu = new Lieu(idlieu, nom, adresse, capacite);
		//update dans la base de donnÃ©es 
		Main.updateLieu(unLieu);
		
		//modification dans l'affichage tableau 
		Object ligne[] = {unLieu.getIdlieu(), nom, adresse, capacite+""};
		this.unTableau.updateLigne(numLigne, ligne);
		
		JOptionPane.showMessageDialog(this,"Modification réussie !");
		this.viderLesChamps();

	
}

public void insertLieu() {
	String nom = this.txtNom.getText(); 
	String adresse = this.txtAdresse.getText(); 
	int capacite = Integer.parseInt(this.txtCapacite.getText()); 
	
	int numLigne = 0;
	int idlieu = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());

		Lieu unLieu = new Lieu(idlieu, nom, adresse, capacite);		//insertion dans la base de donnï¿½es 
		Main.insertLieu(unLieu);
		
		//recuperation de l'id a travers un select where 
		unLieu = Main.selectWhereLieu(nom);
		
		//insertion dans l'affichage tableau 
		Object ligne[] = {unLieu.getIdlieu(), nom, adresse, capacite+""};
		this.unTableau.insertLigne(ligne);
	
		JOptionPane.showMessageDialog(this,"Insertion réussie !");
		this.viderLesChamps();
	
}

public void viderLesChamps() {
	//vider l'ensemble des champs du formulaire 
	 this.txtNom.setText("");
	 this.txtAdresse.setText("");
	 this.txtCapacite.setText(""); 

	 this.btEnregistrer.setText("Enregistrer");
}

}
