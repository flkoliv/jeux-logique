package PlusOuMoins;

import ihm.Main;

/**
 * @author flkoliv
 *
 */
public class JoueurOrdinateur extends Competiteur {

	@Override
	public String getNewCode() {

		double c = Math.random();
		String code = "";
		int nbrChiffres = Main.getInstance().getOptions().getTailleCodePlus();
		for (int i = 0; i < nbrChiffres; i++) {
			c = c * 10;
		}

		code = String.valueOf((int) c);
		while (code.length() < nbrChiffres) {
			code = "0" + code;
		}

		super.logger.debug("Nouveau code généré par l'ordinateur : " + code);

		return code;
	}

	@Override
	public void getProposition() {
		Main.getInstance().getJeu().getPanel().setProposition(getNewCode());
		try {
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
