import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_Top {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> stk = new Stack<>();
		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()) {
				if(top<=stk.peek()[1]) {
					System.out.print(stk.peek()[0]+" ");
					break;
				}
				stk.pop();
			}
			if(stk.isEmpty()) {
				System.out.print("0 ");
			}
			stk.push(new int[] {i,top});
		}
		
	}
}