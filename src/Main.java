import modele.Etudiant;
import modele.GenerateurPDF;
import vue.VuePrincipale;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Etudiant> etudiants = null;

        try {
            etudiants = Etudiant.importeDepuisCSV(Paths.get("resources", "MoyS123-PromoX.csv"));

            for(Etudiant e : etudiants) {
                System.out.println(e);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        if(etudiants != null && etudiants.size() > 0) {
            try {
                GenerateurPDF.creerFichierPDF(etudiants.get(0), Paths.get("", "sortie.pdf"));
                System.out.println("Fichier généré !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            if( System.getProperty("os.name").toLowerCase().contains("linux")) {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } else {
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        VuePrincipale vuePrincipale = new VuePrincipale();
        vuePrincipale.pack();
        vuePrincipale.setVisible(true);
    }
}
