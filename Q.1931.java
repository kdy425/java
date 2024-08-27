package proj;
import java.util.*;
import java.io.*;

public class Main {
	
	static class interval{
		int start, end;
		
		interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	//public static List<interval> select_interval(interval[] intervals){
	public static int select_interval(interval[] intervals){
		// 끝나는 시점을 기준으로 정렬하고, 끝나는 시점이 동일하면 시작하는 시점을 기준으로 정렬
		Arrays.sort(intervals, (a, b) -> {
			if (a.end != b.end) {
				return a.end - b.end; // 끝나는 시점으로 정렬
			} else {
				return a.start - b.start; // 끝나는 시점이 동일하면 시작하는 시점으로 정렬
			}
		});
		List<interval> selected_intervals = new ArrayList<>();
		int end_time = Integer.MIN_VALUE;
		int answer;
		int count = 0;
		
		for(interval interval_ : intervals) {
			if(interval_.start == end_time && interval_.start == interval_.end) {
				selected_intervals.add(interval_);
				end_time = interval_.end;
			}
			
			else if(interval_.start >= end_time) {
				
				selected_intervals.add(interval_);
				end_time = interval_.end; //마지막으로 선택된 구간의 종료 시간
				
			}
		}
		answer = selected_intervals.size() + count;
		return answer;
		//return selected_intervals;
	}
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
    	int count = scanner.nextInt();
    	interval[] intervals = new interval[count];
    	for(int i = 0; i < count; i++) {
    		int a = scanner.nextInt();
    		int b = scanner.nextInt();
    		intervals[i] = new interval(a,b);
    	}
    	
		//List<interval> result = select_interval(intervals);
    	int result = select_interval(intervals);
		System.out.println(result);
    	
		/*
		for(interval interval_ : result) {
			System.out.println(interval_.start + " " +interval_.end);
		}
		*/
    	
    	
    }
    
}

