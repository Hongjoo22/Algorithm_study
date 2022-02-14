import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 교수님 풀이
public class BJ_20304_비밀번호제작 {
	static int N, M; // 입력받을 변수 선언
	static int[] P;
	static int max;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		P=new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			P[i]=Integer.parseInt(st.nextToken());
		}
		max=Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			int min = Integer.MAX_VALUE;
			for (int m = 0; m < M; m++) {
				
				int tr=0;
				int xor=n^P[m];
				for (int b = 1; b <= N; b<<=1) { //2진수 계산
					if((xor & b)>0) tr++;
				}
				if(min>tr) min = tr;
				//min = Math.min(min, tr);
			}
			if(max<min) max=min;
			
		}
		System.out.println(max);
	}

}
