import java.io.*;
import java.util.*;

public class BJ_1931_회의실배정 {

	public static class Room implements Comparable<Room>{
		long start;
		long end;
		public Room(long start, long end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Room room) {
			// 시작시간과 끝나는 시간이 같을 수도 있기 때문에 start가 앞에 있을 수록 유리
			if(this.end==room.end) return (int)  (this.start - room.start);
			else return (int) (this.end-room.end);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Room> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Room(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));			
		}
		
		int answer = 0;
		long before = 0;
		while(!pq.isEmpty()) {
			Room room = pq.poll();
			
			if(room.start>=before) {
				answer++;
				before = room.end;
			}
		}
		
		System.out.println(answer);
	}

}
