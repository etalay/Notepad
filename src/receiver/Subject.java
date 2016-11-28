package receiver;

import invoker.Observer;

/**
* L'interface Subject definit des methodes permettant
* d'enregistrer et de notifier differents {@link Observer}.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07
*/
public interface Subject {
	
	/**
	 * @param o {@link Observer} a enregistrer
	 */
	public void register(Observer o);
	
	/**
	 * @param o {@link Observer} a supprimer
	 */
	public void unregister(Observer o);
	
	/**
	 * Notifie tout les {@link Observer} de ce Subject
	 */
	public void notifyObserver();

}
