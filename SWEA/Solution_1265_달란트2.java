import java.io.*;
import java.util.*;

public class Solution_1265_달란트2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T= Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			long cnt=P;
			long res=1;
			while(cnt!=0) {
				long tmp = N/cnt--;
				N-=tmp;
				res*=tmp;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
