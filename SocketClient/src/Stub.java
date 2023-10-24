import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Stub {
	public String send(String objectName, String methodName, String args) {
	    try {
            // 서버에 연결
            Socket socket = new Socket("localhost", 12345);
            System. out. println ("Stub-conntected to server");
            
            // 서버로 데이터를 보내기 위한 출력 스트림 생성
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 서버로 메시지 보내기
            out.println(objectName);
            out.println(methodName);
            out.println(args);
            
            System.out.println ("Stub-Message sent to skeleton: " + objectName+ methodName + args);

            // 서버로부터 데이터를 읽기 위한 입력 스트림 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 서버로부터 응답 받아 화면에 출력
            String result = in.readLine();
            System.out.println ("Stub-message received from server: " + result);

            // 자원 정리
            in.close();
            out.close();
            socket.close();
            
    		return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
}
