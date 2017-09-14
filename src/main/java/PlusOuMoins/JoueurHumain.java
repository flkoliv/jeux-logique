/**
 * 
 */
package PlusOuMoins;

import javax.swing.JOptionPane;

import ihm.Main;
import ihm.PlusOuMoinsPanel;

/**
 * Classe du joueur Humain
 * 
 * @author flkoliv
 * @version 1
 */
public class JoueurHumain extends Competiteur {

	public JoueurHumain(int nbrEssais, int nbrChrCode) {
		panel = new PlusOuMoinsPanel(nbrEssais, nbrChrCode, true);
		this.nbrChrCode = nbrChrCode;
		this.nbrEssais = nbrEssais;
	}

	/**
	 * @return Chaine de caractère pour un nouveau code
	 */
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
		// TODO Auto-generated method stub

	}

}
