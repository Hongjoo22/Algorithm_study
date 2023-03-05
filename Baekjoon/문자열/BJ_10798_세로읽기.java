import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[5];
		int max  = 0;
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().trim();
			max = Math.max(max, arr[i].length());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i<arr[j].length()) sb.append(arr[j].charAt(i));
			}
		}
		System.out.print(sb.toString());
	}

}
