import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<>();
        for(String p : phone_book) {
            phoneSet.add(p);
        }
        
        // set에서 번호 하나씩 꺼내서
        for(String p : phoneSet) {
            for(int i = 1; i < p.length(); i++) {
                String subsPhone = p.substring(0, i);
                if(phoneSet.contains(subsPhone)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}