package proj;
import java.io.*;
import java.util.*;



public class Main {
	
	static int number; // number of nodes
	static int line; // number of edges
	
	static boolean visited[]; // check visited
	//static int [][] graph;
	static List<List<Integer>> graph; //2차원 list
	
	static void dfs(int node) {
		visited[node] = true;
		System.out.println(node);
		
		/*
		for(int next = 0; next < number; ++next) {
			
			if(!visited[next] && graph[node][next] != 0) {
				dfs(next);
			}
		}
			*/
		
		/*
		for(int next = 0; next < number; ++next) {
			if(!visited[next] && graph.get(node).contains(next))
				dfs(next);
		}
		*/
		Collections.sort(graph.get(node));
		boolean hasNext = false;	
		for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);	
                hasNext = true;
            }
            
        }
		return;
		/*
		if (!hasNext) {
            System.out.println(0);
        }
        */
    }
	
    public static void main(String[] args) throws IOException { 
    	Scanner scanner = new Scanner(System.in);
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        		
        number = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        //graph = new int[number + 1][number + 1];
        graph = new ArrayList<>();
        visited = new boolean[number + 1];
        
     // Initialize the adjacency list
        for (int i = 0; i <= number; i++) {
            graph.add(new ArrayList<>());
        }	
        
        for(int i = 0; i < line; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	//graph[from][to] = graph[to][from] = 1;
        	graph.get(from).add(to);
        	graph.get(to).add(from);
        }
        
     // 시작 노드에서 DFS 시작
       dfs(start);
    }
   
}
