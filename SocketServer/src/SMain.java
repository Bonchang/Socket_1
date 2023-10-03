import java.io.*;
import java.net.*;

public class SMain {
	
	public SMain() {
		Skeleton skeleton = new Skeleton();
		skeleton.process();
	}
	public void run() {

		 try {
	            // 서버 소켓 생성 및 포트 번호 12345로 바인딩.
	            ServerSocket serverSocket = new ServerSocket(12345);
	            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다...");

	            // 클라이언트의 연결을 기다림
	            Socket clientSocket = serverSocket.accept();
	            System.out.println("클라이언트가 연결되었습니다.");

	            // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 생성
	            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

	            // 클라이언트로 데이터를 보내기 위한 출력 스트림 생성
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

	            // 클라이언트로부터 메시지를 읽고 화면에 출력
	            String message = in.readLine();
	            System.out.println("클라이언트로부터 수신된 메시지: " + message);

	            // 클라이언트에게 응답 보내기
	            out.println("Hello, Client!");
	            out.println("Hello, Client!");
	            
	            // 자원 정리
	            in.close();
	            out.close();
	            clientSocket.close();
	            serverSocket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
    public static void main(String[] args) {
       SMain sMain = new SMain();
       sMain.run();
    }
}