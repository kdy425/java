package proj;
import java.io.*;
import java.util.*;

class graph{
	int value;
	int row;
	int col;
	boolean visited;
	
	public graph(int value, int row, int col) {
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


public class Main{
	static int [][] dist;
	static Deque<graph> queue = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int count = 0;
		int tomato = 0; //토마토 개수
		graph[][] matrix = new graph[width][height];
	
		
		
		for(int i = 0; i < width; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < height; j++) {
				int value = Integer.parseInt(st.nextToken());
				matrix[i][j] = new graph(value, i, j);
				
				if(value == 1) {
					queue.addLast(matrix[i][j]);
					tomato++;
				}
				if(value == -1)
					count++;
			}
		}
		
		int nun_tomato = count + tomato; //토마토가 아닌 개수
		
		System.out.println(nun_tomato);
		//System.out.println(count);
		System.out.println(tomato(matrix, width, height, nun_tomato));
		
		
	}
	
	static int tomato(graph[][] matrix, int width, int height, int nun_tomato) {
		int answer = -1;
		dist = new int[width][height]; // 거기 저장 변수
		int tomato_count = 0; // 방문하지 않은 토마토의 개수를 저장하는 변수
		
		while(!queue.isEmpty()) {
			graph node = queue.removeFirst();
			int row = node.row();
			int col = node.col();
			node.set_visited(true);
			
			int[] dRow = {-1, 1, 0, 0};  // 상, 하
			int[] dCol = {0, 0, -1, 1};  // 좌, 우
			
			for (int i = 0; i < 4; i++) {
				int newRow = row + dRow[i];
				int newCol = col + dCol[i];
				
				// 새 위치가 유효하고, 벽이 아니며, 방문하지 않은 경우
				if (newRow >= 0 && newRow < width && newCol >= 0 && newCol < height) {
					if (matrix[newRow][newCol].value() == 0 && !matrix[newRow][newCol].visited()) {
						queue.addLast(matrix[newRow][newCol]);
						matrix[newRow][newCol].set_visited(true);
						matrix[newRow][newCol].set_value(1);
						dist[newRow][newCol] = dist[row][col] + 1;  // 새 위치까지의 거리 업데이트
					}
				}
			}
			
			answer = dist[row][col];
		}
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				if(dist[i][j] == 0)
					tomato_count++;
			}
		}
		
		if(tomato_count > nun_tomato)
			answer = -1;
		return answer;
		
	}
	
}