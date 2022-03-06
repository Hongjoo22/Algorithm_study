import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_교환학생 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] days= new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < 7; i++) {
				days[i]=Integer.parseInt(st.nextToken());				
			}
			
			int min = Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) {
				if(days[start]==0) continue;
				int day = start, cnt=0;
				while(true) {
					if(days[day%7]==1) cnt++;
					++day;
					if(cnt==N) {
						min = Math.min(min, day-start);
						break;
					}
				}
			}					
			System.out.println("#"+t+" "+min);
		}
	}
}
