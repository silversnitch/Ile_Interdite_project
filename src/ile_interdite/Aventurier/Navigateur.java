package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;

public class Navigateur extends Aventurier {
    
    public Navigateur(String nomJoueur) {
        super(nomJoueur);
    }

	public Role getRole() {
		return Role.NAVIGATEUR;
	}

	public Pion getPion() {
		return Pion.JAUNE;
	}
	
    @Override
    public void placerAventurier(Grille g)
    {
	Tuile tuileDepart = g.chercherTuile("La porte d'or");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }

}