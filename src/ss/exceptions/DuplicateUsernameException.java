package ss.exceptions;

public class DuplicateUsernameException extends Exception {
	public DuplicateUsernameException() {
        super("Username is already in use.");
    }
}
