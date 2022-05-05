import java.io.*;
public class BJ_2156_포도죽시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] wine = new int[N];
		long[][] D = new long[N][2]; // 앞에서부터
		for (int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
				
		D[0][0] = wine[0];
		D[0][1] = 1;
		
		long max = wine[0];
		
		if(N>1) {
			D[1][0] = D[0][0]+wine[1];
			D[1][1] = 2;
			max = D[1][0];
		}
		
		if(N>2) {
			D[2][0] = Math.max(D[0][0]+wine[2],D[1][0]);
			D[2][0]= Math.max(wine[1]+wine[2],D[2][0]);
			if(D[2][0] == D[1][0]) D[2][1] = 0; // 안먹었을때
			else if(D[2][0] == D[0][0]+wine[2]) D[2][1] = 1;
			else  D[2][1] = 2;		
			max = Math.max(max, D[2][0]);
		}
		
		for (int i = 3; i < N; i++) {
			if(D[i-1][1]==2) { // 연속 불가능
				D[i][0] = Math.max(D[i-1][0], D[i-2][0]+wine[i]);
				D[i][0] = Math.max(D[i][0], D[i-3][0]+wine[i]+wine[i-1]);
				if(D[i][0] == D[i-1][0]) D[i][1] = 0; // 안먹는게 크다면
				else if(D[i][0] ==  D[i-2][0]+wine[i]) D[i][1] = 1; // 먹는게 크다면
				else D[i][1] =2;
			}else {
				D[i][0] = Math.max(D[i-1][0]+wine[i], D[i-2][0]+wine[i]);
				if(D[i][0] == D[i-1][0]+wine[i]) D[i][1] =  D[i-1][1]+1; // 연속2
				else D[i][1] = 1; // 먹는게 크다면
			}			
			max = Math.max(max, D[i][0]);
		}
		
		System.out.println(max);
	}

}
