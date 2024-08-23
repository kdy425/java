package proj;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
    	Scanner scanner = new Scanner(System.in);
    	int count = scanner.nextInt();
    	scanner.close();
    	ArrayDeque<int[]> ballon = new ArrayDeque<>(count);
    	
    	for(int i = 0; i < count; i++) {
    		int order = scanner.nextInt();
    		ballon.add(new int[] {i + 1, order});
    	}
    	
    	ArrayList<Integer> result = new ArrayList<>(count);
    	
    	int []current = ballon.pollFirst();
		result.add(current[0]);
    	
    	while(!ballon.isEmpty()) {
    		
    		
    		if(current[1] > 0) {
    			for(int i = 0; i < current[1] - 1; i++) {
    				ballon.addLast(ballon.pollFirst());
    			}
    			current = ballon.pollFirst();
    		}
    		else {
    			for(int i = 0; i < ((-1) * current[1] - 1); i++) {
    				ballon.addFirst(ballon.pollLast());
    			}
    			current = ballon.pollLast();
    		}
    		result.add(current[0]);
    	}
    	
    	for(int i = 0; i < result.size(); i++) {
    		System.out.print(result.get(i) + " ");
    	}
    }

}
