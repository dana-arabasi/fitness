package fitness;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class Account {


	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String role;
	private boolean submited;
	private boolean isAccountCreated;
	private boolean emailIsSent;
	private String errorMessage;
	
	public Account() {
		firstName="";
		lastName="";
		email="";
		phone="";
		role="";
		submited=false;
		isAccountCreated=false;
		emailIsSent=false;
		errorMessage="";
	}

	public void enterFirstName(String firstName) {
		this.firstName=firstName;
		
	}

	public void enterLastName(String lastName) {
		this.lastName=lastName;
		
	}

	public void enterEmail(String email) {
		this.email=email;
		
	}

	public void enterPhone(String phone) {
		this.phone=phone;
		
	}

	public void enterRole(String role) {
		this.role=role;
		
	}

	public boolean isFirstNameFill() {
		if(firstName.isEmpty())
		return false;
		else
			return true;
	}

	public boolean isLastName() {
		if(lastName.isEmpty())
		return false;
		else
			return true;
	}

	public boolean isEmailFill() {
		if(email.isEmpty())
		return false;
		else
			return true;
	}

	public boolean isPhoneFill() {
		if(phone.isEmpty())
		return false;
		else
			return true;
	}

	public boolean isRoleFill() {
		if(role.isEmpty())
		return false;
		else
			return true ;
	}

	public void submit() {
		this .submited=true;
		
	}

	public boolean isSubmited() {
		return submited;
	}

	public boolean isAccountCreated() {
		
		return isAccountCreated;
	}

	public void createAccount() {
		this.isAccountCreated=true;
		
	}

	public void emailIsSent() {
		emailIsSent=true;
		
	}

	public boolean isConfirmationEmailSent() {
		return emailIsSent;
	}

	public void dontSubmit() {
		this .submited=false;
		
	}

	public boolean validateAccountDetails() {
		if(isFirstNameFill()&isLastName()&isEmailFill()&isPhoneFill()&isRoleFill())
		return true ;
		else
			return false;
	}

	public void invalidFirstName() {
		enterFirstName("");
		 
		
	}

	public void validFirstName(String string) {
		enterFirstName(string);
		
	}

	public boolean isPhoneValid(String string) {
		return  string.matches("\\d{10}"); 
	}

	public boolean isEmailAlreadyInUse(String string) {
		 List<String> existingEmails = Arrays.asList("existinguser@example.com", "john.doe@email.com");
	        return existingEmails.contains(string);
		
	}

	public boolean isEmailValid(String string) {
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errorMessage = "Invalid email format. Please enter a valid email.";
            return false;
        }
		else
        return true;
		
	}

	public String getErrorMessage() {
		
		 return errorMessage;
	}

	public boolean doesAccountExist(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
