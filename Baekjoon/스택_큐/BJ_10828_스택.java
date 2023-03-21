import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			 st = new StringTokenizer(br.readLine());
			 
			 switch(st.nextToken()) {
			 	case "push":
			 		stack.push(Integer.parseInt(st.nextToken()));
			 		break;
			 	case "pop":
			 		if(stack.isEmpty()) sb.append("-1\n");
			 		else sb.append(stack.pop()+"\n");
			 		break;
			 	case "size":
			 		sb.append(stack.size()+"\n");
			 		break;
			 	case "empty":
		 			if(stack.isEmpty()) sb.append("1\n");
			 		else sb.append("0\n");
		 			break;
			 	case "top":
			 		if(stack.isEmpty()) sb.append("-1\n");
			 		else sb.append(stack.peek()+"\n");
			 		break;
			 }
		}
		System.out.print(sb.toString());
	}

}
