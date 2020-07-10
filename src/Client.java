import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost",8888);
		InputStream in = s.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		OutputStream out = s.getOutputStream();
		PrintStream ps = new PrintStream(out);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str1 = sc.nextLine();
			ps.println(str1);
			if("over".equals(str1)) {
				break;
			}else {
				String str2  = br.readLine();
				System.out.println("server: "+str2);
			}
		}
		sc.close();
		br.close();
		ps.close();
		s.close();
	}

}
