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

	public void JoueurSuivant() {
		// TODO - implement Controleur.JoueurSuivant
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collecTuile
	 * @param pos
	 */
	public void ajouterTuile(Tuile collecTuile, Tuile pos) {
		// TODO - implement Controleur.ajouterTuile
		throw new UnsupportedOperationException();
	}

	public void assecherTuile() {
		// TODO - implement Controleur.assecherTuile
		throw new UnsupportedOperationException();
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
        if(action == "Terminer"){           
            JoueurSuivant();
            nbAction = 0;
        }else{
            if (action == "Assecher"){
                assecherTuile();
            }else if(action == "Deplacement"){
                seDeplacer();
            }
            nbAction+=1;
            if (nbAction == 2){
                JoueurSuivant();
                nbAction = 0; 
            }
        }

    }
}