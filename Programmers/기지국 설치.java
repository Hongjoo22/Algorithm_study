class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 기지국이 가장 마지막으로 닿는 아파트 번호
        int before = 0;
        for(int i=0;i<stations.length;i++){
            if(before>=n) break;
            // 검사할 아파트 번호-1보다 작아야 증설할 수 있음
            if(before < stations[i]-w-1){
                before += 2*w+1;
                answer++;
                i--;
            }else{
                before = stations[i]+w;
            }
        }
        while(before<n){
             before += 2*w+1;
             answer++;
        }
       
        return answer;
    }
}
