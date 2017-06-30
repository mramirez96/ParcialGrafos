
public class GrafoPonderado {
	private int [][] m;
	private int size;
	private int nonConectedValue;
	
	public GrafoPonderado(int nodos) {
		m = new int[nodos][nodos];
		size = nodos;
		for(int i=0;i<nodos;i++)
			for(int j=0;j<nodos;j++)
				m[i][j]= -1;
	}
	
	public void conectar(int origen, int destino, int costo) {
		m[origen][destino] = costo;	
	}
	
	public int costo(int origen, int destino) {
		return m[origen][destino];
	}
	
	public int getSize() { return size; }
	
	public void reinitializeNonConectedCostos(int costo) {
		nonConectedValue = costo;
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(m[i][j] == -1)
					m[i][j]= costo;
	}
	
	public boolean estaConectado(int origen, int destino) {
		return m[origen][destino] != nonConectedValue;
	}
}
