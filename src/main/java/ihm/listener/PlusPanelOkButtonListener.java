package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ihm.Main;

public class PlusPanelOkButtonListener implements ActionListener {
	private static final Logger logger = LogManager.getLogger();

	private JTextField jtf;

	public PlusPanelOkButtonListener(JTextField jtf) {
		this.jtf = jtf;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String prop = jtf.getText();
		if (prop.length() < Main.getInstance().getOptions().getTailleCodePlus()) {
			jtf.setText("");
			logger.debug("proposition pas assez longue : " + prop);
		} else {
			logger.debug("proposition ok");
			Main.getInstance().getJeu().propositionDisponible();

		}

	}

}
