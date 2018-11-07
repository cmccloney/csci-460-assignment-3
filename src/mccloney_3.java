import java.util.*;
import java.lang.*;
import java.io.*;

public class mccloney_3 {
	public static void main(String[] args) {
		Job T1 = new Job(1,3); //pass processing time as second argument
		Job T2 = new Job(2,10); //smaller ID = more important
		Job T3 = new Job(3,3);
		int time = 0; //initial time
		int[] arrival_times = {1,3,6,8,10,12,26}; //max of 10 job requests
		int[] jobs = {3,2,3,1,2,3,1};
		int index = 0; //index to keep track of which job is up
		ArrayList<Job> queue = new ArrayList<Job>(); //queue of jobs if more than one arrives
		boolean mutex = false;
		
		while(time <= arrival_times[arrival_times.length-1]+10) { //loop
			boolean check = false;
			if(index < jobs.length && time == arrival_times[index]) { //new job has arrived
				if(jobs[index] == 1) { //setting jobs IDs and priorities
					queue.add(new Job(jobs[index],3));
					check = true;
				}else if(jobs[index] == 2){
					queue.add(new Job(jobs[index],10));
				}else {
					queue.add(new Job(jobs[index],3));
				}
				if(check && queue.get(0).getID() == 2) { //if T2 has been preempted by T1
					queue.get(0).print(time);
					queue.remove(0);
					Collections.sort(queue, new Sortbypriority()); //sort by priority
					time++;
				}
				check = false;
				if(queue.get(0).getID() == 3 && jobs[index] == 1) {
					
				}else {
					Collections.sort(queue, new Sortbypriority()); //sort by priority
				}
				index++;
			}
			if(!queue.isEmpty()) { //if a job is ready
					int temp;
					temp = queue.get(0).tick(); //process 1 ms of job
					if(temp == 0) {
						queue.get(0).print(time);
						queue.remove(0);
					}
			}
			time++;
		}
	}
}

class Sortbypriority implements Comparator<Job>{
	public int compare(Job j1, Job j2) {
		return j1.getID() - j2.getID();
	}
}

class Job {
	int ID, timeLeft;
	
	public Job(int id, int timer) {
		ID = id;
		timeLeft = timer;
	}
	
	public int tick() {
		timeLeft--;
		return timeLeft;
	}
	
	public void print(int time) {
		String s;
		switch(ID) {
			case 1:
				s = "time ";
				s += time;
				s += ", T1111T1";
				System.out.println(s);
				break;
			case 2:
				s = "time ";
				s += time;
				s += ", T2";
				for(int i = 1; i <= 10-timeLeft; i++) {
					s += "N";
				}
				s += "T2";
				System.out.println(s);
				timeLeft = 0;
				break;
			case 3:
				s = "time ";
				s += time;
				s += ", T3333T3";
				System.out.println(s);
				break;
		}
	}
	
	public int getID() {
		return ID;
	}
	
}