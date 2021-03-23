import java.util.*;
interface UndirectedGraph {
	void isConnected() ;
	void reachable(int a);
	void primMST();
	void shortestPath(int a, int b);
}
class Edge{
	   int node, weight;
	   Edge(int node, int weight){
		   this.node = node;
		   this.weight = weight;
	   }
	   int getNode(){
		   return node;
	   }
	   int getWeight(){
		   return weight;
	   }
}
class UndirectedWeightedGraph implements UndirectedGraph{
	public int vertices;
	public Vector<Edge> adjacencyList[];
	public UndirectedWeightedGraph(int x){
		vertices = x;
		adjacencyList = new Vector[vertices];
		for(int i=0;i<vertices;i++)
			adjacencyList[i] = new Vector<>();
    }
 
	//method to add edge in the adjacency list
    public void addEdge(int source, int destination, int w){
    	boolean ansSource=true;
    	for(int i=0; i<adjacencyList[source].size(); i++){
    		if(adjacencyList[source].get(i).node == destination){
    			ansSource = false;
    			break;
    		}
    	}
    	if(ansSource)
    		adjacencyList[source].add(new Edge(destination, w));
    	boolean ansDestination = true;
    	for(int i=0; i<adjacencyList[destination].size(); i++){
    		if(adjacencyList[destination].get(i).node == source){
    			ansDestination = false;
    			break;
    		}
    	}
    	if(ansDestination)
    		adjacencyList[destination].add(new Edge(source, w));
    }
    
    // it will return true if the graph is a connected graph
    public void isConnected(){
    	boolean[] visited = new boolean[vertices];
    	DFS(0, visited);
    	boolean connected = true;
    	for(int i=0; i<visited.length; i++){
    		if(!visited[i]){
    			connected = false;
    			break;
    		}
    	}
    	if(connected)
    		System.out.println("Graph is Connected\n\n");
    	else
    		System.out.println("Graph is Not Connected\n\n");
    }
    public void DFS(int source, boolean[] visited){
    	visited[source] = true;
    	  for(int i=0; i<adjacencyList[source].size(); i++){
    		 int neighbour = adjacencyList[source].get(i).node;
    		 if(visited[neighbour] == false)
    		    DFS(neighbour, visited);
    	  }
    }
    
    //it will return all the nodes that are reachable from node a
    public void reachable(int a){
    	System.out.println("\n\nNodes reachable from node " + a + " are ");
    	boolean visited[] = new boolean[vertices];
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	visited[a] = true;
    	queue.add(a);
    	while(queue.size()!= 0){
    		a = queue.poll();
    		System.out.print(a + " ");
    		Iterator<Edge> i = adjacencyList[a].listIterator();
    		while(i.hasNext()){
    			int n = i.next().node;
    			if(!visited[n]){
    				visited[n] = true;
    				queue.add(n);
    			}
    		}
    	}
    }
    
    //it will return the MST for the graph using the greedy approach
    public int minKey(int key[], boolean mstSet[]){
    	int min = Integer.MAX_VALUE;
    	int min_index = -1;
    	for(int v=0; v<vertices;  v++){
    		if(mstSet[v] == false && key[v] < min){
    			min = key[v];
    			min_index = v;
    		}
    	}
    	return min_index;
    }
    public void printMST(int parent[]){
    	System.out.println("The minimum spanning tree is ");
    	System.out.println("Edge \t Weight");
    	for(int i=1; i<vertices; i++){
    		int w = 0;
    		for(int j=0; j<adjacencyList[i].size(); j++){
    			if(adjacencyList[i].get(j).node == parent[i])
    				w = adjacencyList[i].get(j).weight;
    		}
    		System.out.println(parent[i] + " - " + i + "\t" + w);
    	}
    }
    public void primMST(){
    	int parent[] = new int[vertices];
    	int key[] = new int[vertices];
    	boolean mstSet[] = new boolean[vertices];
    	for(int i=0; i<vertices; i++){
    		key[i] = Integer.MAX_VALUE;
    		mstSet[i] = false;
    	}
    	key[0] = 0;
    	parent[0] = -1;
    	for(int i=0; i<vertices-1; i++){
    		int u = minKey(key, mstSet);
    		mstSet[u] = true;
    		for(int v=0; v<vertices; v++){
    			boolean ans = false;
    			int w = 0;
    			for(int j=0; j<adjacencyList[u].size(); j++){
    				if(adjacencyList[u].get(j).node == v){
    					ans = true;
    					w = adjacencyList[u].get(j).weight;
    				}
    			}
    			if(ans && mstSet[v] == false && w < key[v]){
    				parent[v] = u;
    				key[v] = w;
    			}
    		}
    	}
    	printMST(parent);
    }
    public void print(){
    	System.out.println("The graph is");
    	for(int i=0; i<vertices; i++){
    		for(int j=0; j<adjacencyList[i].size(); j++)
    			System.out.print(adjacencyList[i].get(j).node + " " + adjacencyList[i].get(j).weight + "  ");
    		System.out.println();
    	}
    } 
    
    //it will return the shortest path from node a to node b using Dijkstra’s algorithm. 
    public void shortestPath(int source, int destination){
    	int shortestDistances[] = new int[vertices];
    	boolean added[] = new boolean[vertices];
    	for(int i=0; i<vertices; i++){
    		shortestDistances[i] = Integer.MAX_VALUE;
    		added[i] = false;
    	}
    	shortestDistances[source] = 0;
    	int parents[] = new int[vertices];
    	parents[source] = -1;
    	for(int i=1; i<vertices; i++){
    		int nearestVertex = -1;
    		int shortestDistance = Integer.MAX_VALUE;
    		for(int j=0; j<vertices; j++){
    			if(!added[j] && shortestDistances[j] < shortestDistance){
    				nearestVertex = j;
    				shortestDistance = shortestDistances[j];
    			}
    		}
    		added[nearestVertex] = true;
    		for(int k=0; k<vertices; k++){
    			int edgeDistance = 0;
    			for(int l=0; l<adjacencyList[nearestVertex].size(); l++){
    				if(adjacencyList[nearestVertex].get(l).node == k)
    					edgeDistance = adjacencyList[nearestVertex].get(l).weight;
    			}
    			if(edgeDistance > 0 && ((shortestDistance+edgeDistance) < shortestDistances[k])){
    				parents[k] = nearestVertex;
    				shortestDistances[k] = shortestDistance + edgeDistance;
    			}
    		}
    	}
    	printSol(source, shortestDistances, parents, destination);
    }
    public void printSol(int source, int[] shortestDistances, int[] parents, int destination){
    	System.out.println("\n\nShortest path from node a to node b are ");
    	System.out.println("Vertex\t Distance\t Path");
    	if(source != destination){
    		System.out.print(source + " ->" + destination + " \t  " + shortestDistances[destination] + "\t\t");
    		printPath(destination, parents);
    	}
    	System.out.println();
    }
    public void printPath(int destination, int[] parents){
    	if(destination == -1)
    		return;
    	printPath(parents[destination], parents);
    	System.out.print(destination + " ");
    }
    
    public static void main(String args[]){
    	UndirectedWeightedGraph graph = new UndirectedWeightedGraph(5);
    	graph.addEdge(0, 1, 2);
    	graph.addEdge(0, 3, 6);
    	graph.addEdge(1, 2, 3);
    	graph.addEdge(1, 3, 8);
    	graph.addEdge(1, 4, 5);
    	graph.addEdge(2, 4, 7);
    	graph.addEdge(3, 4, 9);
    	graph.isConnected();
    	graph.primMST();
    	graph.shortestPath(2, 3);
    	graph.reachable(2);
    }
}
