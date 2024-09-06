package proj;
import java.util.*;
import java.io.*;


public class Main {
	
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	int number = scanner.nextInt();
    	int [] array = new int[number];
    	for(int i = 0; i < number; i++) {
    		array[i] = scanner.nextInt();
    	}
    	int find = scanner.nextInt();
    	int [] target = new int[find];
    	
    	
    	for(int i = 0; i < find; i++) {
    		target[i] = scanner.nextInt();
    	}
    	
    	Arrays.sort(array);
    	
    	for(int i = 0; i < find; i++) {
    		int index = Arrays.binarySearch(array, target[i]);
    		
    		int a = first(array, index, target[i]);
    		int b = last(array, index, target[i]);
    		
    		System.out.print(b - a);
    		System.out.print(" ");
    	}
    
    }
    
    public static int first(int [] array, int index, int target) {
    	
    	if(index < 0)
    		return 0;
    	while(index > 0 && target == array[index - 1]){
    		index--;
    	}
		return index;
    }
    
    public static int last(int [] array, int index, int target) {
    	if(index < 0)
    		return 0;
    	while(index < array.length - 1 && target == array[index + 1]) {
    		index++;
    	}
    	return index + 1;
    }
}

