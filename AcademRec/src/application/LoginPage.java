package application;

public class LoginPage {
	private String password;
	private String defaultPassword;
	private int loginCount;
	private boolean loggedIn;
	private boolean firstLogin;

	public LoginPage() {
		this.defaultPassword = "p";
		this.password = defaultPassword;
		this.loginCount = 1;
		this.loggedIn = false;
		this.firstLogin = true;
	}

	public boolean login(String password) {
		if (this.password.equals(password)) {
			if (firstLogin) {
				firstLogin = false;
				loggedIn = false;
				return false;
			}
			loggedIn = true;
			loginCount++;
			return true;
		}
		loggedIn = false;
		return false;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void logout() {
		loggedIn = false;
	}

	public boolean changePassword(String oldPassword, String newPassword) {
		if (password.equals(oldPassword)) {
			password = newPassword;
			return true;
		}
		return false;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public boolean isFirstLogin() {
		return (loginCount == 1);
	}
}
