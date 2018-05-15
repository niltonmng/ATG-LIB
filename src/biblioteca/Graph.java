package biblioteca;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa a entidade Grafo.
 */
public class Graph {
	
	//private static final String NEW_LINE = System.lineSeparator();

	ArrayList<Vertice> vertices;
	List<Aresta> arestas;

	public Graph() {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
	}

	/**
     * Adiciona um vértice ao grafo.
     */
	Vertice addVertice(String nome) {
		Vertice v = new Vertice(nome);
		if (! this.contemVertice(v)) {
			this.vertices.add(v);
			
			return v;
		}
		return null;
	}

	/**
     * Verifica se o vértice a ser inserido no grafo já existe.
     */
	private boolean contemVertice(Vertice v) {
		for (Vertice ver : vertices) {
			if (ver.nome.equals(v.nome)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Adiciona uma aresta ao grafo.
     */
	Aresta addAresta(String o, String d) {
		
		Vertice origem = new Vertice(o);
		Vertice destino = new Vertice(d);
		
		Aresta e = new Aresta(origem, destino);
		this.arestas.add(e);
		
		return e;
	}

	/**
     * Adiciona uma aresta com peso ao grafo.
     */
	Aresta addAresta(String o, String d, double weight) {
		
		Vertice origem = new Vertice(o);
		Vertice destino = new Vertice(d);
		
		Aresta e = new Aresta(origem, destino, weight);
		this.arestas.add(e);
		
		return e;
	}
	
	/**
     * Retorna grafo em forma de lista de adjacência.
     */
	public String toStringAL() {
		
		Collections.sort(vertices);
		String saida = "";
		
		for (Vertice x : this.vertices) {
			saida += x.nome + " - ";
			for (Aresta e : arestas) {
				if (x.nome.equals(e.origem.nome)) {
					Vertice v = e.destino;
					saida += v.nome + " ";
				} else if (x.nome.equals(e.destino.nome)) {
					Vertice v = e.origem;
					saida += v.nome + " ";
				}
			}
			saida += "\n";
		}
		return saida;
	}
	
	/**
     * Retorna o vértice de maior valor no grafo.
     */
	private int maiorVertice(){
		int maior = 0;
		for (int i = 0; i < vertices.size(); i++) {
			if(Integer.parseInt(vertices.get(i).nome) > maior) maior = Integer.parseInt(vertices.get(i).nome);
		}
		return maior;
	}
	
	/**
     * Verifica se valor está presente na lista.
     */
	private boolean contem(ArrayList<Integer> lista, int valor){
		if(lista.contains(valor)) return true;
		return false;
	}

	/**
     * Retorna grafo em forma de matriz de adjacência.
     */
	public String toStringAM() {
		String saida = "";
		int[][] matriz = new int[this.maiorVertice()+1][this.maiorVertice()+1];
		
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][0] = i;
		}
		for (int i = 0; i < matriz.length; i++) {
			matriz[0][i] = i;
		}
		
		for (Vertice x : this.vertices) {
			String aux = "";
			for (Aresta e : arestas) {
				if (x.nome.equals(e.origem.nome)) {
					Vertice v = e.destino;
					aux += v.nome + " ";
				} else if (x.nome.equals(e.destino.nome)) {
					Vertice v = e.origem;
					aux += v.nome + " ";
				}
			}
			aux.trim();
			String[] quebra = aux.split(" ");
			ArrayList<Integer> aux2 = new ArrayList<Integer>();
			
			for (int i = 0; i < quebra.length; i++) {
				aux2.add(Integer.parseInt(quebra[i]));
			}
			Collections.sort(aux2);
			
			int i = Integer.parseInt(x.nome);
			for (int j = 1; j < matriz.length; j++) {
				if(contem(aux2, j)) matriz[i][j] = 1;
				else matriz[i][j] = 0;
			}
			
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				saida += matriz[i][j] + " ";
			}
			saida += "\n";
		}		

		return saida;
	}

	/**
     * Retorna o número de vértices do Grafo.
     */
	public int getVertexNumber() {
		return this.vertices.size();
	}

	/**
     * Retorna o número de arestas do Grafo.
     */
	public int getEdgeNumber() {
		return this.arestas.size();
	}

	public String graphRepresentation(RepresentationType type) {
		if(type.equals(RepresentationType.AL)){
			return this.toStringAL();
		}
		else if(type.equals(RepresentationType.AM)){
			return this.toStringAM();
		}
		throw new RuntimeException("Not a valid representation!");
	}
}