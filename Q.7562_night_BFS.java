package proj;
import java.io.*;
import java.util.*;


class graph{
	boolean visited;
	int row;
	int col;
	public graph(int row, int col) {
		this.row = row;
		this.col = col;
		this.visited = false;
	}
	
	
	public boolean visited() {
		return visited;
	}
	
	public int row() {
		return row;
	}
	public int col() {
		return col;
	}
	
	public void set_visited(boolean visited) {
		this.visited = visited;
	}
}


public class Main{
	static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
		int testcase = Integer.parseInt(bf.readLine());

		
		for(int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int width = Integer.parseInt(st.nextToken());
			
			Deque<graph> queue = new ArrayDeque<>(); //queue 초기화
			
			graph[][] matrix = new graph[width][width]; //matrix 초기화
			int [][] dist = new int[width][width];	//dist 초기화
			
			for(int a = 0; a < width; a++) {
				for(int b = 0; b < width; b++) {
					matrix[a][b] = new graph(a,b);
					dist[a][b] = -1;
				}
			}
			
			st = new StringTokenizer(bf.readLine());
			
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			
			queue.addLast(matrix[start_x][start_y]); // 시작점 queue 삽입
			matrix[start_x][start_y].set_visited(true);
			dist[start_x][start_y] = 0;
			
			st = new StringTokenizer(bf.readLine());
			int target_x = Integer.parseInt(st.nextToken());
			int target_y = Integer.parseInt(st.nextToken());
		
			
			find(matrix, dist, width, target_x, target_y, queue);
			
		}
		
		for (int ans : answer) {
            System.out.println(ans);
        }
        
		
		
	}
	
	static void find(graph[][] matrix, int [][] dist, int width, int x, int y, Deque<graph> queue) {
		while(queue.size() != 0) {
			graph node = queue.removeFirst();
			
			int row = node.row();
			int col = node.col();
			
			if(row == x && col == y) {
				answer.add(dist[row][col]);
				return;
			}
			
			int[] drow = {1, 1, -1, -1, 2, 2, -2, -2};
			int[] dcol = {2, -2, 2, -2, 1, -1, 1, -1};
			
			for(int i = 0; i < 8; i++) {
				int newrow = row + drow[i];
				int newcol = col + dcol[i];
				
				if (newrow >= 0 && newrow < width && newcol >= 0 && newcol < width) {
					if (!matrix[newrow][newcol].visited()) {
						queue.addLast(matrix[newrow][newcol]);
						matrix[newrow][newcol].set_visited(true);
						dist[newrow][newcol] = dist[row][col] + 1;  // 새 위치까지의 거리 업데이트
					}
				}
			}
		}
		
	}
	
}