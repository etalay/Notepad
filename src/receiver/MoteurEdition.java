package receiver;

/**
* L'interface MoteurEdition definit plusieurs methodes permettant
* d'effectuer des traitements sur un texte.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07 
*/
public interface MoteurEdition extends Subject {

	/**
	 * Coupe la selection
	 */
	public void couper(); 
	
	/**
	 * Copie la selection
	 */
	public void copier();
	
	/**
	 * Colle le contenu d'un presse papier
	 */
	public void coller();
	
	/**
	 * Selectionne une partie du buffer
	 * @param debut Indice du caractere de debut de selection
	 * @param longueur Nombre de caracteres de la selection
	 */
	public void selectionner(int debut, int longueur);
	
	/**
	 * Enregistre dans le buffer le texte passe en parametre
	 * @param texte Texte a saisir
	 */
	public void saisir(String texte);
	
	public void supprimer();
	
}
