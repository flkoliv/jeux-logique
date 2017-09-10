package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.Main;
import ihm.OptionsDialogBox;

public class OptionsListener implements ActionListener {

	private Main main;

	public OptionsListener(Main main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		OptionsDialogBox ob = new OptionsDialogBox(this.main, "Options", true);

	}

}
