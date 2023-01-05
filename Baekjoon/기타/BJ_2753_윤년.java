import java.io.*;
import java.util.*;

public class BJ_2753_윤년 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		if((N%4==0 && N%100!=0) || N%400==0) {
            answer = 1;
        }
		System.out.println(answer);
	}
}
