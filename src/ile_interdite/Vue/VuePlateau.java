/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite.Vue;

import ile_interdite.Plateau.Coordonnee;
import ile_interdite.Plateau.Grille;
import ile_interdite.Plateau.Tuile;
import ile_interdite.util.MessagePlateau;
import ile_interdite.util.Utils;
import ile_interdite.util.Utils.Commandes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ainem
 */
public class VuePlateau extends Observable{
    private JFrame window;
    private JLabel labelPioche_meaux;
    private JLabel labelPioche_tirage;
    private HashMap<Integer, JButton> tuiles;
    private JButton deplacement;
    private JButton assecher;
    private JButton donCarte;
    private JButton gagnerTresor;
    
    public VuePlateau(Grille grille){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définition de la taille de la fenêtre en pixels
        window.setSize(1300,1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width+1900/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        
        JPanel panelCentre= new JPanel(new BorderLayout());
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        
        // Haut de la vue
        // Plateau
        JPanel panelPlateau = new JPanel(new GridLayout(6,6));
        panelCentre.add(panelPlateau, BorderLayout.CENTER);
	ArrayList<JButton> tuiles_tmp = new ArrayList<>();
	
	int i = 0;
	for(i = 0 ; i < 2 ; i++)    panelPlateau.add(new JLabel(""));
	for(i = i ; i < 4 ; i++)
	{
	    tuiles_tmp.add(new JButton("case "+ (i+1)));
	    panelPlateau.add(tuiles_tmp.get(tuiles_tmp.size()-1));
	}
	for(i = i ; i < 7 ; i++)    panelPlateau.add(new JLabel(""));
	for(i = i ; i < 11 ; i++)
	{
	    tuiles_tmp.add(new JButton("case "+ (i+1)));
	    panelPlateau.add(tuiles_tmp.get(tuiles_tmp.size()-1));
	}
    /*  for(i = i ; i < 12 ; i++) */panelPlateau.add(new JLabel("")); i++;		// 1 seul élément donc pas de boucle, le '/* for(...) */' sert pour le visuel
	for(i = i ; i < 24 ; i++)
	{
	    tuiles_tmp.add(new JButton("case "+ (i+1)));
	    panelPlateau.add(tuiles_tmp.get(tuiles_tmp.size()-1));
	}
    /*  for(i = i ; i < 25 ; i++) */panelPlateau.add(new JLabel("")); i++;
	for(i = i ; i < 29 ; i++)
	{
	    tuiles_tmp.add(new JButton("case "+ (i+1)));
	    panelPlateau.add(tuiles_tmp.get(tuiles_tmp.size()-1));
	}
	for(i = i ; i < 32 ; i++)   panelPlateau.add(new JLabel(""));
	for(i = i ; i < 34 ; i++)
	{
	    tuiles_tmp.add(new JButton("case "+ (i+1)));
	    panelPlateau.add(tuiles_tmp.get(tuiles_tmp.size()-1));
	}	    
        for(i = i ; i < 36 ; i++)   panelPlateau.add(new JLabel(""));
	
	Iterator<Coordonnee> it = grille.getListeTuiles().keySet().iterator();
	tuiles = new HashMap<>();
	
	for(JButton button : tuiles_tmp)
	{
	    /*Tuile tuile = grille.getListeTuiles().get(it.next());
	    int id = tuile.getId();*/
	    int id = grille.getListeTuiles().get(it.next()).getId();
	    tuiles.put(id, button);
	    
	    button.addActionListener(new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent e)
		{
		    setChanged();
		    notifyObservers(new MessagePlateau(Commandes.CHOISIR_TUILE,null,null,null,id));
		    clearChanged();
		}
	    });
	}
	
        // Pioches 
        JPanel panelPioches = new JPanel(new GridLayout(7,1));
        panelCentre.add(panelPioches, BorderLayout.WEST);
        for (int k=0; k<7; k++){
            if(k==1){
                setNbrCartePioche_tirage(24);
		panelPioches.add(labelPioche_tirage);
            }
            else if (k==2){
		JButton button = new JButton("Défausse carte tirage");
                panelPioches.add(button);
		button.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.VOIR_DEFAUSSE_TIRAGE,null,null,null,null));
			clearChanged();
		    }
		});
            }
            else if(k==4){
		setNbrCartePioche_meaux(24);
                panelPioches.add(labelPioche_meaux);

            }
            else if (k==5){
                JButton button = new JButton("Défausse Innondation");
		panelPioches.add(button);
		button.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.VOIR_DEFAUSSE_MEAUX,null,null,null,null));
			clearChanged();
		    }
		});
            }
            else{
                panelPioches.add(new JLabel(" "));
            }
        }
        
        // Niveau d'eau
        JPanel panelNiveau = new JPanel(new GridLayout(1,2));
        panelCentre.add(panelNiveau, BorderLayout.EAST);
        JPanel panelCurseur= new JPanel(new GridLayout(10,1));
        panelNiveau.add(panelCurseur);
        for (int l=0; l<10; l++){
            panelCurseur.add(new JLabel(" Niveau "+(l+1)));
        }
        
        JPanel panelInondation= new JPanel(new GridLayout(5,1));
        panelNiveau.add(panelInondation);
        for (int l=0; l<5; l++){
            if(l==0){
                panelInondation.add(new JLabel("vous êtes mort ..."));
            }
            else{
            panelInondation.add(new JLabel(""));
            }
        }
        
        // Boutons d'action
        JPanel panelAction = new JPanel(new GridLayout(3,11));
        panelCentre.add(panelAction, BorderLayout.SOUTH);
        
        for (int l=0; l<33; l++){
            if (l==12){
		deplacement = new JButton("Se déplacer");
                panelAction.add(deplacement);
		deplacement.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.DEPLACER,null,null,null,null));
			clearChanged();
		    }
		});
		
		
            }
            else if (l==14){
		assecher = new JButton("Assécher");
                panelAction.add(assecher);
		assecher.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.ASSECHER,null,null,null,null));
			clearChanged();
		    }
		});
            }
            else if (l==16){
                donCarte = new JButton("Donner carte");
                panelAction.add(donCarte);
		donCarte.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.DONNER,null,null,null,null));
			clearChanged();
		    }
		});
            }
	    else if (l==18){
		gagnerTresor = new JButton("Gagner tresor");
                panelAction.add(gagnerTresor);
		gagnerTresor.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.RECUPERER_TRESOR,null,null,null,null));
			clearChanged();
		    }
		});
	    }
            else if (l==20){
		JButton button = new JButton("Finir tour");
		panelAction.add(button);
		button.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			setChanged();
			notifyObservers(new MessagePlateau(Commandes.TERMINER,null,null,null,null));
			clearChanged();
		    }
		});
		
            }
            else{
                panelAction.add(new JLabel(""));
            }
            
        }
         
         this.afficher();
    }
    
    
    public void afficher() {
           this.window.setVisible(true);
    }

    public void setNbrCartePioche_meaux(int nbr)
    {
	labelPioche_meaux = new JLabel(" Pioche cartes innondation : " + nbr + "/24");
    }
    
    public void setNbrCartePioche_tirage(int nbr)
    {
	labelPioche_tirage = new JLabel(" Pioche cartes tirage : " + nbr + "/24");
    }
    
    public void setEnableButton_deplacement(boolean b)
    {
	deplacement.setEnabled(b);
    }
    
    public void setEnableButton_assecher(boolean b)
    {
	assecher.setEnabled(b);
    }
    
    public void setEnableButton_donnerCarte(boolean b)
    {
	donCarte.setEnabled(b);
    }
    
    public void setEnableButton_gagnerTresor(boolean b)
    {
	gagnerTresor.setEnabled(b);
    }
    
    public void setEnableTuile(boolean b, Integer id)
    {
	tuiles.get(id).setEnabled(b);
    }
	    
	    
    public static void main(String [] args) {
	
	Grille g = new Grille();
	VuePlateau vue = new VuePlateau(g);
    }
}
