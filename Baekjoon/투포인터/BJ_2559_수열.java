import java.io.*;
import java.util.*;

public class BJ_2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = s+K;
		int sum = 0;
		
		for (int i = s; i < e; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		while(e<arr.length) {
			
			sum += arr[e++];
			sum -= arr[s++];
					
			max = Math.max(max,sum);			
		}
		
		System.out.println(max);
	}

}
