package command;

import client.Editeur;

public class Couper implements Command {
	
	private Editeur editeur;
	
	public Couper(Editeur newEditeur) {
		editeur = newEditeur;
	}
	
	public void execute() {
		editeur.getMoteur().couper();
	}
	
}
