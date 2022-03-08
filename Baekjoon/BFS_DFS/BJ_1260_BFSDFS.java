import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_BFSDFS {

	static int N, M, V;
	static int[][] map;
	static boolean[] v;
	static StringBuilder sb;
	static StringBuilder sd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = map[c][r] = 1;
		}
		sb = new StringBuilder();
		sd = new StringBuilder();
		v = new boolean[N + 1];
		dfs(V);
		v = new boolean[N + 1];
		bfs(V);
		sb.setLength(sb.length()-1);
		sd.setLength(sd.length()-1);
		System.out.println(sd.toString());
		System.out.println(sb.toString());
	}

	private static void bfs(int cnt) {
		if(cnt==V) sb.append(V+" ");
		Queue<Integer> qu = new LinkedList<>();
		qu.add(cnt);
		v[cnt]=true;
		while(!qu.isEmpty()) {
			int tmp = qu.poll();
			for (int j = 1; j < N+1; j++) {
				if(v[j]) continue;
				if(map[tmp][j]==1) {
					v[j]=true;			
					sb.append(j+" ");
					qu.add(j);
				}
			}
		}
	}

	private static void dfs(int cnt) {
		if(cnt==V) sd.append(V+" ");
		v[cnt]=true;
		for (int j = 1; j < N+1; j++) {
			if(v[j]) continue;
			if(map[cnt][j]==1) {
				v[j]=true;			
				sd.append(j+" ");
				dfs(j);
			}
		}
		
	}

}
