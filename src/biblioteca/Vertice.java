package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Object>{
	
	private String nome;
	private List<Aresta> adj;
	
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
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAdj(List<Aresta> adj) {
		this.adj = adj;
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