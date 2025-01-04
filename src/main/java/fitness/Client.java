package fitness;

public class Client {
	private String currentUsername;
	private MyApp app;
	private String userName;
	private String password;
	

	
	public Client() {
		super();
	
	}
	
	 public Client(String name, String password2) {
		 super();
			this.userName = name;
			this.password = password2;
	}
	public void setApp(MyApp app) {
	        this.app = app;
	        this.currentUsername = app.getCurrentUsername(); // Set current username from app
	    }

	public String getUsername() {
				return userName;
	}
	
	public void setUsername(String username) {
		this.userName = username;
	}
	

	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
