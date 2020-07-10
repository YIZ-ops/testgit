import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("服务器等待连接...");
		System.out.println("服务器已连接");
		Socket s = ss.accept();
		InputStream in = s.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		OutputStream out = s.getOutputStream();
		PrintStream ps = new PrintStream(out);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str1 = br.readLine();
			System.out.println("client: " + str1);
			if("over".equals(str1)) {
				System.out.println("聊天结束");
				break;
			}else {
				String str2  = sc.nextLine();
				ps.println(str2);
			}
		}
		
		sc.close();
		br.close();
		ps.close();
		s.close();
		ss.close();
		
		
		
	}
}
