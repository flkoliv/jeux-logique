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
import ihm.PlusOuMoinsPanel;

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
	private TypeJeux type;
	private PlusOuMoinsPanel panel;
	private PlusOuMoinsPanel panel2;
	private Main fenetre;
	private static final Logger logger = LogManager.getLogger();
	private boolean gagne = false;

	public PlateauPlusOuMoins(TypeJeux t) {
		this.type = t;
		fenetre = Main.getInstance();
		nbrEssais = Main.getInstance().getOptions().getNbrEssaisPlus();
		longueurCode = Main.getInstance().getOptions().getTailleCodePlus();

		if (t == TypeJeux.CHALLENGER) {

			panel = new PlusOuMoinsPanel(nbrEssais, longueurCode);
			fenetre.getContentPane().removeAll();
			fenetre.getContentPane().repaint();
			fenetre.getContentPane().add(panel);
			fenetre.getContentPane().validate();
			attaquant = new JoueurHumain();
			defenseur = new JoueurOrdinateur();
			start();

		} else if (t == TypeJeux.DEFENSEUR) {

			panel = new PlusOuMoinsPanel(nbrEssais, longueurCode);
			fenetre.getContentPane().removeAll();
			fenetre.getContentPane().repaint();
			fenetre.getContentPane().add(panel);
			fenetre.getContentPane().validate();
			attaquant = new JoueurOrdinateur();
			defenseur = new JoueurHumain();
			start();

		} else if (t == TypeJeux.DUEL) {
			panel = new PlusOuMoinsPanel(nbrEssais, longueurCode);
			panel2 = new PlusOuMoinsPanel(nbrEssais, longueurCode);
			fenetre.getContentPane().removeAll();
			fenetre.getContentPane().repaint();
			fenetre.getContentPane().add(panel);
			fenetre.getContentPane().add(panel2);
			fenetre.getContentPane().validate();
			attaquant = new JoueurHumain();
			defenseur = new JoueurOrdinateur();
			// start();

		}
	}

	@Override
	public synchronized void run() {
		code = defenseur.getNewCode();
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

				proposition = panel.getProposition();
				panel.cleanProposition();
				logger.debug("tour joué : " + (nbrToursJoues + 1) + "proposition :" + proposition);
				String result = "";
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
				panel.setResult(proposition, result);
				if (code.equals(proposition)) {
					gagne = true;
					break;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			nbrToursJoues++;
		} while (nbrToursJoues < nbrEssais);
		String message;

		if (attaquant.getClass() == JoueurOrdinateur.class) {
			gagne = !gagne;
		}

		if (gagne) {
			message = "Vous avez gagné !";
		} else {
			message = "Vous avez perdu !";
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
	public Panel getPanel() {
		return panel;
	}

}
