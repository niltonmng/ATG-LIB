package biblioteca;

public class Aresta implements Comparable<Aresta>{
	
	private Vertice origem;
	private Vertice destino;
	private double peso;

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	Aresta(Vertice origem, Vertice destino) {
		this.origem = origem;
		this.destino = destino;
		this.peso = 0.0;
	}
	
	Aresta(Vertice origem, Vertice destino, double peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
	
	public String toString() {
		return this.origem.getNome() + " -> " + this.destino.getNome();
	}

	@Override
	public int compareTo(Aresta arg0) {
		if(this.peso < arg0.getPeso()) {
			return -1;
		} else if (this.peso > arg0.getPeso()) {
			return 1;
		}
		return 0;
	}
}