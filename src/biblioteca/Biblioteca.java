package biblioteca;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Classe que representa a entidade Biblioteca com funcionalidades para um grafo.
 */
public class Biblioteca implements IPratica1 {
	
	public static int INF = 100000000;
	public static String NOVA_LINHA = System.lineSeparator();
	
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
		int size = graph.getSize();
		
        int[] distancia = new int[size];
        int[] pais = new int[size];
        
        fillDist(distancia);
        fillPais(pais);
        
        bfs(v, distancia, pais);
        
        String resposta = "";
        for (int i = 1; i < size; i++) {
        	resposta += i + " - " + distancia[i] + " ";
        	if (pais[i] == -1) {
        		resposta += "-";
        	} else {
        		resposta += pais[i];
        	}
        	resposta += NOVA_LINHA;
        }
		return resposta;
	}
	
	public int[] bfs(Vertice v, int[] distancia, int[] pais) {
        Queue<Vertice> fila = new LinkedList<>();
        
        Vertice raiz = graph.getVertices().get(0);
    	int raizIndex = Integer.parseInt(raiz.toString());
    	
    	distancia[raizIndex] = 0;
    	
        fila.add(raiz);

        while(!fila.isEmpty()) {
            Vertice u = fila.remove();

            for (Aresta aresta : u.getAdj()) {
            	Vertice vertice = aresta.getDestino();

            	int uIndex = Integer.parseInt(u.getNome());
            	int verticeIndex = Integer.parseInt(vertice.getNome());
            	
            	if(distancia[uIndex]+1 < distancia[verticeIndex]){
            		distancia[verticeIndex] = distancia[uIndex]+1;
            		pais[verticeIndex] = uIndex;
            		fila.add(vertice);
            	}
            }
        }
        
        return distancia;
	}
	
	private void fillPais(int[] pais) {
		for (int i = 0; i < pais.length; i++) {
			pais[i] = -1;
		}
	}
	
	private void fillDist(int[] dist) {
		for (int i = 0; i < dist.length; i++) {
			dist[i] = INF;
		}
	}
	
	/**
     * Busca em profundidade de um elemento no grafo.
     */
	@Override
	public String DFS(Graph graph, Vertice v) {
		int size = graph.getSize();
		int[] visitado = new int[size];
        int[] pais = new int[size];
		int[] nivel = new int[size];

		fillVis(visitado);
		fillPais(pais);
		fillNivel(nivel);
		
		this.dfs(v, visitado, pais, nivel, 0);
		
		String resposta = "";
        for (int i = 1; i < size; i++) {
        	if (nivel[i] == INF) {
        		nivel[i] = 0;
        	}
        	resposta += i + " - " + nivel[i] + " ";
        	if (pais[i] == -1) {
        		resposta += "-";
        	} else {
        		resposta += pais[i];
        	}
        	resposta += NOVA_LINHA;
        }
		
		return resposta;
	}
	
	private void fillVis(int[] vis) {
		for (int i = 0; i < vis.length; i++) {
			vis[i] = 0;
		}
	}
	
	private void fillNivel(int[] nivel) {
		for (int i = 0; i < nivel.length; i++) {
			nivel[i] = INF;
		}
	}
	
	private void dfs(Vertice v, int[] visitado, int[] pais, int[] nivel, int nivelValor) {
		int verticeIndex = Integer.parseInt(v.getNome());
		
		if (visitado[verticeIndex] == 1) {
			return;
		}
		
		visitado[verticeIndex] = 1;
		nivel[verticeIndex] = Math.min(nivel[verticeIndex],nivelValor);

		for (Aresta e : v.getAdj()) {
			int destinoIndex = Integer.parseInt(e.getDestino().getNome());
			if (visitado[destinoIndex] == 0) {
				pais[destinoIndex] = verticeIndex;
				dfs(e.getDestino(), visitado, pais, nivel, nivelValor+1);
			}
		}
	}
	
	private void connected(Vertice v, int[] visitado) {
		int verticeIndex = Integer.parseInt(v.getNome());
		
		if (visitado[verticeIndex] == 1) {
			return;
		}
		
		visitado[verticeIndex] = 1;

		for (Aresta e : v.getAdj()) {
			int destinoIndex = Integer.parseInt(e.getDestino().getNome());
			if (visitado[destinoIndex] == 0) {
				connected(e.getDestino(), visitado);
			}
		}
	}
	
	/**
     * Verifica se o grafo � conexo.
     * De um v�rtice do grafo deve haver um caminho para todos os outros para o mesmo ser conexo.
     */
	@Override
	public boolean connected(Graph graph) {
		Vertice v = graph.getVertices().get(0);
		int size = graph.getSize();
		
        int[] visitado = new int[size];

        this.connected(v, visitado);
        
        for (int i = 1; i < size; i++) {
        	if (visitado[i] == 0) {
        		return false;
        	}
        }
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
	
	class subset {
		int parent, rank;
	};
	
	/**
     * Retorna a �rvore geradora m�nima de um grafo.
     */
	@Override
	public String mst(Graph graph) {
		List<Aresta> arestas = graph.getArestas();
		Collections.sort(arestas);
		
		System.out.println(arestas.toString());
		
		int numeroDeArestas = 0;
		int indice = 0;
		int numeroDeVertices = graph.getVertexNumber();
		
		subset subsets[] = new subset[graph.getSize()];
        for(int i = 1; i < graph.getSize(); i++) {
            subsets[i]= new subset();
        }
        
		Graph tree = new Graph();
		tree.setSize(numeroDeVertices-1);
		
		while (numeroDeArestas < numeroDeVertices - 1)
        {
            // Step 2: Pick the smallest edge. And increment 
            // the index for next iteration
            Aresta proxAresta = arestas.get(indice++);
            
            
            int x = this.find(subsets, Integer.parseInt(proxAresta.getOrigem().getNome()));
            int y = this.find(subsets,  Integer.parseInt(proxAresta.getDestino().getNome()));
 
            // If including this edge does't cause cycle,
            // include it in result and increment the index 
            // of result for next edge
            if (x != y)
            {
                tree.addAresta(proxAresta.getOrigem(), proxAresta.getDestino());
                numeroDeArestas++;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
 
		System.out.println(this.BFS(tree, tree.getVertices().get(0)));
		return null;
	}
	
	private int find(subset[] subsets, int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
	
	private void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
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
		Vertice v = biblioteca.getGraph().getVertices().get(0);

		System.out.println(biblioteca.BFS(biblioteca.graph, v));
		System.out.println(biblioteca.DFS(biblioteca.graph, v));
		System.out.println(biblioteca.connected(biblioteca.getGraph()));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

		biblioteca.readWeightedGraph("grafoPonderado.txt");
		biblioteca.mst(biblioteca.graph);
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AL));
		System.out.println(biblioteca.graphRepresentation(biblioteca.getGraph(), RepresentationType.AM));

	}

}
