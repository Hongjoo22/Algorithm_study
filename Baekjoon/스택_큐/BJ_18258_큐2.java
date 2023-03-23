import java.io.*;
import java.util.*;

public class BJ_18258_큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		Deque<Integer> qu = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			 st = new StringTokenizer(br.readLine());
			 
			 switch(st.nextToken()) {
			 	case "push":
			 		qu.add(Integer.parseInt(st.nextToken()));
			 		break;
			 	case "pop":
			 		if(qu.isEmpty()) sb.append("-1\n");
			 		else sb.append(qu.poll()+"\n");
			 		break;
			 	case "size":
			 		sb.append(qu.size()+"\n");
			 		break;
			 	case "empty":
		 			if(qu.isEmpty()) sb.append("1\n");
			 		else sb.append("0\n");
		 			break;
			 	case "front":
			 		if(qu.isEmpty()) sb.append("-1\n");
			 		else sb.append(qu.peekFirst()+"\n");
			 		break;
			 	case "back":
			 		if(qu.isEmpty()) sb.append("-1\n");
			 		else sb.append(qu.peekLast()+"\n");
			 		break;
			 }
		}
		System.out.print(sb.toString());
	}

}
