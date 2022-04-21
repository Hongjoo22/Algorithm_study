import java.io.*;
import java.util.*;

public class BJ_2580_스도쿠 {

	static class Node{
		int r, c, num;
		boolean[] v;	
		public Node(int r, int c, boolean[] v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	static ArrayList<Node> list;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		map = new int[9][9];
		list = new ArrayList<>();
		 
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					list.add(new Node(i,j,new boolean[] {false,false,false,false,false,false,false,false,false}));
				}
			}
		}	
		
		// 각 위치 구역 나누기
		for (int i = 0; i < list.size(); i++) {
			for (int num = 1; num <= 9; num++) {
				int r = list.get(i).r;
				int c = list.get(i).c;
				if(check(r,c,num)) { // 각 구역 탐색
					list.get(i).num = num;
					break;
				}
			}
		}
		
		search(); // 초기후보숫자 탐색
		init(); // 후보숫자가 한개면 무조건 답이므로 고정
		
	
		if(!list.isEmpty()) go(list.get(0)); // logic			
		
		
//		for (int i = 0; i < list.size(); i++) {
//			int r = list.get(i).r;
//			int c = list.get(i).c;
//			int num = list.get(i).num;
//			boolean[] v = list.get(i).v;
//			
//			System.out.println(i+"번째 r c num : "+r+" " + c + " " + num );
//			System.out.println(Arrays.toString(v));
//		}
		
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	private static void init() {
		for (int i = list.size()-1; i >=0 ; i--) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			boolean[] v = list.get(i).v;
			int num  = 0;
			int idx = 0;
			for (int j = 0; j < v.length; j++) {
				if(!v[j]) {
					num++;
					idx = j;
				}
			}
			if(num==1) {
				map[r][c] = idx+1;
				list.remove(i);
			}
		}
	}

	private static void go(Node node) { // 후보 숫자 넣어보고 아니면 백(지우기)
		int num=0;
		for (int i = 0; i < node.v.length; i++) {
			if(!node.v[i]) {
				num++;
				map[node.r][node.c] = i+1;
				break;
			}
		}
		if(map[node.r][node.c]==0 && num==0) return ;
		for (int i = 0; i < list.size(); i++) {
			go(list.get(i));
		}
		
	}
	
	private static void search() { // 후보숫자 탐색
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			for (int j = 0; j < 9; j++) {
				if(map[r][j]!=0 && !list.get(i).v[map[r][j]-1]) { // 행탐색
					list.get(i).v[map[r][j]-1] = true; // 해당 숫자가 이미 있다면 true
				}
				if( map[j][c]!=0 && !list.get(i).v[map[j][c]-1]) { // 열탐색
					list.get(i).v[map[j][c]-1] = true; // 해당 숫자가 이미 있다면 true
				}				
			}
			int num = list.get(i).num;
			// 사각형 탐색
			if(num==1) square(0,0,list.get(i));
			else if(num==2)  square(0,3,list.get(i));
			else if(num==3) square(0,6,list.get(i));
			else if(num==4) square(3,0,list.get(i));
			else if(num==5) square(3,3,list.get(i));
			else if(num==6) square(3,6,list.get(i));
			else if(num==7) square(6,0,list.get(i));
			else if(num==8) square(6,3,list.get(i));
			else if(num==9) square(6,6,list.get(i));			
		}
	}
	
	private static void square(int r, int c, Node n) { // 사각형 탐색
		for (int i = 0+r; i < 3+r; i++) {
			for (int j = 0+c; j < 3+c; j++) {
				if(map[i][j]!=0 && !n.v[map[i][j]-1]) n.v[map[i][j]-1] = true; 
			}
		}
	}

	private static boolean check(int r, int c, int num) { // 구역탐색
		if(num==1) return r>=0 && r<3 && c>=0 && c<3;
		if(num==2) return r>=0 && r<3 && c>=3 && c<6;
		if(num==3) return r>=0 && r<3 && c>=6 && c<9;
		if(num==4) return r>=3 && r<6 && c>=0 && c<3;
		if(num==5) return r>=3 && r<6 && c>=3 && c<6;
		if(num==6) return r>=3 && r<6 && c>=6 && c<9;
		if(num==7) return r>=6 && r<9 && c>=0 && c<3;
		if(num==8) return r>=6 && r<9 && c>=3 && c<6;
		else  return r>=6 && r<9 && c>=6 && c<9;
	}
}

