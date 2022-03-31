import java.util.Scanner;

public class BJ_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] d = new int[N+1];
		d[0] = 0;
		d[1] = 0;
		for (int i = 2; i <= N; i++) {
			if(i>=3 && i%3 == 0) { // 1 or 3
				d[i] = Math.min(d[i-1], d[i/3]) + 1;
			}
			if(i>=2 && i%2 ==0) { // 2 or 3
				int tmp = Math.min(d[i-1], d[i/2]) + 1;
				if(d[i]!=0) {
					d[i] = Math.min(d[i], tmp);
				}else {
					d[i] = tmp;
				}
			}
			if(i%2 != 0 && i%3 !=0) {
				int tmp = d[i-1]+1;
				if(d[i]!=0) {
					d[i] = Math.min(d[i], tmp);
				}else {
					d[i] = tmp;
				}
			}
		}
		System.out.println(d[N]);
	}
}
