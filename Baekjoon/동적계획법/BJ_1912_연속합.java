import java.io.*;
import java.util.*;

public class BJ_1912_연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[N+1];
		D[1] = arr[1];
		int max= D[1];
		int tmp=0;
		for (int i = 2; i <= N; i++) {
			if(tmp+arr[i-1]>0) tmp+=arr[i-1];
			else tmp=0;
			D[i] = Math.max(tmp+arr[i], D[i-1]);
			max = Math.max(max, D[i]);
		}
//		System.out.println(Arrays.toString(D));
		System.out.println(max);
	}
}
