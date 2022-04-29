import java.io.*;
import java.util.*;

public class BJ_18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sarr = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			pq.add(tmp);
		}
		int idx=0;
		while(!pq.isEmpty()) {
			if(idx>0 && pq.peek()==sarr[idx-1]) pq.poll();
			else sarr[idx++] = pq.poll();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int tmp = Arrays.binarySearch(sarr, 0, idx, arr[i]);
			sb.append(tmp+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
