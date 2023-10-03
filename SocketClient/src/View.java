
public class View {
	private Control control;
	public View() {
		this.control = new Control();
	}
	public void showUserInfo() {
		String UserInfo = this.control.getUserInfo();
		System.out.println(UserInfo);
	}

}
