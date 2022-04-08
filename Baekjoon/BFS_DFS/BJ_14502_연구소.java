import java.io.*;
import java.util.*;
// Combination, BFS , 완탐
public class BJ_14502_연구소 {

	static int N ,M,max,count,total;
	static int[][] map,res,test;
	static ArrayList<int[]> list;
	static ArrayList<int[]> virus;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		res = new int[3][2];
		list = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					list.add(new int[] {i,j});
					total++;
				}
				else if(map[i][j]==2) virus.add(new int[] {i,j});
			}
		}
		max=-1;
		total-=3;
		combi(0,0);
		System.out.println(max);
	}
	private static void combi(int start, int cnt) {
		if(cnt==3) {
			count = total;
			bfs(res);
			max = Math.max(count, max);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			res[cnt][0] =list.get(i)[0];
			res[cnt][1] = list.get(i)[1];
			combi(i+1,cnt+1);
		}
	}
	private static void bfs(int[][] arr) {
		Queue<int[]> qu = new LinkedList<int[]>();
		test = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, test[i], 0, test[0].length);	
		}
		for (int i = 0; i < 3; i++) {
			test[arr[i][0]][arr[i][1]] = 1;
		}
		
		for (int i = 0; i < virus.size(); i++) {
			qu.add(new int[] {virus.get(i)[0],virus.get(i)[1]});
			v[virus.get(i)[0]][virus.get(i)[1]] = true;
		}
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			int r = cur[0];
			int c = cur[1];
			if(count==0) {
				qu.clear();
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc]) continue;
				if(test[nr][nc]==1 || test[nr][nc]==2) continue;
				else if(test[nr][nc]==0) {
					v[nr][nc] =true;
					count--;
					qu.add(new int[] {nr,nc});
				}
			}
		}			
	}
}
