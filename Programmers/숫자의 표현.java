class Solution {
    public int solution(int n) {
        int answer = 0;
        int s = 0;
        int e = 0;
        int count = 0;
        while(s<=e && e<=n){
            if(s==e) {
                if(count==n) answer++;
                e++;
                count +=e;
                continue;
            }
            
           if(count<=n){
                if(count==n) answer++;
                e++;
                count+=e;
            }else{
                s++;
                count-=s;
            }
        }
        return answer;
    }
}
