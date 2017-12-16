package ile_interdite.Vue;

import ile_interdite.Aventurier.Aventurier;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import ile_interdite.util.Utils.Pion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

 
public class VueAventurier extends Observable {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private JLabel label_nomAventurier;
    private JTextField position;
   
   
   
    
    public VueAventurier(/*String nomJoueur, String nomAventurier, Color couleur*/Aventurier av){

        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        //window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        //mainPanel.setBorder(BorderFactory.createLineBorder(av.getPion().getCouleur(), 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(av.getPion().getCouleur());
	label_nomAventurier = new JLabel(av.getRole().toString(),SwingConstants.CENTER );
        panelAventurier.add(label_nomAventurier);
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, av.getPion().getCouleur()));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
	position.setText(av.getPosition().getNom());
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnAutreAction = new JButton("AutreAction") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);

        this.window.setVisible(true);
        
        getBtnBouger().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                String action = "Deplacement";
                notifyObservers(action);
                clearChanged();
            }
        });
        getBtnAutreAction().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                String action = "Autre";
                notifyObservers(action);
                clearChanged();
            }
        });
        getBtnTerminerTour().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                String action = "Terminer";
                notifyObservers(action);
                clearChanged();
            }
        });
        getBtnAssecher().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                String action = "Assecher";
                notifyObservers(action);
                clearChanged();
            }
        });
    }
    
    public void majAventurier(Aventurier av)
    {
	window.setTitle(av.getNomJoueur());
	label_nomAventurier.setText(av.getRole().toString());
	panelAventurier.setBackground(av.getPion().getCouleur());
	mainPanel.setBorder(BorderFactory.createLineBorder(av.getPion().getCouleur(), 2)) ;
	panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, av.getPion().getCouleur()));
	position.setText(av.getPosition().getNom());
    }
    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getBtnAutreAction() {
        return btnAutreAction;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
 
     public static void main(String [] args) {
        // Instanciation de la fenêtre 
        //VueAventurier vueAventurier = new VueAventurier("Manon", "Explorateur",Pion.ROUGE.getCouleur() );
	
    }
     
     public void tourDeJeu() {
	// TODO - implement VueAventurier.tourDeJeu
	throw new UnsupportedOperationException();
    }
}

 

