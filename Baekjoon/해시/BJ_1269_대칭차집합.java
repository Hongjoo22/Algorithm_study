import java.io.*;
import java.util.*;

public class BJ_1269_대칭차집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		int count=0;
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(set.contains(tmp)) count++;
		}
		
		System.out.println(M+N-count*2);
		
	}

}
