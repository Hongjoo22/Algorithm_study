import java.io.*;
import java.util.*;

public class BJ_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		long sum = arr[0];
		int min = Integer.MAX_VALUE;
		
		while(s<=e) {
			if(S <= sum) {
				min = Math.min(min, e-s+1);
				if(min==1) break;
				s++;
				if(s>=N) break;		
				sum -= arr[s-1];
			}else {
				e++;
				if(e>=N) break;			
				sum += arr[e];
			}
		}
		
		System.out.println(min==Integer.MAX_VALUE? 0:min);
	}

}
