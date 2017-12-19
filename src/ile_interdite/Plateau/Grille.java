package ile_interdite.Plateau;


import static ile_interdite.util.Utils.EtatTuile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Grille {
        private HashMap<Coordonnee, Tuile> listeTuiles;
	
	public Grille()
	{
	    Coordonnee coordTmp;
	    listeTuiles = new HashMap<>();
	    //instanciation des tuiles a la mano
	    coordTmp = new Coordonnee(2, 5);
            listeTuiles.put(coordTmp,new Tuile("Le pont des Abîmes",coordTmp));
	    
	    coordTmp = new Coordonnee(3, 5);
            listeTuiles.put(coordTmp,new Tuile("La porte de Bronze",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.INONDEE);
	    
	    coordTmp = new Coordonnee(1, 4);
            listeTuiles.put(coordTmp,new Tuile("La Caverne des ombres",coordTmp));
	    
	    coordTmp = new Coordonnee(2, 4);
            listeTuiles.put(coordTmp,new Tuile("La porte de fer",coordTmp));
	    
	    coordTmp = new Coordonnee(3, 4);
            listeTuiles.put(coordTmp,new Tuile("La porte d'or",coordTmp));
	    
	    coordTmp = new Coordonnee(4, 4);
            listeTuiles.put(coordTmp,new Tuile("Les falaises de l'oubli",coordTmp));
	    
	    coordTmp = new Coordonnee(0, 3);
            listeTuiles.put(coordTmp,new Tuile("Le palais de corail",coordTmp));
	    
	    coordTmp = new Coordonnee(1, 3);
            listeTuiles.put(coordTmp,new Tuile("La porte d'argent",coordTmp));
	    
	    coordTmp = new Coordonnee(2, 3);
            listeTuiles.put(coordTmp,new Tuile("Les dunes de l'illusion",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.COULEE);
	    
	    coordTmp = new Coordonnee(3, 3);
            listeTuiles.put(coordTmp,new Tuile("Héliport",coordTmp));
	    
	    coordTmp = new Coordonnee(4, 3);
            listeTuiles.put(coordTmp,new Tuile("La porte de cuivre",coordTmp));
	    
	    coordTmp = new Coordonnee(5, 3);
            listeTuiles.put(coordTmp,new Tuile("Le jardin des hurlements",coordTmp));
	    
	    coordTmp = new Coordonnee(0, 2);
            listeTuiles.put(coordTmp,new Tuile("La forêt pourpre",coordTmp));
	    
	    coordTmp = new Coordonnee(1, 2);
            listeTuiles.put(coordTmp,new Tuile("La lagon perdu",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.INONDEE);
	    
	    coordTmp = new Coordonnee(2, 2);
            listeTuiles.put(coordTmp,new Tuile("Le marais brumeux",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.COULEE);
	    
	    coordTmp = new Coordonnee(3, 2);
            listeTuiles.put(coordTmp,new Tuile("Observatoire",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.INONDEE);
	    
	    coordTmp = new Coordonnee(4, 2);
            listeTuiles.put(coordTmp,new Tuile("Le rocher Fantome",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.COULEE);
	    
	    coordTmp = new Coordonnee(5, 2);
            listeTuiles.put(coordTmp,new Tuile("La caverne du brasier",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.INONDEE);
	    
	    coordTmp = new Coordonnee(1, 1);
            listeTuiles.put(coordTmp,new Tuile("Le temple du soleil",coordTmp));
	    
	    coordTmp = new Coordonnee(2, 1);
            listeTuiles.put(coordTmp,new Tuile("Le temple de la lune",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.COULEE);
	    
	    coordTmp = new Coordonnee(3, 1);
            listeTuiles.put(coordTmp,new Tuile("Le palais des marees",coordTmp));
	    
	    coordTmp = new Coordonnee(4, 1);
            listeTuiles.put(coordTmp,new Tuile("Le val du crépuscule",coordTmp));
	    
	    coordTmp = new Coordonnee(2, 0);
            listeTuiles.put(coordTmp,new Tuile("La tour du guet",coordTmp));
	    
	    coordTmp = new Coordonnee(3, 0);
            listeTuiles.put(coordTmp,new Tuile("Le jardin des murmures",coordTmp));
	    listeTuiles.get(coordTmp).setEtat(EtatTuile.INONDEE);
	}

	public HashSet<Tuile> getOrt(Tuile tuile)
	{
            HashSet<Tuile> tuilesOrthogonales = new HashSet<>();
	    int x = tuile.getCoordonnee().getX();
	    int y = tuile.getCoordonnee().getY();
	    Coordonnee tmpCoord;
	    
	    // Droite
	    tmpCoord = new Coordonnee(x+1, y);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
	    // Gauche
	    tmpCoord = new Coordonnee(x-1, y);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
	    // Haut
	    tmpCoord = new Coordonnee(x, y+1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
	    // Bas
	    tmpCoord = new Coordonnee(x, y-1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
                
                return tuilesOrthogonales;
	}

	/**
	 * 
	 * @param t
	 */
	public HashSet<Tuile> getDiag(Tuile tuile)
	{
	    HashSet<Tuile> tuilesDiagonales = new HashSet<>();
            int x = tuile.getCoordonnee().getX();
	    int y = tuile.getCoordonnee().getY();
	    Coordonnee tmpCoord;
	    
	    // Haut/Droite
	    tmpCoord = new Coordonnee(x+1, y+1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
	    // Haut/Gauche
	    tmpCoord = new Coordonnee(x-1, y+1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
	    // Bas/Droite
	    tmpCoord = new Coordonnee(x+1, y-1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
	    // Bas/Gauche
	    tmpCoord = new Coordonnee(x-1, y-1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() != EtatTuile.COULEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));

            return tuilesDiagonales;
	}

	/**
	 * 
	 * @param nomTuile
	 */
	public Tuile chercherTuile(String nomTuile)
	{
	    Coordonnee clef = null;
	    Boolean trouve = false;
	    Iterator it = listeTuiles.keySet().iterator();
	    
	    while(it.hasNext() && !trouve)
	    {
		clef = (Coordonnee) it.next();
		trouve = listeTuiles.get(clef).getNom().toLowerCase().equals(nomTuile.toLowerCase());
	    }
	    
	    if(trouve)	return listeTuiles.get(clef);
	    else	return null;
	    
	}

	public HashSet<Tuile> getTuilesAccessibles()
	{
		HashSet<Tuile> tuilesAccessibles = new HashSet<>();
                for(HashMap.Entry<Coordonnee, Tuile> eTuile : listeTuiles.entrySet())
		{
                    if (eTuile.getValue().getEtat()== EtatTuile.ASSECHEE || eTuile.getValue().getEtat()== EtatTuile.INONDEE ){
                        tuilesAccessibles.add(eTuile.getValue());
                    }
                }
            return tuilesAccessibles;
	}

	/**
	 * 
	 * @param pos
	 */
	public HashSet<Tuile> getOrtAssechables(Tuile pos)
	{
	    HashSet<Tuile> tuilesOrthogonales = new HashSet<>();
            int x = pos.getCoordonnee().getX();
	    int y = pos.getCoordonnee().getY();
	    Coordonnee tmpCoord;
	    
	    // Pos
	    if(pos.getEtat() == EtatTuile.INONDEE) tuilesOrthogonales.add(pos);
	    // Droite
	    tmpCoord = new Coordonnee(x+1, y);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
	    // Gauche
	    tmpCoord = new Coordonnee(x-1, y);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
	    // Haut
	    tmpCoord = new Coordonnee(x, y+1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
	    // Bas
	    tmpCoord = new Coordonnee(x, y-1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesOrthogonales.add(listeTuiles.get(tmpCoord));
                
            return tuilesOrthogonales;
	}

	/**
	 * 
	 * @param pos
	 */
	public HashSet<Tuile> getDiagAssechables(Tuile pos) {
            HashSet<Tuile> tuilesDiagonales = new HashSet<>(); 
            int x = pos.getCoordonnee().getX();
	    int y = pos.getCoordonnee().getY();
	    Coordonnee tmpCoord;
	    
	    // Pos
	    if(pos.getEtat() == EtatTuile.INONDEE) tuilesDiagonales.add(pos);
	    // Haut/Droite
	    tmpCoord = new Coordonnee(x+1, y+1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
	    // Haut/Gauche
	    tmpCoord = new Coordonnee(x-1, y+1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
	    // Bas/Droite
	    tmpCoord = new Coordonnee(x+1, y-1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
	    // Bas/Gauche
	    tmpCoord = new Coordonnee(x-1, y-1);
	    if(listeTuiles.get(tmpCoord) != null && listeTuiles.get(tmpCoord).getEtat() == EtatTuile.INONDEE) tuilesDiagonales.add(listeTuiles.get(tmpCoord));
   
            return tuilesDiagonales;
	}

	/**
	 * 
	 * @param pos
	 */
	public HashSet<Tuile> getTuilesPlongeur(Tuile pos) {
            
            HashSet<Tuile> collecTuileNage = new HashSet<>();
            HashSet<Tuile> collecTuileArret = new HashSet<>();
            collecTuileNage.add(pos);
            collecTuileArret.add(pos);
            
            Iterator it = collecTuileNage.iterator();
            Tuile clef;
            while (it.hasNext())
            {
                clef = (Tuile)it.next();
                rangerTuileOrto(clef, collecTuileNage, collecTuileArret);
                              
            }
            collecTuileArret.remove(pos);
            return collecTuileArret;
	}

	

	/**
	 * 
	 * @param pos
	 * @param collecTuilesNage
	 */
	public void rangerTuileOrto(Tuile pos, HashSet<Tuile> collecTuilesNage,HashSet<Tuile> collecTuileArret) {
		HashSet<Tuile> tuileTemp = new HashSet<>();
                tuileTemp = getOrt(pos);
                for(Tuile tuile : tuileTemp){
                    EtatTuile etat = tuile.getEtat();
                    if (etat == EtatTuile.ASSECHEE || etat == EtatTuile.INONDEE){
                        collecTuileArret.add(tuile);
                    }
                    if (etat == EtatTuile.COULEE || etat == EtatTuile.INONDEE){
                        collecTuilesNage.add(tuile);
                    }
                }
            
	}

}
