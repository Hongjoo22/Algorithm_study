import java.util.Scanner;

public class Solution_7272_안경 {
	static String hole1 = "ADOPQR";
	static String hole2 = "CEFGHIJKLMNSTUVWXYZ";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			String st1 = in.next();
			String st2 = in.next();
			int min = 1000;
			int count = 0;
			boolean same = true;
			min = Math.min(st1.length(), st2.length());
			if (st1.length() != st2.length()) {
				same = false;
			}
			for (int i = 0; i < min; i++) {
				if ((hole1.contains(String.valueOf(st1.charAt(i))) && hole1.contains(String.valueOf(st2.charAt(i))))) {
					count++;
				}  if ((hole2.contains(String.valueOf(st1.charAt(i)))
						&& hole2.contains(String.valueOf(st2.charAt(i))))) {					
					count++;
				}  if (st1.charAt(i) == 'B' && st2.charAt(i) == 'B') {				
					count++;
				}
			}
			if(same && count!=min) {
				same=false;
			}
			System.out.println("#" + t + " " + (same ? "SAME" : "DIFF"));
		}
	}

}
