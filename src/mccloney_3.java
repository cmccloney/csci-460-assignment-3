import java.util.*;
import java.lang.*;
import java.io.*;

public class mccloney_3 {
	public static void main(String[] args) {
		Job T1 = new Job(1,3); //pass priority as second argument
		Job T2 = new Job(2,2); //higher priority = more important
		Job T3 = new Job(3,1);
		int[] buffer = {0,0,0}; //buffer shared by T1 and T3
		int time = 0; //initial time
		int[] arrival_times = {1,3,6,8,10,12,26}; //max of 10 job requests
		int[] jobs = {3,2,3,1,2,3,1};
		int index = 0; //index to keep track of which job is up
		ArrayList<Job> queue = new ArrayList<Job>(); //queue of jobs if more than one arrives
		boolean mutex = false;
		int timeLeft = 0;
		String two = "T2 T2";
		
		while(time <= arrival_times[arrival_times.length-1]+10) { //loop
			if(index < jobs.length && time == arrival_times[index]) {
				if(jobs[index] == 1) { //setting jobs IDs and priorities
					queue.add(new Job(jobs[index],3));
				}else if(jobs[index] == 2){
					queue.add(new Job(jobs[index],jobs[index]));
				}else {
					queue.add(new Job(jobs[index],1));
				}
				index++;
				Collections.sort(queue, new Sortbypriority());
				for(int i = 0; i < queue.size(); i++) {
					System.out.print(queue.get(i).getID());
				}
				System.out.println();
			}
			if(!queue.isEmpty()) { //if a job is ready
					switch(1) {
						case 1: //T1 takes 3ms
							
							break;
						case 2: //T2 takes 10ms
							
							break;
						case 3: //T3 takes 3ms
							
					}
			}
			time++;
		}
	}
}

class Sortbypriority implements Comparator<Job>{
	public int compare(Job j1, Job j2) {
		return j1.getPriority() - j2.getPriority();
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
	
	public int getID() {
		return ID;
	}
	
}