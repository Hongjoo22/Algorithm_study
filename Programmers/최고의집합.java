class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        for(int i=0;i < answer.length;i++){
            if(n==0 || s/n == 0) {
                answer = new int[1];
                answer[0] = -1;
                break;
            }
            
            answer[i] = s/n;
            s = s - s/n--;
        }
        return answer;
    }
}
