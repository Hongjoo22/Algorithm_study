import java.io.*;
import java.util.*;

public class BJ_2609_최대공약수와_최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int a = Integer.parseInt(str.split(" ")[0]);
		int b = Integer.parseInt(str.split(" ")[1]);
		
		// 유클리드 호제법
		// 최대 공약수 - GCD (단, a>b이어야 한다) 그러나 b가 더 커도 결국에는 큰 값이 앞에 가게 되어있다.
		int gcd = GCD(a,b);
		System.out.println(gcd);
		// 최소 공배수 - LCM (두 수의 곱 / 최대 공약수)
		System.out.println(a*b/gcd);
	}


	private static int GCD(int a, int b) {
		if(b==0) return a;
		else return GCD(b, a%b);
	}

}
