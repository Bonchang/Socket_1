import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Skeleton {

	public static void process() {
		final int port = 12345;
		
		try {
			ServerSocket serverSocket = new ServerSocket (port);
			Socket clientSocket = serverSocket.accept();
			System.out.println ("Skeleton-Client connected: " + clientSocket.getInetAddress ());
			
			BufferedReader reader = new BufferedReader (new InputStreamReader (clientSocket.getInputStream () ));
			PrintWriter writer = new PrintWriter (clientSocket.getOutputStream () , true);
			
			String objectName = null;
			String methodName = null;
			String args = null;
			while ( (objectName = reader.readLine ()) != null) {
				methodName = reader.readLine();
				args = reader.readLine();
				System.out.println ("Skeleton-Received: " + objectName+methodName+args);
				
				Control control = new Control ();
				String userInfo = control.getUserInfo ();
				writer.println (userInfo);
			}
			clientSocket.close () ;
			System.out.println ("Skeleton-client disconnected: " + clientSocket.getInetAddress ()) ;
			
		} catch (IOException e) {
			e.printStackTrace();
		}

}
}
