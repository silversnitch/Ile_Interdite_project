/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 *
 * @author ainem
 */
public class VueJoueurCarte extends Observable {
    private JFrame window;
    private JLabel message;
    private JPanel mainPanel;
    private int nbJoueur;

    public VueJoueurCarte(int nbJoueur) {
        this.nbJoueur=nbJoueur;
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définition de la taille de la fenêtre en pixels
        window.setSize(600,1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(0, dim.height/2-window.getSize().height/2);
        
    
    
        
        mainPanel= new JPanel(new BorderLayout());
        window.add(mainPanel);
        
        // messages si il faut défausser là où le joueur se trouve ...
        JPanel panelMessage= new JPanel(new GridLayout(1,1));
        mainPanel.add(panelMessage, BorderLayout.NORTH);
        message = new JLabel("   Message    ",SwingConstants.CENTER) ;
        panelMessage.add(message);
        message.setFont(new Font(getMessage().getFont().getName(), getMessage().getFont().getStyle(), (int) (getMessage().getFont().getSize() *2 )));
        
        // nom du joueur et son rôle
        JPanel panelNomj = new JPanel(new GridLayout(20,1));
        mainPanel.add(panelNomj, BorderLayout.WEST);
        
        // Récupérer le nom des joueurs et leur rôle
        
        for(int i=0; i<8;i++){
            if(i==1){
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                BoutonRond boutonRole1 = new BoutonRond("role j1");
                panelNomj.add(boutonRole1);
                panelNomj.add(new JLabel("Nom Joueur 1"));
                
                
                
            }
            else if (i==3){
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                BoutonRond boutonRole2 = new BoutonRond("role J2");
                panelNomj.add(boutonRole2);
                panelNomj.add(new JLabel("Role Joueur 2"));
                 
            }
              else if (i==5){ 
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                //
                JPanel panelBoutonRole3 = new JPanel();
                BoutonRond boutonRole3 = new BoutonRond("role J3");
                panelBoutonRole3.add(boutonRole3);
                panelNomj.add(panelBoutonRole3);
                
                //
                JPanel panelRole3 = new JPanel();
                panelNomj.add(panelRole3);
                panelRole3.add(new JLabel("Role Joueur 3"));
                
                //
                if (nbJoueur<3){
                    panelBoutonRole3.setVisible(false);
                    panelRole3.setVisible(false);
                }
                 
            }
                else if (i==7){
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                
                //
                JPanel panelBoutonRole4 = new JPanel();
                BoutonRond boutonRole4 = new BoutonRond("role J3");
                panelBoutonRole4.add(boutonRole4);
                panelNomj.add(panelBoutonRole4);
                
                //
                JPanel panelRole4 = new JPanel();
                panelNomj.add(panelRole4);
                panelRole4.add(new JLabel("Role Joueur 3"));
                
                // Adaptatif en fonction du nombre de joueur
                if (nbJoueur<4){
                    panelBoutonRole4.setVisible(false);
                    panelRole4.setVisible(false);
                }
                 
            }
            else {
                panelNomj.add(new JLabel(""));
               
            }
            
        }
       
        
        

        
//         // Actions sur les cartes 
//         
//         JPanel panelActionCarte = new JPanel(new GridLayout(5,3));
//         mainPanel.add(panelActionCarte, BorderLayout.EAST);
//         for (int i=0; i<5; i++){
//             if (i==0){
//                 panelActionCarte.add(new JLabel());
//                 panelActionCarte.add(new JLabel(" Joueur 1"));
//                 panelActionCarte.add(new JLabel());
//             }
//             else if(i==1){
//                 panelActionCarte.add(new JLabel());
//                 panelActionCarte.add(new JButton("Défausser"));
//                  panelActionCarte.add(new JLabel());
//             }
//             else if(i==2){
//                panelActionCarte.add(new JLabel());
//                panelActionCarte.add(new JLabel());
//                panelActionCarte.add(new JLabel());
//             }
//             else if(i==3){
//                 panelActionCarte.add(new JLabel());
//                 panelActionCarte.add(new JButton("Jouer"));
//                  panelActionCarte.add(new JLabel());
//             }
//             else{
//                 panelActionCarte.add(new JLabel());
//                 panelActionCarte.add(new JLabel(" visuel carte"));
//                  panelActionCarte.add(new JLabel());
//             }
//         }
         this.mettreAJour();
         this.afficher();
    }
      public void afficher() {
          this.getWindow().setVisible(true);
    }
      
    public void mettreAJour(){
        // nom du joueur et son rôle
        JPanel panelNomj = new JPanel(new GridLayout(20,1));
        mainPanel.add(panelNomj, BorderLayout.WEST);
        
        // Récupérer le nom des joueurs et leur rôle
        
        for(int i=0; i<8;i++){
            if(i==1){
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                BoutonRond boutonRole1 = new BoutonRond("role j1");
                panelNomj.add(boutonRole1);
                panelNomj.add(new JLabel("Nom Joueur 1"));
                
                
                
            }
            else if (i==3){
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                BoutonRond boutonRole2 = new BoutonRond("role J2");
                panelNomj.add(boutonRole2);
                panelNomj.add(new JLabel("Role Joueur 2"));
                 
            }
              else if (i==5){ 
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                //
                JPanel panelBoutonRole3 = new JPanel();
                BoutonRond boutonRole3 = new BoutonRond("role J3");
                panelBoutonRole3.add(boutonRole3);
                panelNomj.add(panelBoutonRole3);
                
                //
                JPanel panelRole3 = new JPanel();
                panelNomj.add(panelRole3);
                panelRole3.add(new JLabel("Role Joueur 3"));
                
                //
                if (this.nbJoueur<3){
                    panelBoutonRole3.setVisible(false);
                    panelRole3.setVisible(false);
                }
                 
            }
                else if (i==7){
                panelNomj.add(new JLabel());
                panelNomj.add(new JLabel());
                
                //
                JPanel panelBoutonRole4 = new JPanel();
                BoutonRond boutonRole4 = new BoutonRond("role J3");
                panelBoutonRole4.add(boutonRole4);
                panelNomj.add(panelBoutonRole4);
                
                //
                JPanel panelRole4 = new JPanel();
                panelNomj.add(panelRole4);
                panelRole4.add(new JLabel("Role Joueur 3"));
                
                // Adaptatif en fonction du nombre de joueur
                if (nbJoueur<4){
                    panelBoutonRole4.setVisible(false);
                    panelRole4.setVisible(false);
                }
                 
            }
            else {
                panelNomj.add(new JLabel(""));
               
            }
            
        }
       
        // cartes des joueurs
        JPanel panelCarte= new JPanel(new GridLayout(8,1));
        mainPanel.add(panelCarte,BorderLayout.CENTER);
        
        
         for(int i=0; i<8;i++){
            if(i==1){
               JPanel panelCarteJ1 = new JPanel(new GridLayout(2,5));
               panelCarte.add(panelCarteJ1);
               for(int j=0; j<10; j++){
                    if (j==9){
                      panelCarteJ1.add(new JLabel());
                  }
                  else{
                   panelCarteJ1.add(new JButton("carte "+(j+1)));
                  }
               }
            }
            else if (i==3){
                JPanel panelCarteJ2 = new JPanel(new GridLayout(2,5));
               panelCarte.add(panelCarteJ2);
               for(int j=0; j<10; j++){
                  if (j==9){
                      panelCarteJ2.add(new JLabel());
                  }
                  else{
                   panelCarteJ2.add(new JButton("carte "+(j+1)));
                  }
               
               }
               
            }
              else if (i==5){
                JPanel panelCarteJ3 = new JPanel(new GridLayout(2,5));
               panelCarte.add(panelCarteJ3);
               if (nbJoueur<3){
                    panelCarteJ3.setVisible(false);
                }
               
               for(int j=0; j<10; j++){
                  if (j==9){
                      panelCarteJ3.add(new JLabel());
                  }
                  else{
                   panelCarteJ3.add(new JButton("carte "+(j+1)));
                  }
               
               }
               
            }
                else if (i==7){
                 
                JPanel panelCarteJ4 = new JPanel(new GridLayout(2,5));
                
                if (nbJoueur<4){
                    panelCarteJ4.setVisible(false);
                }
                
               panelCarte.add(panelCarteJ4);
               for(int j=0; j<10; j++){
                  if (j==9){
                      panelCarteJ4.add(new JLabel());
                  }
                  else{
                   panelCarteJ4.add(new JButton("carte "+(j+1)));
                  }
               
               }
               
            }
            else {
                 JPanel espace = new JPanel(new GridLayout(2,5));
               panelCarte.add(espace);
               for(int j=0; j<10; j++){
                   espace.add(new JLabel());
               }
            }
            
        }
    }  

    /**
     * @return the window
     */
    public JFrame getWindow() {
        return window;
    }

    /**
     * @param window the window to set
     */
    public void setWindow(JFrame window) {
        this.window = window;
    }

    /**
     * @return the message
     */
    public JLabel getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(JLabel message) {
        this.message = message;
    }
}
