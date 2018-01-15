package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Role;
import ile_interdite.util.Utils.Pion;

public class Messager extends Aventurier {
    
    private final static Role role = Role.MESSAGER;
    private final static Pion pion = Pion.ORANGE;
    
    public Messager(String nomJoueur) {
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
	Tuile tuileDepart = g.chercherTuile("La porte d'argent");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }

}