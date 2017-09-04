/**
 * 
 */
package main.java.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author flkoliv
 *
 */
public class ChallengerPlusListener implements ActionListener {

	public ChallengerPlusListener() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Plus ou Moins : Challenger", "Attention", JOptionPane.WARNING_MESSAGE);
	}

}
