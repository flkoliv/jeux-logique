package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	private int emptyRow = 0;

	JTable tab;

	public PlusOuMoinsPanel(int taille, int longueurCode, Boolean humain) {
		this.taille = taille;

		saisie = new JPanel();
		saisie.setLayout(new BoxLayout(saisie, BoxLayout.LINE_AXIS));
		saisie.setMaximumSize(new Dimension(275, 25));
		jtf = new JTextField();
		jtf.setDocument(new JTextFieldLimited(0, longueurCode));
		okButton = new JButton("OK");
		okButton.setMaximumSize(new Dimension(40, 20));
		okButton.addActionListener(new PlusPanelOkButtonListener(jtf));

		if (humain) {
			intitule = new JLabel("Votre proposition : ");

		} else {
			intitule = new JLabel("Proposition Ordinateur : ");
			jtf.setEditable(false);
			okButton.setVisible(false);
		}

		saisie.add(intitule);
		saisie.add(Box.createRigidArea(new Dimension(10, 0)));
		saisie.add(jtf);
		saisie.add(Box.createRigidArea(new Dimension(10, 0)));
		saisie.add(okButton);

		String title[] = { "Proposition", "Résultat" };
		Object[][] tableau = new Object[this.taille][2];
		tab = new JTable(tableau, title);
		tab.setEnabled(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(saisie, BorderLayout.NORTH);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		JScrollPane jsp = new JScrollPane(tab);
		jsp.setMaximumSize(new Dimension(275, 550));
		this.add(jsp, BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(275, 700));
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
