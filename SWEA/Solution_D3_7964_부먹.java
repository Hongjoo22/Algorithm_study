import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7964_부먹 {

	static int N,D;
	static int[] city;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			city = new int[N+2];
			city[0]=city[N+1]=1;
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 1; i < N+1; i++) {
				city[i]= Integer.parseInt(st.nextToken());
			}
			int count = 0;
			int cnt_0 = 0;
			for (int i = 1; i <= N; i++) {
				if(city[i]==1) {
					cnt_0=0;
					continue;
				}
				if(city[i]==0) {
					++cnt_0;
					if(cnt_0==D) {
						city[i]=1;
						count++;
						cnt_0=0;
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}

}
