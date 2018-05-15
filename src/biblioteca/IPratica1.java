package biblioteca;

public interface IPratica1 {
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public boolean readGraph(String path);
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public boolean readWeightedGraph(String path);
	
	/**
	 * 
	 * @param graph
	 * @return
	 */
	public int getVertexNumber(Graph graph);
	
	/**
	 * 
	 * @param graph
	 * @return
	 */
	public int getEdgeNumber(Graph graph);
	
	/**
	 * O grau médio do grafo é o número 2E/V
	 * @param graph
	 * @return
	 */
	public float getMeanEdge(Graph graph);
	
	/**
	 * 
	 * @param graph
	 * @param type
	 * @return
	 */
	public String graphRepresentation(Graph graph, RepresentationType type);
	
	/**
	 * 
	 * @param graph
	 * @param v
	 * @return
	 */
	public String BFS(Graph graph, Vertice v);
	
	/**
	 * 
	 * @param graph
	 * @param v
	 * @return
	 */
	public String DFS(Graph graph, Vertice v);
	
	/**
	 * 
	 * @param graph
	 * @return
	 */
	public boolean connected(Graph graph);
	
	
	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public String shortestPath(Vertice v1, Vertice v2);
	
	/**
	 * 
	 * @param graph
	 * @return
	 */
	public String mst(Graph graph);

}
