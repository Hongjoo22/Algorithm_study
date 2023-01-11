import java.math.*;
import java.util.*;

public class BJ_2407_조합 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		BigInteger answer = BigInteger.ONE;
		long down = 1;
		
		for (int i = n; i > n-m; i--) {
			if(down > m) {
				answer = answer.multiply(BigInteger.valueOf(i));
			}else { 
				answer = answer.multiply(BigInteger.valueOf(i));
				answer = answer.divide(BigInteger.valueOf(down++));
			}
		}
		
		System.out.println(answer);
	}
}
