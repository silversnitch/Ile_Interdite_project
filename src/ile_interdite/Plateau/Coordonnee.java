/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite.Plateau;

/**
 *
 * @author tosiv
 */
public class Coordonnee
{
    private final int x;
    private final int y;
    
    public Coordonnee(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    
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

    /**
     * @return the x
     */
    public int getX()
    {
	return x;
    }

    /**
     * @return the y
     */
    public int getY()
    {
	return y;
    }
    
    public String toString()
    {
        return "(" + getX() + ";" + getY() + (")");
    }
}
