package main;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 */

/**
 * @author flkoliv
 *
 */
public class Options implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243571228898082279L;
	private int nbrEssaisPlus, nbrEssaisMaster, tailleCodePlus, tailleCodeMaster, nbrCouleursMaster;
	private boolean dev;

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
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("game.txt"))));
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lecture() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("game.txt"))));
			// recupérations des données du fichier à faire ici !!!
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
