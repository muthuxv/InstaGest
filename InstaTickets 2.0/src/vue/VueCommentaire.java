package vue;

import java.awt.Color;


import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


import controleur.Commentaire;
import controleur.Main;
import controleur.Tableau;


public class VueCommentaire extends JFrame implements ActionListener{
	
	
	private JTable uneTable ; 
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	private JPanel panelAjout = new JPanel(); 
	private JPanel panelLister = new JPanel(); 
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btRetour = new JButton("<");
	
	private JTextField txtComment = new JTextField(); 
	private JTextField txtNote= new JTextField(); 
	private JTextField txtIdConcert= new JTextField(); 

	
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("Filtrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	

	public VueCommentaire() {
	
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des Commentaires InstaTickets");
		this.setResizable(false); // Taille de fenetre non modifiable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // proc�dure de fermeture de la fenetre
		this.setLayout(null); // pas de cadrillage (pr�sent de base)
		
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
/*
		//construction du panel Ajout
		this.panelAjout.setBounds(40, 100, 300, 250);
		this.panelAjout.setBackground(new Color (205, 243, 255  ));
		
		
		
		this.panelAjout.setLayout(new GridLayout(7,2));
		this.panelAjout.add(new JLabel("Commentaire : ")); 
		this.panelAjout.add(this.txtComment);
		this.panelAjout.add(new JLabel("Note : ")); 
		this.panelAjout.add(this.txtNote);
		this.panelAjout.add(new JLabel("IdConcert :")); 
		this.panelAjout.add(this.txtIdConcert);
		
		this.panelAjout.add(this.btAnnuler); 
		this.panelAjout.add(this.btEnregistrer);
		this.add(this.panelAjout);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		*/
		
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
				int idCommentaire = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
				int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce commentaire ?", "Suppression", JOptionPane.YES_NO_OPTION); 
				if (retour == 0) {
					//suppression dans la base 
					Main.deleteCommentaire(idCommentaire);
					//suppression dans la table d'affichage 
					unTableau.deleteLigne(ligne);
					JOptionPane.showMessageDialog(null, "Suppression réussie");
				}
			}/*else if (e.getClickCount() ==1) {
				int ligne = uneTable.getSelectedRow();
				System.out.println(ligne);
				txtComment.setText(unTableau.getValueAt(ligne, 1).toString());
				txtNote.setText(unTableau.getValueAt(ligne, 2).toString());
				txtIdConcert.setText(unTableau.getValueAt(ligne, 3).toString());
				btEnregistrer.setText("Modifier");		
			}
			*/
		}
	});
	

	 //filtrer les Commentaires par un mot de recherche 
}

public void remplirPanelLister(String mot) {
	
	this.panelLister.removeAll();
	String entetes [] = {"IdCommentaire", "DateCommentaire", "Contenu", "note", "idConcert", "idMembre"};
	Object donnees [][] = this.getDonnees (mot) ;		
	this.unTableau = new Tableau (donnees, entetes); 
	this.uneTable = new JTable(this.unTableau); 
	this.uneScroll = new JScrollPane(this.uneTable); 
	
	this.panelLister.setBounds(40, 100, 700, 350);
	this.uneScroll.setBounds(0, 0, 690, 340);
	this.panelLister.add(this.uneScroll);
	
}


public Object [] [] getDonnees(String mot) {
	//recuperer les Artistes de la bdd 
	ArrayList<Commentaire> lesCommentaires = Main.selectAllCommentaires(mot); 
	//transofrmation des commentaires en matrice de données 
	Object donnees [][] = new Object [lesCommentaires.size()][6];
	int i = 0 ; 
	for (Commentaire unCommentaire : lesCommentaires) {
		donnees[i][0] = unCommentaire.getIdcommmentaire()+""; 
		donnees[i][1] = unCommentaire.getDatecomment(); 
		donnees[i][2] = unCommentaire.getContenu();  
		donnees[i][3] = unCommentaire.getNote()+""; 
		donnees[i][4] = unCommentaire.getIdconcert()+""; 
		donnees[i][5] = unCommentaire.getIdmembre()+""; 

		
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
	}/*
	else if (e.getSource() == this.btAnnuler)
	{
		this.viderLesChamps (); 
	}
	else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) 
	{
		this.insertCommentaire (); 
	}
	else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier")) 
	{
		this.updateCommentaire (); 
	}*/
	else if (e.getSource() == this.btFiltrer)
	{
		this.remplirPanelLister(this.txtMot.getText());
	}
}
/*
public void updateCommentaire() {
	String commentaire = this.txtComment.getText(); 
	int note = Integer.parseInt(this.txtNote.getText()); 
	int idconcert = Integer.parseInt(this.txtIdConcert.getText());  
	
		int numLigne = uneTable.getSelectedRow(); 
		int idCommentaire = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
		
		Commentaire unCommentaire = new Commentaire(idCommentaire , commentaire, note, idconcert);
		//update dans la base de données 
		Main.updateCommentaire(unCommentaire);
		
		//modification dans l'affichage tableau 
		Object ligne[] = {unCommentaire.getIdcommmentaire(), commentaire, note+"", idconcert+""};
		this.unTableau.updateLigne(numLigne, ligne);
		
		JOptionPane.showMessageDialog(this,"Modification r�ussie !");
		this.viderLesChamps();

	
}

public void insertCommentaire() {
	String commentaire = this.txtComment.getText(); 
	int note = Integer.parseInt(this.txtNote.getText()); 
	int idconcert = Integer.parseInt(this.txtIdConcert.getText());  
	
	int numLigne = 0;
	int idCommentaire = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
	

	//datecomment = ?? 
	
		Commentaire unCommentaire = new Commentaire(idCommentaire, datecomment , commentaire, note, idconcert);
		//insertion dans la base de donn�es 
		Main.insertCommentaire(unCommentaire);
		
		//recuperation de l'id a travers un select where 
		unCommentaire = Main.selectWhereCommentaire(commentaire);
		
		//insertion dans l'affichage tableau 
		Object ligne[] = {unCommentaire.getIdcommmentaire(), commentaire, note+"", idconcert+""};
		this.unTableau.insertLigne(ligne);
	
		JOptionPane.showMessageDialog(this,"Insertion réussie !");
		this.viderLesChamps();
	
}

public void viderLesChamps() {
	//vider l'ensemble des champs du formulaire 
	 this.txtComment.setText("");
	 this.txtNote.setText("");
	 this.txtIdConcert.setText(""); 

	 this.btEnregistrer.setText("Enregistrer");
}
*/
}
