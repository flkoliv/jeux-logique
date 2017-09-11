/**
 * 
 */
package PlusOuMoins;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author flkoliv
 *
 */
public abstract class Competiteur {

	protected final Logger logger = LogManager.getLogger();

	public abstract String getNewCode();

	public abstract void getProposition();

}
