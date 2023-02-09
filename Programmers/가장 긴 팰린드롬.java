class Solution
{
    public boolean[][] dp;
    public int solution(String str)
    {
        int answer = 1;
        dp = new boolean[str.length()][str.length()];
        for(int i = 0; i< str.length(); i++){
            dp[i][i] = true;
        }
        for(int e = 0; e < str.length(); e++){
            for(int s = 0; s < e; s++){
                if(str.charAt(s)==str.charAt(e) && check(s,e)){
                    answer = Math.max(answer, e-s+1);
                }
            }
        }
        
        return answer;
    }
    public boolean check(int s, int e){
        if( (e-s<=2) || (e-s > 2 && dp[s+1][e-1])) {
            dp[s][e] = true;
            return true;
        }else return false;
    }
}
