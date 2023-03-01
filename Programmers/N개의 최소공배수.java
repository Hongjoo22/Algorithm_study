import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        // 나눠준 숫자들
        ArrayList<Integer> multi = new ArrayList<>();
        for(int num = 2; num<=100; num++){
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length;i++){
                // 나누어 떨어지면 해당 숫자로 나눌 후보에 들어감
                if(arr[i]%num==0) {
                    count++;
                    list.add(i);
                }
            } 
            
            // 2개 이상이어야 나눌 수 있다
            if(count>=2){
                for(Integer idx: list){
                    arr[idx] /= num; 
                }
                // 나눠준 숫자 저장
                multi.add(num);
                // 다시 2부터 나눌 수 있는지 check 하기 위해
                num = 1;              
            }
        }
        // 왼쪽 나눠준 숫자들 곱하고
        for(Integer num : multi){
            answer *= num;
        }
        // 남은 배열의 숫자들을 다 곱해준다
        for(Integer num : arr){
            answer *= num;
        }
        return answer;
    }
}
