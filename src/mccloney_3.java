import java.util.*;

public class mccloney_3 {
	public static void main(String[] args) {
		Job T1 = new Job(1,3); //pass priorty as argument
		Job T2 = new Job(2,2); //higher priority = more important
		Job T3 = new Job(3,1);
		int[] buffer = {0,0,0}; //buffer shared by T1 and T3
		int time = 0; //initial time
		int[] arrival_times = {1,3,6,8,10,12,26}; //max of 10 job requests
		int[] jobs = {3,2,3,1,2,3,1};
		int index = 0; //index to keep track of which job is up
		Queue<Integer> queue = new LinkedList<>(); //queue of jobs if more than one arrives
		boolean mutex = false;
		int timeLeft = 0;
		String two = "T2 T2";
		
		while(time <= arrival_times[arrival_times.length-1]+10) { //loop
			if(time == arrival_times[index]) {
				queue.add(jobs[index]); //add job to job queue
			}
			if(!queue.isEmpty()) { //if a job is ready
					switch(queue.peek()) {
						case 1: //T1 takes 3ms
							
							break;
						case 2: //T2 takes 10ms
							
							break;
						case 3: //T3 takes 3ms
							
					}
			time++;
		}
	}
}

class Job {
	int priority, ID;
	
	public Job(int id, int p) {
		ID = id;
		priority = p;
	}
	
	public void setPriority(int p) {
		priority = p;
	}
	
	public int getPriority() {
		return priority;
	}
}