package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;
import java.util.HashSet;

public class Pilote extends Aventurier {

    private boolean deplacementSpecialEffectue;
	
    public Pilote(String nomJoueur) {
        super(nomJoueur);
    }

        @Override
	public Role getRole() {
		return Role.PILOTE;
	}
	
    @Override
	public Pion getPion() {
		return Pion.BLEU;
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