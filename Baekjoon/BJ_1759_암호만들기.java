import java.util.Arrays;
import java.util.Scanner;

public class BJ_1759_암호만들기 {
	static StringBuilder sb;
	static int L,C;
	static char[] alp,res;
	static String mo = "aeiou";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		L=in.nextInt();
		C=in.nextInt();
		alp=new char[C];
		res= new char[L];
		for (int i = 0; i < C; i++) {
			alp[i]=in.next().charAt(0);
		}
		Arrays.sort(alp);
		combi(0,0);
	}
	private static void combi(int cnt, int start) {
			
		if(cnt==L) {
			if(check()) return;
			sb = new StringBuilder();
			for (int i = 0; i < L; i++) {
				sb.append(res[i]);
			}
			System.out.println(sb);
			return;
		}
		for (int i = start; i < C; i++) {
			res[cnt]=alp[i];
			combi(cnt+1,i+1);			
		}
	}
	private static boolean check() {
		int cnt=0;
		for (int i = 0; i < L; i++) {
			if(mo.contains(String.valueOf(res[i]))) cnt++;
		}
		int num = L-cnt; // 자음수
		return cnt==0 || (num<2); // 만족 못하면
	}

}
