class Solution
{
    public int solution(int n, int a, int b)
    {
        // 무조건 한 경기는 치뤄야 함
        int answer = 1;
        while(true){
            if(Math.abs(a-b)==1 ){
                if(a>b && a%2==0 && b%2==1 || a<b && a%2==1 && b%2==0) break;
            }
            a = (a%2) + (a/2);
            b = (b%2) + (b/2);
            answer++;
        }
        
        return answer;
    }
}
