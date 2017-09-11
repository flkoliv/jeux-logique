/**
 * 
 */
package PlusOuMoins;

import javax.swing.JOptionPane;

import ihm.Main;

/**
 * @author flkoliv
 *
 */
public class JoueurHumain extends Competiteur {

	@Override
	public String getNewCode() {
		String c = "";
		int nbrChiffres = Main.getInstance().getOptions().getTailleCodePlus();
		boolean b = true;
		do {
			try {
				c = JOptionPane.showInputDialog(null, "Veuillez donner un code de " + nbrChiffres + " chiffres!",
						"Nouveau Code", JOptionPane.QUESTION_MESSAGE);
				Integer.parseInt(c);
				if (c.length() == nbrChiffres) {
					b = false;
					super.logger.debug("nouveau code : " + c);
				} else {
					b = true;
					super.logger.debug("code rentré n'ayant pas la bonne longueur");
				}
			} catch (Exception e) {
				super.logger.debug("code rentré ne contenant pas que des chiffres");
			}
		} while (b);
		return c;
	}

	@Override
	public void getProposition() {
		/*
		 * String c = ""; int nbrChiffres =
		 * Main.getInstance().getOptions().getTailleCodePlus(); boolean b = true; do {
		 * try { c = JOptionPane.showInputDialog(null,
		 * "Veuillez donner une proposition de " + nbrChiffres + " chiffres!",
		 * "Proposition", JOptionPane.QUESTION_MESSAGE); Integer.parseInt(c); if
		 * (c.length() == nbrChiffres) { b = false;
		 * super.logger.debug("proposition faite : " + c); } else { b = true;
		 * super.logger.debug("proposition rentré n'ayant pas la bonne longueur"); } }
		 * catch (Exception e) {
		 * super.logger.debug("proposition rentré ne contenant pas que des chiffres"); }
		 * } while (b);
		 */

	}

}
