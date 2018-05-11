package biblioteca;

import java.util.List;
import java.util.ArrayList;

public class Graph {

	List<Vertice> vertices;
	List<Aresta> arestas;

	public Graph() {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
	}

	Vertice addVertice(String nome) {
		Vertice v = new Vertice(nome);
		this.vertices.add(v);
		return v;
	}

	Aresta addAresta(Vertice origem, Vertice destino) {
		Aresta e = new Aresta(origem, destino);
		origem.addAdj(e);
		this.arestas.add(e);
		return e;
	}

	Aresta addAresta(Vertice origem, Vertice destino, double weight) {
		Aresta e = new Aresta(origem, destino, weight);
		origem.addAdj(e);
		this.arestas.add(e);
		return e;
	}
	
	public String toStringAL() {
		String saida = "";
		for (Vertice x : this.vertices) {
			saida += x.nome + " -> ";
			for (Aresta e : x.adj) {
				Vertice v = e.destino;
				saida += v.nome + " ";
			}
			saida += "\n";
		}
		return saida;
	}
	
	// Fazer
	public String toStringAM() {
		String saida = "";
		
		return saida;
	}

	public int getVertexNumber() {
		return this.vertices.size();
	}

	public int getEdgeNumber() {
		return this.arestas.size();
	}

	
	// Terminar
	public String graphRepresentation(RepresentationType type) {
		if(type.equals(RepresentationType.AL)){
			return this.toStringAL();
		}
		else if(type.equals(RepresentationType.AM)){
			return "fazer esta representa��o";
		}
		throw new RuntimeException("Not a valid representation!");
	}
}