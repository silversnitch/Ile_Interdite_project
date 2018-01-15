package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;
import java.util.HashSet;


public class Ingenieur extends Aventurier {
    
    private final static Role role = Role.INGENIEUR;
    private final static Pion pion = Pion.ROUGE;
    
    public Ingenieur(String nomJoueur) {
        super(nomJoueur);
    }

	public Role getRole() {
		return role;
	}

	public Pion getPion() {
		return pion;
	}
        	
    @Override
    public void placerAventurier(Grille g)
    {
	Tuile tuileDepart = g.chercherTuile("La porte de bronze");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }

}