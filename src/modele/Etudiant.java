package modele;

import modele.exceptions.FichierInvalideException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Etudiant {
    private int rang;
    private String codeNIP;
    private String nom;
    private Semestre[] semestres;
    private double moyenneS1S2;
    private double moyenneTotale;
    private List<Voeu> voeux;

    public Etudiant(int rang, String codeNIP, String nom) {
        this.rang = rang;
        this.codeNIP = codeNIP;
        this.nom = nom;

        this.semestres = new Semestre[3];
        this.voeux = new LinkedList<>();
    }

    public Etudiant(int rang, String codeNIP, String nom, Semestre[] semestres, double moyenneS1S2, double moyenneTotale) {
        this.rang = rang;
        this.codeNIP = codeNIP;
        this.nom = nom;

        this.semestres = semestres;
        this.moyenneS1S2 = moyenneS1S2;
        this.moyenneTotale = moyenneTotale;
        this.voeux = new LinkedList<>();
    }

    public void ajouterVoeu(Voeu voeu) {
        this.voeux.add(voeu);
    }

    public int getRang() {
        return rang;
    }

    public String getCodeNIP() {
        return codeNIP;
    }

    public String getNom() {
        return nom;
    }

    public Semestre[] getSemestres() {
        return semestres;
    }

    public double getMoyenneS1S2() {
        return moyenneS1S2;
    }

    public double getMoyenneTotale() {
        return moyenneTotale;
    }

    public List<Voeu> getVoeux() {
        return voeux;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public void setCodeNIP(String codeNIP) {
        this.codeNIP = codeNIP;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMoyenneTotale(double moyenneTotale) {
        this.moyenneTotale = moyenneTotale;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "rang=" + rang +
                ", codeNIP='" + codeNIP + '\'' +
                ", nom='" + nom + '\'' +
                ", semestres=" + Arrays.toString(semestres) +
                ", moyenneS1S2=" + moyenneS1S2 +
                ", moyenneTotale=" + moyenneTotale +
                ", voeux=" + voeux +
                '}';
    }


    public static List<Etudiant> importeDepuisCSV(Path fichier) throws IOException, FichierInvalideException  {
        List<Etudiant> r = new ArrayList<>();

        List<String> lignes = Files.readAllLines(fichier);

        Etudiant etudiantCourant = null;

        for(String ligne : lignes) {
            String[] colonnes = ligne.split(";");

            if(colonnes.length > 0 && !colonnes[0].equals("\uFEFFRang")) {
                if(colonnes.length < 18) {
                    throw new FichierInvalideException("Nombre de colonnes invalides !");
                }

                if(colonnes[0].isEmpty() && colonnes[1].isEmpty() && colonnes[2].isEmpty()) {

                    if(etudiantCourant == null) {
                        throw new FichierInvalideException("Il y a des voeux avant des étudiants !");
                    }

                    String nomVoeu = colonnes[16];

                    Avis avis = Avis.values()[Integer.valueOf(colonnes[17].split(" ")[0]) - 1];

                    Voeu voeu = new Voeu(nomVoeu, avis);
                    etudiantCourant.ajouterVoeu(voeu);

                } else {

                    if(etudiantCourant != null) {
                        r.add(etudiantCourant);
                    }

                    int rang = Integer.valueOf(colonnes[0]);
                    String codeNIP = colonnes[1];
                    String nom = colonnes[2];

                    Semestre[] semestres = new Semestre[3];

                    semestres[0] = new Semestre(1);
                    semestres[0].ajouterNote("Informatique", Double.valueOf(colonnes[3]));
                    semestres[0].ajouterNote("Conn. et comp. générales", Double.valueOf(colonnes[4]));
                    semestres[0].setMoyenneGenerale(Double.valueOf(colonnes[5]));

                    semestres[1] = new Semestre(2);
                    semestres[1].ajouterNote("Informatique", Double.valueOf(colonnes[6]));
                    semestres[1].ajouterNote("Conn. et comp. générales", Double.valueOf(colonnes[7]));
                    semestres[1].ajouterNote("Sport", Double.valueOf(colonnes[8]));
                    semestres[1].setMoyenneGenerale(Double.valueOf(colonnes[9]));

                    float moyenneS1S2 = Float.valueOf(colonnes[10]);

                    semestres[2] = new Semestre(3);
                    semestres[2].ajouterNote("Informatique", Float.valueOf(colonnes[11]));
                    semestres[2].ajouterNote("Conn. et comp. générales", Float.valueOf(colonnes[12]));
                    semestres[2].ajouterNote("UE 33/{M3302,M3303}", Float.valueOf(colonnes[13]));
                    semestres[2].setMoyenneGenerale(Float.valueOf(colonnes[14]));

                    float moyenneTotale = Float.valueOf(colonnes[15]);

                    etudiantCourant = new Etudiant(rang, codeNIP, nom, semestres, moyenneS1S2, moyenneTotale);

                    String nomVoeu = colonnes[16];
                    Avis avis = Avis.values()[Integer.valueOf(colonnes[17].split(" ")[0]) - 1];

                    Voeu voeu = new Voeu(nomVoeu, avis);
                    etudiantCourant.ajouterVoeu(voeu);
                }
            }
        }

        if(etudiantCourant != null) {
            r.add(etudiantCourant);
        }

        return r;
    }
}
