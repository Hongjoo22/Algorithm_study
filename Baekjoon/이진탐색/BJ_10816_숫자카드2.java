import java.io.*;
import java.util.*;

public class BJ_10816_숫자카드2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			int start = lower_bound(arr,x,N);
			int end = upper_bound(arr, x, N);	
			sb.append((end-start)+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static int lower_bound(int[] arr, int x, int n) { // 원하는 x값 이상이 처음 나오는 위치 찾기
		int mid=0,low = 0;
		int high = arr.length-1;
		while(low<high) {
			mid = (low+high)/2;
			if(arr[mid]>=x) high=mid;
			else low=mid+1;
		}
		return high;
	}
	private static int upper_bound(int[] arr, int x, int n) {// 원하는 x값 초과값 처음 나오는 위치 찾기
		int mid=0,low = 0;
		int high = arr.length-1;
		while(low<high) {
			mid = (low+high)/2;
			if(arr[mid]>x) high=mid;
			else low=mid+1;
		}
		if(high==arr.length-1 && arr[high]==x) high++; // 조건추가 조심!!
		return high;
	}
}
