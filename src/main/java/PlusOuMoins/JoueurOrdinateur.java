package PlusOuMoins;

import ihm.PlusOuMoinsPanel;

/**
 * Classe du joueur Ordinateur
 * 
 * @author flkoliv
 * @version 1
 */
public class JoueurOrdinateur extends Competiteur {

	int rechercheCode[][];
	String lastProposition = "";
	String lastResult = "";

	public JoueurOrdinateur(int nbrEssais, int nbrChrCode) {
		panel = new PlusOuMoinsPanel(nbrEssais, nbrChrCode, false);
		this.nbrChrCode = nbrChrCode;
		this.nbrEssais = nbrEssais;
		rechercheCode = new int[nbrChrCode][2];
		for (int i = 0; i < nbrChrCode; i++) {
			rechercheCode[i][0] = 0;
			rechercheCode[i][1] = 10;
		}
	}

	/**
	 * Obtenir un nouveau code
	 * 
	 * @return chaine de caractère contenant le nouveau code aléatoire
	 */
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
		lastResult = panel.getLastResult();
		if (!lastResult.equals("")) {
			System.out.println("lastResult = " + lastResult);
			for (int i = 0; i < nbrChrCode; i++) {
				String c = "" + lastProposition.charAt(i);
				if (lastResult.charAt(i) == '+') {
					rechercheCode[i][0] = Integer.parseInt(c);
				} else if (lastResult.charAt(i) == '-') {
					rechercheCode[i][1] = Integer.parseInt(c);
				} else if (lastResult.charAt(i) == '=') {
					rechercheCode[i][0] = Integer.parseInt(c);
					rechercheCode[i][1] = Integer.parseInt(c);
				}

			}
		}
		String prop = "";
		for (int i = 0; i < nbrChrCode; i++) {
			prop = prop + ((rechercheCode[i][0] + rechercheCode[i][1]) / 2);
		}
		lastProposition = prop;
		panel.setProposition(prop);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
