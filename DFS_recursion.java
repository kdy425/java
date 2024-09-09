package proj;
import java.io.*;
import java.util.*;



public class Main {
	
	static int number; // number of nodes
	static int line; // number of edges
	
	static boolean visited[]; // check visited
	static int [][] graph;
	static void dfs(int node) {
		visited[node] = true;
		System.out.println(node);
		
		for(int next = 0; next < number; ++next) {
			if(!visited[next] && graph[node][next] != 0) {
				dfs(next);
			}
		}
	}
	
    public static void main(String[] args) throws IOException { 
    	Scanner scanner = new Scanner(System.in);
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        		
        number = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        graph = new int[number + 1][number + 1];
        visited = new boolean[number + 1];
        
        for(int i = 0; i < line; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	graph[from][to] = graph[to][from] = 1;
        }
        
        dfs(start);
        System.out.println(0);
        
    }
   
}
