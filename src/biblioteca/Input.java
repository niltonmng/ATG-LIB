package biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    
    public Graph readGraph(String path) throws IOException {
    	
    	Graph graph = new Graph();
    	try {
	    	FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();

			linha = lerArq.readLine();
			
    		while (linha != null) {
    			String[] line = linha.split(" ");
    			
    			Vertice origem = graph.addVertice(line[0]);
    			Vertice destino = graph.addVertice(line[1]);
    			graph.addAresta(origem, destino);
    	 
    	        linha = lerArq.readLine();
    		}
    	} catch (IOException io){
    		System.err.println("Falha na leitura do arquivo");
    	} 
    	
		
		
		return graph;
	}
    
    public Graph readWeightedGraph(String path) throws IOException {
		Graph graph = new Graph();
		
		try {
	    	FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			linha = lerArq.readLine();
			
    		while (linha != null) {
    			String[] line = linha.split(" ");
    			
    			Vertice origem = graph.addVertice(line[0]);
    			Vertice destino = graph.addVertice(line[1]);
    			graph.addAresta(origem, destino, Double.parseDouble(line[1]));
    	 
    	        linha = lerArq.readLine();
    		}
    	} catch (IOException io){
    		System.err.println("Falha na leitura do arquivo");
    	}
		
		return graph;
	}
    
    

}
