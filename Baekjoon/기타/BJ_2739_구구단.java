import java.util.Scanner;

public class BJ_2739_구구단 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			sb.append(N+" * "+i+" = "+N*i+"\n");
		}
		System.out.print(sb.toString());
	}

}
