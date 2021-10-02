package com.library.validation;

public class PhoneValidator {
	private static String DEFAULT_INTERNATIONAL_CALLING_CODE = "+370";
	private static String DEFAULT_NATIONAL_CALLING_CODE = "8";
	private static int DEFAULT_PHONE_NUMBER_LENGTH = 8;

	private String internationalCallingCode;
	private String nationalCallingCode;
	private int phoneNumberLength;

	public PhoneValidator() {
		this.internationalCallingCode = DEFAULT_INTERNATIONAL_CALLING_CODE;
		this.nationalCallingCode = DEFAULT_NATIONAL_CALLING_CODE;
		this.phoneNumberLength = DEFAULT_PHONE_NUMBER_LENGTH;
	}

	public PhoneValidator(String internationalCallingCode, String nationalCallingCode, int phoneNumberLength) {
		this.internationalCallingCode = internationalCallingCode;
		this.nationalCallingCode = nationalCallingCode;
		this.phoneNumberLength = phoneNumberLength;
	}

	public boolean validate(String phone) {
		if (phone == null || !isLegalPhonePrefix(phone)) {
			return false;
		}
		phone = this.convert(phone);

		return isValidPhoneLength(phone) && isPhoneWithoutIllegalCharacters(phone);
	}

	public String convert(String phone) {
		boolean isInvalidPrefix = !isLegalPhonePrefix(phone);
		if (isInvalidPrefix) {
			throw new IllegalArgumentException("Invalid phone number to convert prefix");
		}

		return phone.startsWith(internationalCallingCode) ? phone
				: internationalCallingCode + phone.substring(nationalCallingCode.length());
	}

	private boolean isLegalPhonePrefix(String phone) {
		return phone != null && (phone.startsWith(nationalCallingCode) || phone.startsWith(internationalCallingCode));
	}

	private boolean isValidPhoneLength(String phone) {
		int callingCodeLength = internationalCallingCode.length();
		return phone.length() >= phoneNumberLength ? phone.substring(callingCodeLength).length() == phoneNumberLength
				: false;
	}

	private boolean isPhoneWithoutIllegalCharacters(String phone) {
		return phone.substring(1).chars().allMatch(Character::isDigit);
	}
}
