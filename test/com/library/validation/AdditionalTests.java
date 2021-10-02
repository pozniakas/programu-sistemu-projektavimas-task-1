package com.library.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionalTests {

    EmailValidator emailValidator;
    PasswordChecker passwordChecker;
    PhoneValidator phoneValidator;

    @BeforeEach
    void setUp (){
        emailValidator = new EmailValidator();
        passwordChecker = new PasswordChecker();
        phoneValidator = new PhoneValidator();
    }

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

    @Test
    void testWhitoutNamePart (){
        assertFalse(emailValidator.isValidEmail("@gmail.com"));
    }

    @Test
    void testAddNewValidationRuleEmptyPrefix (){
        assertThrows(IllegalArgumentException.class, () -> phoneValidator.addValidationRule("",5));
    }

    @Test
    void testAddNewValidationRuleNullPrefix (){
        assertThrows(IllegalArgumentException.class, () -> phoneValidator.addValidationRule(null, 7));
    }

    @Test
    void testAddNewValidationRuleSmallLen (){
        assertThrows(IllegalArgumentException.class, () -> phoneValidator.addValidationRule("+47", -1));
    }

    @Test
    void testAddPolandValidationAndCheck(){
        assertDoesNotThrow(() -> phoneValidator.addValidationRule("+48", 9));
        assertTrue(phoneValidator.isValidPhone("+48123456789"));
        assertFalse(phoneValidator.isValidPhone("+481234567890"));
        assertFalse(phoneValidator.isValidPhone("+48123_56789"));
    }

}
