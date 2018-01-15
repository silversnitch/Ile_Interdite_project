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
public class VueJoueurCarte {
    private JFrame window;

    public VueJoueurCarte() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définition de la taille de la fenêtre en pixels
        window.setSize(600,1000);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(0, dim.height/2-window.getSize().height/2);
        
    
    
        
        JPanel mainPanel= new JPanel(new BorderLayout());
        window.add(mainPanel);
        
        // messages si il faut défausser là où le joueur se trouve ...
        JPanel panelMessage= new JPanel(new GridLayout(1,1));
        mainPanel.add(panelMessage, BorderLayout.NORTH);
        JLabel labelMessage = new JLabel("   Message    ",SwingConstants.CENTER) ;
        panelMessage.add(labelMessage);
        labelMessage.setFont(new Font(labelMessage.getFont().getName(), labelMessage.getFont().getStyle(), (int) (labelMessage.getFont().getSize() *2 )));
        
        // nom du joueur et son rôle
        JPanel panelNomj = new JPanel(new GridLayout(10,1));
        mainPanel.add(panelNomj, BorderLayout.WEST);
        panelNomj.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
        
        for(int i=0; i<8;i++){
            if(i==2){
                
                panelNomj.add(new JLabel("Joueur \n Role Joueur 1"));
                panelNomj.add(new JLabel(""));
                
                
            }
            else if (i==5){
                panelNomj.add(new JLabel("Joueur 2"));
                panelNomj.add(new JLabel("Role Joueur 2"));
                 
            }
            else {
                panelNomj.add(new JLabel(""));
               
            }
            
        }
       
        // cartes des joueurs
        JPanel panelCarte= new JPanel(new GridLayout(4,1));
        mainPanel.add(panelCarte,BorderLayout.CENTER);
        
        
         for(int i=0; i<4;i++){
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
            else {
                 JPanel espace = new JPanel(new GridLayout(2,5));
               panelCarte.add(espace);
               for(int j=0; j<10; j++){
                   espace.add(new JLabel());
               }
            }
            
        }
        
         // Actions sur les cartes 
         
         JPanel panelActionCarte = new JPanel(new GridLayout(5,3));
         mainPanel.add(panelActionCarte, BorderLayout.EAST);
         for (int i=0; i<5; i++){
             if (i==0){
                 panelActionCarte.add(new JLabel());
                 panelActionCarte.add(new JLabel(" Joueur 1"));
                 panelActionCarte.add(new JLabel());
             }
             else if(i==1){
                 panelActionCarte.add(new JLabel());
                 panelActionCarte.add(new JButton("Défausser"));
                  panelActionCarte.add(new JLabel());
             }
             else if(i==2){
                panelActionCarte.add(new JLabel());
                panelActionCarte.add(new JLabel());
                panelActionCarte.add(new JLabel());
             }
             else if(i==3){
                 panelActionCarte.add(new JLabel());
                 panelActionCarte.add(new JButton("Jouer"));
                  panelActionCarte.add(new JLabel());
             }
             else{
                 panelActionCarte.add(new JLabel());
                 panelActionCarte.add(new JLabel(" visuel carte"));
                  panelActionCarte.add(new JLabel());
             }
         }
         this.afficher();
    }
      public void afficher() {
           this.window.setVisible(true);
    }
      
    public static void main(String [] args) {
        VueJoueurCarte vue = new VueJoueurCarte();
    }
}
