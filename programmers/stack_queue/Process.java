package programmers.stack_queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Process {

	public int solution(int[] priorities, int location) {
		
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> indexQueue = new LinkedList<>();
		
		int count = 0;
		
		for(int i = 0; i < priorities.length; i++) {
			queue.offer(priorities[i]);
			indexQueue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			
			int max = Collections.max(queue);
			int currentNum = queue.poll();
			int index = indexQueue.poll();

			if(currentNum == max) {

				if(index == location) {
					count++;
					break;
				}
				count++;

			}else {
				queue.offer(currentNum);
				indexQueue.offer(index);
			}

		}

		return count;
	}




}
