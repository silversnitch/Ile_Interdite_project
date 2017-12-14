package ile_interdite.Aventurier;

import ile_interdite.util.Utils.Role;
import ile_interdite.util.Utils.Pion;

public class Messager extends Aventurier {
    
    public Messager(String nomJoueur) {
        super(nomJoueur);
    }

	public Role getRole() {
		return Role.MESSAGER;
	}

	public Pion getPion() {
		return Pion.ORANGE;
	}

}