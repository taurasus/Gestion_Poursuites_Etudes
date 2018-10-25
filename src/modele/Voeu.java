package modele;

public class Voeu {
    private String nom;
    private Avis avis;

    public Voeu(String nom, Avis avis) {
        this.nom = nom;
        this.avis = avis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Avis getAvis() {
        return avis;
    }

    public void setAvis(Avis avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Voeu{" +
                "nom='" + nom + '\'' +
                ", avis=" + avis +
                '}';
    }
}
