/**
 * 
 */
package ihm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import PlusOuMoins.PlateauPlusOuMoins;
import common.Jeu;
import common.Options;
import ihm.listener.AideListener;
import ihm.listener.ChallengerMasterListener;
import ihm.listener.ChallengerPlusListener;
import ihm.listener.DefenseurMasterListener;
import ihm.listener.DefenseurPlusListener;
import ihm.listener.DuelMasterListener;
import ihm.listener.DuelPlusListener;
import ihm.listener.OptionsListener;

/**
 * Classe principale du jeu
 * 
 * @author flkoliv
 *
 */
public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2999965498510953416L;
	private Jeu jeu;
	private Options options = new Options();
	private static Main INSTANCE;
	private static final Logger logger = LogManager.getLogger();

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
		this.add(image);
		this.setMinimumSize(new Dimension(620, 700));
		initialiseMenu();
		JPanel panneau = new JPanel();
		panneau.add(image);
		this.setContentPane(panneau);
		this.setVisible(true);

	}

	/**
	 * initialise le menu de la fenêtre principale
	 */
	private void initialiseMenu() {
		logger.trace("initialisation interface graphique principale");
		JMenuBar menuBar = new JMenuBar();
		JMenu jeuxMenu = new JMenu("Jeux");
		JMenu optionsMenu = new JMenu("Options");
		JMenu aideMenu = new JMenu("Aide");
		JMenu plusOuMoins = new JMenu("Plus ou Moins");
		JMenu masterMind = new JMenu("Mastermind");

		JMenuItem challengerPlus = new JMenuItem("Challenger");
		challengerPlus.addActionListener(new ChallengerPlusListener());
		JMenuItem defenseurPlus = new JMenuItem("Defenseur");
		defenseurPlus.addActionListener(new DefenseurPlusListener());
		JMenuItem duelPlus = new JMenuItem("Duel");
		duelPlus.addActionListener(new DuelPlusListener());
		JMenuItem challengerMaster = new JMenuItem("Challenger");
		challengerMaster.addActionListener(new ChallengerMasterListener());
		JMenuItem defenseurMaster = new JMenuItem("Defenseur");
		defenseurMaster.addActionListener(new DefenseurMasterListener());
		JMenuItem duelMaster = new JMenuItem("Duel");
		duelMaster.addActionListener(new DuelMasterListener());
		JMenuItem aide = new JMenuItem("?");
		aide.addActionListener(new AideListener());
		JMenuItem options = new JMenuItem("Options");
		options.addActionListener(new OptionsListener(this));
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
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
	 *            parametre de la ligne de commande
	 */
	public static void main(String[] args) {

		logger.info("lancement programme");
		INSTANCE = new Main();
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("dev")) { // si argument ligne de commande = dev
				INSTANCE.getOptions().setDev(true);
				INSTANCE.getOptions().sauvegardeConfig();
			}

		}

	}

	public void setJeu(PlateauPlusOuMoins plateauPlusOuMoins) {
		this.jeu = plateauPlusOuMoins;

	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setOptions(Options o) {
		this.options = o;
	}

	public Options getOptions() {
		return options;
	}

	public static Main getInstance() {
		return INSTANCE;
	}

	public void setBackground() {
		ImageIcon icone = new ImageIcon("src/main/ressources/mastermind.png");
		JLabel image = new JLabel(icone);
		this.add(image);
		JPanel panneau = new JPanel();
		panneau.add(image);
		this.setContentPane(panneau);
		this.validate();
	}

	public boolean isDev() {
		return options.getDev();

	}
}
