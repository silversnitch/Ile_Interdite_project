package ile_interdite.Plateau;

public class Coordonnee
{
    private final int x;
    private final int y;
    

    public Coordonnee(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
  
    /* ------
	Depuis stackoverflow.com
	Permet d'utiliser un clef à 2D tel que HashMap<Coordonnee, Objet> map; ... map.get(new Coordonnee(0,0));
    */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
	else if (!(o instanceof Coordonnee)) return false;
        else
	{
	    Coordonnee key = (Coordonnee) o;
	    return getX() == key.getX() && getY() == key.getY();
	}
    }

    @Override
    public int hashCode()
    {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }
    /* ------ */
    
    public int getX()
    {
	return x;
    }

    public int getY()
    {
	return y;
    }
    
    public String toString()
    {
        return "(" + getX() + ";" + getY() + (")");
    }
}
