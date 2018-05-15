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

	public Aresta(Vertice origem, Vertice destino) {
		this.origem = origem;
		this.destino = destino;
		this.peso = 0.0;
	}
	
	public Aresta(Vertice origem, Vertice destino, double peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
	
	public boolean compare(Aresta a, Aresta b) {
		return a.peso <= b.peso;
	}
	
	public String toString() {
		return this.origem.getNome() + " -> " + this.destino.getNome();
	}

	@Override
	public int compareTo(Aresta a) {
		if (this.peso < a.getPeso()) {
			return -1;
		} else if (this.peso > a.getPeso()) {
			return -1;
		}
		
		return 0;
	}

	
}