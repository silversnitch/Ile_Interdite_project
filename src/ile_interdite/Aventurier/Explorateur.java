package ile_interdite.Aventurier;

import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.Utils.Role;
import ile_interdite.util.Utils.Pion;
import java.util.HashSet;

public class Explorateur extends Aventurier {
    
    public Explorateur(String nomJoueur) {
        super(nomJoueur);
    }

    @Override
	public Role getRole() {
		return Role.EXPLORATEUR;
	}

    @Override
	public Pion getPion() {
		return Pion.VERT;
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
        
    @Override
        public HashSet<Tuile> tuilesAssechables(Grille g){
                 HashSet<Tuile> collecTuile = new HashSet<>();
            
		HashSet<Tuile> collecOrt ;
                collecOrt = g.getOrtAssechables(this.getPosition());
                collecOrt.forEach((tuilO) -> {
                    collecTuile.add(tuilO);
            });
                
                HashSet<Tuile> collecDiag  ;
                collecDiag = g.getDiagAssechables(this.getPosition());
                collecDiag.forEach((tuilD) -> {
                    collecTuile.add(tuilD);
            });
                 
            return collecTuile;  
        }

}