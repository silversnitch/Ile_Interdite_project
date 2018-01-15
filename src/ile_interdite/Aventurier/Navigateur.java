package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;

public class Navigateur extends Aventurier {
    
    private final static Role role = Role.NAVIGATEUR;
    private final static Pion pion = Pion.JAUNE;
    
    public Navigateur(String nomJoueur) {
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
	Tuile tuileDepart = g.chercherTuile("La porte d'or");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }

}