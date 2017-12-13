package ile_interdite.Plateau;

import static ile_interdite.Plateau.EtatTuile.ASSECHEE;
import static ile_interdite.Plateau.EtatTuile.INONDEE;
import java.util.HashSet;
import java.util.LinkedHashSet;
import ile_interdite.util.*;

public class Grille {
        private HashSet<Tuile> listeTuiles;
	/**
	 * 
	 * @param t
	 */
	public HashSet<Tuile> getOrt(Tuile t) {
            HashSet<Tuile> tuilesOrthogonales = new HashSet<>();
            
                
            for (Tuile tui : listeTuiles) {
                if (tui.getCoordonnee() == t.getCoordonnee()-1){
                    tuilesOrthogonales.add(tui);
                }
                if(tui.getCoordonnee() == t.getCoordonnee()+1){
                     tuilesOrthogonales.add(tui);
                }
                if(tui.getCoordonnee() == t.getCoordonnee()+10){
                     tuilesOrthogonales.add(tui);
                }
                if(tui.getCoordonnee() == t.getCoordonnee()-10){
                     tuilesOrthogonales.add(tui);
                }    
            }
                
                return tuilesOrthogonales;
	}

	/**
	 * 
	 * @param t
	 */
	public HashSet<Tuile> getDiag(Tuile t) {
		 HashSet<Tuile> tuilesDiagonales = new HashSet<>();
            
                
            for (Tuile tui : listeTuiles) {
                if (tui.getCoordonnee() == t.getCoordonnee()+11){
                    tuilesDiagonales.add(tui);
                }
                if(tui.getCoordonnee() == t.getCoordonnee()+9){
                     tuilesDiagonales.add(tui);
                }
                if(tui.getCoordonnee() == t.getCoordonnee()-11){
                     tuilesDiagonales.add(tui);
                }
                if(tui.getCoordonnee() == t.getCoordonnee()-9){
                     tuilesDiagonales.add(tui);
                }    
            }
                
                return tuilesDiagonales;
	}

	/**
	 * 
	 * @param nomTuile
	 */
	public Tuile chercherTuile(String nomTuile) {
		// TODO - implement Grille.chercherTuile
		throw new UnsupportedOperationException();
	}

	public HashSet<Tuile> getTuilesAccessibles() {
		HashSet<Tuile> tuilesAccessibles = new HashSet<>();
                for (Tuile tui : listeTuiles){
                    if (tui.getEtat()== ASSECHEE || tui.getEtat()== INONDEE ){
                        tuilesAccessibles.add(tui);
                    }
                }
                return tuilesAccessibles;
	}

	/**
	 * 
	 * @param pos
	 */
	public HashSet<Tuile> getOrtAssechables(Tuile pos) {
		// TODO - implement Grille.getOrtAssechables
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pos
	 */
	public HashSet<Tuile> getDiagAssechables(Tuile pos) {
		// TODO - implement Grille.getDiagAssechables
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pos
	 */
	public HashSet<Tuile> getTuilesPlongeur(Tuile pos) {
		// TODO - implement Grille.getTuilesPlongeur
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pos
	 */
	public void initTuilesNage(Tuile pos) {
		// TODO - implement Grille.initTuilesNage
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pos
	 * @param collecTuilesNage
	 */
	public void rangerTuileOrto(Tuile pos, HashSet<Tuile> collecTuilesNage) {
		// TODO - implement Grille.rangerTuileOrto
		throw new UnsupportedOperationException();
	}

}
