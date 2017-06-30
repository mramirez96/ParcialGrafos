import java.util.Comparator;
import java.util.LinkedList;

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
		LinkedList<NodoNodo> listaNodoNodo = new LinkedList<>();
		int n1, n2, c;
		padre = new int[g.getSize()];
		arbol = new GrafoPonderado(g.getSize());
		
		// Se ordenan los costos de las aristas
		for(int i=0;i<g.getSize();i++)
			for(int j=0;j<g.getSize();j++) {
				if(g.costo(i, j) != -1)
					listaNodoNodo.add(new NodoNodo(i,j,g.costo(i, j))); // Si es digrafo, debería cargarlos una sola vez?
			}
		listaNodoNodo.sort(new Comparator<NodoNodo>() {
			@Override
			public int compare(NodoNodo n1, NodoNodo n2) {
				return n1.getCosto() - n2.getCosto();
			}
		});
		
		// En principio cada nodo es referente de sí mismo
		for (int i = 0; i < padre.length; i++) {
			padre[i] = i;
		}
		
		for (NodoNodo n : listaNodoNodo) {
			n1 = n.getNodo1();
			n2 = n.getNodo2();
			c = n.getCosto();
				
			if(!cierroCiclo(n1, n2)) {
				costo += c; // Incremento costo total del arbol
				arbol.conectar(n1, n2, c); // Agrego al arbol
				union(n1, n2);
				System.out.println("origen:"+(n1+1)+";dest:"+(n2+1));
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
