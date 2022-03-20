import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16928_뱀과사다리 {

	static int N,M;
	static int[] ladder, snake;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 사다리
		M = Integer.parseInt(st.nextToken()); // 뱀
		ladder = new int[107];
		snake = new int[107];
		v = new boolean[107];
		Queue<Integer> qu = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ladder[u]=v;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			snake[u]=v;
		}
		
		int myturn=1;
		int[] count = new int[99999];
		int idx=0, n_idx=1;
		while(true) {
			for (int i = 6; i> 0; i--) {
				int tmp = myturn+i;
				if(snake[tmp]!=0) {
					tmp = snake[tmp];
				}else if(ladder[tmp]!=0) {
					tmp = ladder[tmp];
				}
				if(tmp<=100) {
					if(!v[tmp]) {
						v[tmp] = true;
						qu.add(tmp);
						count[n_idx++] = count[idx]+1;
					}	
				}						
			}
			myturn = qu.poll();	
			idx++;
			if(myturn==100) break;			
		}
		System.out.println(count[idx]);		
	}	
}
