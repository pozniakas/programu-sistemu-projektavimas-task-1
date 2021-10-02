package com.library.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EmailValidatorTest {
	private final EmailValidator emailValidator = new EmailValidator();

	@ParameterizedTest
	@ValueSource(strings = { "moon@gmail.com", "earth@yahoo.com", "steve@inbox.lt", "support@pozniakas.com" })
	void testValidEmailValidation(String email) {
		assertTrue(emailValidator.isValidEmail(email));
	}

	@ParameterizedTest
	@ValueSource(strings = { "moo_n_@gmail.com", "e;;arth@yahoo.com", "steve@/na.lt", "support @pozniakas.com" })
	void testEmailWithIlleagalSymbolsValidation(String email) {
		assertFalse(emailValidator.isValidEmail(email));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "    " })
	void testPhoneValidationWithEmptyValue(String email) {
		assertFalse(emailValidator.isValidEmail(email));
	}

	@ParameterizedTest
	@ValueSource(strings = { "moongmail.com", "yahoo.com", "steve.lt", "pozniakas" })
	void testEmailWithoutAtSignValidation(String email) {
		assertFalse(emailValidator.isValidEmail(email));
	}

	@Test
	void testEmailWithInvalidDomainValidation() {
		String email = "earth@neegzistu?ojanti-svetaine.net";

		assertFalse(emailValidator.isValidEmail(email));
	}

	@Test
	void testEmailWithInvalidTLDValidation() {
		String email = "earth@gmail.blogastld";

		assertFalse(emailValidator.isValidEmail(email));
	}
}