import java.util.Scanner;

public class BJ_2562_최댓값 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[10];
		int max =-1;
		int max_i=0;
		for (int i = 1; i <= 9; i++) {
			arr[i] = in.nextInt();
			if(max<arr[i]) {
				max = arr[i];
				max_i = i;
			}
		}
		System.out.println(max);
		System.out.println(max_i);
	}

}
