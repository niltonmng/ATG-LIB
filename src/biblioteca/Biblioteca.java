package biblioteca;

import java.io.IOException;

public class Biblioteca implements IPratica1 {
	
	private Graph graph;
	
	@Override
	public boolean readGraph(String path) {
		try {
			Input input = new Input();
			this.graph = input.readGraph(path);
		} catch (IOException e) {
			System.err.println("Falha na leitura!");
		}
		return true;
	}

	@Override
	public boolean readWeightedGraph(String path) {
		try {
			Input input = new Input();
			this.graph = input.readWeightedGraph(path);
		} catch (IOException e) {
			System.err.println("Falha na leitura!");
		}
		return true;
	}

	@Override
	public int getVertexNumber(Graph graph) {
		return graph.getVertexNumber();
	}

	@Override
	public int getEdgeNumber(Graph graph) {
		return graph.getEdgeNumber();
	}

	@Override
	public float getMeanEdge(Graph graph) {
		return 2*this.getEdgeNumber(graph)/this.getVertexNumber(graph);
	}

	@Override
	public String graphRepresentation(Graph graph, RepresentationType type) {
		return graph.graphRepresentation(type);
	}

	@Override
	public String BFS(Graph graph, Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DFS(Graph graph, Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SCC(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String shortestPath(Vertice v1, Vertice v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mst(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public static void main(String[] args) {


		Biblioteca biblioteca = new Biblioteca();

		biblioteca.readGraph("grafo.txt");
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));
		
		biblioteca.readWeightedGraph("grafoPonderado.txt");
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

	}

}
