import java.util.*;

class Solution {
    
    public static class Task implements Comparable<Task> {
        int taskId, requestTime, duration;
        
        public Task(int taskId, int requestTime, int duration) {
            this.taskId = taskId;
            this.requestTime = requestTime;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Task o) {
            if(this.duration != o.duration) {
                return Integer.compare(this.duration, o.duration);
            } else if(this.requestTime != o.requestTime) {
                return Integer.compare(this.requestTime, o.requestTime);
            } else {
                return Integer.compare(this.taskId, o.taskId);
            }
        }
    }
    
    public int solution(int[][] jobs) {
        int currentTime = 0;
        int taskIndex = 0;
        int completedTask = 0;
        int totalTime = 0;
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while(completedTask < jobs.length) {
            while (taskIndex < jobs.length && jobs[taskIndex][0] <= currentTime) {
                pq.offer(new Task(taskIndex, jobs[taskIndex][0], jobs[taskIndex][1]));
                taskIndex++;
            }
                
            if(pq.isEmpty()) { // 대기열에 작업 없음
                currentTime = jobs[taskIndex][0];
            } else { // 대기열에 작업 있음
                Task current = pq.poll();
                currentTime += current.duration;
                totalTime += (currentTime - current.requestTime);
                completedTask++;
            }
        }
        
        int answer = totalTime / completedTask;
        return answer;
    }
}