
public class View {
	private CLogin cLogin;
	public View() {
		this.cLogin = new CLogin();
	}
	public void showUserInfo() {
		String UserInfo = this.cLogin.getUserInfo();
		System.out.println(UserInfo);
	}

}
