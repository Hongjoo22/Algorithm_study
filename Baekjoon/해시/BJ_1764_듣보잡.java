import java.io.*;
import java.util.*;

public class BJ_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine().trim());
		}
		
		int count=0;
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine().trim();
			if(set.contains(str)) {
				count++;
				list.add(str);
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(count+"\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
	}
}
