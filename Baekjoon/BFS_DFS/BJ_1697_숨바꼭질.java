import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int[] map = new int[100001];
		int[] v = {-1,1,2};

		Queue<Integer> qu = new LinkedList<>();
		qu.add(N);
		out: while(!qu.isEmpty()) {
			int p = qu.poll();
			if(p==K) break out;
			for (int d = 0; d <3; d++) {
				int n;
				if(d==2) {
					n = p*v[d];
				}else {
				    n = p+v[d];
				}
				if(d==2 && n==0) continue;
				if(n>=0 && n<=100000 && map[n]==0) {
					map[n] = map[p]+1;														
					if(n==K) break out;
					qu.add(n);
				}
			}
		}
		System.out.println(map[K]);
	}

}
