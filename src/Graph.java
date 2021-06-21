import java.util.LinkedList;

public class Graph {
	static int stop_count=0;
	static int vertex;
	static LinkedList<Edge>[] adjacency_List;

	Graph(int vertex) {
		this.vertex = vertex;
		adjacency_List = new LinkedList[vertex];
		
		for (int i = 0; i < vertex; i++) {
			adjacency_List[i] = new LinkedList<>(); //multilinkedlist
		}
	}

	public void addEdge(Vertex source, Vertex destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacency_List[source.getValue()].addFirst(edge);

		edge = new Edge(destination, source, weight);
		adjacency_List[destination.getValue()].addFirst(edge); // undirected graph
	}
}
