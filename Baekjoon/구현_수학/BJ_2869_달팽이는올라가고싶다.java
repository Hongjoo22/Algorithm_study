import java.io.*;
import java.util.*;

public class BJ_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		// answer * A - (answer-1)*B >= V
		// answer(A-B)>=V-B
		// answer >= (V-B)/(A-B)
		int answer = (V-B)/(A-B);
		// 정확히 안나누어 떨어지면 +1 해서 하루 더 간다
		if((V-B)%(A-B)!=0) answer++;
		
		System.out.println(answer);
	}

}
