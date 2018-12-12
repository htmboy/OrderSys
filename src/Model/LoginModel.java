package Model;

public class LoginModel {

	private String username;
	private String password;
	
	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
