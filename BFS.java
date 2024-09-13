package proj;
import java.util.*;
import java.io.*;

class make_graph{
	private int number;
	private List<List<Integer>> graph;
	
	public make_graph(int number) {
		this.number = number;
		graph = new ArrayList<>();
		
	}
	
	public void initialize_graph(int number) {
		for(int i = 0; i <= number; i++)
			graph.add(new ArrayList<>());
	}
	
	public void make_edges(int from, int to) {
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
	
	public List<List<Integer>> get_graph(){
		return graph;
	}
}

class BFS{
	static int number;
	static boolean[] visited;
	static ArrayDeque<Integer> queue;
	static List<List<Integer>> graph;
	static int [] result;
	static int count = 1;
	
	public BFS(int number) {
		this.number = number;
		visited = new boolean[number + 1];
		queue = new ArrayDeque<>();
		result = new int[number + 1];
	}
	
	/*
	public static void BFS_travel(int start) {
		queue.addLast(start);
		visited[start] = true;
		
		while(queue.size() != 0) {
			int node = queue.getFirst();
			System.out.println(node);
			queue.removeFirst();
			//Collections.sort(graph.get(start), Comparator.reverseOrder());
			Collections.sort(graph.get(node));
			for(int next : graph.get(node)) {
				if(!visited[next]) {
					queue.addLast(next);
					visited[next] = true;
				}
			}
		}
	}
	*/
	public static void BFS_travel(int start) {
		queue.addLast(start);
		visited[start] = true;
		
		while(queue.size() != 0) {
			int node = queue.getFirst();
			result[node] = count++;
			queue.removeFirst();
			Collections.sort(graph.get(start), Comparator.reverseOrder());
			//Collections.sort(graph.get(node));
			for(int next : graph.get(node)) {
				if(!visited[next]) {
					queue.addLast(next);
					visited[next] = true;
				}
			}
		}
	}
	
	public static void answer(int number) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i <= number; i++) {
			bw.write(result[i] + "\n");
			
		}
		bw.flush();		//결과 출력
		bw.close();
		//br.close();
	}
}



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int number = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        make_graph make_graph = new make_graph(number);
        BFS BFS = new BFS(number);
        
        make_graph.initialize_graph(number);
        
        for(int i = 0; i < line; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	make_graph.make_edges(from, to);
        }
      BFS.graph = make_graph.get_graph();
      
      
      BFS.BFS_travel(start);
      BFS.answer(number);
	}
}

