import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class File_Reader {
	LinkedList<Vertex>[] vertex;
	private BufferedReader br;
	Graph g;

	public void Adding_vertex() {
		int counter = 0;
		try {
			File file = new File("Stop.txt");
			br = new BufferedReader(new FileReader(file));
			String row;
			row = br.readLine();
			while ((row = br.readLine()) != null) {
				counter++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("ERROR !");
		}
		vertex = new LinkedList[counter];
		for (int i = 0; i < counter; i++) {
			vertex[i] = new LinkedList<>();
		}
		try {
			int count = 0;
			File file = new File("Stop.txt");
			br = new BufferedReader(new FileReader(file));
			String row;
			row = br.readLine();
			while ((row = br.readLine()) != null) {
				String[] splitted = row.split(";");
				for (int i = count; i < vertex.length; i++) {
					Vertex vertex_temp = new Vertex(splitted[1], Integer.valueOf(splitted[0]));
					vertex[i].add(vertex_temp);
					count++;
					break;
				}

			}
			br.close();
		} catch (Exception e) {
			System.out.println("ERROR !");
		}
		counter=9999999;
		g = new Graph(counter);
	}

	public void Read_graph() {
		Vertex a = null;
		Vertex b = null;
		try {
			File file = new File("Distance.txt");
			br = new BufferedReader(new FileReader(file));
			String row;
			row = br.readLine();
			while ((row = br.readLine()) != null) {
				String[] splitted = row.split(";");
				// int temp_origin_stop_id = 0;
				// int temp_destination_stop_id = 0;

				for (int j = 0; j < vertex.length; j++) {
					if (vertex[j].get(0).value == Integer.valueOf(splitted[0])) {
						a = new Vertex(vertex[j].get(0).name, vertex[j].get(0).value);
						break;
					}
				}
				for (int j = 0; j < vertex.length; j++) {
					if (vertex[j].get(0).value == Integer.valueOf(splitted[1])) {
						b = new Vertex(vertex[j].get(0).name, vertex[j].get(0).value);
						break;
					}
				}

				// Vertex a=new
				// Vertex(vertex[Integer.valueOf(splitted[0])].get(0).name,vertex[Integer.valueOf(splitted[0])].get(0).value);
				// Vertex b=new
				// Vertex(vertex[Integer.valueOf(splitted[1])].get(0).name,vertex[Integer.valueOf(splitted[1])].get(0).value);
				g.addEdge(a, b, Integer.valueOf(splitted[2]));
			}
			br.close();
		} catch (Exception e) {
			System.out.println("ERROR !");
		}
	}

}
