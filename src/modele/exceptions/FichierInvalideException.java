package modele.exceptions;

public class FichierInvalideException extends Exception {
    public FichierInvalideException() {
        super();
    }

    public FichierInvalideException(String message) {
        super(message);
    }
}
