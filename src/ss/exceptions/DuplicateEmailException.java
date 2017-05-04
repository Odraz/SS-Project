package ss.exceptions;

public class DuplicateEmailException extends Exception {
	public DuplicateEmailException() {
        super("E-mail is already in use.");
    }
}
