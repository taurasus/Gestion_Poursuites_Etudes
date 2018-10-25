package modele;

import java.util.*;

public class Semestre {
    private int numero;
    private Map<String, Double> moyennesUE;
    private double moyenneGenerale;

    public Semestre(int numero) {
        this.numero = numero;
        this.moyennesUE = new HashMap<>();
        this.moyenneGenerale = 0f;
    }

    public void ajouterNote(String UE, double moyenneUE) {
        this.moyennesUE.putIfAbsent(UE, moyenneUE);
    }

    public void ajouterNotes(Map<String, Double> map) {
        this.moyennesUE.putAll(map);
    }

    public int getNumero() {
        return numero;
    }

    public Map<String, Double> getMoyennesUE() {
        return this.moyennesUE;
    }

    public double getMoyenneGenerale() {
        return this.moyenneGenerale;
    }

    public void setMoyenneGenerale(double moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    @Override
    public String toString() {
        return "Semestre{" +
                "numero=" + numero +
                ", moyennesUE=" + moyennesUE +
                ", moyenneGenerale=" + moyenneGenerale +
                '}';
    }
}
