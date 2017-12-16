package ile_interdite.Controler;

import ile_interdite.Plateau.Tuile;
import ile_interdite.Plateau.Grille;
import ile_interdite.Vue.VueAventurier;
import ile_interdite.Aventurier.Aventurier;
import ile_interdite.Aventurier.Explorateur;
import ile_interdite.Aventurier.Ingenieur;
import ile_interdite.Aventurier.Messager;
import ile_interdite.Aventurier.Navigateur;
import ile_interdite.Aventurier.Pilote;
import ile_interdite.Aventurier.Plongeur;
import ile_interdite.util.Utils.EtatTuile;
import ile_interdite.util.Utils.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class Controleur implements Observer{

	private Grille grille;
	private VueAventurier vueAventurier;
	private ArrayList<Aventurier> joueurs;
        private int indexJoueurActuel = 0;
	private int nbAction = 0;

// instanciation Aventuriers
//            Aventurier a1 = new Aventurier(Pion.BLEU,"Joueur1");
//            
//            .setDépartA()
        public Controleur()
	{
	    grille = null;
	    vueAventurier = null;
	    joueurs = new ArrayList<>();
	}
            
	public void seDeplacer() {
            //Le éplacement du pilote n'est poas géré entièrement ni celui du plongeur 
            // l'assèchement de l'ingénieur non plus
	    Aventurier avActuel = joueurs.get(indexJoueurActuel);
	    HashSet<Tuile> tuilesDeplacement = avActuel.getDeplacementsPossibles(this.grille); // Collection de tuiles accessibles paç l'aventurier
	    
	    if(tuilesDeplacement.isEmpty())
	    {
		System.out.println("Vous ne pouvez pas vous déplacer.");
		nbAction++; //Annulation de l'action
	    }
	    else
	    {
		System.out.println("Vous êtes sur la tuile de coordonnées: "+avActuel.getPosition().getCoordonnee()+" appelée "+avActuel.getPosition().getNom());
		System.out.println("Tuiles accessibles :");
		for (Tuile tui : tuilesDeplacement){  // parcours des tuiles 
		    System.out.println(tui.getNom());
		}

		Scanner sc = new Scanner(System.in);
		String nomtuile;
		Tuile tuiletemp ;

		 do{
		      System.out.print("nom := ");
		      nomtuile = sc.nextLine();
		      tuiletemp=this.grille.chercherTuile(nomtuile);
		 }
		 while (tuiletemp==null || ! tuilesDeplacement.contains(tuiletemp));

		 System.out.println(" Vous vous êtes déplacés sur la tuile : " +tuiletemp.getNom());

		 avActuel.getPosition().rmJoueur(avActuel); // retirer le joueur de sa tuile actuelle
		 avActuel.setPosition(tuiletemp); // le mettre sur la nouvelle tuile
		 tuiletemp.addJoueur(avActuel); // ajouter le joueur à la nouvelle tuile
	    }
	}

	public void JoueurSuivant()
        {
		if(indexJoueurActuel >= 3)
                {
                    indexJoueurActuel = 0;
                }
                else
                {
                    indexJoueurActuel++;
                }
                // IHM -> indiquer le changement de joueur.
	}

	public void assecherTuile()
	{
                Aventurier avActuel = joueurs.get(indexJoueurActuel);
		HashSet<Tuile> collecTuile = avActuel.tuilesAssechables(grille);
                Scanner sc = new Scanner(System.in);
                int x, y;
                String nom;
                Tuile choixTuile;
                
                System.out.println("\nASSECHER");
                
                if(collecTuile.isEmpty())
                {
                    System.out.println("Aucune tuile à assecher.");
                    nbAction++; // Annulation de l'action
                }
                else
                {
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
	}
	
	public void inscrireJoueurs()
	{
	    HashSet<Role> rolesDispo = new HashSet<>();
	    Scanner sc = new Scanner(System.in);
	    String nom, choix;
	    
	    for(Role role : Role.values()) rolesDispo.add(role);
	    
	    for(int i = 1 ; i <= 4 ; i++)
	    {
		
		System.out.println("\n------\nJOUEUR " + i);
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
		
		if(choix.equals(Role.EXPLORATEUR.name()))
		{
			joueurs.add(new Explorateur(nom));
			rolesDispo.remove(Role.EXPLORATEUR);
		}
		else if(choix.equals(Role.INGENIEUR.name()))
		{
			joueurs.add(new Ingenieur(nom));
			rolesDispo.remove(Role.INGENIEUR);
		}
		else if(choix.equals(Role.MESSAGER.name()))
		{
			joueurs.add(new Messager(nom));
			rolesDispo.remove(Role.MESSAGER);
		}
		else if(choix.equals(Role.NAVIGATEUR.name()))
		{
			joueurs.add(new Navigateur(nom));
			rolesDispo.remove(Role.NAVIGATEUR);
		}
		else if(choix.equals(Role.PILOTE.name()))
		{
			joueurs.add(new Pilote(nom));
			rolesDispo.remove(Role.PILOTE);
		}
		else
		{
			joueurs.add(new Plongeur(nom));
			rolesDispo.remove(Role.PLONGEUR);
		}
	    }
	}

	@Override
	public void update(Observable VueAventurier, Object action) {
       
        if(action == "Terminer")
        {
            nbAction = 0;               // La mise a zero permet de terminer le tour
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
        
        if(nbAction == 0)
        {
            JoueurSuivant();
            nbAction = 3;
        }
    }
	
	
    public Grille getGrille()
    {
	return grille;
    }

    /**
     * @return the vueAventurier
     */
    public VueAventurier getVueAventurier()
    {
	return vueAventurier;
    }

    /**
     * @param vueAventurier the vueAventurier to set
     */
    public void setVueAventurier(VueAventurier vueAventurier)
    {
	this.vueAventurier = vueAventurier;
    }

    /**
     * @return the joueurs
     */
    public ArrayList<Aventurier> getJoueurs()
    {
	return joueurs;
    }

    /**
     * @return the indexJoueurActuel
     */
    public int getIndexJoueurActuel()
    {
	return indexJoueurActuel;
    }

    public void lancerPartie()
    {
	inscrireJoueurs();
	Aventurier joueurActuel = getJoueurs().get(indexJoueurActuel);
	vueAventurier = new VueAventurier(joueurActuel.getNomJoueur(), joueurActuel.getRole().toString(), joueurActuel.getPion().getCouleur()); 
	vueAventurier.AfficherVue();
    }
}