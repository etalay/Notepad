package receiver;

/**
* La classe Selection definit une selection par
* un indice de debut et de fin ainsi qu'un contenu.
*
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07
*/
public class Selection {
	
	/**
	 * contenu de la selection
	 */
	private String contenu = "";
	/**
	 * indice de debut de selection
	 */
	private int debut;
	/**
	 * indice de fin de selection
	 */
	private int fin;
	
	/**
     * {@link Selection#contenu}
     */
	public String getContenu() {
		return contenu;
	}

	/**
     * {@link Selection#contenu}
     */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
     * {@link Selection#debut}
     */
	public int getDebut() {
		return debut;
	}

	/**
     * {@link Selection#debut}
     */
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
     * {@link Selection#fin}
     */
	public int getFin() {
		return fin;
	}

	/**
     * {@link Selection#fin}
     */
	public void setFin(int fin) {
		this.fin = fin;
	}
	
}
