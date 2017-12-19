package ile_interdite.Aventurier;

import ile_interdite.Plateau.Tuile;
import ile_interdite.Plateau.Grille;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;
import java.util.HashSet;

public abstract class Aventurier {

	private String nomJoueur;
        private Tuile position;
        
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
	public HashSet<Tuile> tuilesAssechables(Grille g)
	{
	    return g.getOrtAssechables(getPosition());
	}

	/**
	 * 
	 * @param g
     * @return 
	 */
	public HashSet<Tuile> getDeplacementsPossibles(Grille g)
	{
		return g.getOrt(getPosition());
	}

	/**
	 * 
	 * @param t
	 */
	public void setPosition(Tuile t) {
		this.position=t;
	}

	/**
	 * 
	 * @param collecTuile
	 */
	public void ajouterTuile(Tuile collecTuile) {
		// TODO - implement Aventurier.ajouterTuile
		throw new UnsupportedOperationException();
	}
    
    public String getNomJoueur()
    {
	return nomJoueur;
    }
    
    public void setDeplacementSpecialEffectue(boolean logique){
      // cette méthode ne sert à rien à part pour le pilote lol!
    }
    
     public boolean getDeplacementSpecialEffectue(){
      return true;// cette méthode ne sert à rien à part pour le pilote lol!
    }
    
    public abstract void placerAventurier(Grille g);
}
