import java.io.*;
import java.util.*;

public class BJ_11780_플로이드2 {
	static final int INF = 999999999;
	static class Bus{
		int start;
		int end;
		String path;
		int count;
		public Bus(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
			this.path="";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		ArrayList<Bus> bus = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j) map[i][j] = INF;
				bus.add(new Bus(i,j,0));
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(map[r][c]>cost) {
				map[r][c] = cost;
				bus.get((r-1)*N+(c-1)).count = 2;	
			}
		}
	
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i==k) continue;
				for (int j = 1; j <= N; j++) {
					if(k==j || i==j) continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						if(bus.get((i-1)*N+(j-1)).count==0) {
							bus.get((i-1)*N+(j-1)).count=2;	
							bus.get((i-1)*N+(j-1)).path ="";
						}
						bus.get((i-1)*N+(j-1)).path = bus.get((i-1)*N+(k-1)).path+" "+k+bus.get((k-1)*N+(j-1)).path;
						bus.get((i-1)*N+(j-1)).count =  bus.get((i-1)*N+(k-1)).count + bus.get((k-1)*N+(j-1)).count-1;
						map[i][j]=map[i][k]+map[k][j];						
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j]==INF)map[i][j]=0;
				sb.append(map[i][j]+" ");
			}sb.append("\n");
		}
		for (int i = 0; i < bus.size(); i++) {
			if(bus.get(i).count==0) {
				sb.append(0+"\n");
				continue;
			}
			else {
				sb.append(bus.get(i).count+" "+bus.get(i).start+bus.get(i).path+" "+bus.get(i).end+"\n");				
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
