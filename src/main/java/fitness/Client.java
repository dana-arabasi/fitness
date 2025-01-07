package fitness;

public class Client {
	private String userName;
	private String password;
	private boolean isBasic;
	private boolean isPremium;
	

	
	public Client() {
		super();
	
	}
	
	 public Client(String name, String password2) {
		 super();
			this.userName = name;
			this.password = password2;
			 isBasic=true;
			 isPremium=false;
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
	public boolean getisBasic() {
		
		return isBasic;
	}
	
	public void setisBasic(boolean isBasic) {
		this.isBasic = isBasic;
	}
	
    public boolean getisPremium() {
		
		return isPremium;
	}
	
	public void setisPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	
}
