import java.io.*;
import java.util.*;

public class BJ_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			pq.add(x);
		}
		int size =pq.size();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i]=pq.poll();
		}
	
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		go : for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			int low = 0;
			int high = arr.length-1;
			int mid = 0;
			while(low<=high) {
				mid = (low+high)/2;
				if(x==arr[mid]) {
					sb.append("1\n");
					continue go;
				}else if(x<arr[mid]) high=mid-1;
				else low = mid+1;
			}
			sb.append("0\n");
		}		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
