package biblioteca;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Classe que representa a entidade Biblioteca com funcionalidades para um grafo.
 */
public class Biblioteca implements IPratica1 {

	private Graph graph;

	/**
     * Mapeia o conteúdo do arquivo para criar um grafo.
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
     * Mapeia o conteúdo do arquivo para criar um grafo com pesos.
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
     * Retorna o número de vértices do Grafo.
     */
	@Override
	public int getVertexNumber(Graph graph) {
		return graph.getVertexNumber();
	}

	/**
     * Retorna o número de arestas do Grafo.
     */
	@Override
	public int getEdgeNumber(Graph graph) {
		return graph.getEdgeNumber();
	}

	/**
     * Retorna o resultado do cálculo do grau médio do grafo.
     */
	@Override
	public float getMeanEdge(Graph graph) {
		return 2 * this.getEdgeNumber(graph) / this.getVertexNumber(graph);
	}

	/**
     * Retorna o uma string com a representação do grafo de acordo com o tipo especificado.
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

	/**
     * Busca em profundidade de um elemento no grafo.
     */
	@Override
	public String DFS(Graph graph, Vertice v) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Verifica se o grafo é conexo.
     * De um vértice do grafo deve haver um caminho para todos os outros para o mesmo ser conexo.
     */
	@Override
	public boolean connected(Graph graph) {
        Queue<Vertice> fila = new LinkedList<>();
        
        int verticesVisitados = 0;
        
        Vertice raiz = graph.vertices.get(0);

        raiz.setVisitado(true);
        fila.add(raiz);

        while(!fila.isEmpty()) {

            Vertice pai = fila.remove();
            Vertice filho = null;
            
            boolean nivelAtual = false;
            
            while ((filho = filhoNaoVisitado(graph, pai)) != null) {
            	
            	if(!nivelAtual){
                    nivelAtual = true;
                    verticesVisitados++;
                }
            	
            	filho.setVisitado(true);
                fila.add(filho);
            }
        }
        limpaVisitas(graph);
        return (verticesVisitados == graph.vertices.size());
	}

	/**
     * Limpa as visitas feitas nos vértice.
     */
	private void limpaVisitas(Graph graph) {
		for (Vertice vertice : graph.vertices) {
			vertice.visitado = false;
		}
	}
	
	/**
     * Verifica e retorna um filho não visitado do pai.
     */
	private Vertice filhoNaoVisitado(Graph graph, Vertice pai) {
		for (Aresta aresta : graph.arestas) {
			Vertice vertice1 = aresta.origem;
			Vertice vertice2 = aresta.destino;

			if (vertice1.equals(pai) && !(vertice2.visitado)) {
				return vertice2;
			} else if (vertice2.equals(pai) && !(vertice1.visitado)) {
				return vertice1;
			}
		}
		return null;
	}

	/**
     * Retorna o menor caminho de um vértice 1 para um vértice 2.
     */
	@Override
	public String shortestPath(Vertice v1, Vertice v2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Retorna a árvore geradora mínima de um grafo.
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
		System.out.println(biblioteca.connected(biblioteca.getGraph()));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

		biblioteca.readWeightedGraph("grafoPonderado.txt");
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

	}

}
