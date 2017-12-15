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
		// TODO - implement Controleur.seDeplacer
		throw new UnsupportedOperationException();
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

	public void assecherTuile() {
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
                    nbAction++;
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
	    
	    for(int i = 0 ; i < 4 ; i++)
	    {
		
		System.out.println("\n------\nJOUEUR " + i+1);
		System.out.println("\nRoles disponibles :");
		for(Role role : rolesDispo) System.out.println("\t" + role.toString());
		System.out.println("\nNom := ");
		nom = sc.nextLine();
		
		do
		{
		    System.out.println("Role := ");
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
}