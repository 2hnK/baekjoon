import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        List<Integer> answer = new ArrayList<>();
        
        // Map<장르, 총 횟수>
        HashMap<String, Integer> genrePlays = new HashMap<>();
        for(int i = 0; i < len; i++) { 
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // Map<장르, List<인덱스>>
        HashMap<String, List<Integer>> genreIndex = new HashMap<>();
        for(int i = 0; i < len; i++) {
            genreIndex.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }
        
        // 정렬된 genrePlays 리스트
        List<Map.Entry<String, Integer>> sortedGenre = new ArrayList<>(genrePlays.entrySet());
        sortedGenre.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for(Map.Entry<String,Integer> e : sortedGenre) {
            String key = e.getKey();
            List<Integer> index = genreIndex.get(key);
            
            index.sort((a, b) -> plays[b] == plays[a] ? a - b : plays[b] - plays[a]);
            
            for(int i = 0; i < Math.min(index.size(), 2); i++) {
                answer.add(index.get(i));
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}