import java.io.*;

public class BJ_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[][] D = new long[N][2]; // 최대 점수, 밟은 연속 계단 수 1부터
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		D[0][0] = arr[0];
		D[0][1] = 1;
		if(N>1) {
			D[1][0] = arr[0]+arr[1];
			D[1][1] = 2; // 2번째 계단은 1+2 밟아야 최대이므로 2번 연속 밟는다
		}
		if(N>2) {
			D[2][0] = Math.max(D[0][0]+ arr[2], arr[1]+arr[2]); // 1+3 or 2+3
			if(D[2][0]== arr[1]+arr[2]) D[2][1] = 2; // 2+3 이면 연속 2
			else  D[2][1] = 1; // 아니면 연속 1
		}

		for (int i = 3; i < N; i++) {
			if(D[i-1][1]!=2) { 
				D[i][0] = Math.max(D[i-1][0] + arr[i], D[i-2][0] + arr[i]); // 이어서밟기 or 2뛰어서 밟기
				D[i][1]=1;
				if(D[i-1][0] + arr[i]== D[i-2][0] + arr[i]) continue; // 같으면 뛰어서 밟는게 유리하므로 2로 갱신 안해도됨
				if(D[i][0]==D[i-1][0] + arr[i]) D[i][1]=2; // 이어서밟으면 연속 2 갱신
			}else {
				D[i][0] = Math.max(D[i-3][0]+arr[i-1]+arr[i], D[i-2][0]+arr[i]); // 0 x 0 0  or 0 x 0 
				if(D[i][0]==D[i-3][0]+arr[i-1]+arr[i]) D[i][1] = 2; // ********* 전자면 연속 2 => 여기서 계속 틀렷다 
				else D[i][1] = 1; // 후자면 연속 1
			}
		}
		System.out.println(D[N-1][0]); // 마지막 계단을 무조건 밟아야 하므로
	}

}
