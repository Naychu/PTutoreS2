package tests;
import grafix.interfaceGraphique.IG;

public class MaDemoIG {

	public static void main(String[] args) {
		
		Object parametres[];
		parametres=IG.saisirParametres();
		
		int nbJoueurs=((Integer)parametres[0]).intValue();
		IG.creerFenetreJeu("D�mo Librairie IG version 1.9",nbJoueurs);
		IG.rendreVisibleFenetreJeu();
		
		IG.changerNomJoueur(0, (String)parametres[1] +" ("+ (String)parametres[2] +")");
		IG.changerImageJoueur(0,((Integer)parametres[3]).intValue());
		IG.changerNomJoueur(1, (String)parametres[4] +" ("+ (String)parametres[5] +")");
		IG.changerImageJoueur(1,((Integer)parametres[6]).intValue());
		IG.changerNomJoueur(2, (String)parametres[7] +" ("+ (String)parametres[8] +")");
		IG.changerImageJoueur(2,((Integer)parametres[9]).intValue());
		
		// Les objets des joueurs sont affich�s en suivant l'ordre de leur num�ro :
		// l'objet 0 se trouve en position 0 pour le joueur 0,
		IG.changerObjetJoueur(0, 0, 0);
		// l'objet 1 se trouve en position 1 pour le joueur 0...
		for(int i = 1; i <= 5; i++) IG.changerObjetJoueur(0, i, i);
		
		// Les objets des 2 autres joueurs
		int t = 0;
		for(int j = 6; j <= 11; j++) {
			IG.changerObjetJoueur(1, j, t);
			t++;
		}
		t = 0;
		for(int j = 12; j <= 17; j++) {
			IG.changerObjetJoueur(2, j, t);
			t++;
		}
		
		// Le plateau ne contient que des pi�ces du mod�le 2 et de type 0.
		for(int i = 0; i <= 6; i++) {
			for(int j = 0; j < 7; j++) {
				IG.changerPiecePlateau(i, j, 2, 0);
			}
		}
		
		// La pi�ce hors plateau est de mod�le 1 et de type 0.
		IG.changerPieceHorsPlateau(1, 0);
		
		// Les objets sont r�partis sur le plateau dans l'ordre, l'objet 0 sur la premi�re case, l'objet 1 sur la deuxi�me case, ...
		int c = 0;
		for(int i = 0; i <= 17; i++) {
			int l = i / 7;
			if(c >= 7) {
				c = 0;
			}
			IG.placerObjetPlateau(i, l, c);
			c++;
		}
		
		// Le premier joueur est plac� sur la ligne du milieu � gauche du plateau, tandis que le deuxi�me joueur est plac� sur la ligne du milieu � droite du plateau.
		IG.placerJoueurPrecis(0, 3, 0, 1, 0);
		IG.placerJoueurPrecis(1, 3, 6, 1, 2);
		// L'�ventuel troisi�me joueur n'est pas pr�sent sur le plateau.
			
		IG.miseAJourAffichage();
		
		// Un message contenant "Bonjour !" et "Cliquez pour continuer �" est affich�.
		String message[]={
				"",
				"Bonjour !",
				"Cliquez pour continuer �",
				""
		};
		IG.afficherMessage(message);
		IG.miseAJourAffichage();
		IG.attendreClic();
	}

}
