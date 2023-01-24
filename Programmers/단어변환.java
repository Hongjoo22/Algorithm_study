
class Solution {
    public int answer;
    public boolean[] v;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        v = new boolean[words.length];
        for(int i = 0; i< words.length;i++){
            if(v[i]) continue;
            if(check(begin, words[i])) {
                v[i] = true;
                // 현재 idx, 과정개수
                dfs(target, words, i, 1); 
                v[i] = false;
            }               
        }
        return (answer==Integer.MAX_VALUE?0:answer);
    }
    public void dfs(String target, String[] words, int idx, int count){
        if(target.equals(words[idx])){    
            answer = Math.min(answer,count);
            return;
        }
        for(int i = 0; i< words.length;i++){
            if(v[i]) continue;
            if(i!=idx && check(words[idx], words[i])) {
                v[i] = true;
                dfs(target, words, i, count+1); 
                v[i] = false;
            }
               
        }
    }
    // 1개만 다른지 체크
    public boolean check(String str1, String str2){
        boolean once = false;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) {
                if(once) {
                    once = false;
                    break;
                }
                else once = true;
            }
        }
        return once;
    }
}
