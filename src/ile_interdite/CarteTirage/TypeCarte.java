/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite.CarteTirage;

import ile_interdite.util.*;
import java.awt.Color;

/**
 *
 * @author tosiv
 */
public enum TypeCarte
{
    SABLE("Sacs de sable"),
    HELICO("Helicoptère"),
    TRESOR("Tresor"),
    MEAUX("Montée des eaux");

    private final String nom;
    
    private TypeCarte(String nom)
    {
	this.nom = nom;
    }
    
    
}
