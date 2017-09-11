package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ihm.Main;

public class PlusPanelOkButtonListener implements ActionListener {
	private static final Logger logger = LogManager.getLogger();

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String prop = Main.getInstance().getJeu().getPanel().getProposition();
		if (prop.length() < Main.getInstance().getOptions().getTailleCodePlus()) {
			Main.getInstance().getJeu().getPanel().setProposition("");
			logger.debug("proposition pas assez longue : " + prop);
		} else {
			logger.debug("proposition ok");
			Main.getInstance().getJeu().propositionDisponible();

		}

	}

}
