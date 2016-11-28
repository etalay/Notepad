package command;

import client.Editeur;

public class Copier implements Command {
	
	private Editeur editeur;
	
	public Copier(Editeur newEditeur) {
		editeur = newEditeur;
	}
	
	public void execute() {
		editeur.getMoteur().copier();
	}
	
}
