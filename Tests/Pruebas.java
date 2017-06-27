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
	
	@Test
	public void dijkstraSimple() {
		System.out.println("Dijkstra");
		
		GrafoPonderado g = new GrafoPonderado(8);
		g.conectar(0, 1, 12);
		g.conectar(0, 2, 4);
		
		g.conectar(1, 3, 5);
		g.conectar(1, 4, 3);
		
		g.conectar(2, 3, 2);
		g.conectar(2, 5, 6);
		
		g.conectar(3, 6, 8);
		
		g.conectar(4, 7, 7);
		
		g.conectar(5, 6, 5);
		
		g.conectar(6, 7, 3);
		
		Dijkstra d = new Dijkstra(g);
		
		d.run(0);
	}
}
