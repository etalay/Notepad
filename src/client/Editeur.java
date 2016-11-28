package client;

import invoker.Ihm;
import invoker.Observer;
import receiver.MoteurEdition;
import receiver.MoteurEditionImpl;

/**
* La classe Editeur permet de lancer l'editeur de texte.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07 
*/
public class Editeur {
	
	/**
	 * Moteur possedant les fonctions d'edition
	 */
	private MoteurEdition moteur = new MoteurEditionImpl();
	
	/**
	 * Interface Homme Machine
	 */
	private Observer ihm;
	
	/**
	 * Constructeur de a classe 
	 * {@link Editeur#moteur}
	 * {@link Editeur#ihm}
	 */
	public Editeur() {
		moteur = new MoteurEditionImpl();
		ihm = new Ihm(this);
	}
	
	/**
	 * {@link Editeur#moteur}
	 */
	public MoteurEdition getMoteur() {
		return moteur;
	}
	
	public static void main(String[] args) {
		Editeur editeur = new Editeur();
		Observer ihm = editeur.ihm;
		
		editeur.getMoteur().register(ihm);
	}

}
