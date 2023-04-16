package exam03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;


class ServerThread extends Thread{ //연결한 여러 명의 클라이언트와 대화를 이어나가ㅏ는 역할
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = this.socket.getInputStream(); //그냥 socket라고 해도 됨
			os = this.socket.getOutputStream();

		}catch(Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}
	}
	
	public void run() {
		byte []data = new byte[100];
		while(true) {//연결한 클라이언트와 대화 이어나가는 반복문 
			try {
			is.read(data);
			String msg = new String(data);
			// 연결되어진 모든 클라이언트한테 보냄 (방송)
			sendAll(data);
			System.out.println("수신된 데이터:"+msg);
			if(msg.trim().equals("q!")) {
				break;
			}
			Arrays.fill(data, (byte)0);
			}catch(Exception ex) {
				System.out.println("예외 발생 : "+ex.getMessage());
			}
		}
	}
	public void sendAll(byte []data) {
		for(ServerThread st:TCPChatServer.list) {
			try{
				st.os.write(data);
			}catch(Exception e ) {
				System.out.println("예외발생 : " + e.getMessage());
			}
		}
	}
}
public class TCPChatServer {
	
	static ArrayList<ServerThread> list;
	
	public static void main(String[] args) {
		list = new ArrayList<ServerThread>();
		try {
			ServerSocket server = new ServerSocket(9003);
			
			while(true) {//클라이언트의 접속 무한대기
				Socket socket = server.accept();//억셉트가 동ㅈ가했을 때 소켓 발행
				System.out.println("*** 클라이언트가 접속하였습니다. ***");
				ServerThread th = new ServerThread(socket);
				list.add(th);
				th.start();
			//	System.out.println("클라이언트가 나갔습니다.");
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}






