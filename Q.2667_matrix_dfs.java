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
	static Stack<graph> stack = new Stack<>();
	
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int house = 0;
        int number = scanner.nextInt();
        scanner.nextLine();  // 줄바꿈 문자 소비
        List<Integer> housesize = new ArrayList<>();
        graph[][] matrix = new graph[number][number];
        
        // 매트릭스 초기화
        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < number; j++) {
                int value = line.charAt(j) - '0';  // 문자 '0'과 '1'을 정수로 변환
                matrix[i][j] = new graph(value, i, j);
            }
        }
        scanner.close();
        
        for(int i = 0; i < number; i++) {
    		for(int j = 0; j < number; j++) {
    			if(matrix[i][j].value() == 1 && !matrix[i][j].visited) {
    				stack.push(matrix[i][j]);
    				matrix[i][j].set_visited(true);
    				
    				int size = dfs(matrix, number);
    				housesize.add(size);
    				house++;
    				
    			}
    		}
    	}
        
        
        System.out.println(house);
        Collections.sort(housesize);
        for(int an : housesize) {
        	System.out.println(an);
        }
    }
    
    static int dfs(graph[][] matrix, int number) {
    	
    	int count = 0;
    	
    	while(stack.size() != 0) {			
		
			graph node = stack.pop();
			node.set_visited(true);
			count++;
			int row = node.row();
			int col = node.col();
			
			if(row - 1 >= 0 && matrix[row - 1][col].value() == 1 && !matrix[row - 1][col].visited) { //상
				stack.add(matrix[row - 1][col]);
				matrix[row - 1][col].set_visited(true);
			}
			if(row + 1 < number && matrix[row + 1][col].value() == 1 && !matrix[row + 1][col].visited) { //하 
				stack.add(matrix[row + 1][col]);
				matrix[row + 1][col].set_visited(true);
			}
			if(col - 1 >= 0 && matrix[row][col - 1].value() == 1 && !matrix[row][col - 1].visited) { //
				stack.add(matrix[row][col - 1]);
				matrix[row][col - 1].set_visited(true);
			}
			if(col + 1 < number && matrix[row][col + 1].value() == 1 && !matrix[row][col + 1].visited) { //우 
				stack.add(matrix[row][col + 1]);
				matrix[row][col + 1].set_visited(true);
			}
			
			
    	}
    	return count;
    }
}