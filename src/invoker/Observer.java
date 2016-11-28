package invoker;

/**
* L'interface Observer definit une methode permettant
* une mise a jour de l'objet.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07
*/
public interface Observer {
	
	/**
	 * @param contenu 
	 */
	public void update(String contenu);

}
