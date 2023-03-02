class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
         // 가로 * 세로 = N 
        int N = yellow+brown;
        
        // N의 약수 (but 최소값 3부터)
        for(int i = 3; i<= N/3; i++){
            if(N%i==0 && i >= N/i && 2*i + 2*(N/i) - 4 == brown && (i-2)*(N/i-2) == yellow) {    
                 // i가 가로, N/i가 세로
                answer[0] = i;
                answer[1] = N/i;
                break;
            }
        }
        
        return answer;
    }
}
