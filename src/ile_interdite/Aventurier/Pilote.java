package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import java.util.HashSet;

public class Pilote extends Aventurier {

	private boolean deplacementSpecialEffectue;

    public Pilote(String nomJoueur) {
        super(nomJoueur);
    }

	public String getNomRole() {
		// TODO - implement Pilote.getNomRole
		throw new UnsupportedOperationException();
	}

	public Pion getPion() {
		// TODO - implement Pilote.getPion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param logique
	 */
	public void setDeplacementSpecialEffectue(boolean logique) {
		this.deplacementSpecialEffectue = logique;
	}
        
        public HashSet<Tuile> getDeplacementsPossibles(Grille g){
            HashSet<Tuile> tuilesPossibles = new HashSet<>();
            if (deplacementSpecialEffectue == false){
                g.getTuilesAccessibles();
                
            }
            return tuilesPossibles;
        }

}