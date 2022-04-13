import java.io.*;
import java.util.*;

public class BJ_14891_톱니바퀴 {

	
	static ArrayList<Integer> list1;
	static ArrayList<Integer> list2;
	static ArrayList<Integer> list3;
	static ArrayList<Integer> list4;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		list3 = new ArrayList<>();
		list4 = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				// 왼: 2번인덱스, 오: 6번인덱스
				int tmp = cs[j]-'0';
				if(i==0) list1.add(tmp);
				else if(i==1) list2.add(tmp);
				else if(i==2) list3.add(tmp);
				else if(i==3) list4.add(tmp);
			}
		}
		
		int K = Integer.parseInt(br.readLine());				
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 회전번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향 1: 시계방향, -1: 반시계
			boolean[] v = new boolean[3]; 
			if(list1.get(2) != list2.get(6)) v[0] = true;					
			if(list2.get(2) != list3.get(6)) v[1] = true;
			if(list3.get(2) != list4.get(6)) v[2] = true;
			
			rotate(num,dir,v);			
		}
		
		int total = 0;
		if(list1.get(0)==1) total+=1;
		if(list2.get(0)==1) total+=2;
		if(list3.get(0)==1) total+=4;
		if(list4.get(0)==1) total+=8;
					
		System.out.println(total);	
	}

	private static void rotate(int num, int dir, boolean[] v) {
		// 주석은 dir 1 기준
		boolean right = false ,left = false;
		if(dir==1) right =true;
		else left = true;
		
		if(num==1) {
		// 1번 시계방향
			rot(1,list1,right,left);
			if(v[0]) {
			// 2번 반시계
				rot(-1,list2,right,left);
				if(v[1]) {
					//3번 시계
					rot(1,list3,right,left);
					if(v[2]) {
						// 4번 반시계
						rot(-1,list4,right,left);
					}
				}
			}
		}else if(num==2) {
			// 2번 시계방향
			rot(1,list2,right,left);
				if(v[0]) {
				// 1번 반시계
					rot(-1,list1,right,left);
				}
				if(v[1]) {
					//3번 반시계
					rot(-1,list3,right,left);
					if(v[2]) {
						// 4번 시계
						rot(1,list4,right,left);
					}
				}				
		}else if(num==3) {
			// 3번 시계방향
			rot(1,list3,right,left);
			if(v[1]) {
				//2번 반시계
				rot(-1,list2,right,left);
				if(v[0]) {
					// 1번 시계
					rot(1,list1,right,left);
				}
			}
			if(v[2]) {
				// 4번 반시계
				rot(-1,list4,right,left);
			}			
		}else if(num==4) {
			// 4번 시계방향
			rot(1,list4,right,left);
			if(v[2]) {
				// 3번 반시계
				rot(-1,list3,right,left);
				if(v[1]) {
					//2번 시계
					rot(1,list2,right,left);
					if(v[0]) {
						// 1번 반시계
						rot(-1,list1,right,left);
					}
				}
			}			
		}	
	}

	private static void rot(int dir, ArrayList<Integer> list, boolean right, boolean left) { 
		if(dir==1 && right) { // 시계방향
			int tmp = list.get(7);
			list.add(0, tmp);
			list.remove(8);			
		}else if(dir==-1 && right){ // 반시계
			int tmp = list.get(0); 
			list.remove(0);
			list.add(tmp);
		}
		if(dir==-1 && left) { // 반시계방향
			int tmp = list.get(7);
			list.add(0, tmp);
			list.remove(8);			
		}else if(dir==1 && left){ // 시계
			int tmp = list.get(0); 
			list.remove(0);
			list.add(tmp);
		}
	}
}
