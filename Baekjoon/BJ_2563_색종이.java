import java.util.Scanner;

public class BJ_2563_색종이 {
	static int[] dr = { -1, 0 };
	static int[] dc = { 0, 1 };
	static int[][] map;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int count = 0;
		map = new int[100][100];
		int x;
		int y;
		for (int t = 0; t < N; t++) {
			x = in.nextInt();
			y = in.nextInt();
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (map[i][j] == 1)
						continue;
					map[i][j] = 1;
					count++;

				}
			}
		}
		System.out.println(count);
	}
}