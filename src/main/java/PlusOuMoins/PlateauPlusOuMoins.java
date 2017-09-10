/**
 * 
 */
package PlusOuMoins;

import ihm.Main;
import ihm.PlusOuMoinsPanel;

/**
 * @author flkoliv
 *
 */
public class PlateauPlusOuMoins {
	int nbrEssais = 5;
	int longueurCode = 4;
	Competiteur attaquant;
	Competiteur defenseur;
	int code;

	public PlateauPlusOuMoins() {

		PlusOuMoinsPanel p = new PlusOuMoinsPanel(Main.getInstance().getOptions().getNbrEssaisPlus(),
				Main.getInstance().getOptions().getTailleCodePlus());
		Main.getInstance().getContentPane().removeAll();
		Main.getInstance().getContentPane().repaint();
		Main.getInstance().getContentPane().add(p);
		Main.getInstance().getContentPane().validate();
	}

}
