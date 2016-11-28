package command;

import client.Editeur;

public class Coller implements Command {
	
	private Editeur editeur;
	
	public Coller(Editeur newEditeur) {
		editeur = newEditeur;
	}
	
	public void execute() {
		editeur.getMoteur().coller();
	}
	
}
