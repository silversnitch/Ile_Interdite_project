package ile_interdite.Plateau;

import ile_interdite.Aventurier.Aventurier;
import ile_interdite.util.Utils.EtatTuile;
import java.util.HashSet;

public class Tuile {
	private HashSet<Aventurier> aventuriers;
	private EtatTuile etat;
	private String nom;
	private Coordonnee coordonnee;

    public Tuile(String nom, Coordonnee coordonnee) {
	
	this.aventuriers = new HashSet<>();
        this.nom = nom;
        this.coordonnee = coordonnee;
	this.etat = EtatTuile.ASSECHEE;
    }

        
        
	/**
	 * 
	 * @param av
	 */
	public void addJoueur(Aventurier av)
	{
	    aventuriers.add(av);
	}

	/**
	 * 
	 * @param av
	 */
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
        
	public void updateState() {
		// TODO - implement Tuile.updateState
		throw new UnsupportedOperationException();
	}

        public Coordonnee getCoordonnee() {
        return this.coordonnee;
    }

    /**
     * @return the aventuriers
     */
    public HashSet<Aventurier> getAventuriers() {
        return aventuriers;
    }

    /**
     * @param aventuriers the aventuriers to set
     */
    public void setAventuriers(HashSet<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }


    /**
     * @param etat the etat to set
     */
    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }



    /**
     * @param coordonnee the coordonnee to set
     */
    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }
        
}
