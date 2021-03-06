package ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import common.Options;
import ihm.listener.OptionsCancelListener;
import ihm.listener.OptionsOkListener;

public class OptionsDialogBox extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8901635042644317428L;

	private JTextField nombreEssaisPOM, tailleCodePOM, nombreEssaisMaster, tailleCodeMaster;
	private JComboBox<Integer> nbrCouleursMaster;
	private JCheckBox devMod;
	private Main parent;

	public OptionsDialogBox(Main parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		this.setVisible(true);

	}

	private void initComponent() {

		// panel POM
		JPanel panPOM = new JPanel();
		panPOM.setBackground(Color.white);
		panPOM.setPreferredSize(new Dimension(200, 60));
		panPOM.setBorder(BorderFactory.createTitledBorder("Plus ou Moins"));
		nombreEssaisPOM = new JTextField();
		nombreEssaisPOM.setDocument(new JTextFieldLimited(20));
		nombreEssaisPOM.setText(String.valueOf(Main.getInstance().getOptions().getNbrEssaisPlus()));
		nombreEssaisPOM.setPreferredSize(new Dimension(25, 25));
		tailleCodePOM = new JTextField();
		tailleCodePOM.setDocument(new JTextFieldLimited(20));
		tailleCodePOM.setText(String.valueOf(Main.getInstance().getOptions().getTailleCodePlus()));
		tailleCodePOM.setPreferredSize(new Dimension(25, 25));
		panPOM.add(new JLabel("Nombre d'essais"));
		panPOM.add(nombreEssaisPOM);
		panPOM.add(new JLabel("Longueur du Code"));
		panPOM.add(tailleCodePOM);

		// panel Master
		JPanel panMaster = new JPanel();
		panMaster.setBackground(Color.white);
		panMaster.setPreferredSize(new Dimension(220, 60));
		panMaster.setBorder(BorderFactory.createTitledBorder("Mastermind"));
		nombreEssaisMaster = new JTextField();
		nombreEssaisMaster.setDocument(new JTextFieldLimited(20));
		nombreEssaisMaster.setText(String.valueOf(Main.getInstance().getOptions().getNbrEssaisMaster()));
		nombreEssaisMaster.setPreferredSize(new Dimension(25, 25));
		tailleCodeMaster = new JTextField();
		tailleCodeMaster.setDocument(new JTextFieldLimited(20));
		tailleCodeMaster.setText(String.valueOf(Main.getInstance().getOptions().getTailleCodeMaster()));
		tailleCodeMaster.setPreferredSize(new Dimension(25, 25));
		Integer[] tab = { 4, 5, 6, 7, 8, 9, 10 };
		nbrCouleursMaster = new JComboBox<Integer>(tab);
		nbrCouleursMaster.setSelectedItem(Main.getInstance().getOptions().getNbrCouleursMaster());
		panMaster.add(new JLabel("Nombre d'essais"));
		panMaster.add(nombreEssaisMaster);
		panMaster.add(new JLabel("Longueur du Code"));
		panMaster.add(tailleCodeMaster);
		panMaster.add(new JLabel("Nombres de couleurs"));
		panMaster.add(nbrCouleursMaster);

		// panel mode dev
		JPanel panMode = new JPanel();
		panMode.setBackground(Color.white);
		panMode.setPreferredSize(new Dimension(220, 60));
		panMode.setBorder(BorderFactory.createTitledBorder("Mode Dev"));
		panMode.add(new JLabel("Mode developpeur"));
		devMod = new JCheckBox();
		devMod.setSelected(Main.getInstance().getOptions().getDev());
		panMode.add(devMod);

		// panel boutons
		JPanel panBoutons = new JPanel();
		panBoutons.setBackground(Color.white);
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new OptionsOkListener(parent, this));
		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new OptionsCancelListener(this));
		panBoutons.add(okButton);
		panBoutons.add(cancelButton);

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		this.getContentPane().add(panPOM);
		this.getContentPane().add(panMaster);
		this.getContentPane().add(panMode);
		this.getContentPane().add(panBoutons);
	}

	public Options getOptions() {
		int a = Integer.parseInt(nombreEssaisPOM.getText());
		int b = Integer.parseInt(nombreEssaisMaster.getText());
		int c = Integer.parseInt(tailleCodePOM.getText());
		int d = Integer.parseInt(tailleCodeMaster.getText());
		int e = (int) nbrCouleursMaster.getSelectedItem();
		boolean f = devMod.isSelected();
		Options o = new Options(a, b, c, d, e, f);
		if (a > 0 && b > 0 && c > 0 && d > 0) {
			return o;
		} else {
			return null;
		}

	}
}
