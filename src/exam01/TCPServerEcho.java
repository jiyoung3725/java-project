package exam01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPServerEcho {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9003);
			byte []data = new byte[100];
			while(true) {
				Socket socket = server.accept();
				System.out.println("*** 클라이언트가 접속하였습니다. ***");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				while(true) {
					is.read(data);
					os.write(data);
					String msg = new String(data);
					System.out.println("수신된 데이터:"+msg);
					if(msg.trim().equals("q!")) {
						break;
					}
					Arrays.fill(data, (byte)0);
				}
				System.out.println("클라이언트가 나갔습니다.");
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}






