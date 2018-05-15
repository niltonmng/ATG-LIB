package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Object>{
	
	String nome;
	List<Aresta> adj;
	
	Vertice(String nome) {
		this.nome = nome;
		this.adj = new ArrayList<Aresta>();
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public List<Aresta> getAdj() {
		return this.adj;
	}
	
	public void addAdj(Aresta e) {
		this.adj.add(e);
	}
	
	@Override
	public int compareTo(Object o) {
		Vertice v = (Vertice) o;
		return this.nome.compareTo(v.nome);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Vertice) {
			Vertice v = (Vertice) o;
			return this.nome.equalsIgnoreCase(v.nome);
		}
		return false;
	}

}