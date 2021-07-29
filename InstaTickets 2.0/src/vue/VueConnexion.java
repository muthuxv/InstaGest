package vue;


import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Membre;

import javax.swing.JPasswordField;


public class VueConnexion extends JFrame implements ActionListener, KeyListener {
	
	private JButton btSeConnecter = new JButton("Se connecter");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtEmail = new JTextField("r@gmail.com");
	
	private JPasswordField txtMdp = new JPasswordField("1234");
	
	
	private JPanel panelConnexion = new JPanel();
	private JPanel panelMenuGeneral = new JPanel();
	
	private JButton btArtiste = new JButton("Artistes");
	private JButton btConcert = new JButton("Concerts");
	private JButton btCommentaire = new JButton("Commentaires");
	private JButton btGenre = new JButton("Genres");
	private JButton btLieu = new JButton("Lieux");
	private JButton btMembre = new JButton("Membres");
	private JButton btQuitter = new JButton("Quitter");


	
	
	public VueConnexion() {
		this.setBounds(200, 200, 700, 300);
		this.setTitle("Connexion à  l'application InstaTickets");
		this.setResizable(false); // Taille de fenetre non modifiable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // procï¿½dure de fermeture de la fenetre
		this.setLayout(null); // pas de cadrillage (prï¿½sent de base)
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/images/LogoTicket.png");  //Icone Fenetre
	    this.setIconImage(icon); 
		
		this.getContentPane().setBackground(new Color (205, 243, 255));

		this.panelConnexion.setLayout(new GridLayout(3, 2, 0, 2));
		this.panelConnexion.setBounds(340, 60, 300, 140);
		
		this.panelConnexion.setBackground(new Color (205, 243, 255 ));
		this.panelConnexion.add(new JLabel("Email :"));
		this.panelConnexion.add(this.txtEmail);
		this.txtEmail.setBorder(null);
		this.txtMdp.setBorder(null);
		this.panelConnexion.add(new JLabel("Mot de passe :"));
		this.panelConnexion.add(this.txtMdp);
		this.panelConnexion.add(this.btAnnuler);
		this.panelConnexion.add(this.btSeConnecter);
		
		this.btAnnuler.setBackground(new Color(4, 105, 137 ));
		this.btAnnuler.setForeground(new Color(255, 255, 255));
		
		this.btSeConnecter.setBackground(new Color(4, 105, 137 ));
		this.btSeConnecter.setForeground(new Color(255, 255, 255));
		
		this.btArtiste.setBackground(new Color(4, 105, 137 ));
		this.btArtiste.setForeground(new Color(255, 255, 255));
		
		this.btConcert.setBackground(new Color(4, 105, 137 ));
		this.btConcert.setForeground(new Color(255, 255, 255));
		
		this.btGenre.setBackground(new Color(4, 105, 137 ));
		this.btGenre.setForeground(new Color(255, 255, 255));
		
		this.btCommentaire.setBackground(new Color(4, 105, 137 ));
		this.btCommentaire.setForeground(new Color(255, 255, 255));
		
		this.btMembre.setBackground(new Color(4, 105, 137 ));
		this.btMembre.setForeground(new Color(255, 255, 255));
		
		this.btLieu.setBackground(new Color(4, 105, 137 ));
		this.btLieu.setForeground(new Color(255, 255, 255));
		
		this.btQuitter.setBackground(new Color(4, 105, 137 ));
		this.btQuitter.setForeground(new Color(255, 255, 255));
		
		ImageIcon uneImage = new ImageIcon("src/images/LogoTicket.png");
		JLabel monLogo = new JLabel(uneImage);
		monLogo.setBounds(50, 50, 150, 150);
		this.add(monLogo);
		 
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
	    
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.add(this.panelConnexion);
		
		
		
		this.panelMenuGeneral.setLayout(new GridLayout(5, 2, 0, 2));
		this.panelMenuGeneral.setBounds(280, 60, 380, 190);
		this.panelMenuGeneral.setBackground(new Color (205, 243, 255 ));
		
		this.panelMenuGeneral.add(new JLabel("Menu De Gestion :"));
		this.panelMenuGeneral.add(new JLabel("     "));
		this.panelMenuGeneral.add(new JLabel("     "));
		this.panelMenuGeneral.add(this.btArtiste);
		this.panelMenuGeneral.add(this.btConcert);
		this.panelMenuGeneral.add(this.btCommentaire);
		this.panelMenuGeneral.add(this.btGenre);
		this.panelMenuGeneral.add(this.btLieu);
		this.panelMenuGeneral.add(this.btMembre);
		this.panelMenuGeneral.add(new JLabel("     "));
		this.panelMenuGeneral.add(new JLabel("     "));
		this.panelMenuGeneral.add(new JLabel("     "));
		this.panelMenuGeneral.add(new JLabel("     "));
		this.panelMenuGeneral.add(new JLabel("     "));

		this.panelMenuGeneral.add(this.btQuitter);



		
		this.panelMenuGeneral.setVisible(false);
		this.add(this.panelMenuGeneral);
		
		this.btArtiste.addActionListener(this);
		this.btConcert.addActionListener(this);
		this.btCommentaire.addActionListener(this);
		this.btGenre.addActionListener(this);
		this.btLieu.addActionListener(this);
		this.btMembre.addActionListener(this);
		this.btQuitter.addActionListener(this);

		
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}else if (e.getSource()== btSeConnecter) {
			this.traitement();
		}else if (e.getSource()== this.btQuitter) {
			int retour = JOptionPane.showConfirmDialog(this, "Voulez vous quitter l'application ?", "Quitter l'application", JOptionPane.YES_NO_OPTION);
			if(retour == 0) {
				this.panelConnexion.setVisible(true);
				this.panelMenuGeneral.setVisible(false);
				this.txtEmail.setText("");
				this.txtMdp.setText("");
			}
		}else if (e.getSource()== this.btArtiste) {
			
			//on rend invisible la vue connexion
			this.setVisible(false);
			//on instancie la vue artiste
			Main.instancierVueArtiste();
			
		}else if (e.getSource()== this.btConcert) {
			this.setVisible(false);
			//on instancie la vue artiste
			Main.instancierVueConcert();
			
		}else if (e.getSource()== this.btCommentaire) {
			this.setVisible(false);
			
			Main.instancierVueCommentaire();
			
		}else if (e.getSource()== this.btGenre) {
			this.setVisible(false);
			//on instancie la vue artiste
			Main.instancierVueGenre();
			
		}else if (e.getSource()== this.btLieu) {
			//on rend invisible la vue connexion
			this.setVisible(false);
			//on instancie la vue lieu
			Main.instancierVueLieu();
			
		}else if (e.getSource()== this.btMembre) {
			this.setVisible(false);
			//on instancie la vue artiste
			Main.instancierVueMembre();
			
		}
		
	}
	
	public void traitement () {
		String email = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		
		Membre unMembre = Main.verifConnexion(email,  mdp);
		if(unMembre == null) {
			JOptionPane.showMessageDialog(this, "Erreur de connexion, identifiants incorrects");
		}else {
			JOptionPane.showMessageDialog(this, "Bienvenue "+unMembre.getNom()+" "+unMembre.getPrenom());
			//Ouverture du Menu General
			this.panelConnexion.setVisible(false);
			this.panelMenuGeneral.setVisible(true);
			this.txtEmail.setText("");
			this.txtMdp.setText("");
			
		
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.traitement();
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
