
public class CLogin extends Stub implements ICLogin {
	public CLogin() {
		
	}
	public String getUserInfo() {
		String userInfo = send("CLogin", "getUserInfo","");
		return  userInfo;
	}

}
