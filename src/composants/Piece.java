package composants;

import java.util.Random;

/**
 * 
 * Cette classe permet de représenter les différentes pièces du jeu.
 * 
 */
abstract public class Piece {

	private int modelePiece; 		// Le modèle de la pièce
	private int orientationPiece; 	// L'orientation de la pièce
	private Boolean[] pointsEntree = new Boolean[4]; // Les points d'entrée indice 0 pour le haut, 1 pour la droite, 2 pour le bas et 3 pour la gauche.

	/**
	 * A Faire (11/05/2021 All Finalisé)
	 * 
	 * Constructeur permettant de créer une pièce d'un modèle avec l'orientation 0.
	 * @param modelePiece Le modèle de la pièce.
	 * @param pointEntreeHaut Un booléen indiquant si la pièce a un point d'entrée en haut.
	 * @param pointEntreeDroite Un booléen indiquant si la pièce a un point d'entrée à  droite.
	 * @param pointEntreeBas Un booléen indiquant si la pièce a un point d'entrée en bas.
	 * @param pointEntreeGauche Un booléen indiquant si la pièce a un point d'entrée à  gauche.
	 */
	public Piece(int modelePiece,boolean pointEntreeHaut,boolean pointEntreeDroite,boolean pointEntreeBas,boolean pointEntreeGauche){
		this.modelePiece = modelePiece;
		this.orientationPiece = 0;
		this.pointsEntree[0] = pointEntreeHaut;
		this.pointsEntree[1] = pointEntreeDroite;
		this.pointsEntree[2] = pointEntreeBas;
		this.pointsEntree[3] = pointEntreeGauche;
	}
	
	/**
	 * Méthode retournant un String représentant la pièce.
	 */
	@Override
	public String toString() {
		return "[m:"+modelePiece+"|o:"+orientationPiece+"|pe:"+pointsEntree[0]+" "+pointsEntree[1]+" "+pointsEntree[2]+" "+pointsEntree[3]+"]";
	}
	
	/**
	 * A Faire (12/05/2021 JC Finalisé)
	 * 
	 * Méthode permettant de rotationner une pièce dans le sens d'une horloge.
	 */
	public void rotation(){
		// Fini (Méthode full conditions)
		if(modelePiece == 0) {
			if(pointsEntree[0] == true && pointsEntree[1] == true) {
				pointsEntree[0] = false;
				pointsEntree[1] = true;
				pointsEntree[2] = true;
				pointsEntree[3] = false;
			}
			else if(pointsEntree[1] == true && pointsEntree[2] == true) {
				pointsEntree[0] = false;
				pointsEntree[1] = false;
				pointsEntree[2] = true;
				pointsEntree[3] = true;
			}
			else if(pointsEntree[2] == true && pointsEntree[3] == true) {
				pointsEntree[0] = true;
				pointsEntree[1] = false;
				pointsEntree[2] = false;
				pointsEntree[3] = true;
			}
			else if(pointsEntree[3] == true && pointsEntree[0] == true) {
				pointsEntree[0] = true;
				pointsEntree[1] = true;
				pointsEntree[2] = false;
				pointsEntree[3] = false;
			}
		}
		// Fini (Opti)
		else if(modelePiece == 1) {
			for(int i = 0; i <= pointsEntree.length; i++) {
				if(pointsEntree[i] == false) pointsEntree[i] = true;
				else if(pointsEntree[i] == true) pointsEntree[i] = false;
			}
		}
		// Fini (Méthode full conditions)
		else if(modelePiece == 2) {
			if(pointsEntree[0] == true && pointsEntree[1] == true && pointsEntree[2] == true) {
				pointsEntree[0] = false;
				pointsEntree[1] = true;
				pointsEntree[2] = true;
				pointsEntree[3] = true;
			}
			else if(pointsEntree[1] == true && pointsEntree[2] == true && pointsEntree[3] == true) {
				pointsEntree[0] = true;
				pointsEntree[1] = false;
				pointsEntree[2] = true;
				pointsEntree[3] = true;
			}
			else if(pointsEntree[2] == true && pointsEntree[3] == true && pointsEntree[0] == true) {
				pointsEntree[0] = true;
				pointsEntree[1] = true;
				pointsEntree[2] = false;
				pointsEntree[3] = true;
			}
			else if(pointsEntree[3] == true && pointsEntree[0] == true && pointsEntree[1] == true) {
				pointsEntree[0] = true;
				pointsEntree[1] = true;
				pointsEntree[2] = true;
				pointsEntree[3] = false;
			}
		}
		
	}
	
	/**
	 * A Faire (10/05/2021 JC Finalisé)
	 * 
	 * Méthode permettant d'orienter une pièce vers une orientation spécifique.
	 * @param orientationPiece Un entier correspondant à la nouvelle orientation de la pièce.
	 */
	public void setOrientation(int orientationPiece){
		this.orientationPiece = orientationPiece;
	}

	/**
	 * A Faire (11/05/2021 All Finalisé)
	 * 
	 * Méthode retournant le modèle de la pièce.
	 * @return Un entier corrspondant au modèle de la pièce.
	 */
	public int getModelePiece() {
		return modelePiece;
	}

	/**
	 * A Faire (11/05/2021 All Finalisé)
	 * 
	 * Méthode retournant l'orientation de la pièce.
	 * @return un entier retournant l'orientation de la pièce.
	 */
	public int getOrientationPiece() {
		return orientationPiece;
	}

	/**
	 * A Faire (11/05/2021 JC Finalisé)
	 * 
	 * Méthode indiquant si il existe un point d'entrée à une certaine position (0: en haut, 1: à droite, 2: en bas, 3: à gauche).
	 * @param pointEntree L'indice/la position du point d'entrée.
	 * @return true si il y a un point d'entrée, sinon false.
	 */
	public boolean getPointEntree(int pointEntree){
		return this.pointsEntree[pointEntree];
	}
	
	/**
	 * A Faire (12/05/21 JC Finalisé)
	 * 
	 * Méthode permettant de créer un tableau contenant toutes les pièces du jeu (les 50 pièces).
	 * Le tableau contiendra 20 pièces du modèle 0, 12 pièces du modèle 1 et 18 pièces du modèle 2.
	 * L'orientation de chaque pièce sera aléatoire.
	 * @return Un tableau contenant toutes les pièces du jeu.
	 */
	public static Piece[] nouvellesPieces(){
		Piece pieces[] = new Piece[51];
		// A Compléter (A Faire après les classes PieceM0, PieceM1 et PieceM2)
		for (int i = 0; i<= 19 ; i++) {
            pieces[i] = new PieceM0();
            
            Random rand = new Random();
			int r = rand.nextInt(4);
            pieces[i].setOrientation(r);
        }
        for (int i = 20; i<= 31 ; i++) {
        	pieces[i] = new PieceM1();
        	
        	Random rand = new Random();
			int r = rand.nextInt(2);
            pieces[i].setOrientation(r);
        }
        for (int i = 32; i<= 50 ; i++) {
            pieces[i] = new PieceM2();
            
            Random rand = new Random();
			int r = rand.nextInt(4);
            pieces[i].setOrientation(r);
        }
		return pieces;
	}
	
	/**
	 * Méthode permettant de créer une copie de la pièce (un nouvelle objet Java).
	 * @return Une copie de la pièce.
	 */
	public abstract Piece copy();
}
