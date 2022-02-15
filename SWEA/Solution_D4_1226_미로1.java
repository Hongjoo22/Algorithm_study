import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS
public class Solution_D4_1226_미로1 {
	static int[][] map;
	static int start_r, start_c;
	static int final_r, final_c;
	static int  cango;
	static int N =16;
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			in.nextInt();
			map=new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] cs = in.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]=cs[j]-'0';
					if(map[i][j]==2) {
						start_r=i;
						start_c=j;
					}else if(map[i][j]==3) {
						final_r=i;
						final_c=j;
					}
				}
			}
			//미로 찾기 시작	
			cango=0;
			bfs();
			System.out.println("#"+t+" "+cango);
			
		}
	}
	static int[] dr = {-1,0,1,0}; // 시계	방향
	static int[] dc = {0,1,0,-1};
	public static class P{
		int r;
		int c;
		public P(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	//배열로 풀이
	/*private static void bfs() {
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] {start_r,start_c}); // 시작점
		map[start_r][start_c] =-1; //방문
		while(!qu.isEmpty()) { //방문할 지점이 있나?
			int[] cur=qu.poll();
			int cr=cur[0];
			int cc=cur[1];
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc)) continue;
				// 도착 유무 확인 후 계속 간다
				if(nr==final_r && nc==final_c) {
					cango=1;
					break;
				}
				// 계속 가는 조건
				if(map[nr][nc]==0) { // 방문 안했으면
					map[nr][nc]=-1;
					qu.offer(new int[] {nr,nc}); // 현재 위치
				}
			}
		}
	}*/
	
	//class로 풀이
	private static void bfs() {
		Queue<P> ps = new LinkedList<>();
		ps.offer(new P(start_r,start_c));
		map[start_r][start_c]=-1;
		
		while(!ps.isEmpty()) {
			P p=ps.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr == final_r && nc == final_c) {
					cango=1;
					break; // return도 됨
				}
				// 바깥인지?
				if(!check(nr,nc)) continue;
				// 갈수있으면서 안간 곳
				if(map[nr][nc]==0) {
					map[nr][nc]=-1;
					ps.offer(new P(nr,nc)); // 갈수 있는 곳 저장
				}
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
