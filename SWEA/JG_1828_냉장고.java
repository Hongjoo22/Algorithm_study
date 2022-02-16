import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JG_1828_냉장고 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[][] c = new int[N][2];
		for (int i = 0; i < N; i++) {
			c[i][0] = in.nextInt();// 최저
			c[i][1] = in.nextInt();// 최고
		}
		Arrays.sort(c, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int min = c[0][1];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if (c[i][0] > min) {
				min=c[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
