/**
 * 
 */
package main.java.ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author flkol
 *
 */
public class DefenseurPlusListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Plus ou Moins : Defenseur", "Attention", JOptionPane.WARNING_MESSAGE);
	}

}
