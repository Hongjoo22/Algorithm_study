import java.util.Scanner;

public class BJ_9663_NQueen {
	static int N, ans;
	static int[] col;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		ans=0;
		col = new int[N+1];
		setQueen(1);
		
		System.out.println(ans);
	}
	private static void setQueen(int rowNo) {
		if(!cango(rowNo-1)) return;
		
		if(rowNo>N) {
			ans++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	private static boolean cango(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if(col[i]==col[rowNo] || rowNo -i == Math.abs(col[i]-col[rowNo]))return false;
		}
		return true;
	}
}
