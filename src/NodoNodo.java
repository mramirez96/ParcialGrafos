
public class NodoNodo {
	private int nodo1;
	private int nodo2;
	private int costo;
	
	public NodoNodo(int n1, int n2, int c) {
		this.nodo1 = n1;
		this.nodo2 = n2;
		this.costo = c;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public int getNodo1() {
		return nodo1;
	}

	public int getNodo2() {
		return nodo2;
	}
}
