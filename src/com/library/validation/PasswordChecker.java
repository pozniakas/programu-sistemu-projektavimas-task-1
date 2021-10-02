package com.library.validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PasswordChecker {
	public boolean isValidPassowrd(String password) {
		if (password==null) return false;
		if (!checkPasswordSize(password)) return false;
		if (!chechUppercase(password)) return false;
		if (!checkSpecialChar(password)) return false;
		return true;
	}

	private boolean checkPasswordSize (String password){
		int count = 0;
		for (char element:password.toCharArray()) {
			count++;
		}
		if (count>=5) return true;
		else return false;
	}

	private boolean chechUppercase (String password){
		for (char element:password.toCharArray()) {
			if (element >= 'A' && element <= 'Z'){
				return true;
			}
		}
		return false;
	}

	private boolean checkSpecialChar (String password){
		char specials[] = readFile();
		for (char symbom:specials) {
			for (char element:password.toCharArray()) {
				if (symbom==element) return true;
			}
		}
		return false;
	}

	private char[] readFile (){
		try {
			File myObj = new File("src/com/library/validation/PasswordCharacters.txt");
			Scanner myReader = new Scanner(myObj);
			String data = myReader.nextLine();
			myReader.close();
			return data.toCharArray();
		} catch (FileNotFoundException e) {
			System.out.println("File not exist.");
			e.printStackTrace();
		}
		return "".toCharArray();
	}
}
