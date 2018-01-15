package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;
import java.util.HashSet;


public class Plongeur extends Aventurier {
    
    private final static Role role = Role.PLONGEUR;
    private final static Pion pion = Pion.VIOLET;
    
    public Plongeur(String nomJoueur) {
        super(nomJoueur);
    }

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public Pion getPion() {
		return pion;
	}

    @Override
    public void placerAventurier(Grille g)
    {
	Tuile tuileDepart = g.chercherTuile("La porte de fer");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }
    
    public HashSet<Tuile> getDeplacementsPossibles(Grille g)
	{
            return g.getTuilesPlongeur(getPosition());
        } 
    
}