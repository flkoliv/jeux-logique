/**
 * 
 */
package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PlusOuMoins.PlateauPlusOuMoins;
import common.TypeJeux;
import ihm.Main;

/**
 * @author flkol
 *
 */
public class DefenseurPlusListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Main.getInstance().setJeu(new PlateauPlusOuMoins(TypeJeux.DEFENSEUR));
	}

}
