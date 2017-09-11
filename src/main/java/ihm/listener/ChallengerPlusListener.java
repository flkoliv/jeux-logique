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
 * @author flkoliv
 *
 */
public class ChallengerPlusListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.getInstance().setJeu(new PlateauPlusOuMoins(TypeJeux.CHALLENGER));

		/*
		 * PlusOuMoinsPanel p = new PlusOuMoinsPanel(12);
		 * fenetre.getContentPane().removeAll(); fenetre.getContentPane().repaint();
		 * fenetre.getContentPane().add(p); fenetre.getContentPane().validate();
		 */
	}

}
