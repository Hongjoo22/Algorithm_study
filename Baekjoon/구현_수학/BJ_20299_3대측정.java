import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 

public class BJ_20299_3대측정{

	static int N, S, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S =  Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(st.nextToken());
		
		int[] stu = new int[3]; 
		int[] res = new int[3*N]; 
 		int count=0;
 		int index=0; 
		for (int i = 0; i < N; i++) { 
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				stu[j] = Integer.parseInt(st.nextToken());
			}
			int sum = stu[0]+stu[1]+stu[2];
			if(sum>=S && stu[0]>=M && stu[1]>=M && stu[2]>=M) { 
				count++; 
				res[index++] = stu[0]; 
				res[index++] = stu[1]; 
				res[index++] = stu[2]; 
			}
		}
		System.out.println(count); 
		for (int i = 0; i < 3*N; i++) { 
			if(res[i]!=0) sb.append(res[i]+" ");			 
		}
		System.out.println(sb);
	}

}
