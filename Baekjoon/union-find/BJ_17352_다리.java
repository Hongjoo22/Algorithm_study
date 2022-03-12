import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17352_다리 {

	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a,b;		
		int N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parents[i]=i;
		}
		for (int i = 0; i < N-2; i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int cnt=0;
		int tmp=0;
		for (int i = 1; i < N+1; i++) {
			if(find(i)==i && cnt==1) { 
				System.out.println(tmp+" "+i);
			}else if(find(i)==i && cnt==0) {
				cnt++;
				tmp = i;
			}			
		}
	}

	private static int find(int x) {
		if(x==parents[x]) return parents[x];
		else return parents[x] = find(parents[x]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);	
		if(a==b) return;
		parents[b]=a;
	}
}
