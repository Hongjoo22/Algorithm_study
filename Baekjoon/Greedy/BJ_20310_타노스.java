import java.io.*;
import java.util.*;
public class BJ_20310_타노스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		ArrayList<Integer> zero = new ArrayList<>();
		ArrayList<Integer> one = new ArrayList<>();
		ArrayList<Integer> removeList = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='0') zero.add(i);
			else one.add(i);
		}
				
		// 0은 뒤에서부터 지우고 1은 앞에서부터 지운다
		Collections.sort(zero, Collections.reverseOrder());
		
		for (int i = 0; i < zero.size()/2; i++) {
			removeList.add(zero.get(i));
		}
		for (int i = 0; i < one.size()/2; i++) {
			removeList.add(one.get(i));
		}
		
		Collections.sort(removeList);
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < str.length(); i++) {
			if(idx<removeList.size() && removeList.get(idx)==i)idx++;
			else sb.append(str.charAt(i));
		}
		
		System.out.println(sb.toString());
	}

}
