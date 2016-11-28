package receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestMoteurEdition {
	
	private MoteurEditionImpl moteur;
	
	@Before	
	public void setUp() {
		moteur = new MoteurEditionImpl();
	}

	@Test
	public void testCouperNormal() {
		moteur.saisir("test_string");
		// on selectionne "test"
		moteur.selectionner(0, 4);
		moteur.couper();
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		String contenuPressePapier = moteur.getPressePapier().getContenu();
		
		assertTrue("Le presse papier est vide", !contenuPressePapier.isEmpty());
		assertEquals("Le contenu du presse papier n'est pas correct", "test", contenuPressePapier);
		assertEquals("Le contenu du buffer n'est pas correct", "_string", contenuBuffer);
	}
	
	@Test
	public void testCouperBufferVide() {
		moteur.couper();
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		String contenuPressePapier = moteur.getPressePapier().getContenu();
		
		assertTrue("Le presse papier n'est pas vide", contenuPressePapier.isEmpty());
		assertEquals("Le contenu du presse papier n'est pas correct", "", contenuPressePapier);
		assertEquals("Le contenu du buffer n'est pas correct", "", contenuBuffer);
	}

	@Test
	public void testCopierNormal() {
		moteur.saisir("test_string");
		// on selectionne "test"
		moteur.selectionner(0, 4);
		moteur.copier();
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		String contenuPressePapier = moteur.getPressePapier().getContenu();
		
		assertTrue("Le presse papier est vide", !contenuPressePapier.isEmpty());
		assertEquals("Le contenu du presse papier n'est pas correct", "test", contenuPressePapier);
		assertEquals("Le contenu du buffer n'est pas correct", "test_string", contenuBuffer);	
	}
	
	@Test
	public void testCopierBufferVide() {
		moteur.copier();
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		String contenuPressePapier = moteur.getPressePapier().getContenu();
		
		assertTrue("Le presse papier n'est pas vide", contenuPressePapier.isEmpty());
		assertEquals("Le contenu du presse papier n'est pas correct", "", contenuPressePapier);
		assertEquals("Le contenu du buffer n'est pas correct", "", contenuBuffer);	
	}

	@Test
	public void testCollerNormal() {
		moteur.saisir("test_string");
		// on selectionne "test"
		moteur.selectionner(0, 4);
		moteur.couper();
		// on place la selection au debut du buffer
		moteur.selectionner(1, 1);
		moteur.coller();
		
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		assertEquals("Le contenu du buffer n'est pas correct", "_teststring", contenuBuffer);
	}

	@Test
	public void testSelection() {
		moteur.saisir("test_string");
		// on selectionne "test"
		moteur.selectionner(4, 11);
		
		assertEquals("La selection n'est pas correcte", "_string", moteur.getSelection().getContenu());
		assertEquals("L'entier de debut de selection n'est pas correct", 4, moteur.getSelection().getDebut());
		assertEquals("L'entier de fin de selection n'est pas correct", 11, moteur.getSelection().getFin());
	}
	
	@Test
	public void testSelectionVide() {
		moteur.saisir("test_string");
		// on selectionne ""
		moteur.selectionner(5, 5);
		
		assertEquals("La selection n'est pas correcte", "", moteur.getSelection().getContenu());
		assertEquals("L'entier de debut de selection n'est pas correct", 5, moteur.getSelection().getDebut());
		assertEquals("L'entier de fin de selection n'est pas correct", 5, moteur.getSelection().getFin());
	}

	@Test
	public void testSaisir() {
		moteur.saisir("test_string");
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		
		assertTrue("Le contenu du buffer est vide", !contenuBuffer.isEmpty());
		assertEquals("Le contenu du buffer n'est pas correct", "test_string", contenuBuffer);
	}
	
	@Test
	public void testSaisirEntre() {
		moteur.saisir("test_string");
		moteur.selectionner(4, 4);
		moteur.saisir("_something");
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		
		assertTrue("Le contenu du buffer est vide", !contenuBuffer.isEmpty());
		assertEquals("Le contenu du buffer n'est pas correct", "test_something_string", contenuBuffer);
	}
	
	@Test
	public void testSaisirSelection() {
		moteur.saisir("test_string");
		moteur.selectionner(0, 4);
		moteur.saisir("_something");
		String contenuBuffer = moteur.getBuffer().getContenu().toString();
		
		assertTrue("Le contenu du buffer est vide", !contenuBuffer.isEmpty());
		assertEquals("Le contenu du buffer n'est pas correct", "_something_string", contenuBuffer);
	}

}
