import java.io.*;
import java.util.*;

public class BJ_10814_나이순정렬 {

	static class Person implements Comparable<Person>{
		int age;
		String name;
		int regtime;
		public Person(int age, String name, int regtime) {
			super();
			this.age = age;
			this.name = name;
			this.regtime = regtime;
		}
		@Override
		public int compareTo(Person o) {
			if(this.age == o.age) return this.regtime - o.regtime;
			return this.age-o.age;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Person> pq = new PriorityQueue<>();
		int N  = Integer.parseInt(br.readLine());
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new  StringTokenizer(br.readLine());
			pq.add(new Person(Integer.parseInt(st.nextToken()),st.nextToken(), idx++));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Person person = pq.poll();
			sb.append(person.age+" "+person.name+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
