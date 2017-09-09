package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.OptionsDialogBox;

public class OptionsCancelListener implements ActionListener {

	OptionsDialogBox optionsDialogBox;

	public OptionsCancelListener(OptionsDialogBox optionsDialogBox) {
		this.optionsDialogBox = optionsDialogBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.optionsDialogBox.dispose();

	}

}
