import java.io.*;
public class BJ_1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toLowerCase();
		int[] alpha = new int[27];
		int max=-1;
		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i)-'a']++;
			max = Math.max(max, alpha[str.charAt(i)-'a']);
		}
		int num = 0;
		int res = 0;
		for (int i = 0; i < 26; i++) {
			if(max==alpha[i]) {
				num++;
				res = i;
			}
			if(num>=2) {
				System.out.println("?");
				return;
			}
		}
		System.out.println((char)(res+'A'));
	}
}
