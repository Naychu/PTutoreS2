package tests;

import java.util.Random;

import composants.Objet;
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
		
		Objet[] t = Objet.nouveauxObjets();
		int [] c2 = new int[19];
		int [] l2 = new int[19];
		boolean b = true;
		int r = 0;
		for (int i = 0; i <= 17;i++){
			b = true;
			Random rand1 = new Random();
			int l = rand1.nextInt(7);
			int c = rand1.nextInt(7);
			while (b == true) {
				for (int g = 0 ; g<= l2.length;g++ ) {
					for (int j = 0 ; j<= c2.length;j++ ) {
						if (l != g && c != g ){
							IG.placerObjetPlateau(t[i].getNumeroObjet(),l,c);
							c2[i] = c;
							l2[i] = l;
							System.out.println(g);
							System.out.println("----");

							b = false;
						}
					}				
				}
				if (b == true) {
					System.out.println("recommence");
					l = rand1.nextInt(7);
					c = rand1.nextInt(7);	

				}
			}
			System.out.println(l);
			System.out.println(c);
			System.out.println("______");
			r = r + 1;

		}
		System.out.println(r);
		IG.miseAJourAffichage();
		IG.attendreClic();
	}

}
