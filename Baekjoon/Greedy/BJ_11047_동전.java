import java.io.*;
import java.util.*;

public class BJ_11047_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		int res = K;
		out: for (int i = N-1; i >=0; i--) {
			if(res>=arr[i]) {
				while(res>=0) {
					res-=arr[i];
					count++;
				}
				if(res==0) break out;
				if(res!=0) {
					res +=arr[i];
					count--;
				}				
			}
		}
		System.out.println(count);		
	}
}
