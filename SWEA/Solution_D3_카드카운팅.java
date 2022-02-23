import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_카드카운팅 {

	static int[][] card;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			int len = s.length();
			card = new int[5][14]; //4+1 13+1
			
			for (int i = 0; i < len; i+=3) {
				String str = s.substring(i, i+3);
				char type = str.charAt(0);
				int num = Integer.parseInt(str.substring(1));
				switch(type) {
					case 'S': card[1][num]++; break;
					case 'D': card[2][num]++; break;
					case 'H': card[3][num]++; break;
					case 'C': card[4][num]++; break;
				}
			}
			int[] cntS = new int[5];
			boolean dup = true;
			for (int i = 1; i < 5; i++) {
				for (int j = 0; j < 14; j++) {
					if(card[i][j]>=2) dup = false;
					if(card[i][j]==1) cntS[i]++;
				}
			}
			StringBuilder sb= new StringBuilder();
			for (int i = 1; i < 5; i++) {
				sb.append((13-cntS[i])+" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println("#"+t+" "+(dup?sb:"ERROR"));
		}
	}

}
