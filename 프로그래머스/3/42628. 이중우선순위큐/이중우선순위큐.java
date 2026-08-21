import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> q = new TreeMap<>((k1, k2) -> {return Integer.compare(k1, k2);});
        
        for(String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(command.equals("I")) {
                // 숫자 삽입
                q.put(num, q.getOrDefault(num, 0) + 1);
            } else if(command.equals("D") && !q.isEmpty()) {
                // 숫자 삭제
                int key = (num == 1) ? q.lastKey() : q.firstKey();
                if(q.get(key) > 1) {
                    q.put(key, q.get(key) + 1);
                } else {
                    q.remove(key);
                }
            }
        }
        
        if(q.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{q.lastKey(), q.firstKey()};    
        }
    }
}

/*
모든 연산을 처리한 후
- 큐가 비어있다. : [0,0]
- 큐가 비어있지 않다. : [최댓값, 최솟값]
*/