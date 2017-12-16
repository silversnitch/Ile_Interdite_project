package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;

public class Plongeur extends Aventurier {
    
    public Plongeur(String nomJoueur) {
        super(nomJoueur);
    }

    @Override
	public Role getRole() {
		return Role.PLONGEUR;
	}

    @Override
	public Pion getPion() {
		return Pion.VIOLET;
	}

     @Override
    public void placerAventurier(Grille g)
    {
	Tuile tuileDepart = g.chercherTuile("La porte de fer");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }
}