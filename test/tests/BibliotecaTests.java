package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Biblioteca;

public class BibliotecaTests {

	Biblioteca grafo = new Biblioteca();
	Biblioteca gPonderado = new Biblioteca();
	
	@Before
	public void init(){
		grafo.readGraph("grafo.txt");
		gPonderado.readGraph("grafoPonderado.txt");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
