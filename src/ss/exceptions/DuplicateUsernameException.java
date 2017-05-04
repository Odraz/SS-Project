package ss.exceptions;

public class DuplicateUsernameException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateUsernameException() {
        super("Username is already in use.");
    }
}
