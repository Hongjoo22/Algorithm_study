import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		char[] cs = str.toCharArray();
		Stack<Character> st = new Stack<>();
		int idx_e = 0;
		for (int i = 0; i < cs.length; i++) {
			if(cs[i]=='<') {
				if(!st.isEmpty()) {
					while(!st.isEmpty()) {sb.append(st.pop());}				
				}
				for (int j = i+1; j < cs.length; j++) {
					if(cs[j]=='>') {
						for (int k = i; k <= j; k++) {
							sb.append(cs[k]);
						}
						idx_e=j;
						break;
					}
				}
			}
			else if(cs[i]==' ' && idx_e<=i) {
				if(!st.isEmpty()) {
					while(!st.isEmpty()) {sb.append(st.pop());}				
				}
				sb.append(cs[i]);
			}
			else if(cs[i]!='<' && cs[i]!='>' && cs[i]!=' ' && idx_e<=i) {
				st.add(cs[i]);
			}			
		}
		if(!st.isEmpty()) {
			while(!st.isEmpty()) {sb.append(st.pop());}				
		}
		System.out.println(sb.toString());
	}

}
