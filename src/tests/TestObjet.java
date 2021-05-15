package tests;

import java.util.Random;

import grafix.interfaceGraphique.IG;

public class TestObjet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		IG.miseAJourAffichage();
		IG.attendreClic();
		
		for (int i=0;i<=18;i++) { 
            Random rand1 = new Random();
			int l = rand1.nextInt(taillePlateau);
			Random rand2 = new Random();
			int c = rand2.nextInt(taillePlateau);
			IG.placerObjetPlateau(i, l, c);
		}
		IG.miseAJourAffichage();
		IG.attendreClic();
	}

}
