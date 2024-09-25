package proj;
import java.io.*;
import java.util.*;


class node{
	int index;
	int cost;
	public node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}


public class Main{
	static boolean [] visited;
	static List<List<node>> graph;
	static int [] dist;
	static int number;
	static int line;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int INF = Integer.MAX_VALUE;
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		number = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        
        int start = Integer.parseInt(bf.readLine());
        
        visited = new boolean[number + 1];
        
        dist = new int[number + 1];
        
        
        graph = new ArrayList<>();
        for(int i = 0; i <= number; i++) {
        	graph.add(new ArrayList<>());
        }
        
        
        
        for(int i = 0; i < line; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	graph.get(from).add(new node(to, weight));
        }
        
        dijkstra(start);
        
        for(int i = 1; i < dist.length; i++) {
        	if(dist[i] != Integer.MAX_VALUE)
        		System.out.println(dist[i]);
        	else
        		System.out.println("INF");
        }
        
		
	}
	
	/* 우선순위 큐를 쓰지 않은 코드
	static void dijkstra(int start) {
		Arrays.fill(dist, INF);

		dist[start] = 0;
		
		
		for(int i = 0; i <= number; i++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			
			for(int j = 1; j <= number; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					index = j;
				}
			}
			visited[index] = true;
			
			for(int j = 0; j < graph.get(index).size(); j++) {
				node adj = graph.get(index).get(j);
				if(dist[adj.index] > dist[index] + adj.cost) {
					dist[adj.index] = dist[index] + adj.cost;
				}
			}
		}
	
	}
	*/
	
	static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		queue.offer(new node(start, 0));
		
		while(!queue.isEmpty()) {
			node current = queue.poll();
			int node_index = current.index;
			int node_cost = current.cost;
			
			if(!visited[node_index]) {
				visited[node_index] = true;
				for(node adj : graph.get(node_index)) {
					if(dist[adj.index] > dist[node_index] + adj.cost) {
						dist[adj.index] = dist[node_index] + adj.cost;
						queue.offer(new node(adj.index, dist[adj.index]));
					}
				}
			}
				
		}
		
	}
}
		

