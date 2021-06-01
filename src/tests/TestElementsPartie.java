package tests;

import java.util.Random;

import composants.Objet;
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
		
		Objet[] t = Objet.nouveauxObjets();
		int [] pos = new int[36];
		boolean b = false;
		int r = 0;
		int y = 0;

		while(r < 18){
			Random rand1 = new Random();
			int l = rand1.nextInt(7);
			int c = rand1.nextInt(7);
			for ( int i = 0;i<pos.length-1;i+=2) {
				if (pos[i]==l && pos[i+1] == c) {
					b = true;
				}
			}
			if ( b == false) {
				IG.placerObjetPlateau(t[r].getNumeroObjet(),l,c);
				pos[y*2]=l;
				pos[y*2+1]=c;
				y  +=1;
				r +=1;
			}
			b = false;
				
			
			

		}
		System.out.println(r);
		IG.miseAJourAffichage();
		IG.attendreClic();
	}

}
