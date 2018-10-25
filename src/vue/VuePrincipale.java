package vue;

import javax.swing.*;
import java.awt.*;

public class VuePrincipale extends JFrame {
    public VuePrincipale() {
        super("Gestion de poursuite d'études INFO2");

        //JPanel "principal"
        JPanel principal = new JPanel();
        principal.setBackground(Color.white);

        //JPanel ou JFrame (Je sais pas) "formation" par JButton "voir Formation"
            //Voir une liste des formations (côté par exemple) (optionnel)
            //JButton saisir new formation -> JtextArea (Ou quelque chose du style): Ecrire une formation -> Vérifiez s'il n'existe pas déjà / Implémentez dans la bd la formation.
            //JFileChooser charger fichier de formation (format csv ?) -> Vérifiez les formations existants (Ou ceux qui y ressemble)/ Implémenter dans la bd les formations.
        //JPanel ou JFrame "affichage" par JButton "voir Affichage"
            //Filtre (Choix de l'année / Choix de la promo? / Choix du groupe / Choix de l'étudiant (Avec codeNIP ou nom/prenom?) / Choix de la formation?) quelque part (en haut le plus optimisé je pense)
            //JButton "Modification" (soit à côté de l'étudiant) (soit sur le texte de l'étudiant (genre sur le nom/prenom et/ou codeNIP))
            //Soit un JButton "Modification étudiant" proche de filtre ou autre part avec affichage d'un JFrame ou JDialog ou n'importe où l'on demande le codeNIP ou Nom/Prenom de l'étudiant afin d'avoir toutes (Pas forcément toutes à voir lequelles sont interressantes) les données que l'on peut modifier
            //A finir

        this.setPreferredSize(new Dimension(1080, 720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(principal);
    }
}
