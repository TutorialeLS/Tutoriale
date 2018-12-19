package pl.javastart.app;

class InvalidOptionException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -838641837233501828L;

	InvalidOptionException() {
        super("Opcja nie istnieje");
    }
}