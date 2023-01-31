import java.io.*;

public class BJ_12813_이진수연산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine().trim();
		String B = br.readLine().trim();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		
		for (int i = 0; i < A.length(); i++) {
			int a = A.charAt(i)-'0';
			int b = B.charAt(i)-'0';
			sb1.append(a&b);
			sb2.append(a|b);
			sb3.append(a^b);
			sb4.append(a==0?1:0);
			sb5.append(b==0?1:0);
		}
		
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		System.out.println(sb3.toString());
		System.out.println(sb4.toString());
		System.out.println(sb5.toString());
	}

}
