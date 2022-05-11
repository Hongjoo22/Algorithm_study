import java.io.*;
import java.util.*;

public class BJ_3190_뱀 {

	static class Dir{
		int time; // 시간
		char dr; // 방향
		public Dir(int time, char dr) {
			super();
			this.time = time;
			this.dr = dr;
		}
	}
	static int N,K,L,res;
	static int[][] map;
	static int[] dr = {0,1,0,-1}; // 오른쪽부터 시계방향
	static int[] dc = {1,0,-1,0};
	static ArrayList<Dir> list;
	static Queue<Integer> qu;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // 격자판크기
		K = Integer.parseInt(br.readLine()); // 사과 개수
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		L = Integer.parseInt(br.readLine()); // 변환횟수
		list = new ArrayList<>();
		qu = new LinkedList<Integer>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Dir(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
		}
		res = 0;
		map[0][0] = 2; // 뱀위치	
		int r=0,c=0,time=0,d=0,sr=0,sc=0;
		while(true) {			
			if(list.size()>0 && list.get(0).time == time) {
				if(list.get(0).dr =='D') d = (d+1)%4; // 시계방향
				else if(list.get(0).dr =='L') {
					d = ((d-1)%4 < 0 ? (d-1)%4+4 : (d-1)%4); // 반시계방향
				}
				list.remove(0); // 사라지면 인덱스는 0으로 자동갱신
			}
			qu.add(d); //꼬리위치+방향	
			int nr = r + dr[d]; // 머리 위치 정하기
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=N ||map[nr][nc]==2) {
				res = time+1;
				break;
			}
			if(map[nr][nc]==1) { // 사과라면
				map[nr][nc] = 2;
				r = nr;
				c = nc;
				time++;
			}else if(map[nr][nc]==0) {
				map[nr][nc] = 2;
				map[sr][sc] = 0;	
				int tmp = qu.poll();
				r = nr;
				c = nc;
				time++;
				sr += dr[tmp];
				sc += dc[tmp];
			}		
		}
		System.out.println(res);
	}
}
