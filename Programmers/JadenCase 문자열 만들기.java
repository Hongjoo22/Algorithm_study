class Solution {
    public String solution(String s) {
        String answer = "";
        boolean check = true;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)==' ') {
                answer += " ";
                check = true;
            }
            else{
                if(check) {
                   answer += Character.toUpperCase(s.charAt(i));   
                   check = false;
                }else{
                    answer += Character.toLowerCase(s.charAt(i));
                }
                
            }
        }
        return answer;
    }
}
