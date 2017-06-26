import static org.junit.Assert.*;

import org.junit.Test;

import grafos.GrafoGenerator;
import grafos.GrafoNDNP;

public class Pruebas {

	@Test
	public void bfsSimple() {
		System.out.println("BFS");
		GrafoNDNP g = GrafoGenerator.probArista(10, 40);
		System.out.println(g);
		Bfs bfs = new Bfs(g);
		bfs.run(2);
	}

	
	@Test
	public void dfsSimple() {
		System.out.println("DFS");
		GrafoNDNP g = GrafoGenerator.probArista(10, 30);
		System.out.println(g);
		Dfs dfs = new Dfs(g);
		dfs.run(2);
	}
}
