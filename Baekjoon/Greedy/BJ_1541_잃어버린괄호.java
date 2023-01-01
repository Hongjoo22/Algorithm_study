import java.io.*;
import java.util.*;

public class BJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		int answer = 0;
		
		// -가 하나라도 있을때 맨 앞에 있는 -를 기준으로 앞에 숫자는 모두 더하고 
		StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");
		while(plus.hasMoreTokens()) {
			answer +=  Integer.parseInt(plus.nextToken());				
		}
		
		// 뒤에 숫자는 모두 빼준다.
		while(st.hasMoreTokens()) {
		    plus = new StringTokenizer(st.nextToken(),"+");
			while(plus.hasMoreTokens()) {
				answer -= Integer.parseInt(plus.nextToken());				
			}
		}		
		System.out.println(answer);		
	}
}
