package ile_interdite.Plateau;

import ile_interdite.Aventurier.Aventurier;
import ile_interdite.util.Utils.EtatTuile;
import java.util.ArrayList;

public class Tuile {

	private Aventurier departA;
	private ArrayList<Aventurier> aventuriers;
	private EtatTuile etat;
	private String nom;
	private Coordonnee coordonnee;

    public Tuile(String nom, Coordonnee coordonnee) {
	this.departA = null;
        this.nom = nom;
        this.coordonnee = coordonnee;
	this.etat = EtatTuile.ASSECHEE;
    }

        
        
	/**
	 * 
	 * @param av
	 */
	public void addJoueur(Aventurier av) {
		// TODO - implement Tuile.addJoueur
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param av
	 */
	public void rmJoueur(Aventurier av) {
		// TODO - implement Tuile.rmJoueur
		throw new UnsupportedOperationException();
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

        Coordonnee getCoordonnee() {
        return this.coordonnee;
    }

    /**
     * @return the départA
     */
    public Aventurier getDepartA() {
        return departA;
    }

    /**
     * @param départA the départA to set
     */
    public void setDepartA(Aventurier départA) {
        this.departA = départA;
    }

    /**
     * @return the aventuriers
     */
    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    /**
     * @param aventuriers the aventuriers to set
     */
    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
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
