package invoker;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import client.Editeur;
import command.*;

/**
 * La classe Ihm cree une interface Swing afin d'editer un texte.
 *
* @author  Emre Talay & Julien Louis
* @version 1.0
* @since   2016-11-07
 */
public class Ihm extends JFrame implements Observer {

	private static final long serialVersionUID = 545596132571887945L;

	private Editeur editeur;

	// Commandes de l'application
	private Command copierC;
	private Command couperC;
	private Command collerC;
	private Command selectionC;
	private Command saisieC;
	private Command supprimerC;

	// Composants Swing
	private JButton copier;
	private JButton couper;
	private JButton coller;
	private JTextArea textArea;

	/**
	 * Tableau d'indice de debut et fin de selection
	 */
	private int[] selectionData = new int[2];

	/**
	 * Dernier caractere tape
	 */
	private char newChar = ' ';

	/**
	 * Constructeur de la classe
	 * 
	 * @param newEditeur
	 */
	public Ihm(Editeur newEditeur) {
		editeur = newEditeur;

		// Initialisation des commandes
		copierC = new Copier(editeur);
		couperC = new Couper(editeur);
		collerC = new Coller(editeur);
		selectionC = new Selectionner(editeur, this);
		saisieC = new Saisir(editeur, this);
		supprimerC = new Supprimer(editeur);

		this.setSize(700, 700);
		// Centre la JFrame
		this.setLocationRelativeTo(null);
		// Quitte le programme lorsque la JFrame est fermee
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Editeur de texte");

		// Creation du JPanel principal
		JPanel mainPanel = new JPanel();
		// Creation du BorderLayout
		mainPanel.setLayout(new BorderLayout());
		// Ajout du JPanel a la JFrame
		this.add(mainPanel);

		// Initialisation des boutons
		copier = new JButton("Copier");
		couper = new JButton("Couper");
		coller = new JButton("Coller");

		// Desactivation boutons
		coller.setEnabled(false);

		// Creation du listener bouton
		ButtonListener buttonListener = new ButtonListener();
		copier.addActionListener(buttonListener);
		couper.addActionListener(buttonListener);
		coller.addActionListener(buttonListener);

		// Creation du panel superieur pour les boutons d'action
		JPanel upperPanel = new JPanel();
		upperPanel.add(copier);
		upperPanel.add(couper);
		upperPanel.add(coller);
		mainPanel.add(upperPanel, BorderLayout.NORTH);

		// Creation du JTextArea
		textArea = new JTextArea();
		Font f = new Font("Calibri", Font.PLAIN, 20);
		textArea.setFont(f);

		// Creation des Listener pour le JTextArea
		SelectionListener selectionListener = new SelectionListener();
		SaisieListener saisieListener = new SaisieListener();
		textArea.addCaretListener(selectionListener);
		textArea.addKeyListener(saisieListener);

		// Ajout du JTextArea au JPanel principal
		mainPanel.add(textArea, BorderLayout.CENTER);

		this.setVisible(true);

		// Le textArea sera selectionne par defaut
		textArea.requestFocus();
	}

	/**
	 * {@link Ihm#selectionData}
	 */
	public int[] getSelection() {
		return selectionData;
	}

	/**
	 * {@link Ihm#newChar}
	 */
	public char getChar() {
		return newChar;
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == copier) {
				coller.setEnabled(true);
				copierC.execute();
			} else if (e.getSource() == couper) {
				couperC.execute();
				coller.setEnabled(true);
			} else if (e.getSource() == coller)
				collerC.execute();
		}
	}

	private class SelectionListener implements CaretListener {
		public void caretUpdate(CaretEvent e) {
			int newDebut = Math.min(e.getDot(), e.getMark());
			int newFin = Math.max(e.getDot(), e.getMark());

			if (newDebut != selectionData[0] || newFin != selectionData[1]) {
				selectionData[0] = newDebut;
				selectionData[1] = newFin;
				selectionC.execute();
			}
		}
	}

	private class SaisieListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			if (!e.isActionKey()) {
				if ((int) e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					supprimerC.execute();
				} else if ((int) e.getKeyChar() == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
			if ((int) e.getKeyChar() != KeyEvent.VK_BACK_SPACE && (int) e.getKeyChar() != KeyEvent.VK_DELETE) {
				newChar = e.getKeyChar();
				saisieC.execute();
			}
		}

	}

	// Observer method
	public void update(String contenu) {
		textArea.setText(contenu);
	}

}
