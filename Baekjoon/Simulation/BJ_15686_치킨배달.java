import java.io.*;
import java.util.*;

public class BJ_15686_치킨배달 {

	static int N, M, total, mini;
	static ArrayList<int[]> chicken, home, list;
	static int[] res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		res = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int map = Integer.parseInt(st.nextToken());
				if(map==2) chicken.add(new int[] {i,j});
				else if(map==1) home.add(new int[] {i,j});
			}
		}
		mini = Integer.MAX_VALUE;
		combi(0,0);
		System.out.println(mini);
	}
	private static void combi(int cnt, int start) {
		if(cnt==M) {
			list = new ArrayList<>();
			for (int i = 0; i < res.length; i++) {
				list.add(new int[] {chicken.get(res[i])[0],chicken.get(res[i])[1]}); // 해당 치킨 위치
			}
			int tmp = test(list);
			mini = Math.min(tmp, mini);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			res[cnt] = i;
			combi(cnt+1,i+1);
		}
	}
	private static int test(ArrayList<int[]> list) {
		// 모든 치킨거리의 합
		int count=0;
		for (int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < list.size(); j++) {
				// 각 집과 치킨집의 거리
				int tmp = Math.abs(home.get(i)[0]-list.get(j)[0])+Math.abs(home.get(i)[1]-list.get(j)[1]);
				min = Math.min(min, tmp);
			}
			count += min;
		}
		return count;
	}
}
