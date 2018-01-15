package ile_interdite.Plateau;

import ile_interdite.Aventurier.Aventurier;
import ile_interdite.Controler.ObjetIdentifie;
import ile_interdite.util.Utils.EtatTuile;
import java.util.HashSet;

public class Tuile extends ObjetIdentifie{
	private HashSet<Aventurier> aventuriers;    // Collection des aventuriers sur la tuile
	private EtatTuile etat;
	private String nom;
	private Coordonnee coordonnee;

    public Tuile(String nom, Coordonnee coordonnee) {
	
	this.aventuriers = new HashSet<>();
        this.nom = nom;
        this.coordonnee = coordonnee;
	this.etat = EtatTuile.ASSECHEE;
    }

	public void addJoueur(Aventurier av)
	{
	    aventuriers.add(av);
	}

	public void rmJoueur(Aventurier av)
	{
	    aventuriers.remove(av);
	}

	public String getNom() {
		return this.nom;
	}

        public EtatTuile getEtat(){
            return this.etat;
        }

        public Coordonnee getCoordonnee() {
        return this.coordonnee;
    }

    public HashSet<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void setAventuriers(HashSet<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }
        
}
