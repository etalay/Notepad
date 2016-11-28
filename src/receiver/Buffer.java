package receiver;

/**
* La classe Buffer est composee d'un contenu. 
* C'est l'element dans lequel l'utilisateur ecrit.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07 
*/
public class Buffer {

	/**
	 * contenu du buffer
	 */
	private StringBuffer contenu = new StringBuffer("");

	/**
	 * {@link Buffer#contenu}
	 */
	public StringBuffer getContenu() {
		return contenu;
	}

	/**
	 * {@link Buffer#contenu}
	 */
	public void setContenu(String newContenu) {
		contenu = new StringBuffer(newContenu);
	}
	
	/**
	 * Insere un caractere ou une chaine dans le buffer
	 * @param start indice de debut d'insertion
	 * @param end indice de fin d'insertion
	 * @param string chaine a inserer
	 */
	public void insert(int start, int end, String string) {
		contenu.delete(start, end);
		contenu.insert(start, string); 
	}
	
	/**
	 * Supprime une partie du buffer
	 * @param start indice de debut de suppression
	 * @param end indice de fin de suppression
	 */
	public void delete(int start, int end) {
		contenu.delete(start, end); 
		contenu.insert(start, "");
	}
	
	public void append(String newChar) {
		contenu.append(newChar);
	}
	
	/**
	 * Renvoie un extrait de buffer
	 * @param start indice du debut de selection
	 * @param end indice de fin de selection
	 * @return extrait delimite par start et end
	 */
	public String substring(int start, int end) {
		return contenu.substring(start, end);
	}

}
