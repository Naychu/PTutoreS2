package partie;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

/**
 * 
 * Cette classe permet de représenter un ensemble d'élements composant une partie de jeu.
 * 
 */
public class ElementsPartie {

	private Joueur[] joueurs; 	// Les joueurs de la partie.
	private Objet[] objets; 	// Les 18 objets de la partie dans l'ordre de leurs numéros.
	private Plateau plateau; 	// Le plateau des pièces.
	private Piece pieceLibre; 	// La pièce libre.
	private int nombreJoueurs; 	// Le nombre de joueurs.
	private List<Integer> aused = new ArrayList<Integer>(); // Liste des objets d�j� attribu�s

	/**
	 * 
	 * A Faire (29/05/2021 JC Fini)
	 *  
	 * Constructeur permettant de générer et d'initialiser l'ensemble des éléments d'une partie (sauf les joueurs qui sont donnés en paramètres).
	 * 
	 * Un plateau est créé en placant 49 oièces de manière aléatoire (utilisation de la méthode placerPiecesAleatoierment de la classe Plateau).
	 * La pièce restante (celle non présente sur le plateau) est affectée �  la pièce libre.
	 * Les 18 objets sont créés avec des positions aléatoires sur le plateau (utilisation de la méthode Objet.nouveauxObjets)
	 * et distribu�es aux différents joueurs (utilisation de la méthode attribuerObjetsAuxJoueurs).
	 * 
	 * @param joueurs Les joueurs de la partie. Les objets des joueurs ne sont pas encore attribués (c'est au constructeur de le faire).
	 */
	public ElementsPartie(Joueur[] joueurs) {
		/*plateau.placerPiecesAleatoierment();
		Objet.nouveauxObjets();*/
		this.joueurs = joueurs;
		plateau = new Plateau();
		pieceLibre = plateau.placerPiecesAleatoierment();
		objets = Objet.nouveauxObjets();
		attribuerObjetsAuxJoueurs();
		
		
	}

	/**
	 * Un simple constructeur.
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param objets Les 18 objets de la partie.
	 * @param plateau Le plateau de jeu.
	 * @param pieceLibre La pièce libre (la pièce hors plateau).
	 */
	public ElementsPartie(Joueur[] joueurs,Objet[] objets,Plateau plateau,Piece pieceLibre) {
		this.joueurs=joueurs;
		nombreJoueurs=joueurs.length;
		this.objets=objets;
		this.plateau=plateau;
		this.pieceLibre=pieceLibre;
	}

	/**
	 * A Faire (29/05/2021 all Fini)
	 * 
	 * Méthode permettant d'attribuer les objets aux différents joueurs de manière aléatoire.
	 */
	public void attribuerObjetsAuxJoueurs(){
		Random rand = new Random();

		if (joueurs.length == 3) {
			for(Joueur all : joueurs) {
				for(int i = 0; i <= 5; i++) {
					int r = rand.nextInt(18);
					if(aused.contains(r) == true) {
						i--;
					} else {
						IG.changerObjetJoueur(all.getNumJoueur(), r, i);
						aused.add(r);
					}
				}
			}
		}
		if (joueurs.length == 2) {
			for(Joueur all : joueurs) {
				for(int i = 0; i <= 8; i++) {
					int r = rand.nextInt(18);
					if(aused.contains(r) == true) {
						i--;
					} else {
						IG.changerObjetJoueur(all.getNumJoueur(), r, i);
						aused.add(r);
					}
				}
			}
		}
	}

	/**
	 * (28/05/2021 CG Fini)
	 * 
	 * Méthode permettant de récupérer les joueurs de la partie.
	 * @return Les joueurs de la partie.
	 */
	public Joueur[] getJoueurs() {
		return joueurs; 
	}


	/**
	 * (28/05/2021 CG Fini)
	 * 
	 * Méthode permettant de récupérer les pièces de la partie.
	 * @return Les objets de la partie.
	 */
	public Objet[] getObjets() {
		return objets; 
	}


	/**
	 *  (28/05/2021 CG Fini)
	 * 
	 * Méthode permettant de récupérer le plateau de pièces de la partie.
	 * @return Le plateau de pièces.
	 */
	public Plateau getPlateau() {
		return plateau; 
	}


	/**
	 *  (29/05 Max Fini)
	 * 
	 * Méthode permettant de récupérer la pièce libre de la partie.
	 * @return La pièce libre.
	 */
	public Piece getPieceLibre() {
		return pieceLibre; 
	}


	/**
	 * (28/05 CG Fini)
	 * 
	 * Méthode permettant de récupérer le nombre de joueurs de la partie.
	 * @return Le nombre de joueurs.
	 */
	public int getNombreJoueurs() {
		return nombreJoueurs; 
	}


	/**
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode modifiant les différents éléments de la partie suite �  l'insertion de la pièce libre dans le plateau.
	 * 
	 * @param choixEntree L'entrée choisie pour réaliser l'insertion (un nombre entre 0 et 27).
	 */
	public void insertionPieceLibre(int choixEntree){

	}


	/**
	 * Méthode retournant une copie.
	 * 
	 * @return Une copie des éléments.
	 */
	public ElementsPartie copy(){
		Objet[] nouveauxObjets=new Objet[(this.objets).length];
		for (int i=0;i<objets.length;i++)
			nouveauxObjets[i]=(this.objets[i]).copy();
		Joueur[] nouveauxJoueurs=new Joueur[nombreJoueurs];
		for (int i=0;i<nombreJoueurs;i++)
			nouveauxJoueurs[i]=(this.joueurs[i]).copy(objets);
		Plateau nouveauPlateau=(this.plateau).copy();
		Piece nouvellePieceLibre=(this.pieceLibre).copy();
		ElementsPartie nouveauxElements=new  ElementsPartie(nouveauxJoueurs,nouveauxObjets,nouveauPlateau,nouvellePieceLibre); 
		return nouveauxElements;
	}


}