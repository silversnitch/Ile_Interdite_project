/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite.CarteTirage;

import ile_interdite.Tresor.Tresor;

/**
 *
 * @author tosiv
 */
public class CarteTresor extends CarteTirage
{
    private final static TypeCarte type = TypeCarte.TRESOR;
    private final Tresor tresor;

    public CarteTresor(Tresor tresor)
    {
	this.tresor = tresor;
    }

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

    public Tresor getTresor()
    {
	return tresor;
    }
}
