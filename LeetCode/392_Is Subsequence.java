class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int s_idx  = 0;
        for(int i=0; i<t.length(); i++){
            if(s.charAt(s_idx) == t.charAt(i)){
                s_idx++;
                if(s_idx >= s.length()) return true;
            }
        }
        return false;
    }
}
