package proj;
import java.io.*;
import java.util.*;



class tree{
	public int search(int rootvalue, int target) {
		//Set<Integer> visited = new HashSet<>();
		int size =100001;
		boolean [] visited = new boolean [size];
		Queue<node> queue = new LinkedList<>();
        
        // 초기 값과 깊이 설정
        queue.add(new node(rootvalue, 0));
		visited[rootvalue] = true;
		

		while(!queue.isEmpty()) {
			node current = queue.poll();
			int currentvalue = current.value;
			int currentdepth = current.depth;
			
			if(currentvalue == target) {
				return currentdepth;
			}
			
			int plus = currentvalue + 1;
			int minus = currentvalue - 1;
			int mul = currentvalue * 2;
			
			
			if (!visited[plus]) {
                queue.add(new node(plus, currentdepth + 1));
                visited[plus] = true;
	        }
	        
	        
	        if (minus >= 0 && !visited[minus]) {
	        	queue.add(new node(minus, currentdepth + 1));
	        	visited[minus] = true;
	        }
	
	        if (mul <= size && !visited[mul]) {
	        	queue.add(new node(mul, currentdepth + 1));
	        	visited[mul] = true;
	        }
	        
			
	            
	          
		}
		  return -1;
	}

	private static class node{
		int value;
		int depth;
		public node(int value, int depth) {
			this.value = value;
			this.depth = depth;
		}
		
	}

}


public class Main{
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		
		tree tree = new tree();
		
		int depth = tree.search(start,  target);
		
		System.out.print(depth);
		
	}
}