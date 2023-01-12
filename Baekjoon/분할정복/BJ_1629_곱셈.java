import java.util.*;

public class BJ_1629_곱셈 {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long A = in.nextLong();
		long B = in.nextLong();
		long C = in.nextLong();
		System.out.println(pow(A,B,C));
	}

	private static long pow(long a, long b,long c) {
		if(b==0) return 1;
		
		long res = pow(a,b/2,c);
		
		if(b%2==0) return (res*res) % c;
		else return (((res*res)%c)*a) % c;
	}
}
