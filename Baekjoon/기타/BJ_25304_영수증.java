import java.util.*;
import java.io.*;

public class BJ_25304_영수증
{
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer  = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            answer += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }
        System.out.println(total==answer?"Yes":"No");
    }
}
