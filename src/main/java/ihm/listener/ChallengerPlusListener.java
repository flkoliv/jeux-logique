/**
 * 
 */
package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PlusOuMoins.PlateauPlusOuMoins;
import ihm.Main;

/**
 * @author flkoliv
 *
 */
public class ChallengerPlusListener implements ActionListener {

	private Main fenetre;

	public ChallengerPlusListener(Main p) {
		this.fenetre = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fenetre.setJeu(new PlateauPlusOuMoins(fenetre));

		/*
		 * PlusOuMoinsPanel p = new PlusOuMoinsPanel(12);
		 * fenetre.getContentPane().removeAll(); fenetre.getContentPane().repaint();
		 * fenetre.getContentPane().add(p); fenetre.getContentPane().validate();
		 */
	}

}
