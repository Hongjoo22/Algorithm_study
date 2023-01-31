import java.io.*;
import java.util.*;

public class BJ_2098_외판원순회 {

	static final int INF = 99999999;
	static int N, END;
	static int[][] map, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		// - 가 << 보다 연산 우선순위가 높으므로 () 필수
		END = (1<<N) -1;
		map = new int[N][N];
		// 현재노드, 방문배열
		dp = new int[N][1<<N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 0번 노드부터 방문 시작, 0번 노드 방문 저장
		System.out.println(TSP(0,1));
	}
	private static int TSP(int now, int visited) {
		// 모든 노드를 방문했다면
		if(visited==END) {
			// 0번 노드로 갈 수 있으면 경로 반환
			if(map[now][0]!=0) return map[now][0];
			// 없으면 해당 방식으로 갈 수 없음
			else return INF;
		}
		
		// 이미 방문한 상태이면 그대로 반환
		if(dp[now][visited]!=0) return dp[now][visited];
		// 없으면 방문 탐색 시작
		dp[now][visited] = INF;
		
		for (int i = 0; i < N; i++) {
			// 갈수 없으면 pass
			if(map[now][i]==0) continue;
			// 방문한 노드이면 pass
			if((visited & (1<<i))!=0) continue;
			
			// 0~i 까지 방문한 최소비용
			int tmp = TSP(i, visited | 1<<i);
			// 최솟값 갱신
			dp[now][visited] = Math.min(dp[now][visited], map[now][i] + tmp);
		}
		
		// 답 출력
		return dp[now][visited];
	}

}
