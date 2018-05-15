package biblioteca;

public class Vertice implements Comparable<Object>{
	
	String nome;
	boolean visitado;

	Vertice(String nome) {
		this.nome = nome;
		this.visitado = false;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public void setVisitado (boolean visita) {
		this.visitado = visita;
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