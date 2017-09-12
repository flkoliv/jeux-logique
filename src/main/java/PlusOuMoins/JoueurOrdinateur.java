package PlusOuMoins;

import ihm.PlusOuMoinsPanel;

/**
 * @author flkoliv
 *
 */
public class JoueurOrdinateur extends Competiteur {

	public JoueurOrdinateur(int nbrEssais, int nbrChrCode) {
		panel = new PlusOuMoinsPanel(nbrEssais, nbrChrCode, false);
		this.nbrChrCode = nbrChrCode;
		this.nbrEssais = nbrEssais;
	}

	@Override
	public String getNewCode() {

		double c = Math.random();
		String code = "";

		for (int i = 0; i < nbrChrCode; i++) {
			c = c * 10;
		}

		code = String.valueOf((int) c);
		while (code.length() < nbrChrCode) {
			code = "0" + code;
		}

		super.logger.debug("Nouveau code généré par l'ordinateur : " + code);

		return code;
	}

	@Override
	public void getProposition() {
		panel.setProposition(getNewCode());
		try {
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
