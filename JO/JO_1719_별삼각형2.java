import java.util.Scanner;

public class JO_1719_별삼각형2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		if (N >= 1 && N <= 100 && N % 2 == 1) {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < i * 2 + 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i <= N / 2; i++) {
				for (int j = 0; j < N/2 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < N-i*2; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("INPUT ERROR!");
		}

	}
}
