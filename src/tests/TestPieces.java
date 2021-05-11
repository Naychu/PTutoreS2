package tests;

import grafix.interfaceGraphique.IG;

public class TestPieces {

	public static void main(String[] args) {
		// 1. Dans un premier temps, les paramètres du jeu seront saisis. Dans la suite nous supposerons que les paramètres par défaut ont été saisis par l'utilisateur.
		int taillePlateau = 7;
		
		Object parametres[];
		parametres=IG.saisirParametres();
		
		int nbJoueurs=((Integer)parametres[0]).intValue();
		IG.creerFenetreJeu("Démo Librairie IG version 1.9",nbJoueurs);
		IG.rendreVisibleFenetreJeu();
		
		IG.changerNomJoueur(0, (String)parametres[1] +" ("+ (String)parametres[2] +")");
		IG.changerImageJoueur(0,((Integer)parametres[3]).intValue());
		IG.changerNomJoueur(1, (String)parametres[4] +" ("+ (String)parametres[5] +")");
		IG.changerImageJoueur(1,((Integer)parametres[6]).intValue());
		IG.changerNomJoueur(2, (String)parametres[7] +" ("+ (String)parametres[8] +")");
		IG.changerImageJoueur(2,((Integer)parametres[9]).intValue());

		// 2. Une fois les paramètres saisis, le programme ouvrira la fenêtre de jeu avec une configuration initiale correspondant à un affichage par défaut sauf pour le message affiché qui sera "Cliquez pour continuer ...". Le programme attendra un clic de souris de l'utilisateur.
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
