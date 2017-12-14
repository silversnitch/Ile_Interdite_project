package ile_interdite.Aventurier;

import ile_interdite.Plateau.Tuile;
import ile_interdite.Plateau.Grille;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;
import java.util.HashSet;

public abstract class Aventurier {

	private String nomJoueur;
        private Tuile position;
	private Tuile tuileDepart;
        
        public Aventurier(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

	public abstract Role getRole();

	public abstract Pion getPion();

	public Tuile getPosition() {
		return this.position;
        }
       
	/**
	 * 
	 * @param g
     * @return 
	 */
	public HashSet<Tuile> tuilesAssechables(Grille g) {
		return g.getOrtAssechables(this.getPosition());
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

    /**
     * @return the tuileDepart
     */
    public Tuile getTuileDepart()
    {
	return tuileDepart;
    }

    /**
     * @param tuileDepart the tuileDepart to set
     */
    public void setTuileDepart(Tuile tuileDepart)
    {
	this.tuileDepart = tuileDepart;
    }

    }
