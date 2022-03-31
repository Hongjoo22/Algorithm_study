import java.io.*;
import java.util.*;

public class BJ_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K  = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		int max = -1;
		for (int i = 0; i < K; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(max<arr[i]) max = arr[i];
		}
		int low = 0;
		int high = max+1; // 여기 중요 mid가 0일때 고려
		int sum = 0;
		while(low<high) {
			sum = 0;
			int mid = (low+high)/2;
			for (int i = 0; i < K; i++) {
				sum+=arr[i]/mid;
			}
			if(sum>N-1) {
				low = mid+1;
			}
			else high=mid;
		}
		System.out.println(high-1);
	}
}
