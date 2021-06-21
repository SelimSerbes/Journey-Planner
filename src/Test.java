public class Test {

	public static void main(String[] args) {
		File_Reader graph=new File_Reader();
		graph.Adding_vertex();
		graph.Read_graph();
		Dijkstra D=new Dijkstra();
		D.dijkstra(40015, 40737);
	}

}
