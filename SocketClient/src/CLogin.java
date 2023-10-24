
public class Control extends Stub implements IControl {
	public Control() {
		
	}
	public String getUserInfo() {
		String userInfo = send("control", "getIserIngo","");
		return  userInfo;
	}

}
