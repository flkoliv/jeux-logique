/**
 * 
 */
package PlusOuMoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ihm.PlusOuMoinsPanel;

/**
 * Classe de base des joueurs
 * 
 * @author flkoliv
 * @version 1
 *
 */
public abstract class Competiteur {

	protected PlusOuMoinsPanel panel;
	protected int nbrChrCode;
	protected int nbrEssais;

	protected final Logger logger = LogManager.getLogger();

	public abstract String getNewCode();

	/**
	 * 
	 * @return panel retourne le paneau d'interface du jeu
	 */
	public PlusOuMoinsPanel getPanel() {
		return panel;
	}

	public abstract void getProposition();

}
