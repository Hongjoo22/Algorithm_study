import java.io.*;
import java.util.*;

public class BJ_10871_X보다작은수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(st.nextToken());
            if(x<X) System.out.print(x+" ");
        }	
	}
}
