package ile_interdite.Aventurier;

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

}