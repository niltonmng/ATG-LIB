package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable{
	
	String nome;

	Vertice(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}

	@Override
	public int compareTo(Object o) {
		Vertice v = (Vertice) o;
		
		return this.nome.compareTo(v.nome);
	}
	

}