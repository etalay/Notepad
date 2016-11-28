package command;

import client.Editeur;
import invoker.Ihm;

public class Saisir implements Command {
	
	private Editeur editeur;
	private Ihm ihm;
	
	public Saisir(Editeur newEditeur, Ihm newIhm) {
		editeur = newEditeur;
		ihm = newIhm;
	}

	public void execute() {
		char newChar = ihm.getChar();
		editeur.getMoteur().saisir(Character.toString(newChar));
	}
	
}
