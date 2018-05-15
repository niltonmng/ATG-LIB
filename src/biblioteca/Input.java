package biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    
    @SuppressWarnings("resource")
	public Graph readGraph(String path) throws IOException {
    	
    	Graph graph = new Graph();
    	try {
	    	FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			
			graph.setSize(Integer.parseInt(linha));
			linha = lerArq.readLine();
    		while (linha != null) {
    			String[] info = linha.split(" ");
    			
    			graph.addAresta(graph.addVertice(info[0]), graph.addVertice(info[1]));
    	 
    	        linha = lerArq.readLine();
    		}
    	} catch (IOException io){
    		System.err.println("Falha na leitura do arquivo");
    	} 
    	
		
		
		return graph;
	}
    
    @SuppressWarnings("resource")
	public Graph readWeightedGraph(String path) throws IOException {
		Graph graph = new Graph();
		
		try {
	    	FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);
			
			String linha = lerArq.readLine();
			graph.setSize(Integer.parseInt(linha));
			linha = lerArq.readLine();
			
    		while (linha != null) {
    			String[] info = linha.split(" ");
    			
    			graph.addAresta(graph.addVertice(info[0]), graph.addVertice(info[1]), Double.parseDouble(info[2]));
    	 
    	        linha = lerArq.readLine();
    		}
    	} catch (IOException io){
    		System.err.println("Falha na leitura do arquivo");
    	}
		
		return graph;
	}
    
    

}
