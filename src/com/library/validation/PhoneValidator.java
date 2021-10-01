package com.library.validation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneValidator {
	public boolean isValidPhone(String phone) {
		if (phone==null) return false;
		List<Validation_rule> rules = new ArrayList<>();
		rules.add(new Validation_rule("+370", 8));
		for (Validation_rule rule: rules) {
			if(checkCase(rule, phone)) return true;
		}
		return false;
	}

	public String formatPhonePrefix(String phone) {
		return changePrefix(phone);
	}

	private String changePrefix (String phone){
		char newFormat[] = new char[12];
		newFormat[0]='+';
		newFormat[1]='3';
		newFormat[2]='7';
		newFormat[3]='0';
		char charphone[] = phone.toCharArray();
		if (charphone[0]=='8'){
			for (int i=4; i<12; i++){
				newFormat[i]=charphone[i-3];
			}
			return new String(newFormat);
		}
		if (!isValidPhone(phone)) throw new  IllegalArgumentException("Not valid phone");
		else return phone;
	}

	private boolean checkCase(Validation_rule rule, String phone){
		int index = 0;
		int index2 = 0;
		char phoneArr[] = phone.toCharArray();
		if (phone.equals("")) return false;
		for (char element:rule.getPrefix().toCharArray()) {
			if (phoneArr[index]!=element) return false;
			index++;
		}
		for (char element:phoneArr) {
			if (index2==0 && element=='+') {
				index2++;
				continue;
			}
			else if(!isNumber(element)) break;
			index2++;
		}
		if ((index2-index)==rule.getLength()) return true;
		else return false;
	}

	private boolean isNumber(char nr){
		if (nr>='0' && nr<='9') return true;
		else return false;
	}

}
