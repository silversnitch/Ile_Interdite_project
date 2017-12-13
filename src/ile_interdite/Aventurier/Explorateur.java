package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import java.util.HashSet;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJoueur) {
        super(nomJoueur);
    }

	public String getNomRole() {
		// TODO - implement Explorateur.getNomRole
		throw new UnsupportedOperationException();
	}

	public Pion getPion() {
		// TODO - implement Explorateur.getPion
		throw new UnsupportedOperationException();
	}
        
        @Override
        public HashSet<Tuile> getDeplacementsPossibles(Grille g) {
            HashSet<Tuile> collecTuile = new HashSet<>();
            
		HashSet<Tuile> collecOrt ;
                collecOrt = g.getOrt(this.getPosition());
                collecOrt.forEach((tuilO) -> {
                    collecTuile.add(tuilO);
            });
                
                HashSet<Tuile> collecDiag  ;
                collecDiag = g.getDiag(this.getPosition());
                collecDiag.forEach((tuilD) -> {
                    collecTuile.add(tuilD);
            });
                 
            return collecTuile;     
	}

}