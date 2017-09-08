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
	JoueurPlusouMoins attaquant;
	JoueurPlusouMoins defenseur;
	int code;
	Main fenetre;

	public PlateauPlusOuMoins(Main fen) {
		this.fenetre = fen;
		PlusOuMoinsPanel p = new PlusOuMoinsPanel(nbrEssais, longueurCode);
		fenetre.getContentPane().removeAll();
		fenetre.getContentPane().repaint();
		fenetre.getContentPane().add(p);
		fenetre.getContentPane().validate();
	}

}
