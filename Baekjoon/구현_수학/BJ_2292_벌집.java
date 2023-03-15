import java.io.*;
import java.util.*;

public class BJ_2292_벌집 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int answer = 1;
		long sum = 1;
		while(true) {
			if(sum>=N) break;
			sum += 6*answer++;
		}
		System.out.println(answer);
	}

}
