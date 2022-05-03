import java.io.*;
import java.util.*;

public class BJ_2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] person = new int[N+1]; // 자신과 직접 비교했을때 작은 사람들 수를 알기위해
		
		// 각 사람들의 비교군을 위해 2차원 arraylist 초기화
		ArrayList<ArrayList<Integer>> height = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N+1; i++) {
			height.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			person[b]++; // a<b b입장에서 자신보다 바로 아래 작은 사람들 수를 알기위해
			height.get(a).add(b); // arraylist에 a와 b가 비교한 값을 넣는다
		}
		
		Queue<Integer> qu = new LinkedList<Integer>(); // 위상정렬에 사용할 큐
		
		for (int i = 1; i < N+1; i++) {
			if(person[i]==0) qu.add(i); // 자신보다 작은놈이 하나도 없으면 제일 작은거임
		}
		
		StringBuilder sb = new StringBuilder();
		while(!qu.isEmpty()) {
			int tmp = qu.poll(); // 작은순서대로 뺀다
			sb.append(tmp+" ");
			List<Integer> list = height.get(tmp); // 빠진놈 기준으로 비교했던 애들 list 갱신
			for (int i = 0; i < list.size(); i++) {
				person[list.get(i)]--; // 화살표 하나씩 빼는거
				if(person[list.get(i)]==0) qu.add(list.get(i)); // 이떄 다시 0이면 제일 작으므로 큐에 삽입
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
