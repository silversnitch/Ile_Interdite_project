package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;
import java.util.HashSet;

public class Pilote extends Aventurier {

    private boolean deplacementSpecialEffectue;
    private final static Role role = Role.PILOTE;
    private final static Pion pion = Pion.BLEU;
	
    public Pilote(String nomJoueur) {
        super(nomJoueur);
	deplacementSpecialEffectue = true;
    }

        @Override
	public Role getRole() {
		return role;
	}
	
	@Override
	public Pion getPion() {
		return pion;
	}

	public void setDeplacementSpecialEffectue(boolean logique) {
		this.deplacementSpecialEffectue = logique;
	}
        
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
	
    @Override
    public void placerAventurier(Grille g)
    {
	Tuile tuileDepart = g.chercherTuile("Héliport");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }

}