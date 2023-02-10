import java.io.*;
import java.util.*;

public class BJ_2467_용액 {

	static int N;
	static long[] arr, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		answer = new long[2];
		StringTokenizer st = new  StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = N-1;
		long min = Long.MAX_VALUE;
		
		while(s<e) {
			long tmp = arr[s]+arr[e];
			
			if(Math.abs(tmp) < min) {
				min = Math.abs(tmp);
				answer[0] = arr[s];
				answer[1] = arr[e];
			}
			
			if(tmp==0) {
				answer[0] = arr[s];
				answer[1] = arr[e];
				break;
			}else if(tmp>0) e--;
			else s++;	
		}
		
		System.out.println(answer[0]+" "+answer[1]);
	}

}
