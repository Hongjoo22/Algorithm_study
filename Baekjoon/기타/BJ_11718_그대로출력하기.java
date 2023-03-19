import java.io.*;
import java.util.Scanner;

public class BJ_11718_그대로출력하기 {

//	public static void main(String[] args) {
//		Scanner in  = new Scanner(System.in);
//		
//		while(in.hasNext()) {
//			System.out.println(in.nextLine());				
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while((str=br.readLine())!=null) {
			System.out.println(str);	
		}
	}
}
