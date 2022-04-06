import java.io.*;
import java.util.*;

public class BJ_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		int[] D = new int[N];
		int[] D2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		D[0] = 1;
		for (int i = 1; i < N; i++) {
			int max = -1;
			for (int j = 0; j <= i; j++) {
				if (arr[i] > arr[j]) {
					max = Math.max(D[j], max);
				}
			}
			if (max == -1) D[i] = 1;
			else D[i] = max + 1;		
		}
		D2[0]=1;
		for (int i = N-2; i >=0 ; i--) {
			int max = -1;
			for (int j = N-1; j >= i+1; j--) {
				if (arr[i] > arr[j]) {
					max = Math.max(D2[N-j-1], max);
				}
			}
			if (max == -1) D2[N-i-1] = 1;
			else D2[N-i-1] = max + 1;		
		}
		int res=0;
		for (int i = 0; i < N; i++) {
			res = Math.max(res, D[i]+D2[N-i-1]-1);
		}
		System.out.println(res);
	}
}
