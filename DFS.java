package proj;
import java.io.*;
import java.util.*;

class undirected_graph{ //그래프를 생성하는 클래스
	private int count;
    private int[][] vertexMatrix;
    
    public undirected_graph(int count) {
    	this.count = count;
    	vertexMatrix = new int[count][count];
    }
    
    public void addEdges(int from, int to, int weight) {
    	vertexMatrix[from][to] = weight;
    	vertexMatrix[to][from] = weight; // 대칭적
    }
    
    public int[][] getMatrix(){
    	return vertexMatrix;
    }
}

class DFS{
	static int count;
	static boolean[] visited;
	static Stack<Integer> stack;
	static int [][] matrix;
	
	public DFS(int count) {
		this.count = count;
		visited = new boolean[count];
		stack = new Stack<>();
	}
	
	public static void DFS_travel(int start) {
		stack.push(start);
		visited[start] = true;
		
		while(stack.size() != 0) {
			int node = stack.pop();
			System.out.println(node);
			
			List<Integer> neighbors = new ArrayList<>();
			
			for(int j = 0; j < count; j++) {
				if(matrix[node][j] != 0 && !visited[j]) {
					neighbors.add(j);
				}
			}
			
			Collections.sort(neighbors, Comparator.reverseOrder());
			for(int neighbor : neighbors) {
				stack.push(neighbor);
				visited[neighbor] = true;
			}
		}
		System.out.print(0); // 마지막에 0 출력
	}
}


public class Main {
	
    public static void main(String[] args) throws IOException { 
    	Scanner scanner = new Scanner(System.in);
      
    	int number = scanner.nextInt();
    	int line = scanner.nextInt();
    	int start = scanner.nextInt();
    	
    	int [] from = new int[line];
    	int [] to = new int[line];
    	
    	undirected_graph undirected_graph = new undirected_graph(number);
    	DFS DSF = new DFS(number);
    	
    	for(int i = 0; i < line; i++) {
    		from[i] = scanner.nextInt();
    		to[i] = scanner.nextInt();
    	}
    	
    
    	for(int i = 0; i < line; i++) {
    		undirected_graph.addEdges(from[i], to[i], 1);
    	}
    	
    	DFS.matrix = undirected_graph.getMatrix();
    	DFS.DFS_travel(start);
    	
    }
    
   
}
