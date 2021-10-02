package com.library.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordCheckerTest {
	PasswordChecker passwordChecker = new PasswordChecker();

	@ParameterizedTest
	@ValueSource(strings = { "#paswordasA", "SLA-;d#", "čiaBiblioteka;", "_Labas123_" })
	void testValidPasswordValidation(String password) {
		assertTrue(passwordChecker.isValidPassowrd(password));
	}

	@ParameterizedTest
	@ValueSource(strings = { "pass", "S", "či", "_lab", " " })
	void testTooShortPasswordValidation(String password) {
		assertFalse(passwordChecker.isValidPassowrd(password));
	}

	@ParameterizedTest
	@ValueSource(strings = { "#paswordas", "sla-;d#", "čiabiblioteka;", "_labas123_" })
	void testPasswordWithoutUppercaseCharValidation(String password) {
		assertFalse(passwordChecker.isValidPassowrd(password));
	}

	@ParameterizedTest
	@ValueSource(strings = { "paswordasA", "SLAdas", "čiaBiblioteka", "labas123" })
	void testPasswordWithoutSpecialCharValidation(String password) {
		assertFalse(passwordChecker.isValidPassowrd(password));
	}
}