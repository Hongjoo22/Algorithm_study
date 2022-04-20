import java.io.*;
import java.util.StringTokenizer;

public class BJ_1780_종이의개수 {

	static int N,minus,zero,plus;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N =  Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		minus=zero=plus=0;
		divide(0,0,N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	private static void divide(int r, int c, int size) {
		int tmp = map[r][c];
		boolean cango = true;
		out: for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(map[i][j]!=tmp) {
					cango = false;
					break out;
				}
			}
		}
		if(cango && tmp==0) {
			zero++;
			return;
		}else if(cango && tmp==1) {
			plus++;
			return;
		}else if(cango && tmp==-1) {
			minus++;
			return;
		}else {
			int cur = size/3;
			divide(r,c,cur);
			divide(r,c+cur,cur);
			divide(r,c+cur*2,cur);
			
			divide(r+cur,c,cur);			
			divide(r+cur,c+cur,cur);
			divide(r+cur,c+cur*2,cur);
			
			divide(r+cur*2,c,cur);			
			divide(r+cur*2,c+cur,cur);
			divide(r+cur*2,c+cur*2,cur);
		}
	}

}
