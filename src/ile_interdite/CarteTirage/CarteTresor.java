/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite.CarteTirage;

/**
 *
 * @author tosiv
 */
public class CarteTresor extends CarteTirage
{
    private final static TypeCarte type = TypeCarte.TRESOR;

    @Override
    public void utiliser()
    {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypeCarte getType()
    {
	return type;
    }
}
