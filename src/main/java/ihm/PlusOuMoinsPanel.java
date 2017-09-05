package main.java.ihm;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

public class PlusOuMoinsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1213633100918578601L;
	private JFormattedTextField jtf;
	private JButton okButton;
	private JPanel saisie;
	private JLabel intitule;
	private int taille;
	private int emptyRow;
	private Object[][] tableau;
	JTable tab;

	public PlusOuMoinsPanel(int taille) {
		this.taille = taille;
		this.emptyRow = 0;
		intitule = new JLabel("Entrez votre valeur");
		saisie = new JPanel();
		saisie.setLayout(new BoxLayout(saisie, BoxLayout.LINE_AXIS));
		try {
			MaskFormatter mf = new MaskFormatter("####");
			jtf = new JFormattedTextField(mf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		saisie.add(jtf);
		saisie.add(Box.createRigidArea(new Dimension(10, 0)));
		okButton = new JButton("OK");
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

	public void setResult(Integer code, String result) {
		tab.setValueAt(code, emptyRow, 0);
		tab.setValueAt(result, emptyRow, 1);
		this.emptyRow++;
	}

}
