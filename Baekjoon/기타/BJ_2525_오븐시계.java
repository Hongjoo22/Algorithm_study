import java.io.*;
import java.util.*;

public class BJ_2525_오븐시계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		
		int plus = Integer.parseInt(br.readLine());
		
		int plus_hour = plus/60;
		int plus_min = plus - plus_hour*60;
		
		
		hour += plus_hour;
		min += plus_min;
		
		if(min>59) {
			min -= 60;
			hour++;
		}
		
		if(hour>23) {
			hour -= 24;
		}
		
		System.out.println(hour+" "+min);
	}

}
