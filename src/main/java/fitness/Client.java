package fitness;

public class Client {
	

	public Client() {
		super();
	}

	private String username;
	private String password;
	private MyApp app;
	private Object currentUsername;

	public Client(String username, String password) {
		this.username = username;
        this.password = password;
		
	}
	public void setApp(MyApp app) {
        this.app = app;
        this.currentUsername = app.getCurrentUsername(); // Set current username from app
    }

	

	public String getUsername() {
		 return username;
	}
	public void setUsername(String username) {
        this.username = username;
    }

	public String getPassword() {
		 return password;
	}
	public void setPassword(String password) {
        this.password = password;
    }

}
