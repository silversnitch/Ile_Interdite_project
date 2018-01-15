package ile_interdite.Controler;

import ile_interdite.CarteInnondation.CarteInnondation;
import ile_interdite.CarteTirage.CarteTirage;
import ile_interdite.Plateau.Tuile;
import ile_interdite.Plateau.Grille;
import ile_interdite.Vue.VueAventurier;
import ile_interdite.Aventurier.*;
import ile_interdite.CarteTirage.CarteTresor;
import ile_interdite.CarteTirage.TypeCarte;
import ile_interdite.Tresor.Tresor;
import ile_interdite.util.Utils.EtatTuile;
import ile_interdite.util.Utils.Role;
import ile_interdite.CarteTirage.TypeTresor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class Controleur implements Observer{

	private Grille grille;
	private VueAventurier vueAventurier;
	private ArrayList<Aventurier> joueurs;	// La liste des aventurier en jeu
        private int indexJoueurActuel;
	private int nbAction;			// Le nombre d'actions disponible pour un tour
	private ArrayList<CarteTirage> piocheCT;
	private ArrayList<CarteTirage> defausseCT;
	private ArrayList<CarteInnondation> piocheCI;
	private ArrayList<CarteInnondation> defausseCI;
	private final static int[] nbCarteMonteeEau_ATirer = {2,2,3,3,3,4,4,5,5,6};
	private int niveauEau;
        private ArrayList<Tresor> tresors;

        public Controleur()
	{
	    grille = new Grille();
	    vueAventurier = null;
	    joueurs = new ArrayList<>();
	    indexJoueurActuel = 0;
	    nbAction = 3;
	    piocheCT = new ArrayList<>();
	    defausseCT = new ArrayList<>();
	    piocheCI = new ArrayList<>();
	    defausseCI = new ArrayList<>();
	    niveauEau = 0;
	    tresors = new ArrayList<>();
	    initTresor();
	}
            
	public void seDeplacer() {
	    Aventurier avActuel = joueurs.get(indexJoueurActuel);
	    HashSet deplacementsNormaux = grille.getOrt(avActuel.getPosition());		    // Collection de tuile qui sont accessibles par un deplacement 'normal'
	    HashSet<Tuile> tuilesDeplacement = avActuel.getDeplacementsPossibles(this.grille);	    // Collection de tuiles accessibles par l'aventurier
	    
	    System.out.println("\n------\nBOUGER");
	    
	    if(tuilesDeplacement.isEmpty())							    // Si aucune tuile n'est accessible
	    {
		System.out.println("(" + nbAction + " actions restantes)");
		System.out.println("Vous ne pouvez pas vous déplacer.");
		nbAction++;									    //Annulation de l'action
	    }
	    else
	    {
		System.out.println("(" + (nbAction-1) + " actions restantes)");
		System.out.println("\nVous êtes sur la tuile '" + avActuel.getPosition().getNom() + "' : " + avActuel.getPosition().getCoordonnee().toString());
		
		System.out.println("Tuiles accessibles :");
		for(Tuile tui : tuilesDeplacement){ 
		    System.out.print("\t'" + tui.getNom() + "' : " + tui.getCoordonnee().toString());
		    if(deplacementsNormaux.contains(tui) && !avActuel.getDeplacementSpecialEffectue())	// Affiche si la tuile est un déplacement 'normal' si le pilote n'a pas utilisé son action spéciale
		    {
			System.out.println(" [Déplacement de base]");
		    }
		    else System.out.println();
		}

		Scanner sc = new Scanner(System.in);
		String nomtuile;
		Tuile tuiletemp ;

		do{											// Saisie & verification de la validité de la tuile
		    System.out.print("nom := ");
		    nomtuile = sc.nextLine();
		    tuiletemp=this.grille.chercherTuile(nomtuile);
		}
		while (tuiletemp==null || ! tuilesDeplacement.contains(tuiletemp));

		System.out.println(" Vous vous êtes déplacés sur la tuile : '" +tuiletemp.getNom() + "'");

		avActuel.getPosition().rmJoueur(avActuel);						// retirer le joueur de sa tuile actuelle
		avActuel.setPosition(tuiletemp);							// le mettre sur la nouvelle tuile
		tuiletemp.addJoueur(avActuel);								// ajouter le joueur à la nouvelle tuile
		 
		if(!avActuel.getDeplacementSpecialEffectue())						// Si le joueur est un pilote et qu'il a effectué son deplacement special, il ne pourra plus l'utiliser avant son prochain tour
		{
		    if(!deplacementsNormaux.contains(tuiletemp))
		    {
			avActuel.setDeplacementSpecialEffectue(true);
		    }
		} 
	    }
	}

	public void JoueurSuivant()
        {
		if(indexJoueurActuel < joueurs.size()-1)    indexJoueurActuel++;
                else					    indexJoueurActuel = 0;
		getJActuel().setDeplacementSpecialEffectue(false);	// Remet à jour l'action spéciale du pilote
	}

	public void assecherTuile()
	{
		HashSet<Tuile> collecTuile = joueurs.get(indexJoueurActuel).tuilesAssechables(grille);	// Collection des tuiles assechables
		
                System.out.println("\n------\nASSECHER");
                
                if(collecTuile.isEmpty())								// S'il n'y a rien a assecher
                {
		    System.out.println("(" + nbAction + " actions restantes)");
                    System.out.println("Aucune tuile à assecher.");
                    nbAction++;										// Annulation de l'action
		    
                }
                else
                {
		    System.out.println("(" + (nbAction-1) + " actions restantes)");
		    assecherTuile_ChercherEtAction(collecTuile);					// Lance le processus de saisie et d'assechement de la tuile
		    
		    if(joueurs.get(indexJoueurActuel).getRole().equals(Role.INGENIEUR))
		    {
			collecTuile = joueurs.get(indexJoueurActuel).tuilesAssechables(grille);		// MàJ des tuiles assechables
			if(!collecTuile.isEmpty())							// S'il n'y a rien a assecher
			{
			    Scanner sc = new Scanner(System.in);
			    String choix;

			    System.out.println("Voulez-vous assecher une autre tuile ? (o/n)");
			    choix = sc.nextLine();
			    if(choix.equals("o")) assecherTuile_ChercherEtAction(collecTuile);		// Processus de saisie et d'assechement de la 2nd tuile
			}
		    }
		}
	}
	
	/**
	 * Processus de saisie et d'assechement de la tuile.
	 * 
	 * @param collecTuile 
	 *  les tuiles qui sont assechable par le joueur
	 */
	private void assecherTuile_ChercherEtAction(HashSet<Tuile> collecTuile) 
	{
	    Aventurier avActuel = joueurs.get(indexJoueurActuel);
	    Scanner sc = new Scanner(System.in);
            String nom;
            Tuile choixTuile;
	    
            System.out.println("\nVous êtes sur la tuile '" + avActuel.getPosition().getNom() + "' : " + avActuel.getPosition().getCoordonnee().toString());
	    System.out.println("\nVous pouvez assecher:");

            for(Tuile tuile : collecTuile)
            {
		
                System.out.println("\t'" + tuile.getNom() + "' : " + tuile.getCoordonnee().toString());
            }

            do
            {
                System.out.println("\nNom de la tuile à assecher := ");
                nom = sc.nextLine();
                choixTuile = grille.chercherTuile(nom);  
            }
            while(choixTuile == null || !collecTuile.contains(choixTuile));
                    
            choixTuile.setEtat(EtatTuile.ASSECHEE);
            System.out.println("Tuile assechee.");
	}
	
	public void inscrireJoueurs()
	{
	    /* Joueurs predefini
	    joueurs.add(new Explorateur("Indiana Jones"));
	    joueurs.add(new Ingenieur("R2D2"));
	    //joueurs.add(new Messager("Radar"));
	    //joueurs.add(new Navigateur("Cousteau"));
	    joueurs.add(new Pilote("Foehammer"));
	    joueurs.add(new Plongeur("Yellow submarine"));
	    
	    joueurs.get(0).placerAventurier(grille);
	    joueurs.get(1).placerAventurier(grille);
	    joueurs.get(2).placerAventurier(grille);
	    joueurs.get(3).placerAventurier(grille);
	    */
	    
	    HashSet<Role> rolesDispo = new HashSet<>();
	    Scanner sc = new Scanner(System.in);
	    String nom, choix;
	    Tuile tuileDepart;
	    
	    int nbrJoueur = 4;
	    
	    for(Role role : Role.values()) rolesDispo.add(role);
	    
	    for(int i = 0 ; i < nbrJoueur ; i++)
	    {
		
		System.out.println("\n------\nJOUEUR " + (i+1));
		System.out.println("\nRoles disponibles :");
		for(Role role : rolesDispo) System.out.println("\t" + role.toString());
		System.out.print("\nNom := ");
		nom = sc.nextLine();
		
		do
		{
		    System.out.print("Role := ");
		    choix = sc.nextLine().toUpperCase();
		}
		while(!rolesDispo.contains(Role.getFromName(choix)));				    // Tant que le user ne tappe pas un role existant ou disponible
		
		     if(choix.equals(Role.EXPLORATEUR.name()))	joueurs.add(new Explorateur(nom));  // Ajout de l'aventurier dans la liste
		else if(choix.equals(Role.INGENIEUR.name()))	joueurs.add(new Ingenieur(nom));
		else if(choix.equals(Role.MESSAGER.name()))	joueurs.add(new Messager(nom));
		else if(choix.equals(Role.NAVIGATEUR.name()))	joueurs.add(new Navigateur(nom));
		else if(choix.equals(Role.PILOTE.name()))	joueurs.add(new Pilote(nom));
		else						joueurs.add(new Plongeur(nom));
		
		joueurs.get(i).placerAventurier(grille);
		rolesDispo.remove(joueurs.get(i).getRole());					    // Suppression de la liste des aventuriers disponibles
	    }
	}
	
	public void tirerCarte()
	{
	    CarteTirage carte = piocheCT.get(0);
	    piocheCT.remove(0);
	    defausseCT.add(carte);
	    
	    if(carte.getType() != TypeCarte.MEAUX)
	    {
		getJActuel().addInventaire(carte);
	    }
	    else
	    {
		niveauEau++;
		for(CarteInnondation c : defausseCI) piocheCI.add(c);
		defausseCI.clear();
		Collections.shuffle(piocheCI);
	    }
	}
	
	

	public boolean isFinJeu()
	{
	    return  niveauEau > 9 ||
		    // si le niveau de l'eau est trop haut
                    grille.chercherTuile("Héliport").getEtat() == EtatTuile.RETIREE ||
		    // Si l'héliport à sombré
		    (tresors.get(0).getEmplacement()[0].getEtat() == EtatTuile.RETIREE && tresors.get(0).getEmplacement()[1].getEtat() == EtatTuile.RETIREE) ||
		    (tresors.get(1).getEmplacement()[0].getEtat() == EtatTuile.RETIREE && tresors.get(1).getEmplacement()[1].getEtat() == EtatTuile.RETIREE) ||
		    (tresors.get(2).getEmplacement()[0].getEtat() == EtatTuile.RETIREE && tresors.get(2).getEmplacement()[1].getEtat() == EtatTuile.RETIREE) ||
		    (tresors.get(3).getEmplacement()[0].getEtat() == EtatTuile.RETIREE && tresors.get(3).getEmplacement()[1].getEtat() == EtatTuile.RETIREE);  
		    // Si les emplacements d'un des trésor est englouti
	}
	
	
	public void actionsPossibles()
	{
	    isDeplacementPossible();
	    isAssechementPossible();
	    isDonCartePossible();
	    isGagnerTresorPossible();
	}
	
	public boolean isDeplacementPossible()
	{
	    HashSet<Tuile> tuiles = getJActuel().getDeplacementsPossibles(grille);
	    
	    if(tuiles.isEmpty())
	    {
		// MàJ IHM
		return false;
	    }
	    else
	    {
		// MàJ IHM
		return true;
	    }
	}
	
	public boolean isAssechementPossible()
	{
	    HashSet<Tuile> tuiles = getJActuel().tuilesAssechables(grille);
	    
	    if(tuiles.isEmpty())
	    {
		// MàJ IHM
		return false;
	    }
	    else
	    {
		// MàJ IHM
		return true;
	    }
	}
	
	public boolean isDonCartePossible()
	{
	    HashSet<Aventurier> Aventuriers = getJActuel().donnerCarte(joueurs);
	    
	    if(Aventuriers.isEmpty())
	    {
		// MàJ IHM
		return false;
	    }
	    else
	    {
		// MàJ IHM
		return true;
	    }
	}
	
	public boolean isGagnerTresorPossible()
	{
	    boolean surLaTuile = false;   
	    int i = 0;
	    
	    while(i < tresors.size() && !surLaTuile)
	    // Pour tout les types de tresor ou jusqu'à qu'un tresor puisse être recupere
	    {
		if(!tresors.get(i).isGagne())
		// Si le tresor n'est pas encore gagne
		{
		    if(getJActuel().compterCarteTresorDeType(tresors.get(i).getType()) >= 4)
		    // Si le joueur a assez d'un type de carte
		    {
			if(getJActuel().getPosition() == tresors.get(i).getEmplacement()[1] || getJActuel().getPosition() == tresors.get(i).getEmplacement()[0])
			// si le joueur est sur l'une des deux carte où il peut recuperer un tresor
			{
			    surLaTuile = true;
			}
		    }
		}
		i++;
	    }
	    
	    if(surLaTuile)
	    {
		// MàJ IHM
		return true;
	    }
	    else
	    {
		// MàJ IHM
		return false;
	    }
	}
	
	public void donnerCarte()
	{
	    HashSet<Aventurier> aventuriers = getJActuel().donnerCarte(joueurs);
	    
	    // MàJ IHM -> selection
	    Aventurier avChoisi/* -> l'aventurier choisi*/ = new Pilote(""); // Le new est juste là pour ne pas tout planter
	    
	    // MàJ IHM -> selection
	    CarteTresor carte/* -> la carte choisie */ = new CarteTresor(tresors.get(0)); // idem
	    
	    if(aventuriers.contains(avChoisi))
	    {
		getJActuel().rmInventaire(carte);
		avChoisi.addInventaire(carte);
	    }
	}
	
	
	
	@Override
	public void update(Observable VueAventurier, Object action) {
       
        if(action == "Terminer")
        {
            nbAction = 0;						    // La mise a zero permet de terminer le tour
        }
        else if (action == "Assecher")
        {
            assecherTuile();
            nbAction--;
        }
        else if(action == "Deplacement")
        {
            seDeplacer();
            nbAction--;
	    
        }
	else if(action == "Autre")
	{
	    nbAction--;
	}
        
        if(nbAction <= 0)
        {
            JoueurSuivant();
            nbAction = 3;
        }
	vueAventurier.majAventurier(joueurs.get(getIndexJoueurActuel()));   // Met à jour la vue
    }
	
	public void initTresor()
	{
	    tresors.add(new Tresor(TypeTresor.PIERRE, grille.chercherTuile("Le temple de la lune"), grille.chercherTuile("Le temple du soleil")));
	    tresors.add(new Tresor(TypeTresor.ZEPHYR, grille.chercherTuile("Le jardin des hurlements"), grille.chercherTuile("Le jardin des murmures")));
	    tresors.add(new Tresor(TypeTresor.CRISTAL, grille.chercherTuile("La caverne des ombres"), grille.chercherTuile("La caverne du brasier")));
	    tresors.add(new Tresor(TypeTresor.CALICE, grille.chercherTuile("Le palais de corail"), grille.chercherTuile("Le palais des marees")));
	}
	
    public void lancerPartie()
    {
	inscrireJoueurs();
	vueAventurier = new VueAventurier(getJActuel());
	vueAventurier.addObserver(this);
    }
	
	
    public Grille getGrille()
    {
	return grille;
    }

    public VueAventurier getVueAventurier()
    {
	return vueAventurier;
    }

    public void setVueAventurier(VueAventurier vueAventurier)
    {
	this.vueAventurier = vueAventurier;
    }

 
    public ArrayList<Aventurier> getJoueurs()
    {
	return joueurs;
    }

    
    public int getIndexJoueurActuel()
    {
	return indexJoueurActuel;
    }
    
    public Aventurier getJActuel()
    {
	return joueurs.get(indexJoueurActuel);
    }
    
}