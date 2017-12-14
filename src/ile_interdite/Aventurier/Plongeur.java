package ile_interdite.Aventurier;

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

}