import java.util.Scanner;

public class JO_1329_별삼각형3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int m = in.nextInt();
		if (N >= 1 && N <= 100 && N % 2 == 1) {
			switch (m) {
			case 1:
				for (int i = 0; i < N; i++) {
					if (N / 2 >= i) {
						for (int j = 0; j < i + 1; j++) {
							System.out.print("*");
						}
					} else {
						for (int j = 0; j < N - i; j++) {
							System.out.print("*");
						}
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < N; i++) {
					if (N / 2 >= i) {
						for (int j = 0; j < N / 2 + 1; j++) {
							if (N / 2 - i > j)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					} else {
						for (int j = 0; j < N / 2 + 1; j++) {
							if (i - N / 2 > j)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0; i < N; i++) {
					if (N / 2 >= i) {
						for (int j = 0; j < N-i; j++) {
							if (j < i)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					} else {
						for (int j = 0; j <= i; j++) {
							if (j < N-1-i)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					}
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < N; i++) {
					if (N / 2 >= i) {
						for (int j = 0; j <= N/2; j++) {
							if (j < i)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					} else {
						for (int j = 0; j <= i; j++) {
							if (j < N/2)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					}
					System.out.println();
				}
				break;
			default:
				System.out.println("INPUT ERROR!");
				break;
			}
		} else {
			System.out.println("INPUT ERROR!");
		}

	}

}
