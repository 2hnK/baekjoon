import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();
        
        for(String p : participant) {
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }
        
        for(String c : completion) {
            if(participants.get(c) == 1) {
                participants.remove(c);
            } else {
                participants.put(c, participants.get(c) - 1);   
            }
        }
        
        String answer = participants.keySet().iterator().next();
        return answer;
    }
}