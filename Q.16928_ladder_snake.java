package proj;
import java.io.*;
import java.util.*;

class game{ // 게임 세팅 
	int state;
	int index;
	int next;
	boolean visited;
	
	public game(int state, int index, int next) { // 상태, 해당 칸, 넘어갈 칸
		this.state = state;
		this.next = next;
		this.index = index;
		this.visited = false;
	}
	
	public int index() {
		return index;
	}
	
	public boolean visited() {
		return visited;
	}
	
	public void set_visited(boolean visited) {
		this.visited = visited;
	}
	
	public int next() {
		return next;
	}
	
	public int state() {
		return state;
	}
	
	public void set_index(int index) {
		this.index = index;
	}
}



public class Main{
	static int [] dist;
	static Deque<game> queue = new ArrayDeque<>();
	static List<Integer> travel = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());
		
		game[] matrix = new game[101];
		
		for(int i = 0; i < 101; i++) {
			matrix[i] = new game(0, i, -1);
		}
		
		for(int i = 0; i < ladder; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			matrix[start] = new game(1, start, end);
		}
		
		for(int i = 0; i < snake; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			matrix[start] = new game(1, start, end);
		}
		queue.addLast(matrix[1]);
		dist = new int[101];
		
		
		//System.out.println(dice(matrix, dist));
		
		
		
		System.out.println(dice(matrix, dist));
		/*for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");
		*/
	}
	
	static int dice(game[] matrix, int [] dist) {
		while(queue.size() != 0) {
			game current = queue.removeFirst();
			int location = current.index();
			int[] next_dice = {1,2,3,4,5,6};
			
			if(location == 100)
				return dist[location];
			
			
			for(int num = 0; num < 6; num++) {
				int next_index = location + next_dice[num];
				
				if(next_index < 101) {
					if(!matrix[next_index].visited() && matrix[next_index].state() == 0) {
						queue.addLast(matrix[next_index]);
						matrix[next_index].set_visited(true);
						dist[next_index] = dist[location] + 1;
					}
				
				
					if(!matrix[next_index].visited() && matrix[next_index].state() == 1) {
						int final_position = matrix[next_index].next();
						matrix[next_index].set_visited(true); // 원래 칸도 방문 처리
						if (!matrix[final_position].visited()) {
                            queue.addLast(matrix[final_position]);
                            matrix[final_position].set_visited(true);
                            dist[final_position] = dist[location] + 1;
                        }
					}
				}
				
			}
		}
		return -1;
	}
}
