package fitness;

public class Instructor {
	private boolean isLogedIn;
	private boolean isOnProgramManagementPage;
	
	public Instructor() {
		isLogedIn=false;	
		isOnProgramManagementPage=false;
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

}
