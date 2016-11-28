package receiver;

import java.util.ArrayList;
import java.util.List;

import invoker.Observer;

/**
* La classe MoteurEditionImpl permet
* d'effectuer des traitements sur un texte.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07 
*/
public class MoteurEditionImpl implements MoteurEdition, Subject {
	
	/**
	 * contient le texte saisit par l'utilisateur
	 */
	private Buffer buffer;
	
	/**
	 * peut contenir une string 
	 */
	private PressePapier pressePapier;	
	
	/**
	 * permet de connaitre la selection courante
	 */
	private Selection selection;
		
	/**
	 * liste des {@link Observer} de cette classe
	 */
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Constructeur de la classe 
	 * {@link MoteurEditionImpl#buffer}, 
	 * {@link MoteurEditionImpl#pressePapier}, 
	 * {@link MoteurEditionImpl#selection}
	 */
	public MoteurEditionImpl() {
		this.buffer = new Buffer();
		this.pressePapier = new PressePapier();
		this.selection = new Selection();
	}
	
	/**
	 * {@link MoteurEditionImpl#buffer} 
	 */
	public Buffer getBuffer() {
		return buffer;
	}

	/**
	 * {@link MoteurEditionImpl#pressePapier}
	 */
	public PressePapier getPressePapier() {
		return pressePapier;
	}
	
	/**
	 * {@link MoteurEditionImpl#selection}
	 */
	public Selection getSelection() {
		return selection;
	}

	/**
	 * Coupe la selection du buffer et la stocke dans le pressePapier.
	 * Les {@link Observer} sont notifies.
	 */
	public void couper() {
		pressePapier.setContenu(selection.getContenu());

		// suppression de la selection dans le buffer
		buffer.delete(selection.getDebut(), selection.getFin());
		notifyObserver();
	}

	/**
	 * Copie la selection du buffer dans le pressePapier.
	 */
	public void copier() {
		pressePapier.setContenu(selection.getContenu());
	}

	/**
	 * Colle le contenu du pressePapie dans le buffer. 
	 * Les {@link Observer} sont notifies.
	 */
	public void coller() {
		String contenuPressePapier = pressePapier.getContenu();
		int selectionDebut = selection.getDebut();
		int selectionFin = selection.getFin();

		// insertion du contenu du presse papier dans le buffer, au debut de la selection
		buffer.insert(selectionDebut, selectionFin, contenuPressePapier);
		notifyObserver();
	}

	/**
	 * Affecte un extrait du buffer a la selection.
	 * @param debut indice du caractere de debut de selection
	 * @param fin indice du caractere de fin de selection
	 */
	public void selectionner(int debut, int fin) {
		if (buffer.getContenu().length() >= fin) {
			String stringSelectionnee = buffer.substring(debut, fin);
			
			selection.setContenu(stringSelectionnee);
			selection.setDebut(debut);
			selection.setFin(fin);
		}
	}

	/**
	 * Saisit un nouveau caractere dans le buffer
	 * @param newChar caractere a saisir
	 */
	public void saisir(String newChar) {
		int fin = selection.getFin();
		if (fin > buffer.getContenu().length())
			buffer.append(newChar);
		else
			buffer.insert(selection.getDebut(), selection.getFin(), newChar);
		
		int lenght = buffer.getContenu().length();
		selectionner(lenght, lenght);
	}
	
	/**
	 * Supprime une partie du buffer 
	 * definie par la selection courante.
	 */
	public void supprimer() {
		int debut = selection.getDebut();
		int fin = selection.getFin();
		
		if (debut > 0 && debut == fin) {
			buffer.delete(selection.getDebut()-1, selection.getFin());
			selection.setDebut(debut-1); selection.setFin(fin-1);
		} else {
			buffer.delete(selection.getDebut(), selection.getFin());
			selection.setDebut(debut); selection.setFin(debut);
		}
	}
	
	// Subject methods
	
	/**
	 * {@link receiver.Subject}
	 */
	public void register(Observer o) {
		observers.add(o);	
	}

	/**
	 * {@link receiver.Subject}
	 */
	public void unregister(Observer o) {
		int observerIndex = observers.indexOf(o);
		observers.remove(observerIndex);
	}

	/**
	 * {@link receiver.Subject}
	 */
	public void notifyObserver() {
		for (Observer o : observers) {
			o.update(buffer.getContenu().toString());
		}
	}

}
