import java.io.*;

public class BJ_2581_소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] v = new boolean[N+1];
		v[1] = true;
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if(i*j>N) break;
				v[i*j] = true;
			}
		}
		
		int min = Integer.MAX_VALUE;
		long sum = 0;
		
		for (int i = M; i <= N; i++) {
			if(!v[i]) {
				min = Math.min(min, i);
				sum += i;
			}
		}
		
		if(sum==0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
