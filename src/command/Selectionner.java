package command;

import client.Editeur;
import invoker.Ihm;

public class Selectionner implements Command {
	
	private Editeur editeur;
	private Ihm ihm;
	
	public Selectionner(Editeur newEditeur, Ihm newIhm) {
		editeur = newEditeur;
		ihm = newIhm;
	}
	
	public void execute() { 
		int[] debutFin = ihm.getSelection();
		editeur.getMoteur().selectionner(debutFin[0], debutFin[1]);
	}
	
}
