
import java.util.ArrayDeque;
import java.util.Arrays;

import grafos.GrafoNDNP;

public class Bfs2 {

	private GrafoNDNP g;
	private ArrayDeque<Integer> q;
	
	public Bfs2(GrafoNDNP g){
		this.g = g.clone();
	}
	
	public int[] run(int nodo) {
		q = new ArrayDeque<>();
		int[] dist = new int[g.getSize()];
		Arrays.fill(dist, -1); // inicializo las distancias en -1
		
		dist[nodo] = 0;
		q.offer(nodo);
		
		while(!q.isEmpty()) {
			for (int i : g.getAdyacentes(q.peek())) {
				if (dist[i] == -1) { // si está en -1 no lo visité nunca
					q.offer(i);
					dist[i] = dist[q.peek()] + 1; // asigno costo desde donde estoy + 1
				}
			}
			q.remove();
		}
		return dist;
	}
	
}
