package ihm;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import common.Panel;
import ihm.listener.PlusPanelOkButtonListener;

/**
 * @author flkoliv
 */
public class PlusOuMoinsPanel extends JPanel implements Panel {

	private static final long serialVersionUID = 1213633100918578601L;
	private JTextField jtf;
	private JButton okButton;
	private JPanel saisie;
	private JLabel intitule;
	private int taille;
	private int emptyRow;

	JTable tab;

	public PlusOuMoinsPanel(int taille, int longueurCode) {
		this.taille = taille;
		this.emptyRow = 0;
		intitule = new JLabel("Entrez votre valeur");
		saisie = new JPanel();
		saisie.setLayout(new BoxLayout(saisie, BoxLayout.LINE_AXIS));

		jtf = new JFormattedTextField();
		jtf.setDocument(new JTextFieldLimited(0, longueurCode));

		saisie.add(jtf);
		saisie.add(Box.createRigidArea(new Dimension(10, 0)));
		okButton = new JButton("OK");
		okButton.addActionListener(new PlusPanelOkButtonListener());
		saisie.add(okButton);

		String title[] = { "Proposition", "Résultat" };
		Object[][] tableau = new Object[this.taille][2];
		tab = new JTable(tableau, title);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(intitule);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(saisie);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(new JScrollPane(tab));
		this.setVisible(true);
	}

	public int getTaille() {
		return taille;
	}

	public int propositionsRestantes() {
		return taille - emptyRow;
	}

	public void setResult(String code, String result) {
		tab.setValueAt(code, emptyRow, 0);
		tab.setValueAt(result, emptyRow, 1);
		this.emptyRow++;
	}

	@Override
	public String getProposition() {
		String s = jtf.getText();
		return s;

	}

	public void cleanProposition() {

		jtf.setText("");

	}

	@Override
	public Panel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProposition(String string) {
		jtf.setText(string);

	}
}
