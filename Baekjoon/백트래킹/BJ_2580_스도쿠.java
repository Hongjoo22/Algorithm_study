import java.io.*;
import java.util.*;

public class BJ_2580_스도쿠 {

	static ArrayList<int[]> list;
	static int[][] map;
	static boolean finish;
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
					int num = check(i,j); // 구역 정하기
					list.add(new int[] {i,j,num});
				}
			}
		}	
		finish = false;
		go(0);
		
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

	private static void go(int idx) { // 후보 숫자 넣어보고 아니면 백
		if(idx>=list.size()) {
			finish = true;
			return; // 끝나는 조건
		}
		boolean[] v = new boolean[10]; // 1~9까지 가능한 숫자
		search(list.get(idx), v); // 행, 열 , 구역 서치
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		for (int i = 1; i <= 9; i++) {
			if(!finish && !v[i]) { // 가능한 숫자
				map[r][c] = i;
				v[i] = true; // 고려했음
				go(idx+1);
				v[i] = false; 
			}			
		}		
		//가능한 숫자 없어서 내려오면
		if(map[r][c]==0) return;
		if(!finish) { // 안끝났는데도 여기로 내려오면 해당 숫자가 아니라는 뜻 => 0으로 초기화해준다
			map[r][c]=0;
		}
	}

	private static void search(int[] list, boolean[] v) { // 후보숫자 탐색
		int r = list[0];
		int c = list[1];
		int num = list[2];
		int row = 0;
		int col = 0;
		if(num==1) {
			row = col =0;
		}
		else if(num==2) {
			row = 0;
			col = 3;
		}
		else if(num==3) {
			row = 0;
			col = 6;
		}
		else if(num==4) {
			row = 3;
			col = 0;
		}
		else if(num==5) {
			row = 3;
			col = 3;
		}
		else if(num==6) {
			row = 3;
			col = 6;
		}
		else if(num==7) {
			row = 6;
			col = 0;
		}
		else if(num==8) {
			row = 6;
			col = 3;
		}
		else if(num==9){
			row = 6;
			col = 6;
		}				
		for (int i = 0; i < 9; i++) {
			if(!v[map[r][i]] && map[r][i]!=0) { // 행탐색
				v[map[r][i]] = true;
			}
			if(!v[map[i][c]] && map[i][c]!=0) { // 열탐색
				v[map[i][c]] = true;
			}
			for (int r1 = 0+row; r1 < 3+row; r1++) { // 사각형 탐색
				for (int c1 = 0+col; c1 < 3+col; c1++) {
					if(!v[map[r1][c1]] && map[r1][c1]!=0) v[map[r1][c1]] = true; 
				}
			}
		}
	}

	private static int check(int r, int c) { // 구역탐색
		if(r>=0 && r<3 && c>=0 && c<3) return 1;
		else if(r>=0 && r<3 && c>=3 && c<6) return 2;
		else if(r>=0 && r<3 && c>=6 && c<9) return 3;
		else if(r>=3 && r<6 && c>=0 && c<3) return 4;
		else if(r>=3 && r<6 && c>=3 && c<6) return 5;
		else if(r>=3 && r<6 && c>=6 && c<9) return 6;
		else if(r>=6 && r<9 && c>=0 && c<3) return 7;
		else if(r>=6 && r<9 && c>=3 && c<6) return 8;
		else return 9;
	}
}

