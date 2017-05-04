package ss.exceptions;

public class DuplicateEmailException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateEmailException() {
        super("E-mail is already in use.");
    }
}
