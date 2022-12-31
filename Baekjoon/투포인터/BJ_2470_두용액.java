import java.io.*;
import java.util.*;

public class BJ_2470_두용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		
		int s = 0;
		int e = N-1;
		
		int[] answer = new int[2];
		while(s<e) {
			int diff =  Math.abs(arr[s]+arr[e]);
			if(min>diff) {
				min = diff;
				answer[0] = arr[s];
				answer[1] = arr[e];
			}
			if(arr[s]+arr[e]==0) {
				answer[0] = arr[s];
				answer[1] = arr[e];
				break;
			}else if(arr[s]+arr[e] < 0) s++;
			else e--;
		}
		System.out.println(answer[0]+" "+answer[1]);
	}

}
