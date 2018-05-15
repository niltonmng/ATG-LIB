package biblioteca;

public class Main {
	
	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();
		biblioteca.readGraph("grafo.txt");
		Vertice v = biblioteca.getGraph().getVertices().get(0);

		System.out.println(biblioteca.BFS(biblioteca.getGraph(), v));
		System.out.println(biblioteca.DFS(biblioteca.getGraph(), v));
		System.out.println(biblioteca.connected(biblioteca.getGraph()));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

		biblioteca.readWeightedGraph("grafoPonderado.txt");
		System.out.println(biblioteca.getGraph().getSize());
		biblioteca.shortestPath(biblioteca.getVertexByName(1), biblioteca.getVertexByName(5));
		System.out.println();
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

	}

}
