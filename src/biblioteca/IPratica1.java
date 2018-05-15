package biblioteca;

public interface IPratica1 {
	
	/**
	 * Mapeia o conte�do do arquivo para criar um grafo.
	 * @param path
	 * @return boolean
	 */
	public boolean readGraph(String path);
	
	/**
	 * Mapeia o conte�do do arquivo para criar um grafo com pesos.
	 * @param path
	 * @return boolean
	 */
	public boolean readWeightedGraph(String path);
	
	/**
	 * Retorna o n�mero de v�rtices do Grafo.
	 * @param graph
	 * @return int
	 */
	public int getVertexNumber(Graph graph);
	
	/**
	 * Retorna o n�mero de arestas do Grafo.
	 * @param graph
	 * @return int
	 */
	public int getEdgeNumber(Graph graph);
	
	/**
	 * Retorna o resultado do c�lculo do grau m�dio do grafo.
	 * @param graph
	 * @return float
	 */
	public float getMeanEdge(Graph graph);
	
	/**
	 * Retorna o uma string com a representa��o do grafo de acordo com o tipo especificado.
	 * @param graph
	 * @param type
	 * @return String
	 */
	public String graphRepresentation(Graph graph, RepresentationType type);
	
	/**
	 * Busca em largura de um elemento no grafo.
	 * @param graph
	 * @param v
	 * @return String
	 */
	public String BFS(Graph graph, Vertice v);
	
	/**
	 * Busca em profundidade de um elemento no grafo.
	 * @param graph
	 * @param v
	 * @return String
	 */
	public String DFS(Graph graph, Vertice v);
	
	/**
	 * Verifica se o grafo � conexo.
     * De um v�rtice do grafo deve haver um caminho para todos os outros para o mesmo ser conexo.
	 * @param graph
	 * @return boolean
	 */
	public boolean connected(Graph graph);
	
	
	/**
	 * Retorna o menor caminho de um v�rtice 1 para um v�rtice 2.
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public String shortestPath(Vertice v1, Vertice v2);
	
	/**
	 * Retorna a �rvore geradora m�nima de um grafo.
	 * @param graph
	 * @return String
	 */
	public String mst(Graph graph);

}
