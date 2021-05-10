package composants;

import grafix.interfaceGraphique.IG;
import java.util.Random;

/**
 * 
 * Cette classe permet de repr�senter les diff�rentes pi�ces du jeu.
 * 
 */
abstract public class Piece {

	private int modelePiece; 		// Le mod�le de la pi�ce
	private int orientationPiece; 	// L'orientation de la pi�ce
	private boolean[] pointsEntree; // Les points d'entr�e indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de cr�er une pi�ce d'un mod�le avec l'orientation 0.
	 * @param modelePiece Le mod�le de la pi�ce.
	 * @param pointEntreeHaut Un bool�en indiquant si la pi�ce a un point d'entr�e en haut.
	 * @param pointEntreeDroite Un bool�en indiquant si la pi�ce a un point d'entr�e � droite.
	 * @param pointEntreeBas Un bool�en indiquant si la pi�ce a un point d'entr�e en bas.
	 * @param pointEntreeGauche Un bool�en indiquant si la pi�ce a un point d'entr�e � gauche.
	 */
	public Piece(int modelePiece,boolean pointEntreeHaut,boolean pointEntreeDroite,boolean pointEntreeBas,boolean pointEntreeGauche){
		this.modelePiece = modelePiece;
		
		
	}
	
	/**
	 * M�thode retournant un String repr�sentant la pi�ce.
	 */
	@Override
	public String toString() {
		return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
	}
	
	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant de rotationner une pi�ce dans le sens d'une horloge.
	 */
	public void rotation(){
		IG.changerPiecePlateau(random(1, 7),random(1, 7) , modelePiece, 1);
		
	}
	
	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode permettant d'orienter une pi�ce vers une orientation sp�cifique.
	 * @param orientationPiece Un entier correspondant � la nouvelle orientation de la pi�ce.
	 */
	public void setOrientation(int orientationPiece){
		this.orientationPiece = orientationPiece;
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode retournant le mod�le de la pi�ce.
	 * @return Un entier corrspondant au mod�le de la pi�ce.
	 */
	public int getModelePiece() {
		// A Modifier !!!
		return modelePiece;
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode retournant l'orientation de la pi�ce.
	 * @return un entier retournant l'orientation de la pi�ce.
	 */
	public int getOrientationPiece() {
		// A Modifier !!!
		return orientationPiece;
	}

	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * M�thode indiquant si il existe un point d'entr�e � une certaine position (0: en haut, 1: � droite, 2: en bas, 3: � gauche).
	 * @param pointEntree L'indice/la position du point d'entr�e.
	 * @return true si il y a un point d'entr�e, sinon false.
	 */
	public boolean getPointEntree(int pointEntree){
		// A compl�ter
		return false;
	}
	
	/**
	 * A Faire (08/05/21 CG EnCours)
	 * 
	 * M�thode permettant de cr�er un tableau contenant toutes les pi�ces du jeu (les 50 pi�ces).
	 * Le tableau contiendra 20 pi�ces du mod�le 0, 12 pi�ces du mod�le 1 et 18 pi�ces du mod�le 2.
	 * L'orientation de chaque pi�ce sera al�atoire.
	 * @return Un tableau contenant toutes les pièces du jeu.
	 */
	public static Piece[] nouvellesPieces(){
		Piece pieces[]=null;
		// A Compl�ter (A Faire apr�s les classes PieceM0, PieceM1 et PieceM2)
		for (int i = 0; i<= 20 ; i++) {
            //pieces = new int[modelePiece(0)];
        }
        for (int i = 0; i<= 12 ; i++) {
            //pieces = new int[modelePiece(1)];
        }
        for (int i = 0; i<= 18 ; i++) {
            //pieces = new int[modelePiece(2)];
        }
		return pieces;
	}
	
	/**
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public abstract Piece copy();
	
	public int random(int min, int max) {
		Random random = new Random();
		int value = random.nextInt(max - min) + min;
		return value;
	}
}
