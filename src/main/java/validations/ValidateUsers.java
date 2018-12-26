package validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Users;

public class ValidateUsers {

	private void checkUsername(String username, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(username);

		if (m.matches()) {
			if (errorMap.get("username") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Username cannot be empty");
				errorMap.put("username", errorList);
			} else {
				List<String> errorList = errorMap.get("username");
				errorList.add("Username cannot be empty");
				errorMap.put("username", errorList);
			}
		}

		p = Pattern.compile("^.{3,}$");
		m = p.matcher(username);

		if (!m.matches()) {
			if (errorMap.get("username") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Username length must be minium 3 characters");
				errorMap.put("username", errorList);
			} else {
				List<String> errorList = errorMap.get("username");
				errorList.add("Username length must be minium 3 characters");

				errorMap.put("username", errorList);
			}
		}
	}
	
	private void checkPassword(String password, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(password);

		if (m.matches()) {
			if (errorMap.get("password") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Password cannot be empty");
				errorMap.put("password", errorList);
			} else {
				List<String> errorList = errorMap.get("password");
				errorList.add("Password cannot be empty");
				errorMap.put("password", errorList);
			}
		}

		p = Pattern.compile("^.{6,}$");
		m = p.matcher(password);

		if (!m.matches()) {
			if (errorMap.get("password") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Password length must be minium 6 characters");
				errorMap.put("password", errorList);
			} else {
				List<String> errorList = errorMap.get("password");
				errorList.add("Password length must be minium 6 characters");

				errorMap.put("password", errorList);
			}
		}


		p = Pattern.compile("^[A-Za-z0-9]*$");
		m = p.matcher(password);

		if (!m.matches()) {
			if (errorMap.get("password") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Password should be in alphanumeric");
				errorMap.put("password", errorList);
			} else {
				List<String> errorList = errorMap.get("password");
				errorList.add("Password should be in alphanumeric");

				errorMap.put("password", errorList);
			}
		}
		

	}
	
	private void checkPhone(String phone, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher m = p.matcher(phone);

		if (!m.matches()) {
			if (errorMap.get("phone") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Phone Number Must be a valid Indian mobile phone number");
				errorMap.put("phone", errorList);
			} else {
				List<String> errorList = errorMap.get("phone");
				errorList.add("Phone Number Must be a valid Indian mobile phone number");
				errorMap.put("phone", errorList);
			}
		}
	}
	
	private void checkEmail(String email, Map<String, List<String>> errorMap) {

		Pattern p = Pattern.compile("^+$");
		Matcher m = p.matcher(email);

		if (m.matches()) {
			if (errorMap.get("email") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("email cannot be empty");
				errorMap.put("email", errorList);
			} else {
				List<String> errorList = errorMap.get("email");
				errorList.add("Email cannot be empty");
				errorMap.put("email", errorList);
			}
		}

		p = Pattern.compile("^.{3,}$");
		m = p.matcher(email);

		if (!m.matches()) {
			if (errorMap.get("email") == null) {
				List<String> errorList = new ArrayList<String>();
				errorList.add("Email length must be minium 3 characters");
				errorMap.put("email", errorList);
			} else {
				List<String> errorList = errorMap.get("email");
				errorList.add("Email length must be minium 3 characters");

				errorMap.put("email", errorList);
			}
		}
	}

	public Map<String, List<String>> validateUsers(Users u) {

		Map<String, List<String>> errorMap = new HashMap<String, List<String>>();

		checkUsername(u.getUsername(), errorMap);
		checkPassword(u.getPassword(), errorMap);
		checkEmail(u.getEmail(), errorMap);
		checkPhone(u.getPhoneNo(), errorMap);

		return errorMap;
	}


}
