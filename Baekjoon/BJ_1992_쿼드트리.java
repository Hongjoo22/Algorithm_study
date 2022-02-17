import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = cs[j]-'0';
			}
		}
		cut(0,0,N);
		
	}
	private static void cut(int r, int c, int size) {
		int sum=0;
		for (int i = r; i <r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum+=map[i][j];
			}
		}
		
		if(sum == size*size) {
			System.out.print("1");
			
		}else if(sum==0) {
			System.out.print("0");	
		}else {
			int now=size/2;
			System.out.print("(");
			cut(r,c,now);
			cut(r,c+now,now);
			cut(r+now,c,now);
			cut(r+now,c+now,now);
			System.out.print(")");			
		}
	}

}
