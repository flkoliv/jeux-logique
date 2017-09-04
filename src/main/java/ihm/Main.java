/**
 * 
 */
package main.java.ihm;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Classe principale du jeu
 * 
 * @author flkoliv
 *
 */
public class Main extends JFrame {

	/**
	 * Constructeur de la fenêtre principale de jeu
	 */
	public Main() {

		this.setTitle("Mettez votre logique à l'épreuve !");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("src/main/ressources/mastermind-icon.jpg");
		this.setIconImage(img.getImage());
		ImageIcon icone = new ImageIcon("src/main/ressources/mastermind.png");
		JLabel image = new JLabel(icone);
		JLabel texte = new JLabel("texte");
		this.add(image);
		// this.add(texte);
		this.setMinimumSize(new Dimension(620, 700));
		initialiseMenu();
		this.setVisible(true);
		// image.setVisible(true);

	}

	private void initialiseMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu jeuxMenu = new JMenu("Jeux");
		JMenu optionsMenu = new JMenu("Options");
		JMenu aideMenu = new JMenu("Aide");
		JMenu plusOuMoins = new JMenu("Plus ou Moins");
		JMenu masterMind = new JMenu("Mastermind");

		JMenuItem quitter = new JMenuItem("Quitter");
		JMenuItem challengerPlus = new JMenuItem("Challenger");
		JMenuItem defenseurPlus = new JMenuItem("Defenseur");
		JMenuItem duelPlus = new JMenuItem("Duel");
		JMenuItem challengerMaster = new JMenuItem("Challenger");
		JMenuItem defenseurMaster = new JMenuItem("Defenseur");
		JMenuItem duelMaster = new JMenuItem("Duel");
		JMenuItem aide = new JMenuItem("?");
		JMenuItem options = new JMenuItem("Options");
		plusOuMoins.add(challengerPlus);
		plusOuMoins.add(defenseurPlus);
		plusOuMoins.add(duelPlus);
		masterMind.add(challengerMaster);
		masterMind.add(defenseurMaster);
		masterMind.add(duelMaster);

		optionsMenu.add(options);
		jeuxMenu.add(plusOuMoins);
		jeuxMenu.add(masterMind);
		jeuxMenu.addSeparator();
		jeuxMenu.add(quitter);
		aideMenu.add(aide);
		menuBar.add(jeuxMenu);
		menuBar.add(optionsMenu);
		menuBar.add(aideMenu);

		this.setJMenuBar(menuBar);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Main f = new Main();
	}

}
