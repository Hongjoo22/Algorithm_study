import java.io.*;
import java.util.*;

public class BJ_3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int count = 0;
		
		int s = 0;
		int e = N-1;
		while(s<e) {
			if(x==arr[s]+arr[e]) { 
				count++;
				s++;
				e--;
			}
			else if(x>arr[s]+arr[e]) s++;
			else e--;
		}
		
		System.out.println(count);
	}
}
