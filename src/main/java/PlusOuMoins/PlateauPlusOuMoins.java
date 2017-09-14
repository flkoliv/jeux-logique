/**
 * 
 */
package PlusOuMoins;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.Jeu;
import common.TypeJeux;
import ihm.Main;

/**
 * Constitue la base du Jeu "plus ou moins"
 * 
 * @author flkoliv
 * @version 1
 *
 */
public class PlateauPlusOuMoins extends Thread implements Jeu {

	private int nbrEssais;
	private int longueurCode;
	private Competiteur attaquant;
	private Competiteur defenseur;
	private String code = "";
	private String code2 = " ";
	private TypeJeux type;
	private Main fenetre;
	private static final Logger logger = LogManager.getLogger();
	private Boolean joueur1Gagne = false;
	private Boolean joueur2Gagne = false;

	public PlateauPlusOuMoins(TypeJeux t) {
		this.type = t;
		fenetre = Main.getInstance();
		nbrEssais = Main.getInstance().getOptions().getNbrEssaisPlus();
		longueurCode = Main.getInstance().getOptions().getTailleCodePlus();
		if (t == TypeJeux.CHALLENGER) {
			attaquant = new JoueurHumain(nbrEssais, longueurCode);
			defenseur = new JoueurOrdinateur(nbrEssais, longueurCode);
			fenetre.getContentPane().removeAll();
			fenetre.getContentPane().add(attaquant.getPanel());
			fenetre.getContentPane().repaint();
			fenetre.getContentPane().validate();
			start();
		} else if (t == TypeJeux.DEFENSEUR) {
			attaquant = new JoueurOrdinateur(nbrEssais, longueurCode);
			defenseur = new JoueurHumain(nbrEssais, longueurCode);
			fenetre.getContentPane().removeAll();
			fenetre.getContentPane().repaint();
			fenetre.getContentPane().add(attaquant.getPanel());
			fenetre.getContentPane().validate();
			start();
		} else if (t == TypeJeux.DUEL) {
			attaquant = new JoueurHumain(nbrEssais, longueurCode);
			defenseur = new JoueurOrdinateur(nbrEssais, longueurCode);
			fenetre.getContentPane().removeAll();
			fenetre.getContentPane().repaint();
			fenetre.getContentPane().add(attaquant.getPanel());
			fenetre.getContentPane().add(defenseur.getPanel());
			fenetre.getContentPane().validate();
			start();
		}
	}

	/**
	 * Thread du jeu "Plus ou Moins"
	 */
	@Override
	public synchronized void run() {
		String result;
		code = defenseur.getNewCode();
		if (fenetre.isDev())
			attaquant.getPanel().setMsgDev(code);
		// attaquant.getPanel().repaint();
		if (type == TypeJeux.DUEL) {
			code2 = attaquant.getNewCode();
			if (fenetre.isDev())
				defenseur.getPanel().setMsgDev(code2);
		}
		int nbrToursJoues = 0;
		String proposition1 = "";
		String proposition2 = "";
		logger.info("Début du jeu");
		do {
			try {
				if (attaquant.getClass() == JoueurHumain.class) {
					wait();
				} else {
					attaquant.getProposition();
				}
				proposition1 = attaquant.getPanel().getProposition();
				attaquant.getPanel().cleanProposition();
				logger.debug("tour joué : " + (nbrToursJoues + 1) + "proposition :" + proposition1);
				result = "";
				for (int i = 0; i < code.length(); i++) {
					int j = code.charAt(i);
					int k = proposition1.charAt(i);
					if (j == k) {
						result = result + "=";
					} else if (j > k) {
						result = result + "+";
					} else {
						result = result + "-";
					}
				}
				attaquant.getPanel().setResult(proposition1, result);
				if (type == TypeJeux.DUEL) { // si c'est un duel, demander une proposition aux deuxieme joueur
					defenseur.getProposition();
					proposition2 = defenseur.getPanel().getProposition();
					defenseur.getPanel().cleanProposition();
					logger.debug("tour joué : " + (nbrToursJoues + 1) + "proposition :" + proposition2);
					result = "";
					for (int i = 0; i < code2.length(); i++) {
						int j = code2.charAt(i);
						int k = proposition2.charAt(i);
						if (j == k) {
							result = result + "=";
						} else if (j > k) {
							result = result + "+";
						} else {
							result = result + "-";
						}
					}
					defenseur.getPanel().setResult(proposition2, result);
				}
				boolean sortie = false;
				if (code.equals(proposition1)) {
					joueur1Gagne = true;
					sortie = true;
				}
				if (code2.equals(proposition2)) {
					joueur2Gagne = true;
					sortie = true;
				}
				if (sortie)
					break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nbrToursJoues++;
		} while (nbrToursJoues < nbrEssais);
		String message = "";
		if (type == TypeJeux.CHALLENGER) {
			if (joueur1Gagne) {
				message = "Vous avez gagné !";
			} else {
				message = "Vous avez perdu !";
			}
		} else if (type == TypeJeux.DEFENSEUR) {
			if (joueur1Gagne) {
				message = "L'ordinateur a gagné !";
			} else {
				message = "L'ordinateur a perdu !";
			}
		} else if (type == TypeJeux.DUEL) {
			if (joueur1Gagne && joueur2Gagne) {
				message = "Gagné Ex Aequo!";
			} else if (joueur1Gagne) {
				message = "Vous avez gagné !";
			} else {
				message = "Vous avez perdu !";
			}
		}

		message = message + "\n Voulez-vous recommencer ?";
		int o = JOptionPane.showConfirmDialog(null, message, "Attention", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (o == 0) {
			Main.getInstance().setJeu(new PlateauPlusOuMoins(type));
		} else {
			Main.getInstance().setBackground();
		}
	}

	/**
	 * notification pour continuer le Thread (utilisée si une proposition est
	 * disponible)
	 */
	@Override
	public synchronized void propositionDisponible() {
		notify();
	}

}
