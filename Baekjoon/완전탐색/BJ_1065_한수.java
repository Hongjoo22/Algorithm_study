import java.util.Scanner;

public class BJ_1065_한수 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int answer = 0;
		go : for (int i = 1; i <= N; i++) {
			String str  = i+"";
			int before = 0;
			if(str.length()==1) {
				answer++;
				continue;
			}
			else before = (str.charAt(0)-'0')-(str.charAt(1)-'0');
			for (int j = 1; j < str.length()-1; j++) {
				if((str.charAt(j)-'0')-(str.charAt(j+1)-'0')!=before) continue go;
			}
			answer++;
		}
		System.out.println(answer);
	}

}
