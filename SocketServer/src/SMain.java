import java.io.*;
import java.net.*;

public class SMain {
	
	public void run() throws IOException {
		Skeleton skeleton = new Skeleton();
		skeleton.process();
	}
	
    public static void main(String[] args) throws IOException {
       SMain sMain = new SMain();
       sMain.run();
    }
}