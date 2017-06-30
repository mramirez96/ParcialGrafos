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
	public void bfsMica() {
		System.out.println("BFS Mica");
		GrafoNDNP g = new GrafoNDNP(9);
		g.conectar(6, 7);
		g.conectar(7, 8);
		g.conectar(7, 4);
		g.conectar(4, 3);
		g.conectar(3, 0);
		g.conectar(0, 1);
		g.conectar(1, 2);
		g.conectar(2, 3);
		g.conectar(2, 5);
		g.conectar(5, 4);
		System.out.println(g);
		Bfs2 bfs = new Bfs2(g);
		bfs.run(4);
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
	
	@Test
	public void dijkstraMica() {
		System.out.println("Dijkstra Mica");
		
		GrafoPonderado g = new GrafoPonderado(5);
		g.conectar(0, 1, 100);
		g.conectar(0, 2, 30);
		g.conectar(0, 3, 20);
		
		g.conectar(2, 1, 40);
		g.conectar(2, 4, 5);
		
		g.conectar(4, 1, 30);
		
		Dijkstra2 d = new Dijkstra2(g);
		
		d.run(0);
	}
	
	@Test
	public void kruskal() {
		System.out.println("Kruskal");
		
		GrafoPonderado g = new GrafoPonderado(7);
		g.conectar(0, 1, 2);
		g.conectar(0, 3, 1);
		
		g.conectar(1, 5, 5);
		
		g.conectar(2, 3, 2);
		g.conectar(2, 0, 4);
		g.conectar(2, 5, 5);
		
		g.conectar(3, 1, 3);
		g.conectar(3, 6, 4);
		g.conectar(3, 4, 7);
		
		g.conectar(5, 6, 1);
		g.conectar(5, 3, 8);
		
		g.conectar(6, 4, 6);
		
		Kruskal k = new Kruskal(g);
		
		k.run();
	}
}
