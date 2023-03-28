import java.io.*;
import java.util.*;

public class BJ_27866_문자와_문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		System.out.println(str.charAt(N-1));
	}

}
