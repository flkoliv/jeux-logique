package ihm.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ihm.Main;

public class entreeListener implements KeyListener {
	private static final Logger logger = LogManager.getLogger();

	private JTextField jtf;

	public entreeListener(JTextField jtf) {
		this.jtf = jtf;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
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

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
