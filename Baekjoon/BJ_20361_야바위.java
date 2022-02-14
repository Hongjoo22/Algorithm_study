import java.util.Scanner; // Scanner를 쓰기위해 import

public class BJ_20361_야바위 {

	static int N, X, K; // 앞으로 받을 변수들을 static 변수로 선언한다.

	public static void main(String[] args) { // 실행 메서드
		Scanner in = new Scanner(System.in); // 입력받기 위해 선언
		int T = in.nextInt(); // 테스트 케이스 입력받기
		for (int t = 1; t <= T; t++) { // 테스트케이스 수만큼 알고리즘 돌리기
			N = in.nextInt(); // 종이컵 수 입력받기
			X = in.nextInt(); // 간식이 들어있는 위치 입력받기
			K = in.nextInt(); // 종이컵 움직이는 수 입력받기

			int cup[] = new int[N + 1]; // 종이컵들을 배열로 그러나 실제 인덱스는 1번부터이기때문에 N+1로 할당해준다
			cup[X] = 1; // 위에서 입력받은 x번째컵에 간식(1) 넣기(나머지는 0으로 간식이 없다)
			for (int i = 0; i < K; i++) { // k번 움직이니까 k번만큼 반복
				int k1 = in.nextInt(); // 바꾸는 컵위치1
				int k2 = in.nextInt(); // 바꾸는 컵위치2
				int tmp = cup[k1]; // 컵위치1을 임시로 tmp에 담고
				cup[k1] = cup[k2]; // 컵위치1에 컵위치2 값을 넣는다
				cup[k2] = tmp; // 컵위치2에 아까 담아두었던 tmp(원래 컵위치1)을 넣는다
			}
			int index = -1; // 답을 출력하기 위한 인덱스값 초기화
			for (int i = 0; i < N + 1; i++) { // cup배열을 돌면서
				if (cup[i] == 1) { // 해당 원소가 1이라면(간식이 있다면
					index = i; // 해당 i값을 index값에 넣어준다
				}
			}
			System.out.println("#"+t+" "+index); //간식이 있는위치(index) 출력
		}
	}

}
