import java.util.Scanner;

public class BJ_8320_직사각형 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int count=0; 		
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if(i*j>N) break;
				if(i*j<=N) count++;
			}
		}
		System.out.println(count);
	}
}
