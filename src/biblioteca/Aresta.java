package biblioteca;

public class Aresta {
	
	Vertice origem;
	Vertice destino;
	double peso;

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
		return this.origem.nome + " -> " + this.destino.nome;
	}
}