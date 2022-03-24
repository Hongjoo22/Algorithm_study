import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder()); // 앞쪽
		PriorityQueue<Integer> pqmin= new PriorityQueue<>();
		pqmax.add(Integer.MIN_VALUE);
		pqmin.add(Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(pqmax.size()<=pqmin.size()) {
				if(x>pqmin.peek()) {
					pqmax.add(pqmin.poll());
					pqmin.add(x);
					sb.append(pqmax.peek()+"\n");
					continue;
				}
				pqmax.add(x);
				sb.append(pqmax.peek()+"\n");
			}else {
				if(x<pqmax.peek()) {
					pqmin.add(pqmax.poll());
					pqmax.add(x);
					sb.append(pqmax.peek()+"\n");
					continue;
				}
				pqmin.add(x);
				sb.append(pqmax.peek()+"\n");
			}			
			
		}		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
