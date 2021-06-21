import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {

	public void dijkstra(int start, int finish) {
		boolean[] sptSet = new boolean[Graph.vertex];
		int[] distance = new int[Graph.vertex];

		for (int i = 0; i < Graph.vertex; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Graph.vertex,
				Comparator.comparingInt(o -> o.getWeight()));
		distance[start] = 0;

		Vertex V = new Vertex("", start);
		Edge start_priorityQueue = new Edge(V, start);
		priorityQueue.offer(start_priorityQueue);

		while (!priorityQueue.isEmpty()) {
			Edge edge_temp = priorityQueue.poll();
			int start_vertex = edge_temp.getWeight();
			if (sptSet[start_vertex] == false) {
				sptSet[start_vertex] = true;
				LinkedList<Edge> edge_list = Graph.adjacency_List[start_vertex];
				for (int i = 0; i < edge_list.size(); i++) {
					
					Edge edge = edge_list.get(i);
					int destination = edge.destination.getValue();
					if (sptSet[destination] == false) {
						
						int new_value = distance[start_vertex] + edge.weight;
						int current = distance[destination];
						if (current > new_value) {
							V = new Vertex("", new_value);
							edge_temp = new Edge(V, destination);
							priorityQueue.offer(edge_temp);
							distance[destination] = new_value;
							//Graph.stop_count++;
						}

					}
				}
			}
		}
		printMinresult(distance, start, finish);
	}

	public void printMinresult(int[] distance, int start, int finish) {
		System.out.println("\t\t   The shortest path\n\n(" + start + ")-" + Graph.adjacency_List[start].get(0).source.name
						+ " --> (" + finish + ")-" + Graph.adjacency_List[finish].get(0).source.name
						+ "\n\n\t\t   Distance = " + distance[finish]);
	}

}
