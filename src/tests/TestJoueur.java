package tests;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur{
	public static void main(String[] args) {
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
        
        Plateau plateau = new Plateau();
        Piece pieceHorsPlateau = plateau.placerPiecesAleatoierment();
        
        Joueur joueurs[]=Joueur.nouveauxJoueurs(parametres);

    }
}