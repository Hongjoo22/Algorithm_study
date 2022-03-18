import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int min = Integer.MAX_VALUE;
			// c1->c2, r1-> r2
			boolean hori,verti;
			int count=0;
			int tmpr1=r1, tmpc1=c1;
			while(true) {
				if(count%2==0) {
					hori = true;
					verti = false;
				}else {
					hori = false;
					verti = true;
				}
				
				if(tmpr1==r2 && tmpc1==c2) {
					min = Math.min(min, count);
					break;
				}
				//가로이동
				if(tmpr1<r2 && verti) { //오른쪽
					tmpr1++;
					count++;
					continue;
				}else if(tmpr1>=r2 && verti) { //left
					tmpr1--;
					count++;
					continue;
				}
				//세로이동
				if(tmpc1<c2 && hori) { // top
					tmpc1++;
					count++;
					continue;
				}else if(tmpc1>=c2 && hori) { // bottom
					tmpc1--;
					count++;
					continue;
				}
			}
			count=0;
			tmpr1=r1;
			tmpc1=c1;
			while(true) {
				if(count%2==1) {
					hori = true;
					verti = false;
				}else {
					hori = false;
					verti = true;
				}
				
				if(tmpr1==r2 && tmpc1==c2) {
					min = Math.min(min, count);
					break;
				}
				//가로이동
				if(tmpr1<r2 && verti) { //오른쪽
					tmpr1++;
					count++;
					continue;
				}else if(tmpr1>=r2 && verti) { //left
					tmpr1--;
					count++;
					continue;
				}
				//세로이동
				if(tmpc1<c2 && hori) { // top
					tmpc1++;
					count++;
					continue;
				}else if(tmpc1>=c2 && hori) { // bottom
					tmpc1--;
					count++;
					continue;
				}
			
			}
			System.out.println("#"+t+" "+min);
		}
	}

}
