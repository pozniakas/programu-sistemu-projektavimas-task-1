package com.library.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PhoneValidatorTest {
	private final PhoneValidator phoneValidator = new PhoneValidator();

	@ParameterizedTest
	@ValueSource(strings = { "+37063854648", "+37064355003", "+37061235001", "+37067940308" })
	void testValidPhoneValidation(String phone) {
		assertTrue(phoneValidator.isValidPhone(phone));
	}

	@ParameterizedTest
	@ValueSource(strings = { "+370638548", "+370655003", "+370611", "+3706", "+370" })
	void testTooShortPhoneValidation(String phone) {
		assertFalse(phoneValidator.isValidPhone(phone));
	}

	@ParameterizedTest
	@ValueSource(strings = { "+370638546448", "+370643545003", "+3706123502201", "+370679403222208" })
	void testTooLongPhoneValidation(String phone) {
		assertFalse(phoneValidator.isValidPhone(phone));
	}

	@ParameterizedTest
	@ValueSource(strings = { "+3706385s648", "+37064_55003", ";37061235001", "370.6.7.9.4.0.3.0.8." })
	void testPhoneWithIlleagalSymbolsValidation(String phone) {
		assertFalse(phoneValidator.isValidPhone(phone));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", " ", "    " })
	void testPhoneValidationWithEmptyValue(String phone) {
		assertFalse(phoneValidator.isValidPhone(phone));
	}

	@Test
	void testValidPhonePrefixFormatting() {
		String phone = "863854648";
		String formattedPhone = "+37063854648";

		assertEquals(formattedPhone, phoneValidator.formatPhonePrefix(phone));
	}

	@Test
	void testFormattedPhonePrefixFormatting() {
		String phone = "+37063854648";

		assertEquals(phone, phoneValidator.formatPhonePrefix(phone));
	}

	@ParameterizedTest
	@ValueSource(strings = { "+370638546448", "+37064_55003", " ", "+370611" })
	void testInvalidPhonePrefixFormatting(String phone) {
		assertThrows(IllegalArgumentException.class, () -> phoneValidator.formatPhonePrefix(phone));
	}
}
