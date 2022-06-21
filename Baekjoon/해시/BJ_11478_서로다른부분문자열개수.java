import java.io.*;
import java.util.*;

public class BJ_11478_서로다른부분문자열개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j <= str.length(); j++) {
				set.add(str.substring(i,j));
			}
		}
		System.out.println(set.size());
	}
}
