import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n = A.length;
        // Greedy (큰수*작은수)를 계속 곱해나가면 됨
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<n;i++){
            answer += A[i] * B[n-1-i];
        }
        return answer;
    }
}
