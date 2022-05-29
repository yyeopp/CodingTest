package pro;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int [] time = new int [progresses.length];
			
		for (int i = 0; i < progresses.length; i++) {
			time[i] = (int) Math.ceil((100-progresses[i])/ (double)speeds[i]);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		Stack<Integer> stack = new Stack<>();
        
		stack.add(time[0]);
		int seed = time[0];
		for (int i = 1; i < time.length; i++) {
			if(seed >= time[i]) {
				stack.add(time[i]);
			}
			else {
				list.add(stack.size());
				stack.clear();
				stack.add(time[i]);
                seed = time[i];
			}
		}
		if(!stack.isEmpty()) {
			list.add(stack.size());
		}
        
        int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}