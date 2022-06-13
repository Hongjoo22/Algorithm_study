import java.io.*;
import java.util.*;

public class BJ_10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int tmp =Integer.parseInt(st.nextToken());
			if(set.contains(tmp)) sb.append(1+" ");
			else sb.append(0+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
