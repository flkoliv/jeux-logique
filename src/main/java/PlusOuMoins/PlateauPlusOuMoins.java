/**
 * 
 */
package PlusOuMoins;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.Jeu;
import common.Panel;
import common.TypeJeux;
import ihm.Main;

/**
 * @author flkoliv
 *
 */
public class PlateauPlusOuMoins extends Thread implements Jeu {
	private int nbrEssais;
	private int longueurCode;
	private Competiteur attaquant;
	private Competiteur defenseur;
	private String code;
	private String code2;
	private TypeJeux type;
	private Main fenetre;
	private static final Logger logger = LogManager.getLogger();
	private int gagne = 3;// 0 : gagne / 1:perdu / 2:exaeqo

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

	@Override
	public synchronized void run() {
		String result;
		code = defenseur.getNewCode();
		if (type == TypeJeux.DUEL) {
			code2 = attaquant.getNewCode();
		}
		int nbrToursJoues = 0;
		String proposition = "";
		logger.info("Début du jeu");
		do {
			try {
				if (attaquant.getClass() == JoueurHumain.class) {
					wait();
				} else {
					attaquant.getProposition();
				}
				proposition = attaquant.getPanel().getProposition();
				attaquant.getPanel().cleanProposition();
				logger.debug("tour joué : " + (nbrToursJoues + 1) + "proposition :" + proposition);
				result = "";
				for (int i = 0; i < code.length(); i++) {
					int j = code.charAt(i);
					int k = proposition.charAt(i);
					if (j == k) {
						result = result + "= ";
					} else if (j > k) {
						result = result + "+ ";
					} else {
						result = result + "- ";
					}
				}
				attaquant.getPanel().setResult(proposition, result);
				if (code.equals(proposition)) {
					gagne = 0;
					break;
				}
				if (type == TypeJeux.DUEL) { // si c'est un duel, demander une proposition aux deuxieme joueur
					defenseur.getProposition();
					proposition = defenseur.getPanel().getProposition();
					defenseur.getPanel().cleanProposition();
					logger.debug("tour joué : " + (nbrToursJoues + 1) + "proposition :" + proposition);
					result = "";
					for (int i = 0; i < code.length(); i++) {
						int j = code.charAt(i);
						int k = proposition.charAt(i);
						if (j == k) {
							result = result + "= ";
						} else if (j > k) {
							result = result + "+ ";
						} else {
							result = result + "- ";
						}
					}
					defenseur.getPanel().setResult(proposition, result);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			nbrToursJoues++;
		} while (nbrToursJoues < nbrEssais);
		String message;

		if (attaquant.getClass() == JoueurOrdinateur.class) { // fin du jeu et affichage d'un message

		}
		if (gagne == 0) {
			message = "Vous avez gagné !";
		} else if (gagne == 1) {
			message = "Vous avez perdu !";
		} else {
			message = "Ex Aequo !";
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

	@Override
	public synchronized void propositionDisponible() {
		notify();
	}

	@Override
	public Panel getPanel() { // à supprimer !!!
		return null;
	}

}
