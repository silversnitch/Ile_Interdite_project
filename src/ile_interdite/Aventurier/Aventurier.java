package ile_interdite.Aventurier;

import ile_interdite.Plateau.Tuile;
import ile_interdite.Plateau.Grille;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Aventurier {

	private String nomJoueur;
        private Tuile position;

	public abstract String getNomRole();

	public abstract Pion getPion();

	public Tuile getPosition() {
		return this.position;
        }
       
	/**
	 * 
	 * @param g
	 */
	public void tuilesAssechables(Grille g) {
		// TODO - implement Aventurier.tuilesAssechables
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
     * @return 
	 */
	public HashSet<Tuile> getDeplacementsPossibles(Grille g) {
		return g.getOrt(this.getPosition());
                
	}

	/**
	 * 
	 * @param t
	 */
	public void setPosition(Tuile t) {
		this.position=t;
	}

	public void initialiserAventurier() {
		// TODO - implement Aventurier.initialiserAventurier
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param collecTuile
	 */
	public void ajouterTuile(Tuile collecTuile) {
		// TODO - implement Aventurier.ajouterTuile
		throw new UnsupportedOperationException();
	}

    }
