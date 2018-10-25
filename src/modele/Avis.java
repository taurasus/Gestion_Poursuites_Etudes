package modele;

public enum Avis {
    //public static final String[] LABELS_AVIS = { "Très favorable", "Favorable", "Assez favorable", "Avis réservé", "Sans avis" };

    TRES_FAVORABLE(1, "Très favorable"),
    FAVORABLE(2, "Favorable"),
    ASSEZ_FAVORABLE(3, "Assez favorable"),
    AVIS_RESERVE(4, "Avis reservé"),
    SANS_AVIS(5, "Sans avis");

    private int numero;
    private String label;

    Avis(int numero, String label) {
        this.numero = numero;
        this.label = label;
    }

    public int getNumero() {
        return numero;
    }

    public String getLabel() {
        return label;
    }
}
