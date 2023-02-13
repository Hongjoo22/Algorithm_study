import java.util.*;
class Solution {
    public String solution(int n, int time, int m, String[] timetable) {
        String answer = "";
        
        // 대기순으로 정렬
        Arrays.sort(timetable);
        
        // n회차 버스에 m명 수용 가능(순서대로)
        String[][] bus = new String[n][m];
        
        // 첫 차시간
        String now = "09:00";
        int hour = 9;
        int minutes = 0;
        int s_idx = 0;
        
        // n회마다 최대 몇명 태우고 갈 수 있는지 check
        out : for(int i = 0; i < n; i++){
            // 현재 남은 대기 인원 중 m명 뽑기
            for(int j = 0, t=s_idx; t<s_idx+m; j++, t++){
                if(t>=timetable.length) break out;
                // 양수이면 now 시간이 더 늦은 시간
                if(timetable[t].compareTo(now) > 0){
                    s_idx = t;
                    break;
                }
                bus[i][j] = timetable[t];
            }
            // m명 다채웠으면 그 다음 순서부터 시작
            if(bus[i][m-1]!=null){
                s_idx += m;
            }
            
            //다음 시간 계산(마지막 셔틀 도착시간 pass)
            if(i==n-1) break;
            
            minutes += time;
            hour += minutes/60;
            minutes = minutes%60;
            
            if(hour<10) now = "0"+hour+":";
            else now = hour+":";
            
            if(minutes<10) now += "0"+minutes;
            else now += minutes;
        }
        
        // 마지막 n회에서 사람이 남으면 마지막 셔틀 도착시간출력
        if(bus[n-1][m-1]==null){
            answer = now;
        }else{
            // 사람이 꽉찼으면  가장 늦게온사람보다 -1분     
            String tmp = bus[n-1][m-1];
            int tHour = Integer.parseInt(tmp.substring(0,2));
            int tMin = Integer.parseInt(tmp.substring(3,5));
            
            if(tMin == 0){
                tMin = 59;
                tHour--;
            }else tMin--;
            
            if(tHour<10) answer = "0"+tHour+":";
            else answer = tHour+":";
            
            if(tMin<10) answer += "0"+tMin;
            else answer += tMin;
        }
               
        return answer;
    }
}
