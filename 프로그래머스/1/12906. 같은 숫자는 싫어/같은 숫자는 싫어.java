import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
         Deque<Integer> dq = new ArrayDeque<>();
        int prev = -1;
        
        for(int a : arr) {
            if(prev == a) continue;
            dq.add(a);
            prev = a;
        }
        
                
        int[] answer = new int[dq.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = dq.pollFirst();
        }
        

        return answer;
    }
}