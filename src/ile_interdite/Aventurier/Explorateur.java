package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Role;
import ile_interdite.util.Utils.Pion;
import java.util.HashSet;

public class Explorateur extends Aventurier {
    
    private final static Role role = Role.EXPLORATEUR;
    private final static Pion pion = Pion.VERT;
    
    public Explorateur(String nomJoueur) {
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
        public HashSet<Tuile> getDeplacementsPossibles(Grille g) {
            HashSet<Tuile> collecTuile = super.getDeplacementsPossibles(g);
	    collecTuile.addAll(g.getDiag(getPosition()));
                 
            return collecTuile;     
	}
        
    @Override
        public HashSet<Tuile> tuilesAssechables(Grille g)
	{
            HashSet<Tuile> collecTuile = super.tuilesAssechables(g);
	    collecTuile.addAll(g.getDiagAssechables(getPosition()));
                 
            return collecTuile;  
        }
	
    @Override
    public void placerAventurier(Grille g)
    {
	Tuile tuileDepart = g.chercherTuile("La porte de cuivre");
	tuileDepart.addJoueur(this);
	setPosition(tuileDepart);
    }
}