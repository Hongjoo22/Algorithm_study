import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675_문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String str = st.nextToken().trim();
			char[] cs = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cs.length; i++) {
				for (int j = 0; j < num; j++) {
					sb.append(cs[i]);
				}
			}
			System.out.println(sb);
		}
	}

}
