package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 
 */

/**
 * @author flkoliv
 *
 */
public class Options {

	private Integer nbrEssaisPlus, nbrEssaisMaster, tailleCodePlus, tailleCodeMaster, nbrCouleursMaster;
	private Boolean dev;

	/**
	 * 
	 */
	public Options() {
		// TODO Auto-generated constructor stub
	}

	public void setDev(boolean b) {
		this.dev = b;
	}

	public void setNbrEssaisPlus(int i) {
		this.nbrEssaisPlus = i;
	}

	public void setNbrEssaisMaster(int i) {
		this.nbrEssaisMaster = i;
	}

	public void setTailleCodePlus(int i) {
		this.tailleCodePlus = i;
	}

	public void setTailleCodeMaster(int i) {
		this.tailleCodeMaster = i;
	}

	public void setNbrCouleursMaster(int i) {
		this.nbrCouleursMaster = i;
	}

	public boolean getDev() {
		return this.dev;
	}

	public int getNbrEssaisPlus() {
		return this.nbrEssaisPlus;
	}

	public int getNbrEssaisMaster() {
		return this.nbrEssaisMaster;
	}

	public int getTailleCodePlus() {
		return this.tailleCodePlus;
	}

	public int getTailleCodeMaster() {
		return this.tailleCodeMaster;
	}

	public int getNbrCouleursMaster() {
		return this.nbrCouleursMaster;
	}

	public void sauvegarde() {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");
			prop.setProperty("nbrEssaisPlus", nbrEssaisPlus.toString());
			prop.setProperty("nbrEssaisMaster", nbrEssaisMaster.toString());
			prop.setProperty("tailleCodePlus", tailleCodePlus.toString());
			prop.setProperty("tailleCodeMaster", tailleCodeMaster.toString());
			prop.setProperty("nbrCouleursMaster", nbrCouleursMaster.toString());
			prop.setProperty("dev", dev.toString());
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public void lecture() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			nbrEssaisPlus = Integer.parseInt(prop.getProperty("nbrEssaisPlus"));
			nbrEssaisMaster = Integer.parseInt(prop.getProperty("nbrEssaisMaster"));
			tailleCodePlus = Integer.parseInt(prop.getProperty("tailleCodePlus"));
			tailleCodeMaster = Integer.parseInt(prop.getProperty("tailleCodeMaster"));
			nbrCouleursMaster = Integer.parseInt(prop.getProperty("nbrCouleursMaster"));
			dev = Boolean.parseBoolean(prop.getProperty("dev"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
