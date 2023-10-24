import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Skeleton {
	private HashMap<String, Object> objectMap;

	public Skeleton() {
		this.objectMap = new HashMap<String, Object>();
		this.objectMap.put("cLogin", new CLogin());
	}

	public void process() {
		final int port = 12345;

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System. out.println ("Skeleton-listening on port " + port);
			while (true) {
			Socket clientSocket = serverSocket.accept();
			System.out.println("Skeleton-Client connected: " + clientSocket.getInetAddress());

			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

			String objectName = reader.readLine();
			String methodName = reader.readLine();
			String args = reader.readLine();
			System. out.println ("Skeleton-Received: " + objectName + methodName + args) ;
			
			Object object = this.objectMap.get(objectName);
			Session session = new Session();
			session. process (object, methodName, args, writer);
			
			clientSocket.close ();
			

			CLogin control = new CLogin();
			String userInfo = control.getUserInfo();
			writer.println(userInfo);

			clientSocket.close();
			System.out.println("Skeleton-client disconnected: " + clientSocket.getInetAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public class Session {
	    public void process(Object object, String methodName, String args, PrintWriter writer) {
	        try {
	            if (object != null) {
	                String[] arguments = args.split(","); // 분리된 인수 배열
	                Object[] methodArgs = new Object[arguments.length]; // 메서드에 전달할 인수 배열

	                for (int i = 0; i < arguments.length; i++) {
	                    methodArgs[i] = arguments[i];
	                }

	                String result = (String) object.getClass().getMethod(methodName, String[].class).invoke(object, new Object[] { methodArgs });
	                writer.println("Result Count: " + methodArgs.length); // 인수 개수 출력
	                writer.println("Result: " + result);
	            } else {
	                // Handle the case where 'object' is null (e.g., return an error message)
	                writer.println("Object is null");
	            }
	        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
	            // Handle other exceptions as needed
	            e.printStackTrace();
	        }
	    }
	}


}

