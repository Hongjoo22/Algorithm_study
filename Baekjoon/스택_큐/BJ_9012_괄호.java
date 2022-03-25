import java.io.*;
import java.util.Stack;

public class BJ_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		StringBuilder sb = new StringBuilder();
		
		go: for (int i = 0; i < N; i++) {
			Stack<Character> st = new Stack<>();
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < cs.length; j++) {
				if(cs[j]=='(') {
					st.add(cs[j]);
				}else if( cs[j]==')') {
					if(!st.isEmpty()) st.pop();
					else {
						 sb.append("NO\n");
						 continue go;
					}
				}
			}
			if(!st.isEmpty()) sb.append("NO\n");
			else sb.append("YES\n");
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
