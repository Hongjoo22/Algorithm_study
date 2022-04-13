import java.io.*;
import java.util.*;

public class BJ_17143_낚시왕 {

	static class Shark{
		int r,c,s,d,z; // 위치, 속력, 이동방향, 크기
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}		
	}
//	static int R,C,M;
//	static ArrayList<Shark> shark;
//	static Shark[][] map;
//	static Shark[][] move;
//	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Shark> shark = new ArrayList<>();
		Shark[][] map = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 사이즈
			shark.add(new Shark(r,c,s,d,z));
			map[r][c] = new Shark(r,c,s,d,z);
		}
		int location = 0;
		int total = 0;
		while(location!=C) {
			// 해당칼럼 상어탐색 후 있다면 잡기
			for (int r = 0; r < R; r++) {
				if(map[r][location]!=null) {
					Shark sh = map[r][location];
					total += sh.z;
					map[r][location] = null;
					for (int i = 0; i < shark.size(); i++) {
						if(shark.get(i).z==sh.z) {
							shark.remove(i);
							break;
						}
					}
					break;
				}
			}
			if(location==C-1) break;
			// 상어 이동			
			Shark[][] move = new Shark[R][C];
			int size = shark.size();
			for (int i = size-1; i >=0 ; i--) {
				Shark sh = shark.get(i);
				for (int k = 0; k < sh.s; k++) {
					if(sh.d==1) { // 위
						if(sh.r>0) {
							sh.r--;	
							sh.d=1;
						}
						else { 
							sh.r++;
							sh.d=2;
						}						
					}else if(sh.d==2) { // 아래
						if(sh.r<R-1) {
							sh.r++;	
							sh.d=2;
						}
						else {
							sh.r--;
							sh.d=1;
						}						
					}else if(sh.d==3) { // 오른쪽
						if(sh.c < C-1) {
							sh.c++;	
							sh.d = 3;
						}
						else {
							sh.c--;
							sh.d = 4;
						}						
					}else if(sh.d==4) { // 왼쪽
						if(sh.c > 0 ) {
							sh.c--;	
							sh.d = 4;
						}
						else {
							sh.c++;
							sh.d = 3;
						}
					}				
				}
				if(move[sh.r][sh.c]==null) move[sh.r][sh.c] = sh;
				else {
					if(move[sh.r][sh.c].z<sh.z) { // 큰 놈이 잡아먹기
						 for (int j = 0; j < shark.size(); j++) {
							if(shark.get(j).z==move[sh.r][sh.c].z) {
								shark.remove(j);
								break;
							}
						 }
						 move[sh.r][sh.c] = sh;
					}else {
						shark.remove(i); // 작으면 잡아먹힘
					}
				}
			}
			for (int i = 0; i < R; i++) {
				System.arraycopy(move[i], 0, map[i], 0, C);
			}
			// 이동
			location++;
		}
		shark.clear();
		System.out.println(total);
	}
}
