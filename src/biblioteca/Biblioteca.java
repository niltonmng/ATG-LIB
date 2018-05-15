package biblioteca;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe que representa a entidade Biblioteca com funcionalidades para um grafo.
 */
public class Biblioteca implements IPratica1 {

	private Graph graph;

	/**
     * Mapeia o conte�do do arquivo para criar um grafo.
     */
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

	/**
     * Mapeia o conte�do do arquivo para criar um grafo com pesos.
     */
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

	/**
     * Retorna o n�mero de v�rtices do Grafo.
     */
	@Override
	public int getVertexNumber(Graph graph) {
		return graph.getVertexNumber();
	}

	/**
     * Retorna o n�mero de arestas do Grafo.
     */
	@Override
	public int getEdgeNumber(Graph graph) {
		return graph.getEdgeNumber();
	}

	/**
     * Retorna o resultado do c�lculo do grau m�dio do grafo.
     */
	@Override
	public float getMeanEdge(Graph graph) {
		return 2 * this.getEdgeNumber(graph) / this.getVertexNumber(graph);
	}

	/**
     * Retorna o uma string com a representa��o do grafo de acordo com o tipo especificado.
     */
	@Override
	public String graphRepresentation(Graph graph, RepresentationType type) {
		return graph.graphRepresentation(type);
	}

	/**
     * Busca em largura de um elemento no grafo.
     */
	@Override
	public String BFS(Graph graph, Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int[] bfs(Vertice v, int size) {
        Queue<Vertice> fila = new LinkedList<>();
        
        int[] distancia = new int[size+1];
        
        fillDist(distancia);
        
        Vertice raiz = graph.vertices.get(0);
    	int raizIndex = Integer.parseInt(raiz.toString());
    	
    	distancia[raizIndex] = 0;
    	
        fila.add(raiz);

        while(!fila.isEmpty()) {

            Vertice u = fila.remove();
            System.out.println(u.getAdj().toString());
            for (Aresta aresta : u.getAdj()) {
            	Vertice vertice = aresta.destino;
            	System.out.println(aresta.origem.nome + " - > " + vertice.nome);

            	int uIndex = Integer.parseInt(u.toString());
            	int verticeIndex = Integer.parseInt(vertice.toString());
            	
            	if(distancia[uIndex]+1 < distancia[verticeIndex]){
            		distancia[verticeIndex] = distancia[uIndex]+1;
            		fila.add(vertice);
            	}
            }
        }
        
        System.out.println(Arrays.toString(distancia));
        return distancia;
	}
	
	private void fillDist(int[] dist) {
		int INF = 2222;
		for (int i = 0; i < dist.length; i++) {
			dist[i] = INF;
		}
	}
	/**
     * Busca em profundidade de um elemento no grafo.
     */
	@Override
	public String DFS(Graph graph, Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int[] dfs(Vertice v, int size) {
		
		return null;
	}
	
	/**
     * Verifica se o grafo � conexo.
     * De um v�rtice do grafo deve haver um caminho para todos os outros para o mesmo ser conexo.
     */
	@Override
	public boolean connected(Graph graph) {
		Vertice v = graph.vertices.get(0);
//        int[] visitado = this.dfs(graph.getVertexNumber(), v);

        return true;
	}

	/**
     * Retorna o menor caminho de um v�rtice 1 para um v�rtice 2.
     */
	@Override
	public String shortestPath(Vertice v1, Vertice v2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Retorna a �rvore geradora m�nima de um grafo.
     */
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
		Vertice v = biblioteca.getGraph().vertices.get(0);

		biblioteca.bfs(v, biblioteca.getGraph().getVertexNumber());
//		System.out.println(biblioteca.connected(biblioteca.getGraph()));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

		biblioteca.readWeightedGraph("grafoPonderado.txt");
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

	}

}
