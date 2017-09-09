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
		// TODO Auto-generated method stub
		// JOptionPane.showMessageDialog(null, "Options", "Attention",
		// JOptionPane.WARNING_MESSAGE);
		OptionsDialogBox ob = new OptionsDialogBox(this.main, "Options", true);

	}

}
