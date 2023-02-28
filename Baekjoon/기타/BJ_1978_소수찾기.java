import java.io.*;
import java.util.*;

public class BJ_1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		final int max = 1000;
		boolean[] arr = new boolean[max+1];
		// 1은 소수가 아니다
		arr[1] = true;
		
		for (int i = 2; i <= max; i++) {
			// 2부터!
			for (int j = 2; j <= max/2; j++) {
				if(i*j > max) break;
				arr[i*j] = true;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(!arr[x]) answer++;
		}
		
		System.out.println(answer);
	}

}
