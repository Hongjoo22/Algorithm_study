import java.io.*;
import java.util.*;

public class BJ_2342_DDR {

	static int number;
	static ArrayList<Integer> list;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			number = Integer.parseInt(st.nextToken());
			if(number==0) break;
			list.add(number);
		}
		dp = new int[5][5][list.size()];
		System.out.println(dfs(0,0,0));
	}
	
	// 발이 l,r에 있을 때 드는 최소 비용
	private static int dfs(int l, int r, int n) {
		if(n==list.size()) return 0;
		// 이미 최적화 되어있으면 해당 값 return
		if(dp[l][r][n]!=0) return dp[l][r][n]; 
		// l->n 움직였을때 드는 왼쪽 힘 + n번째 발판부터 밟았을떄의 최솟값 ,  r->n 움직였을때 드는 오른쪽 힘 + n번째 발판부터 밟았을떄의 최솟값
		return dp[l][r][n] = Math.min(dfs(list.get(n),r,n+1)+power(l,list.get(n)) , dfs(l,list.get(n),n+1)+power(r,list.get(n)));
	}
	private static int power(int from, int to) {
		if(from == to) return 1;
		else if(from == 0) return 2;
		else if((from+to)%2==1) return 3;
		else return 4;
	}

}
