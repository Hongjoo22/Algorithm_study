import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 전혀모르겠음
public class BJ_12927_배수스위치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int N = s.length();
		int[] light = new int[N+1];
		int[] res = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			if(s.charAt(i-1)=='Y') light[i]=1;
			else light[i]=0;
		}
		
		for (int i = 1; i < N+1; i++) {
			res[i]=0;
		}
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if((light[i]^res[i])!=1) continue;
			for (int j = 1; i*j < N+1; j++) {
				res[i*j] = (res[i*j]==0?1:0);
			}
			count++;
		}
		if(Arrays.equals(light, res)) {
			System.out.println(count);
		}else {
			System.out.println((-1));
		}	
	}
}
