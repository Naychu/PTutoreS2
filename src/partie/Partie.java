package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// Element: Joueurs
		for(Joueur all : elementsPartie.getJoueurs()) {
	        IG.changerNomJoueur(all.getNumJoueur(), all.getNomJoueur() +" ("+ all.getCategorie() +")");
	        IG.changerImageJoueur(all.getNumJoueur(), all.getNumeroImagePersonnage());
	        IG.placerJoueurSurPlateau(all.getNumJoueur(), all.getPosLigne(), all.getPosColonne());
	    }
		
		// Element: Plateau
		Plateau plateau = elementsPartie.getPlateau();
	    Piece pieceHorsPlateau = plateau.placerPiecesAleatoierment();
	        
	    IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(), pieceHorsPlateau.getOrientationPiece());
			
		for(int i = 0; i <= 7 - 1; i++) {
			for(int j = 0; j < 7; j++) {
				Piece piecePlateau = plateau.placerPiecesAleatoierment();
				IG.changerPiecePlateau(i, j, piecePlateau.getModelePiece(), piecePlateau.getOrientationPiece());	
			}
		}
		
		// Element: Objet
		

		IG.rendreVisibleFenetreJeu();
	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){
		// A Compléter
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		while(true){
			Partie partie=new Partie();
			partie.lancer();
		}
	}

}