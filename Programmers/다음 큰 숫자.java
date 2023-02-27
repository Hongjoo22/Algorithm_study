class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int count = 0;
        for(int i = 0;i<=22;i++){
            if( (n & (1<<i)) > 0) count++;
        }
        int tmp = n+1;
        while(true){
            int cnt = 0;
            for(int i = 0;i<=22;i++){
                if( (tmp & (1<<i))> 0) cnt++;
            }
            if(cnt == count) {
                answer = tmp;
                break;
            }
            tmp++ ;
        }
        return answer;
    }
}
