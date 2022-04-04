import java.io.*;
import java.util.*;

// 이진탐색활용
public class BJ_12015_가장긴증가하는수열2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		int[] D = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(D, 0, size, arr[i]);	
			if(temp>=0) continue; // 중복값처리
			temp = Math.abs(temp)-1;
			D[temp] = arr[i];
			if(size==temp) {
				size++;
			}
		}
		System.out.println(size);
	}
}
