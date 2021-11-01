package com.library.validation;

import java.util.Arrays;
import java.util.List;

public class EmailValidator {
	private static List<Character> INVALID_CHARACTERS = Arrays.asList('!', '#', '$', '%', '^', '&', '*', '(', ')', '<',
			'>');

	public boolean validate(String email) {
		if (email == null) {
			return false;
		}

		return hasValidEmailFormat(email) && hasNoInvalidCharacters(email) && hasValidDomain(email)
				&& hasValidTLD(email);
	}

	private boolean hasNoInvalidCharacters(String email) {
		return INVALID_CHARACTERS.stream().noneMatch(character -> email.contains(character.toString()));
	}

	private boolean hasValidDomain(String email) {
		String domain = email.substring(email.indexOf('@') + 1);
		return hasValidDomainName(domain) && domain.contains(".") && !domain.startsWith("-");
	}

	private boolean hasValidDomainName(String domain) {
		int nameLength = domain.substring(0, domain.indexOf('.')).length();
		return nameLength >= 2 && nameLength <= 63;
	}

	private boolean hasValidTLD(String email) {
		String domain = email.substring(email.indexOf('@') + 1);
		String tld = domain.substring(domain.lastIndexOf(".") + 1);

		return tld.length() >= 2 && tld.length() <= 63;
	}

	private boolean hasValidEmailFormat(String email) {
		boolean onlyOneAtSignInEmail = email.chars().filter(c -> c == '@').count() == 1;
		boolean atSignIsBetweenCharacters = email.indexOf("@") != 0 && email.indexOf("@") != email.length() - 1;

		return email.contains(".") && onlyOneAtSignInEmail && atSignIsBetweenCharacters;

	}
}
