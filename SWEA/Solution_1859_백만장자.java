import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] money = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			int max=-1;
			for (int i = 0; i < N; i++) {				
				money[i]=Integer.parseInt(st.nextToken());
				if(money[i]>max) max = money[i];
			}
			long count=0;
			long res=0;
			long sum=0;
			for (int i = 0; i < N; i++) {
				if(money[i]<max) {
					count++;
					sum+=money[i];						
				}else if(money[i]==max) {
					res+=money[i]*count-sum;
					count=0;
					sum=0;
					max=-1;
					for (int j = i+1; j < N; j++) {
						if(money[j]>max) max = money[j];
					}
				}
			}			
			System.out.println("#"+t+" "+res);
		}
	}
}