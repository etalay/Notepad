package command;

import client.Editeur;

public class Supprimer implements Command {
	
	private Editeur editeur;
	
	public Supprimer(Editeur newEditeur) {
		editeur = newEditeur;
	}

	public void execute() {
		editeur.getMoteur().supprimer();
	}
	
}
