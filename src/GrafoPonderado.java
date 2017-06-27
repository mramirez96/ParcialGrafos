
public class GrafoPonderado {
	private int [][] m;
	private int size;
	
	public GrafoPonderado(int nodos) {
		m = new int[nodos][nodos];
		size = nodos;
		for(int i=0;i<nodos;i++)
			for(int j=0;j<nodos;j++)
				m[i][j]= -1;
	}
	
	public void conectar(int origen, int destino, int costo){
		m[origen][destino] = costo;	
	}
	
	public int costo(int origen, int destino){
		return m[origen][destino];
	}
	
	public int getSize(){return size;}
}
