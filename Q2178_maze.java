package proj;
import java.io.*;
import java.util.*;

class graph{
	int value;
	int row;
	int col;
	boolean visited;
	
	public graph(int value, int row, int col){
		this.value = value;
		this.row = row;
		this.col = col;
		this.visited = false;
	}
	
	public void set_value(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
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





public class Main {
	static Deque<graph> queue = new ArrayDeque<>();
	static Deque<Integer> maze = new ArrayDeque<>();
	static int [][] dist;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        scanner.nextLine();
        int count = 1; // 방문 횟수
        int min = width * height;
        
        graph[][] matrix = new graph[width][height];
        
        
        for(int i = 0; i < width; i++) { // matrix 초기화
        	String line = scanner.nextLine();
        	for(int j = 0; j < height; j++) {
        		int value = line.charAt(j) - '0';
        		matrix[i][j] = new graph(value, i, j);
        	}
        }
        
        int first = 0;
        int second = 0;
        int size = 0;
        
        
		
		
		queue.addLast(matrix[0][0]);
		matrix[0][0].set_visited(true);
		
		
		System.out.println(bfs(matrix, width, height));
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				System.out.print(dist[i][j]);
			}
			System.out.println();
		}
	}
        
      
    
    static int bfs(graph[][] matrix, int width, int height) {
    	queue.addLast(matrix[0][0]);
    	matrix[0][0].set_visited(true);
    	dist = new int[width][height];
    	dist[0][0] = 1;
    	
		while(queue.size() != 0) {
			graph node = queue.removeFirst();
			node.set_visited(true);
			
			int row = node.row();
			int col = node.col();
			
			if (row == width - 1 && col == height - 1) {
				return dist[row][col];  // 현재 위치까지의 거리 반환
			}
			
			// 상, 하, 좌, 우 이동
						int[] dRow = {-1, 1, 0, 0};  // 상, 하
						int[] dCol = {0, 0, -1, 1};  // 좌, 우
						
						for (int i = 0; i < 4; i++) {
							int newRow = row + dRow[i];
							int newCol = col + dCol[i];
							
							// 새 위치가 유효하고, 벽이 아니며, 방문하지 않은 경우
							if (newRow >= 0 && newRow < width && newCol >= 0 && newCol < height) {
								if (matrix[newRow][newCol].value() == 1 && !matrix[newRow][newCol].visited()) {
									queue.addLast(matrix[newRow][newCol]);
									matrix[newRow][newCol].set_visited(true);
									dist[newRow][newCol] = dist[row][col] + 1;  // 새 위치까지의 거리 업데이트
								}
							}
						}
					}
			
    	return -1;
    }
}