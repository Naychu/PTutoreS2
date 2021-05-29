package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import partie.ElementsPartie;

public class TestElementsPartie {

	public static void main(String[] args) {
		int taillePlateau = 7;
        
        Object parametresJeu[];
        parametresJeu = IG.saisirParametres();
        int nbJoueurs = ((Integer)parametresJeu[0]).intValue();
        IG.creerFenetreJeu("- TestElementsPartie", nbJoueurs);
        Joueur joueurs[] = Joueur.nouveauxJoueurs(parametresJeu);
        ElementsPartie elementsPartie = new ElementsPartie(joueurs);
        
        IG.creerFenetreJeu("Démo Librairie IG version 1.9",nbJoueurs);
        IG.rendreVisibleFenetreJeu();
        
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoierment();
        
        IG.changerPieceHorsPlateau(pieceHorsPlateau.getModelePiece(), pieceHorsPlateau.getOrientationPiece());
		
		for(int i = 0; i <= taillePlateau - 1; i++) {
			for(int j = 0; j < taillePlateau; j++) {
				Piece piecePlateau = plateau.placerPiecesAleatoierment();
				IG.changerPiecePlateau(i, j, piecePlateau.getModelePiece(), piecePlateau.getOrientationPiece());	
			}
		}
        
        for(Joueur all : joueurs) {
        	IG.changerNomJoueur(all.getNumJoueur(), all.getNomJoueur() +" ("+ all.getCategorie() +")");
            IG.changerImageJoueur(all.getNumJoueur(), all.getNumeroImagePersonnage());
            IG.placerJoueurSurPlateau(all.getNumJoueur(), all.getPosLigne(), all.getPosColonne());
        }
        
        String message[]={
				"",
				"Cliquez pour continuer …",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();

	}

}
