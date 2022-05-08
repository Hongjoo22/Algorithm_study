import java.io.*;
import java.util.*;

public class BJ_2565_전깃줄 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] arr = new int[501]; 
		int[] D = new int[501]; // 최소개수
		int[] Lis = new int[501]; // 최장수열
		int N = Integer.parseInt(br.readLine()); // 전봇대 개수
		int max_idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[tmp] = value;
			max_idx = Math.max(max_idx,  tmp); // 여기까지만 해도 답이 나오기 때문
		}
		Lis[0]=0;
		for (int i = 1; i <= max_idx; i++) {
			int cnt=1;
			for (int j = 1; j < i; j++) {
				if(arr[i]==0) break;
				if(arr[i]<=arr[j]) continue; // 현재의 길이가 더 클때만 Lis 가능
				cnt = Math.max(cnt,Lis[j]+1); // 최장 수열 구하기
			}
			if(arr[i]==0) cnt=0;
			Lis[i] = cnt;
		}
		D[1]=0; // 초반에는 안없애도 된다
		int count=0; // 배열의 인덱스 까지의 전깃줄 개수를 세기위한 변수
		if(arr[1]!=0) count++; // 1부터 있다면 +1해준다
		for (int i = 2; i <= max_idx; i++) {
			if(arr[i]==0) {
				D[i] = D[i-1]; // 전깃줄 없으면 그전까지의 답이 최적의 답
				continue;
			}
			count++; // 전깃줄 있는 인덱스이니 +1해준다
			D[i] = Math.min(D[i-1]+1, count-Lis[i]); // 현재를 제거하고 최소값 vs 현재를 포함하고 현재까지의 전깃줄 개수-최장수열 의 최소값
		}
		System.out.println(D[max_idx]);
	}
}
