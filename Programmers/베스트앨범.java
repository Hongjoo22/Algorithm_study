import java.util.*;
class Solution {
    public class Music implements Comparable<Music> {
        int idx;
        int count;
        int genre;
        public Music(int idx, int count, int genre){
            this.idx=idx;
            this.count=count;
            this.genre = genre;
        }
        @Override
        public int compareTo(Music m){
            if(this.genre == m.genre){
                if(this.count==m.count) return this.idx-m.idx;
                else return m.count-this.count;    
            }else return m.genre - this.genre;
            
        }
    }
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        // 장르별 총 count      
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            if(map.containsKey(genre)){
                map.put(genre,map.get(genre)+plays[i]);
            }else map.put(genre,plays[i]);
        }
        
        // 장르별, 재생수별, 고유번호별 정렬을 위한 힙
        PriorityQueue<Music> pq = new PriorityQueue<>();
        for(int i=0;i<plays.length;i++){
            String genre = genres[i];
            pq.add(new Music(i,plays[i], map.get(genre)));
        }
        
        int before = -1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            Music music = pq.poll();
            
            if(before == music.genre){               
                count++;
            }else {
                before = music.genre;
                count = 1;
            }
            // 2개씩만 추가
            if(count<=2) {
                list.add(music.idx);     
            }
           
        }
        return list;
    }
}
