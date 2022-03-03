import java.util.Scanner;

public class JO_1523_별삼각형1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int m = in.nextInt();
		if (N >= 1 && N <= 100) {
			switch (m) {
			case 1:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < i + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = N; i > 0; i--) {
					for (int j = 0; j < i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < N; i++) {
					for (int j = 1; j <= N+i; j++) {
						if(j<N-i)System.out.print(" ");
						else System.out.print("*");
					}System.out.println();
				}
				break;
			default:
				System.out.println("INPUT ERROR!");
				break;
			}
		}else {
			System.out.println("INPUT ERROR!");
		}

	}

}
