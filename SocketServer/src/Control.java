import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Control {
	public Control() {
		
	}
	
	public String getUserInfo() {
	    try {
            // 서버에 연결
            Socket socket = new Socket("localhost", 12345);

            // 서버로 데이터를 보내기 위한 출력 스트림 생성
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 서버로 메시지 보내기
            String objectName = "control";
            out.println(objectName);
            String methodName = "getUserInfo";
            out.println(methodName);
            String arg = "";
            out.println(arg);
            
            out.println("Hello, Server!");

            // 서버로부터 데이터를 읽기 위한 입력 스트림 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 서버로부터 응답 받아 화면에 출력
            String response = in.readLine();
            System.out.println("서버로부터 받은 응답: " + response);

            // 자원 정리
            in.close();
            out.close();
            socket.close();
            
    		return "User Info";

        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}

}
