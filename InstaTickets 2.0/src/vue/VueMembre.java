package vue;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Membre;
import controleur.Tableau;

public class VueMembre extends JFrame implements ActionListener 
{
	private JButton btRetour = new JButton("<"); 
	private JPanel panelAjout = new JPanel(); 
	private JPanel panelLister = new JPanel(); 
	
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField(); 
	private JTextField txtAdresse= new JTextField(); 
	private JTextField txtTel = new JTextField(); 
	private JTextField txtEmail = new JTextField(); 
	private JTextField txtDroits= new JTextField();
	private JTextField txtMdp= new JTextField();
	
	private JTable uneTable ; 
	private JScrollPane uneScroll ; 
	private Tableau unTableau ;
	
	private JTextField txtMot = new JTextField ();
	private JButton btFiltrer = new JButton("filtrer"); 
	
	public VueMembre ()
	{
		this.setBounds(100, 100, 900, 500);
		this.setTitle("Gestion des Membres d'InstaTickets");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		this.getContentPane().setBackground(new Color (205, 243, 255));
		
		//installer le bouton retour 
		this.btRetour.setBounds(10, 10, 50, 50);
		this.add(this.btRetour); 
		this.btRetour.addActionListener(this);
		
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
		this.panelAjout.setBackground(new Color (205, 243, 255));
		this.panelAjout.setLayout(new GridLayout(8,2));
		this.panelAjout.add(new JLabel("Nom :")); 
		this.panelAjout.add(this.txtNom);
		this.panelAjout.add(new JLabel("Prénom :")); 
		this.panelAjout.add(this.txtPrenom);
		this.panelAjout.add(new JLabel("Adresse :")); 
		this.panelAjout.add(this.txtAdresse);
		this.panelAjout.add(new JLabel("Tel :")); 
		this.panelAjout.add(this.txtTel);
		this.panelAjout.add(new JLabel("Email :")); 
		this.panelAjout.add(this.txtEmail);
		this.panelAjout.add(new JLabel("Droits :")); 
		this.panelAjout.add(this.txtDroits);
		this.panelAjout.add(new JLabel("MDP :")); 
		this.panelAjout.add(this.txtMdp);
		this.panelAjout.add(this.btAnnuler); 
		this.panelAjout.add(this.btEnregistrer);
		this.add(this.panelAjout);
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
		
		//construire le panel Lister 
		this.panelLister.setBackground(new Color (205, 243, 255));
		this.panelLister.setLayout(null);
		this.add(this.panelLister); 
		
		this.remplirPanelLister ("");  
		
		
		//suppression d'un Membre de la table 
		
		this.uneTable.addMouseListener(new MouseListener() {
			
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
					int idmembre = Integer.parseInt(unTableau.getValueAt(ligne, 0).toString()); 
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce Membre ?", "Suppression", JOptionPane.YES_NO_OPTION); 
					if (retour == 0) {
						//suppression dans la base 
						Main.deleteMembre(idmembre);
						//suppression dans la table d'affichage 
						unTableau.deleteLigne(ligne);
						JOptionPane.showMessageDialog(null, "Suppression réussie");
					}
				}else if (e.getClickCount() ==1) {
					int ligne = uneTable.getSelectedRow();
					txtNom.setText(unTableau.getValueAt(ligne, 1).toString());
					txtPrenom.setText(unTableau.getValueAt(ligne, 2).toString());
					txtAdresse.setText(unTableau.getValueAt(ligne, 3).toString());
					txtTel.setText(unTableau.getValueAt(ligne, 4).toString());
					txtEmail.setText(unTableau.getValueAt(ligne, 5).toString());
					txtDroits.setText(unTableau.getValueAt(ligne, 6).toString());
					txtMdp.setText(unTableau.getValueAt(ligne, 7).toString());
					btEnregistrer.setText("Modifier");
				}
				
			}
		});
		
		//filter les Membres par un mot de recherche 
		this.txtMot.setBounds(450, 40, 100, 20);
		this.add(this.txtMot); 
		this.btFiltrer.setBounds(580, 40, 100, 20);
		this.add(this.btFiltrer);
		this.btFiltrer.addActionListener(this);
		
		this.setVisible(true);
	}

	public void remplirPanelLister(String mot) {
		
		this.panelLister.removeAll();
		String entetes [] = {"Id Membre", "Nom", "PrÃ©nom", "Adresse", "Tel", "Email", "Droits","Mot de Passe"};
		Object donnees [][] = this.getDonnees (mot) ;		
		this.unTableau = new Tableau (donnees, entetes); 
		this.uneTable = new JTable(this.unTableau); 
		this.uneScroll = new JScrollPane(this.uneTable); 
		this.panelLister.setBounds(350, 80, 530, 300);
		
		this.uneScroll.setBounds(20, 20, 510, 280);
		this.panelLister.add(this.uneScroll);
		
	}

	public Object [] [] getDonnees(String mot) {
		//recuperer les Membres de la bdd 
		ArrayList<Membre> lesMembres = Main.selectAllMembres(mot); 
		//transofrmation des Membres en matrice de donnï¿½es 
		Object donnees [][] = new Object [lesMembres.size()][8];
		int i = 0 ; 
		for (Membre unMembre : lesMembres) {
			donnees[i][0] = unMembre.getIdMembre()+""; 
			donnees[i][1] = unMembre.getNom(); 
			donnees[i][2] = unMembre.getPrenom(); 
			donnees[i][3] = unMembre.getAdresse(); 
			donnees[i][4] = unMembre.getTel(); 
			donnees[i][5] = unMembre.getEmail(); 
			donnees[i][6] = unMembre.getDroits(); 
			donnees[i][7] = unMembre.getMdp();
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
			this.viderLesChamps(); 
		}
		else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Enregistrer")) 
		{
			this.insertMembre (); 
		}
		else if (e.getSource()  == this.btEnregistrer && e.getActionCommand().equals("Modifier")) 
		{
			this.updateMembre (); 
		}else if (e.getSource() == this.btFiltrer)
		{
			this.remplirPanelLister(this.txtMot.getText());
		}
	}

	public void updateMembre() {
		String nom = this.txtNom.getText(); 
		String prenom = this.txtPrenom.getText(); 
		String tel = this.txtTel.getText();
		String adresse = this.txtAdresse.getText();
		String email = this.txtEmail.getText(); 
		String droits = this.txtDroits.getText();
		String mdp = this.txtMdp.getText();
		/*
		int nbHeuresVols = 0; 
		try {
			nbHeuresVols = Integer.parseInt(this.txtNbHeuresVols.getText());
		}
		catch (NumberFormatException exp) {
			JOptionPane.showMessageDialog(this,"Attention au format du nombre d'heures de vols !");
			nbHeuresVols = -1 ;
		}
		*/
		int numLigne = uneTable.getSelectedRow(); 
		int idmembre = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString ());
		Membre unMembre = new Membre(idmembre,nom, prenom, adresse, tel, email, droits, mdp);
		//update dans la base de donnï¿½es 
		Main.updateMembre(unMembre);
			
		//modifiaction dans l'affichage tableau 
		Object ligne[] = {unMembre.getIdMembre(), nom, prenom, adresse, tel, email, droits, mdp};
		this.unTableau.updateLigne(numLigne, ligne);
			
		JOptionPane.showMessageDialog(this,"Modification réussie !");
		this.viderLesChamps();
		
	}

	public void insertMembre() {
		String nom = this.txtNom.getText(); 
		String prenom = this.txtPrenom.getText(); 
		String adresse = this.txtAdresse.getText();
		String tel = this.txtTel.getText();
		String email = this.txtEmail.getText();
		String droits = this.txtDroits.getText(); 
		String mdp = this.txtMdp.getText();
		
		Membre unMembre = new Membre(nom, prenom, adresse, tel, email, droits, mdp);
		//insertion dans la base de donnï¿½es 
		Main.insertMembre(unMembre);
			
		//recuperation de l'id a travers un select where 
		unMembre = Main.selectWhereMembre(email, nom);
			
		//insertion dans l'affichage tableau 
		Object ligne[] = {unMembre.getIdMembre(), nom, prenom, adresse, tel, email, droits, mdp};
		this.unTableau.insertLigne(ligne);
			
		JOptionPane.showMessageDialog(this,"Insertion réussie !");
		this.viderLesChamps();

		
	}

	public void viderLesChamps() {
		//vider l'ensemble des champs du formulaire 
		 this.txtTel.setText("");; 
		 this.txtEmail.setText("");
		 this.txtAdresse.setText(""); 
		 this.txtEmail.setText("");
		 this.txtNom.setText("");
		 this.txtDroits.setText("");
		 this.txtPrenom.setText("");
		 this.txtMdp.setText("");
		 this.btEnregistrer.setText("Enregistrer");
	}
	

}