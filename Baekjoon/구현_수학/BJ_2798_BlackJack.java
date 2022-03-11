import java.util.Scanner;

//서로다른 n개가 아니라서 완탐으로 푼다. N개의 수를 줄여가면서 3중 for문
public class BJ_2798_BlackJack {
	static int N,M;
	static int[] card;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();	
		card= new int[N];
		for (int i = 0; i < N; i++) {
			card[i]=in.nextInt();
		}
		int res=0;
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int j2 = j+1; j2 < N; j2++) {
					int tot=card[i]+card[j]+card[j2];
					if(tot > M) continue;
					if(res<tot) res=tot;				
				}
			}
		}
		System.out.println(res);
	}
}
