package biblioteca;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
	
	private static final String NEW_LINE = System.lineSeparator();

	ArrayList<Vertice> vertices;
	List<Aresta> arestas;

	public Graph() {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
	}

	Vertice addVertice(String nome) {
		Vertice v = new Vertice(nome);
		if (! this.contemVertice(v)) {
			this.vertices.add(v);
			
			return v;
		}
		return null;
	}

	private boolean contemVertice(Vertice v) {
		for (Vertice ver : vertices) {
			if (ver.nome.equals(v.nome)) {
				return true;
			}
		}
		return false;
	}

	Aresta addAresta(String o, String d) {
		
		Vertice origem = new Vertice(o);
		Vertice destino = new Vertice(d);
		
		Aresta e = new Aresta(origem, destino);
		this.arestas.add(e);
		
		return e;
	}

	Aresta addAresta(String o, String d, double weight) {
		
		Vertice origem = new Vertice(o);
		Vertice destino = new Vertice(d);
		
		Aresta e = new Aresta(origem, destino, weight);
		this.arestas.add(e);
		
		return e;
	}
	
	public String toStringAL() {
		
		Collections.sort(vertices);
		String saida = "";
		
		for (Vertice x : this.vertices) {
			saida += x.nome + " -> ";
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