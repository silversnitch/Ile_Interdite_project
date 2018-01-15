package ile_interdite.CarteTirage;

import ile_interdite.Aventurier.Aventurier;

public abstract class CarteTirage
{
    private Aventurier possesseur;
    
    public abstract void utiliser();
    public abstract TypeCarte getType();

    /**
     * @return the possesseur
     */
    public Aventurier getPossesseur()
    {
	return possesseur;
    }

    /**
     * @param possesseur the possesseur to set
     */
    public void setPossesseur(Aventurier possesseur)
    {
	this.possesseur = possesseur;
    }
}
