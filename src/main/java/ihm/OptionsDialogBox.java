package main.java.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsDialogBox extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8901635042644317428L;

	private JFormattedTextField nombreEssaisPOM, tailleCodePOM, nombreEssaisMaster, tailleCodeMaster;
	private JComboBox<Integer> nbrCouleursMaster;
	private JCheckBox devMod;

	public OptionsDialogBox(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		this.setVisible(true);
	}

	private void initComponent() {

		// POM
		JPanel panPOM = new JPanel();
		panPOM.setBackground(Color.white);
		panPOM.setPreferredSize(new Dimension(200, 60));
		nombreEssaisPOM = new JFormattedTextField();
		nombreEssaisPOM.setPreferredSize(new Dimension(25, 25));
		tailleCodePOM = new JFormattedTextField();
		tailleCodePOM.setPreferredSize(new Dimension(25, 25));
		panPOM.setBorder(BorderFactory.createTitledBorder("Plus ou Moins"));
		panPOM.add(new JLabel("Nombre d'essais"));
		panPOM.add(nombreEssaisPOM);
		panPOM.add(new JLabel("Longueur du Code"));
		panPOM.add(tailleCodePOM);

		JPanel panMaster = new JPanel();
		panMaster.setBackground(Color.white);
		panMaster.setPreferredSize(new Dimension(220, 60));
		panMaster.setBorder(BorderFactory.createTitledBorder("Mastermind"));
		nombreEssaisMaster = new JFormattedTextField();
		nombreEssaisMaster.setPreferredSize(new Dimension(25, 25));
		tailleCodeMaster = new JFormattedTextField();
		tailleCodeMaster.setPreferredSize(new Dimension(25, 25));
		Integer[] tab = { 4, 5, 6, 7, 8, 9, 10 };
		nbrCouleursMaster = new JComboBox<Integer>(tab);
		panMaster.add(new JLabel("Nombre d'essais"));
		panMaster.add(nombreEssaisMaster);
		panMaster.add(new JLabel("Longueur du Code"));
		panMaster.add(tailleCodeMaster);
		panMaster.add(new JLabel("Nombres de couleurs"));
		panMaster.add(nbrCouleursMaster);

		JPanel panMode = new JPanel();
		panMode.setBackground(Color.white);
		panMode.setPreferredSize(new Dimension(220, 60));
		panMode.setBorder(BorderFactory.createTitledBorder("Mode Dev"));
		panMode.add(new JLabel("Mode developpeur"));
		devMod = new JCheckBox();
		panMode.add(devMod);

		JPanel panBoutons = new JPanel();
		panBoutons.setBackground(Color.white);
		panBoutons.add(new JButton("OK"));
		panBoutons.add(new JButton("Annuler"));

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.getContentPane().add(panPOM);
		this.getContentPane().add(panMaster);
		this.getContentPane().add(panMode);
		this.getContentPane().add(panBoutons);
	}
}
