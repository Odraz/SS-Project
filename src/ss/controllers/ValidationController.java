package ss.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationController {
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private static Matcher matcher;
	
	public static boolean validateEmail(String email){
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean validateText(String text){
		return !text.isEmpty();
	}
}
