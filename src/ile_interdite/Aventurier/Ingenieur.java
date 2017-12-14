package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.util.Utils.Pion;
import ile_interdite.util.Utils.Role;

public class Ingenieur extends Aventurier {
    
    public Ingenieur(String nomJoueur) {
        super(nomJoueur);
    }

	public Role getRole() {
		return Role.INGENIEUR;
	}

	public Pion getPion() {
		return Pion.ROUGE;
	}

	/**
	 * 
	 * @param g
	 */
	public void tuilesPos(Grille g) {
		// TODO - implement Ingenieur.tuilesPos
		throw new UnsupportedOperationException();
	}

}