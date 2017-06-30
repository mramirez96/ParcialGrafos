import java.util.ArrayList;

public class Dijkstra2 {

	private GrafoPonderado g;
	int [] prev;
	int [] cost;

	
	public Dijkstra2(GrafoPonderado g) {
		this.g = g;
		prev = new int[g.getSize()];
		cost = new int[g.getSize()];
	}
	
	// no calcula predecesores
	public void run(int nodo) {
		g.reinitializeNonConectedCostos(getInfValue());
		int costoMin = getInfValue();
		int nodoMin = -1;
		ArrayList<Integer> conjS = new ArrayList<>(); // conj nodos ya usados
		
		// podría meter este for dentro del while para menor complejidad pero dificulta más la lectura
		for (int i = 0; i < g.getSize(); i++) {
			if (i!=nodo) {
				cost[i] = g.costo(nodo, i); // inicializo array de costos
				if (g.estaConectado(nodo, i) && costoMin > cost[i]) {
					nodoMin = i;	// me guardo al primero de menor costo
					costoMin = cost[i];
				}
					
			}
		}
	
		int proxNodoMin = 0;
		while(nodoMin != -1) {
			conjS.add(nodoMin);
			costoMin = getInfValue();
			
			for(int i = 0; i < g.getSize(); i++) {
				if (i != nodo &&
						cost[nodoMin]+g.costo(nodoMin, i) < cost[i]) { 
					cost[i] = cost[nodoMin]+g.costo(nodoMin, i);
				}
				if (i!= nodo && !conjS.contains(i) && costoMin > cost[i]) {
					proxNodoMin = i;
					costoMin = cost[i];
				}	
			}
			
			if(costoMin != getInfValue()) { // Si encontré mínimo, lo asigno. Sino cierro ciclo.
				nodoMin = proxNodoMin;
			} else {
				nodoMin = -1;
			}
		}
	}
	
	/**
	 * Por ser un algoritmo greedy, compararía siempre igual 
	 * Necesito un valor alto para no romper la comparación
	 * Dependería del problema cuál sería el inf necesario
	 * @return inf value
	 */
	private int getInfValue() {
		return 1000;
	}
}
