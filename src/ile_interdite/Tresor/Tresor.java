package ile_interdite.Tresor;

import ile_interdite.CarteTirage.TypeTresor;
import ile_interdite.Plateau.Tuile;
import java.util.ArrayList;

public class Tresor
{
    private TypeTresor type;
    private Tuile[] emplacement;
    
    public Tresor(TypeTresor type, Tuile emplacement1, Tuile emplacement2)
    {
	this.emplacement = new Tuile[2];
	this.emplacement[0] = emplacement1;
	this.emplacement[1] = emplacement2;
    }

    public TypeTresor getType()
    {
	return type;
    }

    public Tuile[] getEmplacement()
    {
	return emplacement;
    }

}
