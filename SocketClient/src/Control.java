
public class Control extends Stub{
	public Control() {
		
	}
	public String getUserInfo() {
		String userInfo = send("control", "getIserIngo","");
		return  userInfo;
	}

}
