package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import java.util.HashSet;

public class Pilote extends Aventurier {

	private boolean deplacementSpecialEffectue;

    public Pilote(String nomJoueur) {
        super(nomJoueur);
    }

        @Override
	public String getNomRole() {
		// TODO - implement Pilote.getNomRole
		throw new UnsupportedOperationException();
	}

    /**
     *
     * @return
     */
    @Override
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
        
          /**
	 * 
     * @return 
	 */
	public boolean getDeplacementSpecialEffectue() {
		return deplacementSpecialEffectue;
	}
        
        @Override
        public HashSet<Tuile> getDeplacementsPossibles(Grille g){
            HashSet<Tuile> tuilesPossibles = new HashSet<>();
            if (!this.getDeplacementSpecialEffectue()){
                tuilesPossibles = g.getTuilesAccessibles(); 
            }
            else{
                tuilesPossibles= g.getOrt(this.getPosition());
            }
            return tuilesPossibles;
        }

}