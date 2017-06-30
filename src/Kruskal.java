import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Kruskal {
	// In
	private GrafoPonderado g;
	int[] padre;
	
	// Out
	private GrafoPonderado arbol;
	private int costo;

	public Kruskal(GrafoPonderado g) {
		this.g = g;
	}
	
	public void run() {
		PriorityQueue<NodoNodo> pq = new PriorityQueue<>(new Comparator<NodoNodo>() {
			public int compare(NodoNodo o1, NodoNodo o2) { return o1.getCosto() - o2.getCosto(); }
		});
		
		int n1, n2, c;
		padre = new int[g.getSize()];
		arbol = new GrafoPonderado(g.getSize());
		
		// Se cargan los costos de las aristas
		for(int i=0;i<g.getSize();i++)
			for(int j=i;j<g.getSize();j++) { // Recorro solo la mitad para no repetir aristas (usado para grafos no dirigidos)
				if(g.costo(i, j) != -1) {
					pq.offer(new NodoNodo(i,j,g.costo(i, j)));
				}
			}
		
		// En principio cada nodo es referente de sí mismo
		for (int i = 0; i < padre.length; i++) {
			padre[i] = i;
		}
		
		NodoNodo n;
		while(!pq.isEmpty()) {
			n = pq.poll(); // Saco de la cola al elemento del frente (sería el de menor costo)
			
			n1 = n.getNodo1();
			n2 = n.getNodo2();
			c = n.getCosto();
				
			if(!cierroCiclo(n1, n2)) {
				costo += c; // Incremento costo total del arbol
				arbol.conectar(n1, n2, c); // Agrego al arbol
				union(n1, n2); // Cambio el referente
				System.out.println("arco:"+(n1+1)+"-"+(n2+1));
			}
		}
		// si cant nodos - 1 es distinto a la cantidad de aristas, el grafo era no conexo
	}
	
	private int find(int x) {
		return (x == padre[x]) ? x : find(padre[x]);
	}
	
	private void union(int x, int y) {
		padre[find(x)] = find(y);
	}
	
	private boolean cierroCiclo(int x ,int y) {
	    if(find(x) == find(y)) 
	    	return true;
	    return false;
	}
}
