import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 양수
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 음수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
		   int x = Integer.parseInt(br.readLine());
		   if(x!=0) {
			   if(x>0) pq.add(Math.abs(x));
			   if(x<0) pq2.add(Math.abs(x));
		   }else {
			   if(pq.size()==0 && pq2.size()==0) {
				   sb.append("0\n");
				   continue;
			   }
			   int pqtmp=Integer.MAX_VALUE,pqtmp2=Integer.MAX_VALUE;
			   if(pq.size()!=0) pqtmp = pq.peek();
			   if(pq2.size()!=0) pqtmp2 = pq2.peek();
			   if(pqtmp<pqtmp2) {
				   sb.append(pq.poll()+"\n");
			   }else if(pqtmp>pqtmp2) {
				   sb.append("-"+pq2.poll()+"\n");
			   }else {
				   sb.append("-"+pq2.poll()+"\n");
			   }
			  
		   }
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
