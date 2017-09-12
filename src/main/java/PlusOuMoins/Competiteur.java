/**
 * 
 */
package PlusOuMoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ihm.PlusOuMoinsPanel;

/**
 * @author flkoliv
 *
 */
public abstract class Competiteur {

	protected PlusOuMoinsPanel panel;
	protected int nbrChrCode;
	protected int nbrEssais;

	protected final Logger logger = LogManager.getLogger();

	public abstract String getNewCode();

	public abstract void getProposition();

	public PlusOuMoinsPanel getPanel() {
		return panel;

	}

}
