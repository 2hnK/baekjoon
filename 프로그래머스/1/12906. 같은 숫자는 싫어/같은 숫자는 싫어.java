import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
         Deque<Integer> dq = new ArrayDeque<>();
        
        for(int a : arr) {
            if(!dq.isEmpty() && dq.peekLast() == a) continue;
            dq.addLast(a);
        }
        
                
        int[] answer = new int[dq.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = dq.pollFirst();
        }
        

        return answer;
    }
}