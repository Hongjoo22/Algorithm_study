import java.io.*;
import java.util.*;

public class BJ_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum+=i;
		}
		long[] arr = new long[sum];
		long[] D = new long[sum];
		int index=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j <= i; j++) {
				arr[index++] = Integer.parseInt(st.nextToken());
			}
		}
		D[0] = arr[0];
		long max = D[0];
		if(N>1) D[1] = arr[0] + arr[1];
		if(N>1) D[2] = arr[0] + arr[2];
		if(N>1) {
			max = Math.max(max, D[1]);
			max = Math.max(max, D[2]);
		}
		index=3;
		for (int i = 2; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j==0) D[index] = D[index-i] + arr[index];
				else if(j!=0 && j!=i) D[index]  = Math.max(D[index-i], D[index-i-1])+arr[index];
				else if(j==i) D[index] = D[index-i-1] + arr[index];
				max = Math.max(max,D[index]);
				index++;
			}
		}
		System.out.println(max);
	}
}
