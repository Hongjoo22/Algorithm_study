import java.io.*;
import java.util.*;

public class BJ_9205_맥주마시면서걸어가기 {

	static boolean cango;
	static int ex,ey,N;
	static ArrayList<int[]> conv;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N  = Integer.parseInt(br.readLine());
			StringTokenizer st=  new StringTokenizer(br.readLine()," ");
			int sx = Integer.parseInt(st.nextToken()); // 시작위치
			int sy  = Integer.parseInt(st.nextToken());
			conv = new ArrayList<>();
			for (int i = 0; i < N; i++) { // 편의점 위치
				st=  new StringTokenizer(br.readLine()," ");
				conv.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			st =  new StringTokenizer(br.readLine()," ");
			ex = Integer.parseInt(st.nextToken()); // 페스티벌위치
			ey  = Integer.parseInt(st.nextToken());
			cango = false;
			bfs(sx,sy);
			if(cango) sb.append("happy"+"\n");
			else sb.append("sad"+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void bfs(int sr, int sc) {
		Queue<int[]> qu = new LinkedList<int[]>();
		boolean[] v = new boolean[N];
		qu.add(new int[] {sr,sc});
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int x = cur[0];
			int y = cur[1];
			int check = Math.abs(ex-x)+Math.abs(ey-y);
			if(check<=1000||(x==ex && y == ey)) { // 페스티벌 도착
				cango = true;
				return;
			}
			for (int i = 0; i < conv.size(); i++) {
				if(v[i]) continue;
				int[] loc = conv.get(i);
				int distance = Math.abs(loc[0]-x)+Math.abs(loc[1]-y);
				if(distance>1000) continue;
				v[i] = true;
				qu.add(new int[] {loc[0],loc[1]});
			}
		}
		
	}
}
