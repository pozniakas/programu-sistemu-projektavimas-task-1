package com.library.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionalTests {
    private final EmailValidator emailValidator = new EmailValidator();
    PasswordChecker passwordChecker = new PasswordChecker();
    private final PhoneValidator phoneValidator = new PhoneValidator();

    @Test
    void testNullEmail (){
        assertFalse(emailValidator.isValidEmail(null));
    }

    @Test
    void testNullPassword (){
        assertFalse(passwordChecker.isValidPassowrd(null));
    }

    @Test
    void testNullPhone (){
        assertFalse(phoneValidator.isValidPhone(null));
    }
}
