
public class Control1 extends Stub implements IControl {
	public Control1() {
		
	}
	public String getUserInfo() {
		String userInfo = send("control", "getIserIngo","");
		return  userInfo;
	}

}
