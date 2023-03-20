import java.io.*;
import java.util.*;

public class BJ_9372_상근이의여행 {

	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			int count = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				if(isUnion(a,b)) continue;
				Union(a,b);
				
				count++;
			}
						
			sb.append(count+"\n");
		}
		System.out.print(sb.toString());
	}
	private static void Union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return;
		
		if(a<b) parents[b] = a;
		else parents[a] = b;
		
	}
	private static boolean isUnion(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return true;
		else return false;
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}

}
