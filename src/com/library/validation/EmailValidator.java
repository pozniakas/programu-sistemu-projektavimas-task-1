package com.library.validation;

public class EmailValidator {
	public boolean isValidEmail(String email) {
		if (email==null) return false;

		if (counterAt(email)!=1) return false;

		if (!checkFirstNameChar(email)) return false;

		if (!checkLastNameChar(email)) return false;

		if (chechDublicateSymbols(email)) return false;

		if (checkDomain(email)) return false;

		if (!checkTLD(email)) return false;

		return true;
	}

	private int counterAt (String email){
		int count=0;
		for (char character:email.toCharArray())
		{
			if (character=='@') count++;
		}
		return count;
	}

	private boolean checkFirstNameChar (String email){
		char charArr[] = email.toCharArray();

		return checkLetterWithNumber(charArr[0]);
	}

	private boolean checkLastNameChar (String email){
		char charArr[] = email.toCharArray();
		int count=0;
		for (char character:email.toCharArray())
		{
			if (character=='@') break;
			count++;
		}

		return checkLetterWithNumber(charArr[count-1]);
	}

	private boolean chechDublicateSymbols (String email){
		char previous=0;
		for (char letter:email.toCharArray())
		{
			if (letter == previous){
				if (!checkSymbolWithHymen(letter)) return true;
			}
			previous=letter;
		}
		return false;
	}

	private boolean checkLetter(char letter){
		if ((letter >= 'A') && (letter <= 'Z')){
			return true;
		}
		if ((letter >= 'a') && (letter <= 'z')){
			return true;
		}
		return false;
	}

	private boolean checkLetterWithNumber(char letter){
		if (checkLetter(letter)) return true;
		if ((letter >= '0') && (letter <= '9')){
			return true;
		}
		return false;
	}

	private boolean checkSymbolWithHymen(char letter){
		if (checkLetterWithNumber(letter)) return true;
		if (letter=='-') return true;
		return false;
	}

	private boolean checkDomain (String email){
		int count = 0;
		int fistindex = 0;
		char emailArr[] = email.toCharArray();
		for (char letter:emailArr) {
			if (letter=='@') fistindex=count+1;

			if (fistindex<=count && fistindex!=0 && letter!='.'){
				if (!checkSymbolWithHymen(letter)) return true;
			}
			count++;
		}
		count--;
		if (count!=fistindex){
			if (emailArr[fistindex]=='-') return true;
			if (emailArr[count]=='-') return true;
		}
		return false;
	}

	private boolean checkTLD (String email){
		int length = 0;
		for (char letter:email.toCharArray()) {
			length++;
			if (letter == '.') length=0;
		}
		if (length>=2 && length<=6) return true;
		else return false;
	}
}
