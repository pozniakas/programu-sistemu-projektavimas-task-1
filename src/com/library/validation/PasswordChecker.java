package com.library.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PasswordChecker {
	private static int MIN_PASSWORD_LENGTH = 5;
	private static List<Character> DEFAULT_SPECIAL_CHARACTERS = Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*',
			'(', ')', '<', '>');

	private List<Character> specialCharacters;

	public PasswordChecker() {
		this.specialCharacters = DEFAULT_SPECIAL_CHARACTERS;
	}

	public PasswordChecker(List<Character> specialCharacters) {
		this.specialCharacters = specialCharacters;
	}

	public boolean validate(String password) {
		return password != null && this.isValidLength(password) && this.hasSpecialCharacter(password)
				&& this.hasUppercaseCharacter(password);
	}

	private boolean isValidLength(String password) {
		return password.length() >= MIN_PASSWORD_LENGTH;
	}

	private boolean hasSpecialCharacter(String password) {
		Stream<Character> specialCharactersStream = specialCharacters.stream();
		return specialCharactersStream.anyMatch(character -> password.contains(character.toString()));
	}

	private boolean hasUppercaseCharacter(String password) {
		IntStream passwordInChars = password.chars();
		return passwordInChars.anyMatch(Character::isUpperCase);
	}
}
