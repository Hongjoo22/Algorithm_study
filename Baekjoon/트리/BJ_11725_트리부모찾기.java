import java.io.*;
import java.util.*;

public class BJ_11725_트리부모찾기 {

	static int n;
	static int[] parents;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1]; // 각 노드마다 파생되게
		for (int i = 1; i <=n; i++) {
			list[i] = new ArrayList<>(); // 초기화
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);			
		}
		StringBuilder sb = new StringBuilder();
		parents = new int[n+1];
		dfs(1,0);	// 1부터 각 노드의 부모찾기
		for (int i = 2; i <= n; i++) {
			sb.append(parents[i]+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	private static void dfs(int start, int parent) {
		parents[start]=parent;		
		for (int i : list[start]) { // 각 노드마다 파생되는 노드들 탐색
			if(i != parent) dfs(i,start); // 
		}
	}

}
