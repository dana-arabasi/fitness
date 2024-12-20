package fitness;

public class Instructor {
	private boolean isLogedIn;
	private boolean isOnProgramManagementPage;
	private String message;
	
	public Instructor() {
		isLogedIn=false;	
		isOnProgramManagementPage=false;
		message="";
	}
    public void login() {
    	isLogedIn=true;
    }
    
    public void OnProgramManagementPage() {
    	
    	isOnProgramManagementPage=true;
    }
	public boolean isLogedIn() {
		if(isLogedIn==true)
			return true;
		else
		   return false;
	}

	public boolean isOnProgramManagementPage() {
		if(isOnProgramManagementPage==true)
			return true;
		else
		   return false;
	}
	public void setConfirmationMessage(String string) {
		this.message=string;
		
	}
	public String getConfirmationMessage() {
		return message;
	}

}
