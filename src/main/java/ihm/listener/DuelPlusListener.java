/**
 * 
 */
package ihm.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * @author flkoliv
 *
 */
public class DuelPlusListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Plus ou Moins : Duel", "Attention", JOptionPane.WARNING_MESSAGE);
	}

}
