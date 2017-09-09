package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ihm.Main;
import ihm.OptionsDialogBox;

public class OptionsOkListener implements ActionListener {

	OptionsDialogBox optionsDialogBox;

	public OptionsOkListener(Main fenetre, OptionsDialogBox optionsDialogBox) {
		this.optionsDialogBox = optionsDialogBox;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Main.getInstance().setOptions(optionsDialogBox.getOptions());
			Main.getInstance().getOptions().sauvegardeConfig();
			optionsDialogBox.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Attention au valeurs rentrées !", "Attention",
					JOptionPane.WARNING_MESSAGE);

		}

	}

}
