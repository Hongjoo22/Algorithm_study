import java.util.Scanner;

public class BJ_3040_백설공주 {
	static int[] p;
	static int[] res;
	static int total;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		p = new int[9];
		res = new int[7];
		for (int i = 0; i < 9; i++) {
			p[i] = in.nextInt();
		}
		subset(0, 0);
	}

	private static void subset(int cnt, int start) {
		if (cnt == 7) {
			for (int i = 0; i < 7; i++) {
				total+=res[i];
			}
			if(total==100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(res[i]);
				}
				total=0;
				return;
			}
			total=0;
			return;
		}
		for (int i = start; i < 9; i++) {
			res[cnt]=p[i];
			subset(cnt+1,i+1);
		}
	}

}
