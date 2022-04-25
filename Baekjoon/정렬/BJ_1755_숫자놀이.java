import java.io.*;
import java.util.*;

public class BJ_1755_숫자놀이 {

	static class Node implements Comparable<Node>{
		String eng;
		int num; // 원래 숫자
		public Node(String eng, int num) { // 삽입용 node
			super();
			this.eng = eng;
			this.num = num;
		}
		@Override
		public int compareTo(Node o) { // 사전순 정렬
			return this.eng.compareTo(o.eng);
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 이상
		int N =  Integer.parseInt(st.nextToken()); // 이하
		PriorityQueue<Node> qu = new PriorityQueue<>();
	
		for (int i = M; i <= N; i++) {
			StringBuilder sb = new StringBuilder();		// 영어받음	
			StringBuilder sb2 = new StringBuilder(); // 해당 숫자만큼 받기위해
			sb2.append(i);
			for (int j = 0; j < sb2.length(); j++) { // 해당숫자길이만큼 돌린다
				switch(sb2.toString().charAt(j)) { // 순서대로
				case '0': // 각 케이스에 맞게
					sb.append(9); // 영어받는 변수에 넣는다
					break;
				case '1': 
					sb.append(4); // append 안에 있는 숫자는 작을수록 영어 우선순위가 높다.
					break;
				case '2': 
					sb.append(8);
					break;
				case '3': 
					sb.append(7);
					break;
				case '4': 
					sb.append(2);
					break;
				case '5': 
					sb.append(1);
					break;
				case '6': 
					sb.append(6);
					break;
				case '7': 
					sb.append(5);
					break;
				case '8': 
					sb.append(0);
					break;
				case '9': 
					sb.append(3);
					break;
				}				
			}			
			qu.add(new Node(sb.toString(),i));
		}
	
		StringBuilder res = new StringBuilder(); // 출력
		int num = 0;
		while(!qu.isEmpty()) {
			if(num!=0 && num%10==0) { // 한줄에 10자리 하기위해서
				res.setLength(res.length()-1); // 공백제거
				res.append("\n");		
			}
			res.append(qu.poll().num+" ");
			num++;
		}
		res.setLength(res.length()-1); // 맨마지막 공백 및 한줄 띄어쓰기 제거
		System.out.println(res.toString()); // 출력		
	}
}