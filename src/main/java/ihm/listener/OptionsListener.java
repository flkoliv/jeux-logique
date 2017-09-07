package main.java.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.ihm.OptionsDialogBox;

public class OptionsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// JOptionPane.showMessageDialog(null, "Options", "Attention",
		// JOptionPane.WARNING_MESSAGE);
		OptionsDialogBox ob = new OptionsDialogBox(null, "Options", true);

	}

}
